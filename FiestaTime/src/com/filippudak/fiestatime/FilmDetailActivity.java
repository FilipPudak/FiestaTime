package com.filippudak.fiestatime;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.filippudak.fiestatime.model.Film;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FilmDetailActivity extends SherlockActivity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    Film film = (Film)getIntent().getSerializableExtra("Film");
	    
	    int pos = Integer.parseInt(getIntent().getStringExtra("Image"));
	    
	    Bitmap bm = FiestaTimeApplication.images[pos];
	    
	    setContentView(R.layout.activity_filmsdetail);
	    
	    ImageView image = (ImageView) findViewById(R.id.filmdetails_image);
	    image.setImageBitmap(bm);
	    
	    TextView title = (TextView) findViewById(R.id.filmdetails_title);
	    title.setText(film.getTitle());
	    
	    LinearLayout linlay = (LinearLayout) findViewById(R.id.filmdetails_venue);
	    TextView text;
	    View separator;
	    String[] venues = film.getVenues();
	    LayoutInflater li = getLayoutInflater();
	    for (int i = 0; i < venues.length; i++) {
	    	text = (TextView)li.inflate(R.layout.filmsdetail_textview, null, false);
	    	text.setText(venues[i]);
	    	linlay.addView(text);
	    	if (i < venues.length - 1)
	    	{
	    		separator = li.inflate(R.layout.separator, null, false);
	    		linlay.addView(separator);
	    	}
		}
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		menu.add("Share").setIcon(R.drawable.actionbar_share).setShowAsAction(
				MenuItem.SHOW_AS_ACTION_IF_ROOM
						| MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		return super.onCreateOptionsMenu(menu);
	}
		
}
