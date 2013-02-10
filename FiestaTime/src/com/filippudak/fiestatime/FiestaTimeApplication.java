package com.filippudak.fiestatime;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;

public class FiestaTimeApplication extends Application {
	
	public static Bitmap images[];

	private static FiestaTimeApplication singleton;

	public FiestaTimeApplication getInstance() {
		return singleton;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		singleton = this;
		setupImages();
	}
		
	public void setupImages(){
		images = new Bitmap[8];
		
		Bitmap icon = decodeSampledBitmapFromResource(getResources(), R.drawable.the_hobbit_big, 400, 400);
		
		Bitmap icon1 = decodeSampledBitmapFromResource(getResources(), R.drawable.superman, 400, 400);
		
		Bitmap icon2 = decodeSampledBitmapFromResource(getResources(), R.drawable.django, 400, 400);
		
		Bitmap icon3 = decodeSampledBitmapFromResource(getResources(), R.drawable.iron_man, 400, 400);
		
		Bitmap icon4 = decodeSampledBitmapFromResource(getResources(), R.drawable.star_trek, 400, 400);
		
		Bitmap icon5 = decodeSampledBitmapFromResource(getResources(), R.drawable.suckerpunch, 400, 400);
		
		Bitmap icon6 = decodeSampledBitmapFromResource(getResources(), R.drawable.taken_2, 400, 400);
		
		Bitmap icon7 = decodeSampledBitmapFromResource(getResources(), R.drawable.world_war_z, 400, 400);

		
		images[0] = icon;
		images[1] = icon1;
		images[2] = icon2;
		images[3] = icon3;
		images[4] = icon4;
		images[5] = icon5;
		images[6] = icon6;
		images[7] = icon7;
		
	}
	
	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
	        int reqWidth, int reqHeight) {

	    // First decode with inJustDecodeBounds=true to check dimensions
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;
	    BitmapFactory.decodeResource(res, resId, options);
	    int imageHeight = options.outHeight;
	    int imageWidth = options.outWidth;
	    DisplayMetrics metrics = res.getDisplayMetrics();
	    int width = metrics.widthPixels;
	    int height = metrics.heightPixels;
	    // Calculate inSampleSize
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);  

	    // Decode bitmap with inSampleSize set
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeResource(res, resId, options);
	}
	
	public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        // Calculate ratios of height and width to requested height and width
        final int heightRatio = Math.round((float) height / (float) reqHeight);
        final int widthRatio = Math.round((float) width / (float) reqWidth);

        // Choose the smallest ratio as inSampleSize value, this will guarantee
        // a final image with both dimensions larger than or equal to the
        // requested height and width.
        inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
    }

    return inSampleSize;
}

}
