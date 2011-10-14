package ren.shao.instrument;

import java.util.HashMap;

import ren.shao.ToolName;

public class ToolManager {
	private static HashMap<ToolName, DrawingInstrument> toolMap = 
		new HashMap<ToolName, DrawingInstrument>();
	
	private static DrawingInstrument currentTool;
	
	static{
		Pencil pencil = new Pencil();
		pencil.setToolName(ToolName.PENCIL);
		toolMap.put(pencil.getToolName(), pencil);
		
		Eraser eraser = new Eraser();
		eraser.setToolName(ToolName.ERASER);
		toolMap.put(eraser.getToolName(), eraser);
		
		Rectangle strokeRectangle = new Rectangle(Rectangle.STYLE_STROKE);
		strokeRectangle.setToolName(ToolName.RECT_STROKE);
		toolMap.put(strokeRectangle.getToolName(), strokeRectangle);
		
		Rectangle fillRectangle = new Rectangle(Rectangle.STYLE_FILL);
		fillRectangle.setToolName(ToolName.RECT_FILL);
		toolMap.put(fillRectangle.getToolName(), fillRectangle);
		
		Oval strokeOval = new Oval(Oval.STYLE_STROKE);
		strokeOval.setToolName(ToolName.OVAL_STROKE);
		toolMap.put(strokeOval.getToolName(), strokeOval);
		
		Oval fillOval = new Oval(Oval.STYLE_FILL);
		fillOval.setToolName(ToolName.OVAL_FILL);
		toolMap.put(fillOval.getToolName(), fillOval);
		
		currentTool = pencil;
	}
	
	public static DrawingInstrument getCurrentTool(){
		return currentTool;
	}
	
	public static void setCurrentTool(DrawingInstrument currentTool){
		ToolManager.currentTool = currentTool;
	}
	
	public static DrawingInstrument getTool(ToolName toolName){
		return toolMap.get(toolName);
	}
}
