package ren.shao;

import java.util.ArrayList;
import java.util.HashMap;

import ren.shao.action.Action;
import ren.shao.action.ChangeBrushAction;
import ren.shao.view.ShapeButton;
import ren.shao.view.ShapeButton.IconShape;
import ren.shao.view.ShapeButton.IconStyle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public class Repository {
	private static int foreground = 0xff000000; // foreground color
	private static int background = 0xffffffff; // default to white
	private static Bitmap bitmap = Bitmap.createBitmap(480, 320, Bitmap.Config.ARGB_8888);
	private static Canvas backCanvas = new Canvas(bitmap);
	private static Paint paint = new Paint();
	private static Paint bgPaint = new Paint();
	private static int thickness = 1;
	private static Brush brush = null;
	private static HashMap<String, Brush> brushMap = new HashMap<String, Brush>();

	private static HashMap<String, Action> actionMap = new HashMap<String, Action>();
	

	/**
	 * The position of cursor image top left corner, relative to finger impact point
	 */
	public static Point cursorOffset = new Point(-50, -40);
	
	/**
	 * The position of the actual draw point, relative to finger impact point
	 */
	public static Point touchPointOffset = new Point(-55, -45);
	

	static{
		bgPaint.setColor(0xffffffff);
		
		// initialse action
		actionMap.put("changeBrush", new ChangeBrushAction());
		
		// initialse brush
		Canvas c = new Canvas();
		Bitmap b = Bitmap.createBitmap(20, 20, Bitmap.Config.ARGB_8888);
		c.setBitmap(b);
		c.drawCircle(9, 9, 4, paint);
		
		Brush circle_1 =  new Brush();
		circle_1.setBrushBitmap(b);
		circle_1.setSpacing(4); // set spacing to 4 pixel
		
		brushMap.put("circle_1", circle_1);
		setBrush("circle_1");
	}
	
	private static ArrayList<ShapeButton> shapeButtonList = new ArrayList<ShapeButton>();
	
	public static ShapeButton getShapeButton(IconShape shape, IconStyle style){
		for(ShapeButton shapeButton : shapeButtonList){
			if(shapeButton.getIconShape() == shape &&
					shapeButton.getIconStyle() == style){
				return shapeButton;
			}
		}
		return null;
	}
	
	public static void registerShapeButton(ShapeButton shapeButton){
		shapeButtonList.add(shapeButton);
	}
	
	
	public static Bitmap getBitmap(){
		return bitmap;
	}
	
	public static void setBitmap(Bitmap bitmap){
		Repository.bitmap = bitmap;
	}
	
	public static int getForeground() {
		return foreground;
	}

	public static void setForeground(int foreground) {
		Repository.foreground = foreground;
	}
	
	public static int getBackground() {
		return background;
	}

	public static void setBackground(int background) {
		Repository.background = background;
	}
	
	public static Canvas getBackCanvas() {
		return backCanvas;
	}

	public static void setBackCanvas(Canvas backCanvas) {
		Repository.backCanvas = backCanvas;
	}
	
	public static Paint getPaint() {
		return paint;
	}

	public static void setPaint(Paint paint) {
		Repository.paint = paint;
	}
	
	public static Paint getBgPaint(){
		return bgPaint;
	}
	
	public static int getThickness() {
		return thickness;
	}

	public static void setThickness(int thickness) {
		Repository.thickness = thickness;
		paint.setStrokeWidth(thickness);
	}
	
	public static Brush getBrush() {
		return brush;
	}
	
	public static Brush getBrush(String brushId){
		return brushMap.get(brushId);
	}

	public static void setBrush(Brush brush) {
		Repository.brush = brush;
	}
	
	public static void setBrush(String brushId){
		brush = brushMap.get(brushId);
	}
	
	public static Action getAction(String actionName) {
		return actionMap.get(actionName);
	}
}
