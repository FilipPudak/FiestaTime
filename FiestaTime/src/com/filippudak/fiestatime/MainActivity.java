package com.filippudak.fiestatime;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import android.widget.TabHost;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.filippudak.fiestatime.adapters.TabsAdapter;
import com.filippudak.fiestatime.fragments.FilmsFragment;
import com.filippudak.fiestatime.fragments.PoIFragment;
import com.filippudak.fiestatime.fragments.ScheduleFragment;

public class MainActivity extends SherlockFragmentActivity {

	TabHost mTabHost;
	ViewPager mViewPager;
	TabsAdapter mTabsAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_tabs_pager);

		mViewPager = (ViewPager) findViewById(R.id.pager);

		ActionBar bar = getSupportActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		mTabsAdapter = new TabsAdapter(this, mViewPager);

		mTabsAdapter.addTab(bar.newTab().setText("Schedule"),
				ScheduleFragment.class, null);
		mTabsAdapter.addTab(bar.newTab().setText("Films"),
				FilmsFragment.class, null);
		mTabsAdapter.addTab(bar.newTab().setText("Places"),
				PoIFragment.class, null);

	}

	

}
