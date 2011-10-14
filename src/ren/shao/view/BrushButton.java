package ren.shao.view;

import ren.shao.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class BrushButton extends ImageButton{
	
	/**
	 * This paint is used to draw current brush size
	 */
	private Paint iconPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	
	/**
	 * This paint is used to draw single pixel dot. ANTI_ALIAS flag is not
	 * set. Because if ANTI_ALIAS is set the color of the single pixel will
	 * be averaged with suronding environment color
	 */
	private Paint iconPaintNonAntiAlias = new Paint();
	private float thickness = 2;
	private String brushId;

	public BrushButton(Context context, AttributeSet attrs){
		super(context, attrs);
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BrushButton);
		thickness = a.getInt(R.styleable.BrushButton_thickness, 1);
		updateIcon();
	}

	public String getBrushId() {
		return brushId;
	}

	public void setBrushId(String brushId) {
		this.brushId = brushId;
	}

	
	//TODO override on measure
	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
		setMeasuredDimension(50, 50);
	}
	
	public void setThickness(float thickness){
		this.thickness = thickness;		
	}
	
	public void updateIcon() {
		iconPaint.setStrokeWidth(thickness);
		
		Bitmap iconBitmap = Bitmap.createBitmap((int)thickness, (int)thickness, Config.ARGB_8888);
		Canvas iconCanvas = new Canvas(iconBitmap);
		
		int x = iconBitmap.getWidth() / 2;
		int y = iconBitmap.getHeight() / 2;
		
		if(thickness == 1){
			iconCanvas.drawPoint(0, 0, iconPaintNonAntiAlias);
		}else{
			iconCanvas.drawCircle(x, y, (float)thickness / 2, iconPaint);
		}
		setImageBitmap(iconBitmap);
		invalidate();
	}
	
	/**
	 * Change color of backend paint for this button
	 * @param color
	 */
	public void setColor(int color){
		iconPaint.setColor(color);
		iconPaintNonAntiAlias.setColor(color);
	}
	
	public float getThickness() {
		return thickness;
	}
}
