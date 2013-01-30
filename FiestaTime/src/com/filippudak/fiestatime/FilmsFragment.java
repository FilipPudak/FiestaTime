package com.filippudak.fiestatime;

import java.util.HashMap;
import java.util.Map;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class FilmsFragment extends SherlockListFragment{

	@Override
	  public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    
	    setHasOptionsMenu(true);

	    String titles[] = {"The Hobbit", "Zee Hobbit", "T3h Hobbitz", "Big Hobitzzz", "Le Hobboz", "Froodooooo", "Bilboqqqq"};
	    
	    Bitmap images[] = new Bitmap[2];
	    
		Bitmap icon = BitmapFactory.decodeResource(getSherlockActivity().getResources(),
	             R.drawable.the_hobbit_big);
		
		Bitmap icon1 = BitmapFactory.decodeResource(getSherlockActivity().getResources(),
	               R.drawable.the_hobbit_med);
		
		images[0] = icon;
		images[1] = icon1;

	    FilmsAdapter listAdapter = new FilmsAdapter(getSherlockActivity(), titles, images);

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
