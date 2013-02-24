package com.filippudak.fiestatime;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.filippudak.fiestatime.model.Film;
import com.filippudak.fiestatime.model.FilmVenue;
import com.filippudak.fiestatime.model.PoI;
import com.filippudak.fiestatime.model.Venue;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;

public class FiestaTimeApplication extends Application {
	
	public static Bitmap images[];
	public static int imageIds[];
	public static Film films[];
	public static PoI pois[];
	public static ArrayList<Venue> venues;
	public static ArrayList<String> headersVenue = new ArrayList<String>();
	public static Map<String, ArrayList<Venue>> sectionsVenue = new LinkedHashMap<String, ArrayList<Venue>>();
	public static ArrayList<String> headersPoi = new ArrayList<String>();
	public static Map<String, ArrayList<PoI>> sectionsPoi = new LinkedHashMap<String, ArrayList<PoI>>();
	public static String address = "Ilica 1, Zagreb";
	public static double latitude = 45.81307;
	public static double longitude = 15.97608;

	private static FiestaTimeApplication singleton;

	public FiestaTimeApplication getInstance() {
		return singleton;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		singleton = this;
		setupImages();
		setupFilms();
		setupVenues();
		setupPois();
		System.out.println("RAWR");
	}
		
	public void setupImages(){
		images = new Bitmap[8];
		imageIds = new int[8];
		
		Bitmap icon = decodeSampledBitmapFromResource(getResources(), R.drawable.the_hobbit, 300, 300);
		
		Bitmap icon1 = decodeSampledBitmapFromResource(getResources(), R.drawable.superman, 300, 300);
		
		Bitmap icon2 = decodeSampledBitmapFromResource(getResources(), R.drawable.django, 300, 300);
		
		Bitmap icon3 = decodeSampledBitmapFromResource(getResources(), R.drawable.iron_man, 300, 300);
		
		Bitmap icon4 = decodeSampledBitmapFromResource(getResources(), R.drawable.star_trek, 300, 300);
		
		Bitmap icon5 = decodeSampledBitmapFromResource(getResources(), R.drawable.suckerpunch, 300, 300);
		
		Bitmap icon6 = decodeSampledBitmapFromResource(getResources(), R.drawable.taken_2, 300, 300);
		
		Bitmap icon7 = decodeSampledBitmapFromResource(getResources(), R.drawable.world_war_z, 300, 300);
	
		images[0] = icon;
		images[1] = icon1;
		images[2] = icon2;
		images[3] = icon3;
		images[4] = icon4;
		images[5] = icon5;
		images[6] = icon6;
		images[7] = icon7;
		
		imageIds[0] = R.drawable.the_hobbit;
		imageIds[1] = R.drawable.superman;
		imageIds[2] = R.drawable.django;
		imageIds[3] = R.drawable.iron_man;
		imageIds[4] = R.drawable.star_trek;
		imageIds[5] = R.drawable.suckerpunch;
		imageIds[6] = R.drawable.taken_2;
		imageIds[7] = R.drawable.world_war_z;
		
	}
	
	public void setupFilms(){
		films = new Film[8];
		    
	    Film hobbit = new Film("The Hobbit", "<b>Director : </b>Peter Jackson", "169 min, New Zealand", 
	    						"<b>Starring : </b>Martin Freeman, Ian McKellen, Richard Armitage",
	    						"<b>Summary : </b>A younger and more reluctant Hobbit, Bilbo Baggins, sets out on an \"unexpected journey\" to the Lonely Mountain with a spirited group of Dwarves to reclaim their stolen mountain home from a dragon named Smaug.",
	    						"ADVENTURE | FANTASY", 
	    						"http://www.youtube.com/watch?v=nOGsB9dORBg", "http:/rokaj.com", 4.7);
	    FilmVenue[] venues = new FilmVenue[3];
	    FilmVenue venue = new FilmVenue();
	    venue.setDate("01-01-2013");
	    venue.setTime("19:30");
	    venue.setPlace("Big Hall");
	    venues[0] = venue;
	    venue = new FilmVenue();
	    venue.setDate("02-01-2013");
	    venue.setTime("19:30");
	    venue.setPlace("Small Hall");
	    venues[1] = venue;
	    venue = new FilmVenue();
	    venue.setDate("03-01-2013");
	    venue.setTime("18:30");
	    venue.setPlace("Big Hall");
	    venues[2] = venue;
	    hobbit.setVenues(venues);
	    films[0] = hobbit;
	    
	    Film superman = new Film("Man of Steel", "<b>Director : </b>Zack Snyder", "148 min, USA", 
				"<b>Starring : </b>Henry Cavill, Russell Crowe, Amy Adams",
				"<b>Summary : </b>A young journalist raised by his adoptive parents after he was transported to Earth in infancy from the dying planet of Krypton finds himself in the position to save humankind after Earth is attacked.",
				"ACTION | ADVENTURE | FANTASY", 
				"http://www.youtube.com/watch?v=KVu3gS7iJu4", "http:/rokaj.com", 4.4);
	    venues = new FilmVenue[3];
	    venue = new FilmVenue();
	    venue.setDate("01-01-2013");
	    venue.setTime("19:30");
	    venue.setPlace("Big Hall");
	    venues[0] = venue;
	    venue = new FilmVenue();
	    venue.setDate("02-01-2013");
	    venue.setTime("19:30");
	    venue.setPlace("Small Hall");
	    venues[1] = venue;
	    venue = new FilmVenue();
	    venue.setDate("03-01-2013");
	    venue.setTime("18:30");
	    venue.setPlace("Big Hall");
	    venues[2] = venue;
	    superman.setVenues(venues);
	    films[1] = superman;
	    
	    Film django = new Film("Django", "<b>Director : </b>Quentin Tarantino", "165 min, USA", 
				"<b>Starring : </b>Jamie Foxx, Christoph Waltz, Leonardo DiCaprio",
				"<b>Summary : </b>With the help of a German bounty hunter, a freed slave sets out to rescue his wife from a brutal Mississippi plantation owner.",
				"ADVENTURE | DRAMA | WESTERN", 
				"http://www.youtube.com/watch?v=eUdM9vrCbow", "http:/rokaj.com", 4.5);
	    venues = new FilmVenue[3];
	    venue = new FilmVenue();
	    venue.setDate("01-01-2013");
	    venue.setTime("19:30");
	    venue.setPlace("Big Hall");
	    venues[0] = venue;
	    venue = new FilmVenue();
	    venue.setDate("02-01-2013");
	    venue.setTime("19:30");
	    venue.setPlace("Small Hall");
	    venues[1] = venue;
	    venue = new FilmVenue();
	    venue.setDate("03-01-2013");
	    venue.setTime("18:30");
	    venue.setPlace("Big Hall");
	    venues[2] = venue;
	    django.setVenues(venues);
	    films[2] = django;
	    
	    Film ironman = new Film("Iron Man 3", "<b>Director : </b>Shane Black", "120 min, USA", 
				"<b>Starring : </b>Robert Downey Jr., Guy Pearce, Gwyneth Paltrow", 
				"<b>Summary : </b>Marvel's \"Iron Man 3\" pits brash-but-brilliant industrialist Tony Stark/Iron Man against an enemy whose reach knows no bounds (Mandarin). When Stark finds his personal world destroyed at his enemy's hands, he embarks on a harrowing quest to find those responsible. This journey, at every turn, will test his mettle.", 
				"ACTION | ADVENTURE | SCI-FI", 
				"http://www.youtube.com/watch?v=2CzoSeClcw0", "http:/rokaj.com", 4.0);
	    venues = new FilmVenue[3];
	    venue = new FilmVenue();
	    venue.setDate("01-01-2013");
	    venue.setTime("19:30");
	    venue.setPlace("Big Hall");
	    venues[0] = venue;
	    venue = new FilmVenue();
	    venue.setDate("02-01-2013");
	    venue.setTime("19:30");
	    venue.setPlace("Small Hall");
	    venues[1] = venue;
	    venue = new FilmVenue();
	    venue.setDate("03-01-2013");
	    venue.setTime("18:30");
	    venue.setPlace("Big Hall");
	    venues[2] = venue;
	    ironman.setVenues(venues);
	    films[3] = ironman;
	    
	    Film startrek = new Film("Star Trek 2", "<b>Director : </b>J.J. Abrams", "129 min, USA", 
				"<b>Starring : </b>Chris Pine, Zachary Quinto, Zoe Saldana", 
				"<b>Summary : </b>After the crew of the Enterprise find an unstoppable force of terror from within their own organization, Captain Kirk leads a manhunt to a war-zone world to capture a one man weapon of mass destruction.", 
				"ACTION | ADVENTURE | SCI-FI", 
				"http://www.youtube.com/watch?v=diP-o_JxysA", "http:/rokaj.com", 4.0);
	    venues = new FilmVenue[3];
	    venue = new FilmVenue();
	    venue.setDate("01-01-2013");
	    venue.setTime("19:30");
	    venue.setPlace("Big Hall");
	    venues[0] = venue;
	    venue = new FilmVenue();
	    venue.setDate("02-01-2013");
	    venue.setTime("19:30");
	    venue.setPlace("Small Hall");
	    venues[1] = venue;
	    venue = new FilmVenue();
	    venue.setDate("03-01-2013");
	    venue.setTime("18:30");
	    venue.setPlace("Big Hall");
	    venues[2] = venue;
	    startrek.setVenues(venues);
	    films[4] = startrek;
	    
	    Film suckerpunch = new Film("Suckerpunch", "<b>Director : </b>Peter Jackson", "110 min, USA", 
				"<b>Starring : </b>Emily Browning, Vanessa Hudgens, Abbie Cornish",
				"<b>Summary : </b>A young girl is institutionalized by her abusive stepfather. Retreating to an alternative reality as a coping strategy, she envisions a plan which will help her escape from the mental facility.",
				"ACTION | FANTASY | THRILLER", 
				"http://www.youtube.com/watch?v=vp6yBwZgpxA", "http:/rokaj.com", 4.0);
	    venues = new FilmVenue[3];
	    venue = new FilmVenue();
	    venue.setDate("01-01-2013");
	    venue.setTime("19:30");
	    venue.setPlace("Big Hall");
	    venues[0] = venue;
	    venue = new FilmVenue();
	    venue.setDate("02-01-2013");
	    venue.setTime("19:30");
	    venue.setPlace("Small Hall");
	    venues[1] = venue;
	    venue = new FilmVenue();
	    venue.setDate("03-01-2013");
	    venue.setTime("18:30");
	    venue.setPlace("Big Hall");
	    venues[2] = venue;
	    suckerpunch.setVenues(venues);
	    films[5] = suckerpunch;
	    
	    Film taken2 = new Film("Taken 2", "<b>Director : </b>Olivier Megaton", "92 min, USA", 
				"<b>Starring : </b>Liam Neeson, Famke Janssen, Maggie Grace", 
				"<b>Summary : </b>In Istanbul, retired CIA operative Bryan Mills and his wife are taken hostage by the father of a kidnapper Mills killed while rescuing his daughter.",
				"ACTION | CRIME | THRILLER", 
				"http://www.youtube.com/watch?v=VpaT8NzkLgE", "http:/rokaj.com", 4.0);
	    venues = new FilmVenue[3];
	    venue = new FilmVenue();
	    venue.setDate("01-01-2013");
	    venue.setTime("19:30");
	    venue.setPlace("Big Hall");
	    venues[0] = venue;
	    venue = new FilmVenue();
	    venue.setDate("02-01-2013");
	    venue.setTime("19:30");
	    venue.setPlace("Small Hall");
	    venues[1] = venue;
	    venue = new FilmVenue();
	    venue.setDate("03-01-2013");
	    venue.setTime("18:30");
	    venue.setPlace("Big Hall");
	    venues[2] = venue;
	    taken2.setVenues(venues);
	    films[6] = taken2;
	    
	    Film wwz = new Film("World War Z", "<b>Director : </b>Marc Forster", "180 min, USA", 
				"<b>Starring : </b>Brad Pitt, Mireille Enos, David Morse", 
				"<b>Summary : </b>A U.N. employee is racing against time and fate, as he travels the world trying to stop the outbreak of a deadly Zombie pandemic.", 
				"ACTION | DRAMA | HORROR ", 
				"http://www.youtube.com/watch?v=HcwTxRuq-uk", "http:/rokaj.com", 4.0);
	    venues = new FilmVenue[3];
	    venue = new FilmVenue();
	    venue.setDate("01-01-2013");
	    venue.setTime("19:30");
	    venue.setPlace("Big Hall");
	    venues[0] = venue;
	    venue = new FilmVenue();
	    venue.setDate("02-01-2013");
	    venue.setTime("19:30");
	    venue.setPlace("Small Hall");
	    venues[1] = venue;
	    venue = new FilmVenue();
	    venue.setDate("03-01-2013");
	    venue.setTime("18:30");
	    venue.setPlace("Big Hall");
	    venues[2] = venue;
	    wwz.setVenues(venues);
	    films[7] = wwz;
	}
	
	public void setupVenues(){
		
		for (int i = 0; i < films.length; i++) {
			for (int j = 0; j < films[i].getVenues().length; j++) {
				FilmVenue[] venues = films[i].getVenues();
				if (!sectionsVenue.containsKey(venues[j].getDate())){
					sectionsVenue.put(venues[j].getDate(), new ArrayList<Venue>());
					headersVenue.add(venues[j].getDate());
				}
				Venue venue = new Venue();
				venue.setFilm(films[i]);
				venue.setDate(venues[j].getDate());
				venue.setPlace(venues[j].getPlace());
				venue.setTime(venues[j].getTime());
				sectionsVenue.get(venues[j].getDate()).add(venue);
			}
		}
	}
	
	void setupPois(){
		
		pois = new PoI[3];
		PoI poi = new PoI();
		poi.setAddress("Ulica kneza Borne 2, 10000 Zagreb");
		poi.setName("Hotel Sheraton");
		poi.setCategory("Lodging");
		poi.setType("<b>Type : </b>Hotel");
		poi.setPhone("<b>Phone : </b>+385 1 4553 535");
		poi.setLatitude(45.80760);
		poi.setLongitude(15.98425);
		poi.setImage(R.drawable.sheraton);
		poi.setInfo("<b>About : </b>Located in the city centre, Sheraton Zagreb Hotel is just a stroll away from the main attractions where Zagreb’s history and tradition can be witnessed in museums and galleries, architecture, numerous theatres, lively cafés, and bars. Offering easy access to the city’s main points of interest and close to public transport, we are the hotel of choice for business and leisure travellers.");
		pois[0] = poi;
		
		poi = new PoI();
		poi.setAddress("Skalinska ulica 4, 10000 Zagreb");
		poi.setName("Nokturno");
		poi.setCategory("Food & Drink");
		poi.setType("<b>Type : </b>Restaurant");
		poi.setPhone("<b>Phone : </b>+385 1 4813 394");
		poi.setLatitude(45.814773);
		poi.setLongitude(15.977066);
		poi.setImage(R.drawable.nokturno);
		poi.setInfo("<b>About : </b>Nokturno, a tiny Zagreb institution made of Italian flavors and aromas located on the picturesque Skalinska Street. Nokturno Restaurant gladly offers Zagrebites and eager visitors alike an extensive menu of Italian fare and Croatian delicacies. The decade-long Nokturno tradition of offering to gourmands a pleasant atmosphere with Zagreb character includes delicious pizzas, pastas, risottos, and meat specialities which all await your tempted palette.");
		pois[1] = poi;
		
		poi = new PoI();
		poi.setAddress("Tuškanac ulica 1A, 10000 Zagreb");
		poi.setName("Saloon");
		poi.setCategory("Nightlife");
		poi.setType("<b>Type : </b>Night Club");
		poi.setPhone("<b>Phone : </b>+385 1 4834 903");
		poi.setLatitude(45.815485);
		poi.setLongitude(15.969524);
		poi.setImage(R.drawable.saloon);
		poi.setInfo("<b>About : </b>Hoping to avoid the guest lists and dress code police in search of unadulterated fun amongst the locals? If so, include Saloon nightclub in your plans and don't worry, you can leave the pistols at home. Established as Zagreb's first dedicated nightclub back 1970, Saloon has recently celebrated its 35th birthday and since its conception, has become one of Zagreb's, and indeed Croatia's, most beloved of nocturnal hotspots. Tourists are welcomed with the same sweaty embrace and feel good vibe afforded to the locals that frequent the club regularly and, unlike some of Zagreb's 'trendier' hotspots, the mood is decidedly unpretentious. Cast aside your clubbing hang ups and participate in a bit of Zagreb's nightlife heritage.");
		pois[2] = poi;
		
		for (int i = 0; i < pois.length; i++) {
			if(!sectionsPoi.containsKey(pois[i].getCategory()))
			{
				sectionsPoi.put(pois[i].getCategory(), new ArrayList<PoI>());
				headersPoi.add(pois[i].getCategory());
			}
			sectionsPoi.get(pois[i].getCategory()).add(pois[i]);
		}
	}
	
	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
	        int reqWidth, int reqHeight) {

	    // First decode with inJustDecodeBounds=true to check dimensions
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;
	    BitmapFactory.decodeResource(res, resId, options);
	    int imageHeight = options.outHeight;
	    int imageWidth = options.outWidth;
	    DisplayMetrics metrics = res.getDisplayMetrics();
	    int width = metrics.widthPixels;
	    int height = metrics.heightPixels;
	    // Calculate inSampleSize
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);  

	    // Decode bitmap with inSampleSize set
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeResource(res, resId, options);
	}
	
	public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        // Calculate ratios of height and width to requested height and width
        final int heightRatio = Math.round((float) height / (float) reqHeight);
        final int widthRatio = Math.round((float) width / (float) reqWidth);

        // Choose the smallest ratio as inSampleSize value, this will guarantee
        // a final image with both dimensions larger than or equal to the
        // requested height and width.
        inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
    }

    return inSampleSize;
}

}
