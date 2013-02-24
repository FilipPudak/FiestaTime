package com.filippudak.fiestatime;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.filippudak.fiestatime.model.Film;
import com.filippudak.fiestatime.model.FilmVenue;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FilmDetailActivity extends SherlockActivity {

	Film film;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		film = (Film) getIntent().getSerializableExtra("Film");

		int pos = Integer.parseInt(getIntent().getStringExtra("Image"));

		Bitmap bm = FiestaTimeApplication.images[pos];

		setContentView(R.layout.activity_filmsdetail);

		ImageView image = (ImageView) findViewById(R.id.filmdetails_image);
		image.setImageBitmap(bm);

		TextView filmTitle = (TextView) findViewById(R.id.filmdetails_title);
		filmTitle.setText(film.getTitle());

		TextView runtime = (TextView) findViewById(R.id.filmdetails_runtime);
		runtime.setText(film.getRuntime());

		TextView category = (TextView) findViewById(R.id.filmdetails_category);
		category.setText(film.getCategory());

		LinearLayout linlay = (LinearLayout) findViewById(R.id.filmdetails_venue);
		View row;
		View separator;
		TextView text;
		TextView title;
		TextView subtitle;
		FilmVenue[] venues = film.getVenues();
		LayoutInflater li = getLayoutInflater();
		for (int i = 0; i < venues.length; i++) {
			row = li.inflate(R.layout.filmsdetail_venue_item, null, false);
			text = (TextView) row.findViewById(R.id.block_time);
			text.setText(venues[i].getTime());
			title = (TextView) row.findViewById(R.id.block_title);
			title.setText(venues[i].getDate());
			subtitle = (TextView) row.findViewById(R.id.block_subtitle);
			subtitle.setText(venues[i].getPlace());
			linlay.addView(row);
			if (i < venues.length - 1) {
				separator = li.inflate(R.layout.separator, null, false);
				linlay.addView(separator);
			}
		}
		linlay = (LinearLayout) findViewById(R.id.filmdetails_description);
		text = (TextView) li
				.inflate(R.layout.filmsdetail_textview, null, false);
		text.setText(Html.fromHtml(film.getDirector()));
		linlay.addView(text);
		text = (TextView) li
				.inflate(R.layout.filmsdetail_textview, null, false);
		text.setText(Html.fromHtml(film.getMainActors()));
		linlay.addView(text);
		text = (TextView) li
				.inflate(R.layout.filmsdetail_textview, null, false);
		text.setText(Html.fromHtml(film.getShortSummary()));
		linlay.addView(text);
		
		LinearLayout viewTrailer = (LinearLayout) findViewById(R.id.filmdetails_view_trailer);
		viewTrailer.setOnClickListener(new ViewTrailerOnClickListener(film.getTrailerLink()));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getSupportMenuInflater().inflate(R.menu.activity_filmsdetail, menu);
		ShareActionProvider shareActionProvider = (ShareActionProvider) menu
				.findItem(R.id.menu_item_share).getActionProvider();

		// Set the share intent
		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.setAction(Intent.ACTION_SEND);
		shareIntent.setType("text/plain");
		shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out " + film.getTitle());

		shareActionProvider.setShareIntent(shareIntent);

		return true;
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
	
	class ViewTrailerOnClickListener implements OnClickListener{
		
		String mTrailerLink;

		public ViewTrailerOnClickListener(String trailerLink) {
			
			mTrailerLink = trailerLink;
		}
		
		@Override
		public void onClick(View v) {
			
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mTrailerLink)));
			
		}
		
	}

}
