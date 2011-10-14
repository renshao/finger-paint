package ren.shao.instrument;

import static android.graphics.Paint.Style.STROKE;
import ren.shao.Repository;
import android.graphics.Paint;

public class Eraser extends Pencil{

	@Override
	public void onActive() {
		Paint paint = Repository.getPaint();
		paint.setColor(Repository.getBackground());
		paint.setStyle(STROKE);
	}
}
