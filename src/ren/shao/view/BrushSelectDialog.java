package ren.shao.view;

import ren.shao.Paint;
import ren.shao.R;
import ren.shao.Repository;
import ren.shao.action.ChangeBrushAction;
import ren.shao.action.ChangeBrushEvent;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class BrushSelectDialog extends Dialog{
	private BrushButton btnSelectThickness = null;
	private BrushButton selectedBrush;
	
	public BrushSelectDialog(Context context){
		super(context);
		Paint mainView = ((ren.shao.Paint)context);
		btnSelectThickness = (BrushButton)mainView.findViewById(R.id.btn_select_thickness);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.brush_select_dialog);
		
		selectedBrush = (BrushButton)findViewById(R.id.btn_thickness_2);
		
		
//		// Init slider
//		Slider slider = (Slider)findViewById(R.id.slider);
//		slider.setProgress(Repository.getThickness());
//		ThicknessSelectionChangedListener l = new ThicknessSelectionChangedListener((ThicknessButton)findViewById(R.id.btn_thickness));
//		slider.setOnSliderValueChangeListener(l);
		
		// Create a brush button click listener
		View.OnClickListener click = new View.OnClickListener(){
			public void onClick(View v) {
				BrushButton button = (BrushButton)v;
				float newBrushThickness = button.getThickness();
				Repository.getPaint().setStrokeWidth(newBrushThickness);
				btnSelectThickness.setThickness(newBrushThickness);
				btnSelectThickness.updateIcon();
				dismiss();
			}
		};
		
		// init thickness button
		((BrushButton)findViewById(R.id.btn_thickness)).setOnClickListener(click);
		((BrushButton)findViewById(R.id.btn_thickness_2)).setOnClickListener(click);
		((BrushButton)findViewById(R.id.btn_thickness_4)).setOnClickListener(click);
		((BrushButton)findViewById(R.id.btn_thickness_8)).setOnClickListener(click);
		((BrushButton)findViewById(R.id.btn_thickness_16)).setOnClickListener(click);
	}
	
	public void focusSelectedBrush(){
		
		selectedBrush.requestFocusFromTouch();
		Log.i("focus: ", selectedBrush.isFocusable() ? "true" : "false");
	}
}
