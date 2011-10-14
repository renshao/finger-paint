package ren.shao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ColorPickerView extends LinearLayout{
	public ColorPickerView(Context context){
		super(context);
	}
	
	public ColorPickerView(Context context, AttributeSet attrs){
		super(context, attrs);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(300, 300);
	}
}
