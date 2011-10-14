package ren.shao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.ImageColumns;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class SaveImageListener implements OnClickListener{

	public void onClick(View v) {
		Bitmap bitmap = Repository.getBitmap();
		
//		ContentValues values = new ContentValues();
//
//		values.put(MediaStore.Images.ImageColumns.TITLE, "newpic.jpg");
//		//values.put(Media.MIME_TYPE, "image/png");
//		values.put(MediaStore.Images.ImageColumns.MIME_TYPE, "image/jpeg");
//		//values.put(Media.BUCKET_DISPLAY_NAME, "bucket");
//		//values.put(Media.TITLE, "newpic_title");
//		
//		Uri uri = v.getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//				values);
		
		
		try{
			OutputStream out = new FileOutputStream("/sdcard/abc.png");
//			OutputStream out = v.getContext().getContentResolver().openOutputStream(uri);
			bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
			out.close();
		}catch(IOException e){
			Log.e("save image", "failed to save image", e);
		}

		
	}
	
}
