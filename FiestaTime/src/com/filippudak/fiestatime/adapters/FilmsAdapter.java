package com.filippudak.fiestatime.adapters;

import com.filippudak.fiestatime.FilmDetailActivity;
import com.filippudak.fiestatime.R;
import com.filippudak.fiestatime.model.Film;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class FilmsAdapter extends BaseAdapter{
	
	private Film[] filmsList;
	private Context context;
	private Bitmap[] images;
	private int elementPosition;
	
	public FilmsAdapter(Context context, Film[] filmsList, Bitmap[] images)
	{
		this.filmsList = filmsList;
		this.context = context;
		this.images = images;
	}

	@Override
	public int getCount() {
		
		int numOfBigs = (int) Math.ceil(filmsList.length / 5.0);
		int numOfSmalls = (int) Math.ceil((filmsList.length - numOfBigs) / 2.0);
		
		return numOfBigs + numOfSmalls;
	}

	@Override
	public Object getItem(int position) {
		return filmsList[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}	

	@Override
	public int getItemViewType(int position) {
		return position % 3;
	}

	@Override
	public int getViewTypeCount() {
		return 3;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		OnePictureViewHolder onePictureViewHolder = null;
		TwoPicturesViewHolder twoPicturesViewHolder = null;
		
		int type = getItemViewType(position);
		
		int numOfBigs = (int) Math.ceil(position / 3.0);
		int numOfSmalls = position - numOfBigs;
		elementPosition = numOfBigs + 2*numOfSmalls;
		
		View row = convertView;
				
		if (row == null)
		{
			LayoutInflater inflater = (LayoutInflater) context
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			if (type == 0)
			{
				onePictureViewHolder = new OnePictureViewHolder();
				row = inflater.inflate(R.layout.list_item1_films, parent, false);
				onePictureViewHolder.image = (ImageView) row.findViewById(R.id.films_row1_image1);
				onePictureViewHolder.text = (TextView) row.findViewById(R.id.films_row1_text1);
				row.setTag(onePictureViewHolder);
			}	
			else
			{
		    	twoPicturesViewHolder = new TwoPicturesViewHolder();
		    	row = inflater.inflate(R.layout.list_item2_films, parent, false);
		    	twoPicturesViewHolder.flLeft = (FrameLayout) row.findViewById(R.id.films_row2_frameLayout1);
		    	twoPicturesViewHolder.imageLeft = (ImageView) row.findViewById(R.id.films_row2_image1);
		    	twoPicturesViewHolder.textLeft = (TextView) row.findViewById(R.id.films_row2_text1);
		    	
		    	twoPicturesViewHolder.flRight = (FrameLayout) row.findViewById(R.id.films_row2_frameLayout2);
		    	twoPicturesViewHolder.imageRight = (ImageView) row.findViewById(R.id.films_row2_image2);
		    	twoPicturesViewHolder.textRight = (TextView) row.findViewById(R.id.films_row2_text2);
		    	row.setTag(twoPicturesViewHolder);
			}					
		
		}
		else
		{
			if (type == 0)
			{
				onePictureViewHolder = (OnePictureViewHolder) row.getTag();
			}
			else
			{
		    	twoPicturesViewHolder = (TwoPicturesViewHolder) row.getTag();
			}
		}
		
		if (type == 0)
		{
		    onePictureViewHolder.image.setImageBitmap(images[elementPosition]);		    
		    onePictureViewHolder.text.setText(filmsList[elementPosition].getTitle());
		    onePictureViewHolder.image.setOnClickListener(new FilmsOnClickListener(elementPosition));
		    
		}
		else
		{
		    twoPicturesViewHolder.imageLeft.setImageBitmap(images[elementPosition]);
		    twoPicturesViewHolder.textLeft.setText(filmsList[elementPosition].getTitle());
		    twoPicturesViewHolder.flLeft.setOnClickListener(new FilmsOnClickListener(elementPosition));
		    
		    if (elementPosition+1 < filmsList.length)
		    {
			    twoPicturesViewHolder.imageRight.setImageBitmap(images[elementPosition+1]);
			    twoPicturesViewHolder.textRight.setText(filmsList[elementPosition+1].getTitle());
			    twoPicturesViewHolder.flRight.setOnClickListener(new FilmsOnClickListener(elementPosition+1));
		    }
		    else
		    {
		    	
		    	 twoPicturesViewHolder.flRight.setBackgroundColor(Color.TRANSPARENT);
		    	 twoPicturesViewHolder.imageRight.setImageDrawable(null);
				 twoPicturesViewHolder.textRight.setText("");
		    	 twoPicturesViewHolder.flRight.setOnClickListener(null);
		    }
		    
		}
				
		return row;
	}
	
	
	/**
	 * View Holders -> They save the ids of elements so a findviewbyid call is not necessary every time we deal with an element.
	 */		
	static class OnePictureViewHolder {
		ImageView image;
	    TextView text;
	}
	
	static class TwoPicturesViewHolder {
		FrameLayout flLeft;
		ImageView imageLeft;
	    TextView textLeft;
	    FrameLayout flRight;
	    ImageView imageRight;
	    TextView textRight;
	}
	
	/**
	 * OnClickListener -> Handles clicks on films in the list
	 */
	class FilmsOnClickListener implements OnClickListener {
		
		private int pos;
		
		FilmsOnClickListener(int pos){
			
			this.pos = pos;
		}
		
	      public void onClick(View v) {
	    	  Intent myIntent = new Intent(context, FilmDetailActivity.class);
	    	  myIntent.putExtra("Film", filmsList[pos]);
	    	  myIntent.putExtra("Image", String.valueOf(pos));
		      context.startActivity(myIntent);
	      }
	    }

}
