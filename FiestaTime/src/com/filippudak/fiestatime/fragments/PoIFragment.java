package com.filippudak.fiestatime.fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.filippudak.fiestatime.FiestaTimeApplication;
import com.filippudak.fiestatime.R;
import com.filippudak.fiestatime.adapters.PoIHelperAdapter;
import com.filippudak.fiestatime.adapters.SectionedListAdapter;
import com.filippudak.fiestatime.location.LocationActivity;
import com.filippudak.fiestatime.model.PoI;

public class PoIFragment extends SherlockListFragment{
	

	public final static String ITEM_TITLE = "title";
	public final static String ITEM_CAPTION = "caption";


	// Adapter for ListView Contents
	private SectionedListAdapter adapter;
	
	public Map<String, ?> createItem(String title, String caption)
		{
			Map<String, String> item = new HashMap<String, String>();
			item.put(ITEM_TITLE, title);
			item.put(ITEM_CAPTION, caption);
			return item;
		}
	

	@Override
	  public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    
	    setHasOptionsMenu(true);

	    // Create the ListView Adapter
 		adapter = new SectionedListAdapter(this.getActivity());
 		

 		// Add Sections
 		for (int i = 0; i < FiestaTimeApplication.sectionsPoi.size(); i++)
 			{
 				ArrayList<String> headers = FiestaTimeApplication.headersPoi;
 				ArrayList<PoI> pois = FiestaTimeApplication.sectionsPoi.get(headers.get(i));
 				PoIHelperAdapter poiHelperAdapter = new PoIHelperAdapter(this.getActivity(), pois);
 				adapter.addSection(headers.get(i), poiHelperAdapter);
 			}

 		// Set the adapter on the ListView holder
 		setListAdapter(adapter);
	    
	  }


	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		
		menu.clear();
		
		menu.add("Map").setIcon(R.drawable.actionbar_map).setShowAsAction(
				MenuItem.SHOW_AS_ACTION_IF_ROOM);
		super.onPrepareOptionsMenu(menu);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getTitle().equals("Map"))
		{
			Intent intent = new Intent(this.getActivity(), LocationActivity.class);
			startActivity(intent);
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	
		
}
