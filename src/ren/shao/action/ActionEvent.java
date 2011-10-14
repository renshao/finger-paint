package ren.shao.action;

public class ActionEvent {
	private String actionCommand;
	private long when;
	
	public ActionEvent(){
		when = System.currentTimeMillis();
	}
	
	public ActionEvent(String actionCommand){
		this.actionCommand = actionCommand;
	}
	
	public String actionCommand(){
		return actionCommand;
	}
	
	public long getWhen(){
		return when;
	}
}
