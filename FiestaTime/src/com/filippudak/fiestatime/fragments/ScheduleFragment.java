package com.filippudak.fiestatime.fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.filippudak.fiestatime.FiestaTimeApplication;
import com.filippudak.fiestatime.adapters.ScheduleHelperAdapter;
import com.filippudak.fiestatime.adapters.SectionedListAdapter;
import com.filippudak.fiestatime.model.Venue;

public class ScheduleFragment extends SherlockListFragment {
	

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
		for (int i = 0; i < FiestaTimeApplication.sectionsVenue.size(); i++)
			{
				ArrayList<String> headers = FiestaTimeApplication.headersVenue;
				ArrayList<Venue> venues = FiestaTimeApplication.sectionsVenue.get(headers.get(i));
				ScheduleHelperAdapter scheduleHelperAdapter = new ScheduleHelperAdapter(this.getActivity(), venues);
				adapter.addSection(headers.get(i), scheduleHelperAdapter);
			}

		// Set the adapter on the ListView holder
		setListAdapter(adapter);
	    
	  }
	

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		
		menu.clear();
		
		menu.add("About").setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
		
		super.onPrepareOptionsMenu(menu);
	}
	
}
