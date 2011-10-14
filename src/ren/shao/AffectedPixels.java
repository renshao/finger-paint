package ren.shao;

import android.graphics.Point;

public class AffectedPixels {
	private int[] pixels;
	private int width;
	private int height;
	private Point topLeftInBitmap;
	
	public int[] getPixels() {
		return pixels;
	}
	public void setPixels(int[] pixels) {
		this.pixels = pixels;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Point getTopLeftInBitmap() {
		return topLeftInBitmap;
	}
	public void setTopLeftInBitmap(Point topLeftInBitmap) {
		this.topLeftInBitmap = topLeftInBitmap;
	}
}
