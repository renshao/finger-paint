package ren.shao;

import ren.shao.instrument.ToolManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View {
	Bitmap cursorImage = null;
	private float impactPointX;
	private float impactPointY;
	
	public CanvasView(Context context) {
		super(context);
		init(context);
	}

	public CanvasView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		BitmapFactory.Options options = new BitmapFactory.Options();
		cursorImage = BitmapFactory.decodeResource(getResources(), R.drawable.cursor, options);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		impactPointX = event.getX();
		impactPointY = event.getY();
		ToolManager.getCurrentTool().handleTouchEvent(event);
		invalidate();
		return true;
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		// draw background
		canvas.drawColor(Repository.getBackground());

		// draw bitmap
		canvas.drawBitmap(Repository.getBitmap(), 0, 0, null);

		// draw running bitmap
		ToolManager.getCurrentTool().drawUncommittedShape(canvas);
		
		// draw cursor
		canvas.drawBitmap(cursorImage, impactPointX + Repository.cursorOffset.x,
				impactPointY + Repository.cursorOffset.y, null);
		float x = impactPointX + Repository.touchPointOffset.x;
		float y = impactPointY + Repository.touchPointOffset.y;
		canvas.drawLine(x - 3, y - 3, x + 3, y + 3, Repository.getPaint());
		canvas.drawLine(x - 3, y + 3, x + 3, y - 3, Repository.getPaint());
		
		//		canvas.drawBitmap(cursorImage, cursorX + Repository.cursorOffset.x,
//				cursorY + Repository.cursorOffset.y, null);
	}
}
