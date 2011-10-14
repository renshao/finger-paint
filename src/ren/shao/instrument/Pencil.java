package ren.shao.instrument;

import static android.graphics.Paint.Style.STROKE;
import ren.shao.Repository;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.view.MotionEvent;

public class Pencil extends DrawingInstrument {
	private static final float TOUCH_TOLERANCE = 4;

	// The current drawing path that hasn't been committed to back canvas
	protected Path path = new Path();
	// The previous two points, used as control points for cubic bezier curve
	private PointF[] previous = new PointF[2];
	
	public Pencil() {
	}
	
	@Override
	public void handleTouchEvent(MotionEvent event) {
		PointF impactPoint = getImpactPointTranslated(event);
		
		//Log.i("Pressure: ", String.valueOf(event.getPressure()));
		
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			touch_start(impactPoint.x, impactPoint.y);
			break;
		case MotionEvent.ACTION_MOVE:
			touch_move(impactPoint.x, impactPoint.y);
			break;
		case MotionEvent.ACTION_UP:
			touch_up(impactPoint.x, impactPoint.y);
			break;
		}
	}
	
	/**
	 * Draw uncommitted path of pencil
	 */
	@Override	
	public void drawUncommittedShape(Canvas canvas){
		canvas.drawPath(path, Repository.getPaint());
	}	

	@Override
	public void onActive() {
		Paint paint = Repository.getPaint();
		paint.setColor(Repository.getForeground());
		paint.setStyle(STROKE);
	}

	private void touch_start(float x, float y) {
		path.reset();
		path.moveTo(x, y);
		previous[0] = new PointF(x, y);
	}
	
	private void touch_move(float x, float y) {
		if(previous[0] == null){
			previous[0] = new PointF(x, y);
		}else if(previous[1] == null){
			previous[1] = new PointF(x, y);
		}else{
			float dx = Math.abs(x - previous[1].x);
			float dy = Math.abs(y - previous[1].y);
			if (dx < TOUCH_TOLERANCE && dy < TOUCH_TOLERANCE) {
//				path.quadTo(touchStartX, touchStartY, (x + touchStartX) / 2,
//						(y + touchStartY) / 2);
//				touchStartX = x;
//				touchStartY = y;
				return;
			}
			
			path.cubicTo(previous[0].x, previous[0].y, previous[1].x, previous[1].y, 
					(previous[1].x + x) / 2, (previous[1].y + y) / 2);
			previous[0] = new PointF(x, y);
			previous[1] = null;
		}
	}

	private void touch_up(float x, float y) {
		path.lineTo(x, y);
		// commit current path to offscreen
		Repository.getBackCanvas().drawPath(path, Repository.getPaint());		
		// kill this so we don't double draw
		path.reset();
		// must clear control points
		previous[0] = previous[1] = null;
	}
}
