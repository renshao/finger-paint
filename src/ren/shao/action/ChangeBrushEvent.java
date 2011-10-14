package ren.shao.action;

public class ChangeBrushEvent extends ActionEvent{
	private String brushId;

	public ChangeBrushEvent(String brushId){
		super("brushChanged");
		this.brushId = brushId;
	}
	
	public String getBrushId() {
		return brushId;
	}

	public void setBrushId(String brushId) {
		this.brushId = brushId;
	}
}
