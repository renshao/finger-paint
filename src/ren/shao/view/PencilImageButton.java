package ren.shao.view;

import ren.shao.R;
import ren.shao.ToolName;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class PencilImageButton extends ImageButton implements ToolChangeAction{
	public PencilImageButton(Context context, AttributeSet attrs){
		super(context, attrs);
	}

	public ToolName getToolName() {
		return ToolName.PENCIL;
	}

	public void updateToolIcon(ImageButton btnSelectTool) {
		btnSelectTool.setImageResource(R.drawable.pencil);
	}
}
