package com.filippudak.fiestatime.fragments;

import android.os.Bundle;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.filippudak.fiestatime.FiestaTimeApplication;
import com.filippudak.fiestatime.R;
import com.filippudak.fiestatime.adapters.FilmsAdapter;
public class FilmsFragment extends SherlockListFragment{
	 
	@Override
	  public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    
	    setHasOptionsMenu(true); 

	    FilmsAdapter listAdapter = new FilmsAdapter(getSherlockActivity(), FiestaTimeApplication.films, FiestaTimeApplication.images);

		// Set the adapter on the ListView holder
		setListAdapter(listAdapter);

		ListView lv = getListView();
		
		lv.setDividerHeight(0);
	    
	  }

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		
		menu.clear();
		menu.add("Refresh").setIcon(R.drawable.actionbar_refresh).setShowAsAction(
				MenuItem.SHOW_AS_ACTION_IF_ROOM
						| MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		super.onPrepareOptionsMenu(menu);
	}
		
}
