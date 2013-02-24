package com.filippudak.fiestatime.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.filippudak.fiestatime.FiestaTimeApplication;
import com.filippudak.fiestatime.PoIDetailsActivity;
import com.filippudak.fiestatime.R;
import com.filippudak.fiestatime.model.PoI;

public class PoIHelperAdapter extends BaseAdapter{

	Context mContext;
	ArrayList<PoI> mPois;
	
	public PoIHelperAdapter(Context context, ArrayList<PoI> pois){
		mContext = context;
		mPois = pois;
	};
	
	@Override
	public int getCount() {
		return mPois.size();
	}

	@Override
	public Object getItem(int position) {
		mPois.get(position);
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		PoIHolder poiHolder = null;
		
		View row = convertView;
		
		if (row == null)
		{
			LayoutInflater inflater = (LayoutInflater) mContext
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.list_item_poi, parent, false);
			poiHolder = new PoIHolder();
			poiHolder.imagePoI = (ImageView) row.findViewById(R.id.poi_imageView);
			poiHolder.addressPoI = (TextView) row.findViewById(R.id.poi_address);
			poiHolder.titlePoI = (TextView) row.findViewById(R.id.poi_title);
			row.setTag(poiHolder);
		}
		else{
			poiHolder = (PoIHolder) row.getTag();
		}
		
		Bitmap bm = FiestaTimeApplication.decodeSampledBitmapFromResource(mContext.getResources(), mPois.get(position).getImage(), 96, 96);
		poiHolder.imagePoI.setImageBitmap(bm);
		poiHolder.addressPoI.setText(mPois.get(position).getAddress());
		poiHolder.titlePoI.setText(mPois.get(position).getName());
		row.setOnClickListener(new ScheduleOnClickListener(position));
		
		return row;
	}

	static class PoIHolder {
		ImageView imagePoI;
	    TextView addressPoI;
	    TextView titlePoI;
	}
	
	class ScheduleOnClickListener implements OnClickListener {
		
		private int pos;
		
		ScheduleOnClickListener(int pos){
			
			this.pos = pos;
		}
		
	      public void onClick(View v) {
	    	  Intent myIntent = new Intent(mContext, PoIDetailsActivity.class);
	    	  myIntent.putExtra("PoI", mPois.get(pos));
	    	  myIntent.putExtra("Image", String.valueOf(pos));
		      mContext.startActivity(myIntent);
	      }
	    }
}
