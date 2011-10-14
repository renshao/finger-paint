package ren.shao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;

public class Slider extends ProgressBar {

	private OnSliderValueChangeListener listener;

	private static int padding = 2;

	public interface OnSliderValueChangeListener {
		void onProgressChanged(View v, int progress);
	}

	public Slider(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public Slider(Context context, AttributeSet attrs) {
		super(context, attrs, android.R.attr.progressBarStyleHorizontal);
	}

	public Slider(Context context) {
		super(context);
	}

	public void setOnSliderValueChangeListener(OnSliderValueChangeListener l) {
		listener = l;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		
		if (action == MotionEvent.ACTION_DOWN
		|| action == MotionEvent.ACTION_MOVE) {

			float x_mouse = event.getX() - padding;
			float width = getWidth() - 2 * padding;
			
			int max = getMax();
			
			int progress = Math.round((float)max * (x_mouse / width));
			if (progress < 1)
				progress = 1;
			else if(progress > max)
				progress = max;

			this.setProgress(progress);

			if (listener != null)
				listener.onProgressChanged(this, progress);
		}
		return true;
	}
}
