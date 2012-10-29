package com.paragp.games.gamefish;

import java.awt.CompositeContext;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

class ZCompositeContext implements CompositeContext {
	private static int THRESHOLD = 230;
	public void compose(Raster src, Raster dstIn, WritableRaster dstOut) {
		 int width = Math.min(src.getWidth(), dstIn.getWidth());
         int height = Math.min(src.getHeight(), dstIn.getHeight());       
         if (src.getDataBuffer() instanceof DataBufferInt || dstIn.getDataBuffer() instanceof DataBufferInt	 ) {        	 
        	 return;
         }
        	 
         byte[] srcPixels = ((java.awt.image.DataBufferByte)src.getDataBuffer()).getData();
         byte[] dstPixels = ((java.awt.image.DataBufferByte)dstIn.getDataBuffer()).getData();
         
         for (int y = 0; y < height; y++) {
             src.getDataElements(0, y, width, 1, srcPixels);
             dstIn.getDataElements(0, y, width, 1, dstPixels);
             for (int x = 0; x < width * 4; x+=4) {
            	 
            	 if ((int)(srcPixels[x] & 0xFF) > THRESHOLD && (int)(srcPixels[x] & 0xFF) > THRESHOLD && (int)(srcPixels[x] & 0xFF) > THRESHOLD) {
	                      
                 }
            	 else {                     
                	 dstPixels[x]=srcPixels[x];
                	 dstPixels[x+1]=srcPixels[x+1];
                	 dstPixels[x+2]=srcPixels[x+2];
                	 dstPixels[x+3]=(byte)(srcPixels[x+3] | 0xF);
                 }
                 
             }
             dstOut.setDataElements(0, y, width, 1, dstPixels);
         }       
     }

	public void dispose() {
	}
}