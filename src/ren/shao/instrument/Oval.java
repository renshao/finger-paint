package ren.shao.instrument;

import static android.graphics.Paint.Style.FILL;
import static android.graphics.Paint.Style.STROKE;
import ren.shao.Repository;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Oval extends Rectangle{
	
	public Oval(int style){
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
	public void drawUncommittedShape(Canvas canvas) {
		canvas.drawColor(Repository.getBackground());
		canvas.drawBitmap(Repository.getBitmap(), 0, 0, Repository.getPaint());
		canvas.drawOval(makeRect(), Repository.getPaint());
	}

	@Override
	protected void touch_up() {
		Repository.getBackCanvas().drawOval(makeRect(), Repository.getPaint());
	}
	
}
