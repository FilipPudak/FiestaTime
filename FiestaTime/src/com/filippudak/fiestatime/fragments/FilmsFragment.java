package com.filippudak.fiestatime.fragments;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.filippudak.fiestatime.FiestaTimeApplication;
import com.filippudak.fiestatime.R;
import com.filippudak.fiestatime.adapters.FilmsAdapter;
import com.filippudak.fiestatime.model.Film;

public class FilmsFragment extends SherlockListFragment{
	 
	@Override
	  public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    
	    setHasOptionsMenu(true);
	    
	    Film films[] = new Film[8];
	    
	    Film hobbit = new Film("The Hobbit", "Direktor", "180 min", 
	    						"Elijah Wood", "There and back again", "Fantasy", 
	    						"www.youtube.com", "http:/rokaj.com", 4.7);
	    String[] venues = new String[3];
	    venues[0] = "01-01-2013";
	    venues[1] = "02-01-2013";
	    venues[2] = "03-01-2013";
	    
	    hobbit.setVenues(venues);
	    films[0] = hobbit;
	    
	    Film superman = new Film();
	    superman.setTitle("Man of steel");
	    films[1] = superman;
	    
	    Film django = new Film();
	    django.setTitle("Django Unchained");
	    films[2] = django;
	    
	    Film ironman = new Film();
	    ironman.setTitle("Iron Man 3");
	    films[3] = ironman;
	    
	    Film startrek = new Film();
	    startrek.setTitle("Star Trek 2");
	    films[4] = startrek;
	    
	    Film suckerpunch = new Film();
	    suckerpunch.setTitle("Suckerpunch");
	    films[5] = suckerpunch;
	    
	    Film taken2 = new Film();
	    taken2.setTitle("Taken 2");
	    films[6] = taken2;
	    
	    Film wwz = new Film();
	    wwz.setTitle("World War Z");
	    films[7] = wwz;

	    FilmsAdapter listAdapter = new FilmsAdapter(getSherlockActivity(), films, FiestaTimeApplication.images);

		// Set the adapter on the ListView holder
		setListAdapter(listAdapter);

		ListView lv = getListView();
		
		lv.setDividerHeight(0);
	    
	  }

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		
		menu.add("Favorites").setIcon(R.drawable.actionbar_favorite).setShowAsAction(
				MenuItem.SHOW_AS_ACTION_IF_ROOM
						| MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		menu.add("Refresh").setIcon(R.drawable.actionbar_refresh).setShowAsAction(
				MenuItem.SHOW_AS_ACTION_IF_ROOM
						| MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		super.onPrepareOptionsMenu(menu);
	}
		
}
