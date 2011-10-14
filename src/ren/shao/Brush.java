package ren.shao;

import android.graphics.Bitmap;

/**
 * Represents a brush
 * @author ren
 *
 */
public class Brush {
	protected String id;
	protected Bitmap brushBitmap;
	protected float spacing;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Bitmap getBrushBitmap() {
		return brushBitmap;
	}
	public void setBrushBitmap(Bitmap brushBitmap) {
		this.brushBitmap = brushBitmap;
	}
	public int getWidth(){
		return brushBitmap.getWidth();
	}
	public int getHeight(){
		return brushBitmap.getHeight();
	}
	public float getSpacing() {
		return spacing;
	}
	public void setSpacing(float spacing) {
		this.spacing = spacing;
	}
}
