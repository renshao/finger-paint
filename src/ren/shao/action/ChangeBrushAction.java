package ren.shao.action;

import ren.shao.Repository;

public class ChangeBrushAction extends Action{
	
	public void actionPerformed(ActionEvent e) {
		ChangeBrushEvent event = (ChangeBrushEvent)e;
		String brushId = event.getBrushId();
		Repository.setBrush(brushId);
	}	
}
