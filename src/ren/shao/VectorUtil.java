package ren.shao;

import android.graphics.PointF;

public class VectorUtil {
	public static float distance(float x1, float y1, float x2, float y2){
		return (float)Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
	
	public static float distance(PointF point1, PointF point2){
		return distance(point1.x, point1.y, point2.x, point2.y);
	}
}
