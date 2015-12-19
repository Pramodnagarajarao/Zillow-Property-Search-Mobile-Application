package com.example.hw9_zillow;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//
//public class Charts extends Activity {
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_charts);
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.charts, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
//}


import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class Charts extends Fragment
{
    ArrayList<Bitmap> bitmaps = new ArrayList<Bitmap>();
    Bitmap bitmap1;
    Bitmap bitmap2;
    Bitmap bitmap3;
    String completeAddress;
    int counter=0;
    TextView historicalHeading;
    TextView addressHeading;
    ImageView chartImage;
    TextView footer1;
    TextView footer2;
    TextView footer3;

    Button nextButton;
    Button prevButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_charts, container, false);

        Bundle b = getArguments();
        String jsonString = b.getString("jsonObject");

//        historicalHeading = (TextView) view.findViewById(R.id.historicalHeading);
//        addressHeading = (TextView) view.findViewById(R.id.addressHeading);
//        chartImage = (ImageView) view.findViewById(R.id.chartImageView);
//        footer1 = (TextView) view.findViewById(R.id.footer1);
//        footer2 = (TextView) view.findViewById(R.id.footer2);
//        footer3 = (TextView) view.findViewById(R.id.footer3);
//
//        nextButton = (Button) view.findViewById(R.id.btnNext);
//        nextButton.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v) {
//                counter++;
//                if(counter==3)
//                    counter=0;
//                if(counter==0)
//                {
//                    historicalHeading.setText(R.string.historical1heading);
//                    addressHeading.setText(completeAddress);
//                    chartImage.setImageBitmap(Bitmap.createScaledBitmap(bitmap1,1200, 850, false));                }
//                else if(counter==1)
//                {
//                    historicalHeading.setText(R.string.historical5heading);
//                    addressHeading.setText(completeAddress);
//                    chartImage.setImageBitmap(Bitmap.createScaledBitmap(bitmap2,1200, 850, false));
//                }
//                else if (counter==2)
//                {
//                    historicalHeading.setText(R.string.historical10heading);
//                    addressHeading.setText(completeAddress);
//                    chartImage.setImageBitmap(Bitmap.createScaledBitmap(bitmap3,1200, 850, false));
//                }
//            }
//        });
//        prevButton = (Button) view.findViewById(R.id.btnPrevious);
//        prevButton.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v) {
//                counter--;
//                if(counter==-1)
//                    counter=2;
//                if(counter==0)
//                {
//                    historicalHeading.setText(R.string.historical1heading);
//                    addressHeading.setText(completeAddress);
//                    chartImage.setImageBitmap(Bitmap.createScaledBitmap(bitmap1,1200, 850, false));                }
//                else if(counter==1)
//                {
//                    historicalHeading.setText(R.string.historical5heading);
//                    addressHeading.setText(completeAddress);
//                    chartImage.setImageBitmap(Bitmap.createScaledBitmap(bitmap2,1200, 850, false));
//                }
//                else if (counter==2)
//                {
//                    historicalHeading.setText(R.string.historical10heading);
//                    addressHeading.setText(completeAddress);
//                    chartImage.setImageBitmap(Bitmap.createScaledBitmap(bitmap3,1200, 850, false));
//                }
//            }
//        });
//
//        footer2.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v) {
//                //TODO: footer2b handling
//            }
//        });
//        footer3.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v) {
//                //TODO: Click for the link
//            }
//        });
//        DrawChartTask drawChart = new DrawChartTask();
//        drawChart.execute(jsonString);


        return view;
    }

//    private class DrawChartTask extends AsyncTask<String,Void,Bitmap>
//    {
//        @Override
//        protected Bitmap doInBackground(String... params)
//        {
//            try
//            {
//                JSONObject jsonObject = new JSONObject(params[0]);
//                String chart1Url = jsonObject.get("chartUrl1").toString();
//                String chart5Url = jsonObject.get("chartUrl5").toString();
//                String chart10Url = jsonObject.get("chartUrl10").toString();
//
//                completeAddress = new String();
//                completeAddress = jsonObject.getJSONObject("streetResponse").get("value").toString()+" ";
//                completeAddress+= jsonObject.getJSONObject("cityResponse").get("value").toString()+ " ";
//                completeAddress+= jsonObject.getJSONObject("stateResponse").get("value").toString()+" ";
//                completeAddress+= jsonObject.getJSONObject("zipResponse").get("value").toString();
//
//                System.out.println(chart10Url);
//                InputStream in = new java.net.URL(chart1Url).openStream();
//                bitmap1 = BitmapFactory.decodeStream(in);
//                bitmaps.add(bitmap1);
//
//                in = new java.net.URL(chart5Url).openStream();
//                bitmap2 = BitmapFactory.decodeStream(in);
//                bitmaps.add(bitmap2);
//
//                in = new java.net.URL(chart10Url).openStream();
//                bitmap3 = BitmapFactory.decodeStream(in);
//                bitmaps.add(bitmap1);
//
//                return bitmap1;
//            }
//            catch (JSONException e)
//            {
//                e.printStackTrace();
//            }
//            catch (MalformedURLException e)
//            {
//                e.printStackTrace();
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return null;
//        }

//        @Override
//        protected void onPostExecute(Bitmap bitmap)
//        {
//            super.onPostExecute(bitmap);
//            
//            addressHeading.setText(completeAddress);
//            if(bitmap!=null)
//            {
//            	historicalHeading.setText(R.string.historical1heading);
//            	chartImage.setImageBitmap(Bitmap.createScaledBitmap(bitmap,1200, 850, false));
//	            prevButton.setVisibility(View.VISIBLE);
//	            nextButton.setVisibility(View.VISIBLE);
//        	}   
//            else
//            	historicalHeading.setText("No chart info available");
//            footer1.setVisibility(View.VISIBLE);
//            footer2.setVisibility(View.VISIBLE);
//            footer3.setVisibility(View.VISIBLE);
//
//            footer2.setText(Html.fromHtml(
//                    "Use is subject to "+
//                            "<a href=\"http://www.zillow.com/wikipages/Privacy-and-Terms-of-Use/\">Terms of Use</a> "
//            ));
//            footer2.setMovementMethod(LinkMovementMethod.getInstance());
//
//            footer3.setText(Html.fromHtml(
//
//                    "<a href=\"http://www.zillow.com/zestimate/\">What's a Zestimate</a> "
//            ));
//            footer3.setMovementMethod(LinkMovementMethod.getInstance());
//
//
//        }
//    }
}

