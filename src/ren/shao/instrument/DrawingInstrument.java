package ren.shao.instrument;

import ren.shao.Repository;
import ren.shao.ToolName;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.view.MotionEvent;

public abstract class DrawingInstrument {
	protected ToolName toolName;	

	public abstract void handleTouchEvent(MotionEvent event);
	
	/**
	 * Draw shape that hasn't been committed. The shape is not committed until user's
	 * finger leaves the screen. The user needs to see the uncommited shape
	 * @param canvas
	 */
	public abstract void drawUncommittedShape(Canvas canvas);
	
	/**
	 * This method should be invoked when this instrument
	 * becomes active, it sets the paint properties
	 */
	public abstract void onActive();
	
	protected PointF getImpactPointTranslated(MotionEvent event){
		float x = event.getX() + Repository.touchPointOffset.x;
		float y = event.getY() + Repository.touchPointOffset.y;
		return new PointF(x, y);
	}
	
	public ToolName getToolName() {
		return toolName;
	}
	public void setToolName(ToolName toolName) {
		this.toolName = toolName;
	}
}