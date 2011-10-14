package ren.shao;

import java.io.Serializable;

import android.graphics.Bitmap;

public class BitmapSerializable implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public int[] pixels;
	public int width;
	public int height;
	
	public BitmapSerializable(Bitmap bitmap){
		width = bitmap.getWidth();
		height = bitmap.getHeight();
		pixels = new int[width * height];
		bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
	}
}
