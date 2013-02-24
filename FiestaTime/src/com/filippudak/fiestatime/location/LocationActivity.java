package com.filippudak.fiestatime.location;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.filippudak.fiestatime.FiestaTimeApplication;
import com.filippudak.fiestatime.PoIDetailsActivity;
import com.filippudak.fiestatime.R;
import com.filippudak.fiestatime.model.PoI;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationActivity extends FragmentActivity {

	private GoogleMap map;
	private ArrayList<Marker> markers = new ArrayList<Marker>();
	private Marker eventMarker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location);
		map = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map)).getMap();
		LatLng position = null;
		
		
		eventMarker = map.addMarker(new MarkerOptions().position(new LatLng(FiestaTimeApplication.latitude, FiestaTimeApplication.longitude)).title("Event location").snippet(FiestaTimeApplication.address));

		for (int i = 0; i < FiestaTimeApplication.pois.length; i++) {

			PoI poi = FiestaTimeApplication.pois[i];

			position = new LatLng(poi.getLatitude(), poi.getLongitude());

			Marker marker = map.addMarker(new MarkerOptions()
					.position(position)
					.title(poi.getName())
					.snippet(poi.getAddress())
					.icon(BitmapDescriptorFactory
							.fromResource(R.drawable.marker_poi)));
			markers.add(marker);
		}

		map.setOnInfoWindowClickListener(new LocationOnInfoWindowClickListener(
				this));
		
		Intent intent = getIntent();
		String title;
		if(intent.getStringExtra("Title") != null)
		{
			LatLng pos = null;
			title = intent.getStringExtra("Title");
			for (int i = 0; i < markers.size(); i++) {
				if(markers.get(i).getTitle().equals(title))
				{
					pos = markers.get(i).getPosition();
					markers.get(i).showInfoWindow();
					break;
				}
			}
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos, 15));
			
		}
		else
		{
			eventMarker.showInfoWindow();
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(eventMarker.getPosition(), 15));
		}
		

		// Zoom in, animating the camera.
		map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
	}

	class LocationOnInfoWindowClickListener implements
			OnInfoWindowClickListener {

		Context mContext;

		public LocationOnInfoWindowClickListener(Context context) {
			mContext = context;

		}

		@Override
		public void onInfoWindowClick(Marker marker) {
			String title = marker.getTitle();
			for (int i = 0; i < FiestaTimeApplication.pois.length; i++) {

				if (title.equals(FiestaTimeApplication.pois[i].getName())) {
					Intent intent = new Intent(mContext, PoIDetailsActivity.class);
					intent.putExtra("PoI", FiestaTimeApplication.pois[i]);
					intent.putExtra("Image", String.valueOf(i));
					startActivity(intent);
					break;
				}
			}
		}

	}
}