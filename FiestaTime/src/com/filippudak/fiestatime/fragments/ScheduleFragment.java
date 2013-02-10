package com.filippudak.fiestatime.fragments;

import java.util.HashMap;
import java.util.Map;

import android.R.anim;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.filippudak.fiestatime.R;
import com.filippudak.fiestatime.R.drawable;
import com.filippudak.fiestatime.R.layout;
import com.filippudak.fiestatime.adapters.SectionedListAdapter;

public class ScheduleFragment extends SherlockListFragment {
	

	public final static String ITEM_TITLE = "title";
	public final static String ITEM_CAPTION = "caption";

	// SectionHeaders
	private final static String[] days = new String[]{"Mon", "Tue", "Wed", "Thur", "Fri"};

	// Section Contents
	private final static String[] notes = new String[]{"Ate Breakfast", "Ran a Marathan ...yah really", "Slept all day"};


	// Adapter for ListView Contents
	private SectionedListAdapter adapter;

	// ListView Contents
	private ListView journalListView;

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
		ArrayAdapter<String> listadapter = new ArrayAdapter<String>(this.getActivity(), R.layout.list_item_schedule, notes);

		// Add Sections
		for (int i = 0; i < days.length; i++)
			{
				adapter.addSection(days[i], listadapter);
			}

		// Set the adapter on the ListView holder
		setListAdapter(adapter);

	    
	  }
	

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		
		menu.add("Refresh").setIcon(R.drawable.actionbar_refresh).setShowAsAction(
				MenuItem.SHOW_AS_ACTION_IF_ROOM
						| MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		super.onPrepareOptionsMenu(menu);
	}
	
}