package ren.shao.view;

import ren.shao.ToolName;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class RectButton extends ShapeButton implements ToolChangeAction{
	
	public RectButton(Context context, AttributeSet attrs){
		super(context, attrs);
	}
	
	protected  void drawShape(){
		// Due to the FILL_AND_STROKE bug, I have to draw
		// it again in FILL style
		if(iconPaint.getStyle() == Style.FILL_AND_STROKE){
			Paint p = new Paint(iconPaint);
			p.setStyle(Style.FILL);
			iconCanvas.drawRect(0, 0,
					iconBitmap.getWidth() - 1,
					iconBitmap.getHeight() - 1,
					p);
		}
		
		iconCanvas.drawRect(0, 0,
		iconBitmap.getWidth() - 1,
		iconBitmap.getHeight() - 1,
		iconPaint);
	}

	/*
	 * (non-Javadoc)
	 * @see ren.shao.view.ToolChangeAction#getToolName()
	 */
	public ToolName getToolName() {
		if(iconStyle == IconStyle.STROKE){
			return ToolName.RECT_STROKE;
		}else{
			return ToolName.RECT_FILL;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ren.shao.view.ToolChangeAction#updateToolIcon(android.widget.ImageButton)
	 */
	public void updateToolIcon(ImageButton btnSelectTool) {
		btnSelectTool.setImageBitmap(iconBitmap);
	}
}
