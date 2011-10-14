package ren.shao.view;

import ren.shao.R;
import ren.shao.Repository;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.widget.ImageButton;

public abstract class ShapeButton extends ImageButton{
	public enum IconShape{RECT, OVAL, CIRCLE};
	public enum IconStyle{FILL, FILL_AND_STROKE, STROKE};
	
	protected Bitmap iconBitmap;
	protected Canvas iconCanvas;
	protected Paint iconPaint;
	protected int padding = 3;
	protected IconStyle iconStyle;
	protected IconShape iconShape;
	

	public ShapeButton(Context context, AttributeSet attrs){
		super(context, attrs);
		iconBitmap = Bitmap.createBitmap(32, 32, Config.ARGB_8888);
		iconCanvas = new Canvas(iconBitmap);
		iconPaint = new Paint();
		iconPaint.setAntiAlias(true);
		
		setImageBitmap(iconBitmap);
		
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ShapeButton);
		int color = a.getColor(
				R.styleable.ShapeButton_iconColor, 0xff000000);
		setIconColor(color);
		
		int iconStyleInt = a.getInt(R.styleable.ShapeButton_iconStyle, 0);
		setIconStyleInt(iconStyleInt);
		
		
		int iconShapeInt = a.getInt(R.styleable.ShapeButton_iconShape, 0);
		setIconShape(iconShapeInt);
		
		Repository.registerShapeButton(this);
	}
	
	public void setIconColor(int color){
		iconPaint.setColor(color);
		// clear with transparent color
		iconCanvas.drawColor(0x00000000, Mode.CLEAR);
		drawShape();
	}
	
	public void setIconStyleInt(int iconStyleInt){
		if(iconStyleInt == IconStyle.FILL.ordinal()){
			iconStyle = IconStyle.FILL;
		}else if(iconStyleInt == IconStyle.FILL_AND_STROKE.ordinal()){
			iconStyle = IconStyle.FILL_AND_STROKE;
		}else if(iconStyleInt == IconStyle.STROKE.ordinal()){
			iconStyle = IconStyle.STROKE;
		}
		
		if(iconStyle != null){
			iconPaint.setStyle(Style.valueOf(iconStyle.name()));
			// clear with transparent color
			iconCanvas.drawColor(0x00000000, Mode.CLEAR);
			drawShape();	
		}
	}
	
	public IconStyle getIconStyle(){
		return iconStyle;
	}
	
	public IconShape getIconShape() {
		return iconShape;
	}

	public void setIconShape(int iconShapeInt) {
		if(iconShapeInt == IconShape.RECT.ordinal()){
			iconShape = IconShape.RECT;	
		}else if(iconShapeInt == IconShape.OVAL.ordinal()){
			iconShape = IconShape.OVAL;
		}else if(iconShapeInt == IconShape.CIRCLE.ordinal()){
			iconShape = IconShape.CIRCLE;
		}
	}
	
	protected abstract void drawShape();
}
