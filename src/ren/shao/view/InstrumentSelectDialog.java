package ren.shao.view;

import ren.shao.R;
import ren.shao.ToolName;
import ren.shao.instrument.DrawingInstrument;
import ren.shao.instrument.ToolManager;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InstrumentSelectDialog extends Dialog implements android.view.View.OnClickListener{
	private ImageButton btnSelectTool;

	public InstrumentSelectDialog(Context context){
		super(context);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setTitle("Please select a tool:");
		setContentView(R.layout.instrument_select_dialog);
		
		findViewById(R.id.btn_pencil).setOnClickListener(this);
		findViewById(R.id.btn_eraser).setOnClickListener(this);
		findViewById(R.id.btn_rect_stroke).setOnClickListener(this);
		findViewById(R.id.btn_rect_fill).setOnClickListener(this);
		findViewById(R.id.btn_oval_stroke).setOnClickListener(this);
		findViewById(R.id.btn_oval_fill).setOnClickListener(this);
	}

	public void onClick(View v) {
		ToolChangeAction action = (ToolChangeAction)v;
		ToolName selectedToolName = action.getToolName();
		DrawingInstrument selectedTool = ToolManager.getTool(selectedToolName);
		
		ToolManager.setCurrentTool(selectedTool);
		selectedTool.onActive();
		
		action.updateToolIcon(btnSelectTool);
		dismiss();
	}
	
	public void setBtnSelectTool(ImageButton btnSelectTool) {
		this.btnSelectTool = btnSelectTool;
	}	
}
