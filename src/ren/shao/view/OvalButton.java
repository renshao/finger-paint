package ren.shao.view;

import static android.graphics.Paint.ANTI_ALIAS_FLAG;
import static android.graphics.Paint.DITHER_FLAG;
import static ren.shao.ToolName.OVAL_FILL;
import static ren.shao.ToolName.OVAL_STROKE;
import ren.shao.ToolName;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class OvalButton extends ShapeButton implements ToolChangeAction{
	public OvalButton(Context context, AttributeSet attrs){
		super(context, attrs);
		iconPaint.setFlags(DITHER_FLAG | ANTI_ALIAS_FLAG);
	}
	
	@Override
	protected void drawShape() {
		RectF oval = new RectF(0, padding,
				iconBitmap.getWidth() - 1,
				iconBitmap.getHeight() - padding - 1);
		iconCanvas.drawOval(oval, iconPaint);
	}

	public ToolName getToolName() {
		return iconStyle == IconStyle.STROKE ? OVAL_STROKE : OVAL_FILL;
	}

	public void updateToolIcon(ImageButton btnSelectTool) {
		btnSelectTool.setImageBitmap(iconBitmap);
	}
}
