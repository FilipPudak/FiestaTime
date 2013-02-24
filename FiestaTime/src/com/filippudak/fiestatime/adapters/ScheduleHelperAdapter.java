package com.filippudak.fiestatime.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.filippudak.fiestatime.FiestaTimeApplication;
import com.filippudak.fiestatime.FilmDetailActivity;
import com.filippudak.fiestatime.R;
import com.filippudak.fiestatime.model.Venue;

public class ScheduleHelperAdapter extends BaseAdapter{

	Context mContext;
	ArrayList<Venue> mVenues;
	
	public ScheduleHelperAdapter(Context context, ArrayList<Venue> venues){
		mContext = context;
		mVenues = venues;
	};
	
	@Override
	public int getCount() {
		return mVenues.size();
	}

	@Override
	public Object getItem(int position) {
		mVenues.get(position);
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ScheduleHolder scheduleHolder = null;
		
		View row = convertView;
		
		if (row == null)
		{
			LayoutInflater inflater = (LayoutInflater) mContext
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.schedule_venue_item, parent, false);
			scheduleHolder = new ScheduleHolder();
			scheduleHolder.imageSchedule = (ImageView) row.findViewById(R.id.schedule_imageView);
			scheduleHolder.timeSchedule = (TextView) row.findViewById(R.id.schedule_time);
			scheduleHolder.placeSchedule = (TextView) row.findViewById(R.id.schedule_place);
			scheduleHolder.titleSchedule = (TextView) row.findViewById(R.id.schedule_title);
			row.setTag(scheduleHolder);
		}
		else{
			scheduleHolder = (ScheduleHolder) row.getTag();
		}
		
		//Bitmap bm = FiestaTimeApplication.decodeSampledBitmapFromResource(mContext.getResources(), FiestaTimeApplication.imageIds[position], 72, 72);
		//scheduleHolder.imageSchedule.setImageBitmap(bm);
		scheduleHolder.imageSchedule.setImageBitmap(FiestaTimeApplication.images[position]);
		scheduleHolder.timeSchedule.setText(mVenues.get(position).getTime());
		scheduleHolder.placeSchedule.setText(", " + mVenues.get(position).getPlace());
		scheduleHolder.titleSchedule.setText(mVenues.get(position).getFilm().getTitle());
		row.setOnClickListener(new ScheduleOnClickListener(position));
		
		return row;
	}

	static class ScheduleHolder {
		ImageView imageSchedule;
	    TextView timeSchedule;
	    TextView placeSchedule;
	    TextView titleSchedule;
	}
	
	class ScheduleOnClickListener implements OnClickListener {
		
		private int pos;
		
		ScheduleOnClickListener(int pos){
			
			this.pos = pos;
		}
		
	      public void onClick(View v) {
	    	  Intent myIntent = new Intent(mContext, FilmDetailActivity.class);
	    	  myIntent.putExtra("Film", mVenues.get(pos).getFilm());
	    	  myIntent.putExtra("Image", String.valueOf(pos));
		      mContext.startActivity(myIntent);
	      }
	    }
}
