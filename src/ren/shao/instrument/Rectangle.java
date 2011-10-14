package ren.shao.instrument;

import static android.graphics.Paint.Style.FILL;
import static android.graphics.Paint.Style.STROKE;
import ren.shao.Repository;
import ren.shao.ToolName;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;

public class Rectangle extends DrawingInstrument{
	public static final int STYLE_STROKE =         0x00000000;
	public static final int STYLE_FILL =           0x0000000f;
	public static final int STYLE_SHARP_CORNER =   0x00000000;
	public static final int STYLE_ROUNDED_CORNER = 0x000000f0;
	
	protected int style;

	private float touchStartX;
	private float touchStartY;
	private float touchFinishX;
	private float touchFinishY;
	
	public Rectangle(){
		this.style = STYLE_STROKE | STYLE_SHARP_CORNER;
	}
	
	public Rectangle(int style){
		this.style = style;
	}
	
	@Override
	public void onActive() {
		Paint paint = Repository.getPaint();
		paint.setColor(Repository.getForeground());
		
		if((style & STYLE_FILL) != 0)
			paint.setStyle(FILL);
		else
			paint.setStyle(STROKE);
	}
	
	@Override
	public void drawUncommittedShape(Canvas canvas){
		canvas.drawColor(Repository.getBackground());
		canvas.drawBitmap(Repository.getBitmap(), 0, 0, Repository.getPaint());
		canvas.drawRect(makeRect(), Repository.getPaint());
	}
	
	protected RectF makeRect(){
		float left, right, top, bottom;
		if(touchStartX < touchFinishX){
			left = touchStartX;
			right = touchFinishX;
		}else{
			left = touchFinishX;
			right = touchStartX;
		}
		
		if(touchStartY < touchFinishY){
			top = touchStartY;
			bottom = touchFinishY;
		}else{
			top = touchFinishY;
			bottom = touchStartY;
		}
		
		return new RectF(left, top, right, bottom);
	}
	
	@Override
	public void handleTouchEvent(MotionEvent event) {
		PointF impactPoint = getImpactPointTranslated(event);
		
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			touch_start(impactPoint.x, impactPoint.y);
			break;
		case MotionEvent.ACTION_MOVE:
			touch_move(impactPoint.x, impactPoint.y);
			break;
		case MotionEvent.ACTION_UP:
			touch_up();
			break;
		}
	}
	
	protected void touch_start(float x, float y) {
		touchStartX = touchFinishX = x;
		touchStartY = touchFinishY = y;
	}

	protected void touch_move(float x, float y) {
		touchFinishX = x;
		touchFinishY = y;
	}

	protected void touch_up() {
		Repository.getBackCanvas().drawRect(makeRect(), 
				Repository.getPaint());
	}
	
	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}
}
