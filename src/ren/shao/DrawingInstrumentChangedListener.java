package ren.shao;

import ren.shao.view.InstrumentSelectDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class DrawingInstrumentChangedListener implements OnClickListener{
	private InstrumentSelectDialog dialog;
	
	public void onClick(View v) {
		if(dialog == null){
			dialog = new InstrumentSelectDialog(v.getContext());
			dialog.setBtnSelectTool((ImageButton)v);
		}
		
		dialog.show();
	}
	
}
