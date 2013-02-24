package com.filippudak.fiestatime;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.filippudak.fiestatime.location.LocationActivity;
import com.filippudak.fiestatime.model.PoI;
import com.google.android.gms.maps.model.LatLng;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PoIDetailsActivity extends SherlockActivity {

	private PoI poi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_poisdetail);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		Intent intent = getIntent();
		poi = (PoI) intent.getSerializableExtra("PoI");

		Bitmap bm = FiestaTimeApplication.decodeSampledBitmapFromResource(getResources(), poi.getImage(), 300, 300);

		ImageView image = (ImageView) findViewById(R.id.poidetails_image);
		image.setImageBitmap(bm);

		TextView text = (TextView) findViewById(R.id.poidetails_title);
		text.setText(poi.getName());
		
		text = (TextView) findViewById(R.id.poidetails_address);
		text.setText(poi.getAddress());
		
		LayoutInflater li = getLayoutInflater();
		LinearLayout linlay = (LinearLayout) findViewById(R.id.poidetails_description);
		text = (TextView) li
				.inflate(R.layout.filmsdetail_textview, null, false);
		text.setText(Html.fromHtml(poi.getType()));
		linlay.addView(text);
		text = (TextView) li
				.inflate(R.layout.filmsdetail_textview, null, false);
		text.setText(Html.fromHtml(poi.getPhone()));
		linlay.addView(text);
		text = (TextView) li
				.inflate(R.layout.filmsdetail_textview, null, false);
		text.setText(Html.fromHtml(poi.getInfo()));
		linlay.addView(text);
		
		LinearLayout showOnMap = (LinearLayout) findViewById(R.id.poidetails_map);
		showOnMap.setOnClickListener(new ShowOnMapOnClickListener(poi.getName(), this));

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This is called when the Home (Up) button is pressed
			// in the Action Bar.
			Intent parentActivityIntent = new Intent(this, MainActivity.class);
			parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(parentActivityIntent);
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	class ShowOnMapOnClickListener implements OnClickListener{
		
		private String mTitle;
		private Context mContext;
		
		public ShowOnMapOnClickListener(String title, Context context){
			
			mTitle = title;
			mContext = context;
		}

		@Override
		public void onClick(View v) {
			
			Intent intent = new Intent(mContext, LocationActivity.class);
			intent.putExtra("Title", mTitle);
			startActivity(intent);
			finish();
		}
		
	}
	
}
