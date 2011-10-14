package ren.shao.view;

import android.widget.ImageButton;
import ren.shao.ToolName;

public interface ToolChangeAction {
	ToolName getToolName();
	
	/**
	 * Invoked when the current tool has been changed to 
	 * this tool. Implementation of this method should
	 * update the icon on btnSelectTool
	 * @param btnSelectTool
	 */
	void updateToolIcon(ImageButton btnSelectTool);
}
