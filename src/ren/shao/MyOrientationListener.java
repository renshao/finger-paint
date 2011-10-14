package ren.shao;

import android.content.Context;
import android.util.Log;
import android.view.OrientationListener;

public class MyOrientationListener extends OrientationListener{

	public MyOrientationListener(Context context){
		super(context);
	}
	
	@Override
	public void onOrientationChanged(int orientation) {
		Log.i("Orientation Changed", orientation  + "");
	}
	
}
