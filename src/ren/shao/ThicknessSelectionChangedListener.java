package ren.shao;

import ren.shao.view.Slider;
import ren.shao.view.BrushButton;
import android.view.View;
import android.view.View.OnClickListener;

public class ThicknessSelectionChangedListener implements Slider.OnSliderValueChangeListener{
	private BrushButton thicknessButton;
	
	public ThicknessSelectionChangedListener(BrushButton thicknessButton){
		this.thicknessButton = thicknessButton;
	}
	
	public void onProgressChanged(View v, int progress) {
		Repository.setThickness(progress);
		thicknessButton.setThickness(progress);
	}
	
	
}
