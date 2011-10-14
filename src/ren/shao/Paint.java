package ren.shao;

import ren.shao.view.BrushButton;
import ren.shao.view.BrushSelectDialog;
import android.app.Activity;
import android.app.AlertDialog;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OrientationListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Paint extends Activity {
	static int instanceCount = 0;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this)
					.setMessage("haha").setTitle("title");
			dialogBuilder.create().show();

			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Display display = getWindowManager().getDefaultDisplay();
		int screenWidth = display.getWidth();
		int screenHeight = display.getHeight();
		if (screenWidth < screenHeight) {
			setContentView(R.layout.main_portrait);
		} else {
			setContentView(R.layout.main_landscape);
		}

		OrientationListener orientationListener = new MyOrientationListener(
				this);
		boolean oriRegisterd = ((SensorManager) getSystemService(SENSOR_SERVICE))
				.registerListener(orientationListener,
						SensorManager.SENSOR_ORIENTATION);
		Log.i("oriRegisted", oriRegisterd + "");

		Log.i("screen size", getWindowManager().getDefaultDisplay().getWidth()
				+ " X " + getWindowManager().getDefaultDisplay().getHeight());

		

			DrawingInstrumentChangedListener instrumentChangedListener = new DrawingInstrumentChangedListener();
			findViewById(R.id.btn_select_tool).setOnClickListener(
					instrumentChangedListener);
//			findViewById(R.id.btn_eraser).setOnClickListener(
//					instrumentChangedListener);	

			
		final BrushButton btnSelectThickness = (BrushButton)findViewById(R.id.btn_select_thickness);
		btnSelectThickness.setOnClickListener(new OnClickListener(){
			private BrushSelectDialog dialog;
			
			public void onClick(View v) {
				if(dialog == null){
					dialog = new BrushSelectDialog(Paint.this);
				}
				dialog.show();
				dialog.focusSelectedBrush();
			}
		});

		findViewById(R.id.btn_save).setOnClickListener(new SaveImageListener());
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		Log.i("onRestoreInstanceState", "instancestate restored");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.i("onSaveInstanceState", "instancestate saved");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i("Paint maint program", "on pause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i("Paint maint program", "on stop");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i("Paint main program", "on resume");
	}
}