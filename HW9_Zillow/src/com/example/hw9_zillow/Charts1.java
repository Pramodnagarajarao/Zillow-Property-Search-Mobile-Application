package com.example.hw9_zillow;

//import org.json.JSONException;
//import org.json.JSONObject;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;


import android.app.Activity;
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
 
public class Charts1 extends Activity
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
    JSONObject jsonObject_charts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //My code 
        System.out.println("Inside Charts1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts1);
        
		try {
	      System.out.println("valid value before Charts1:");
		  jsonObject_charts = new JSONObject(getIntent().getStringExtra("jsonDataone"));	    
		  System.out.println("valid value after Charts1"+jsonObject_charts);
		  
		  String year1 = jsonObject_charts.getJSONObject("chart").get("year1").toString();
		  String years5 = jsonObject_charts.getJSONObject("chart").get("years5").toString();
		  String years10 = jsonObject_charts.getJSONObject("chart").get("years10").toString(); 
		  System.out.println("valid value after year1"+year1);
		  System.out.println("valid value after years5"+years5);
		  System.out.println("valid value after years10"+years10);
//  	      TextView textview1 = (TextView) findViewById(R.id.historicalHeading);
//  	      textview1.setText(year1);
//Ends
		  
          historicalHeading = (TextView) findViewById(R.id.historicalHeading);
          addressHeading = (TextView) findViewById(R.id.addressHeading);
          chartImage = (ImageView) findViewById(R.id.chartImageView);
          footer1 = (TextView) findViewById(R.id.footer1);
          footer2 = (TextView) findViewById(R.id.footer2);
          footer3 = (TextView) findViewById(R.id.footer3);
          nextButton = (Button) findViewById(R.id.btnNext);
  	      
          nextButton.setOnClickListener(new View.OnClickListener()
          {
              @Override
              public void onClick(View v) {
                  counter++;
                  if(counter==3)
                      counter=0;
                  if(counter==0)
                  {
                      historicalHeading.setText("Historical Zestimate for the past 1 year");
                      addressHeading.setText(completeAddress);
                      chartImage.setImageBitmap(Bitmap.createScaledBitmap(bitmap1,1200, 850, false));                }
                  else if(counter==1)
                  {
                      historicalHeading.setText("Historical Zestimate for the past 5 years");
                      addressHeading.setText(completeAddress);
                      chartImage.setImageBitmap(Bitmap.createScaledBitmap(bitmap2,1200, 850, false));
                  }
                  else if (counter==2)
                  {
                      historicalHeading.setText("Historical Zestimate for the past 10 years");
                      addressHeading.setText(completeAddress);
                      chartImage.setImageBitmap(Bitmap.createScaledBitmap(bitmap3,1200, 850, false));
                  }
              }
          });
          prevButton = (Button) findViewById(R.id.btnPrevious);
          prevButton.setOnClickListener(new View.OnClickListener()
          {
              @Override
              public void onClick(View v) {
                  counter--;
                  if(counter==-1)
                      counter=2;
                  if(counter==0)
                  {
                      historicalHeading.setText("Historical Zestimate for the past 1 year");
                      addressHeading.setText(completeAddress);
                      chartImage.setImageBitmap(Bitmap.createScaledBitmap(bitmap1,1200, 850, false));                }
                  else if(counter==1)
                  {
                      historicalHeading.setText("Historical Zestimates for the past 5 years");
                      addressHeading.setText(completeAddress);
                      chartImage.setImageBitmap(Bitmap.createScaledBitmap(bitmap2,1200, 850, false));
                  }
                  else if (counter==2)
                  {
                      historicalHeading.setText("Historical Zestimates for the past 10 years");
                      addressHeading.setText(completeAddress);
                      chartImage.setImageBitmap(Bitmap.createScaledBitmap(bitmap3,1200, 850, false));
                  }
              }
          });

          footer2.setOnClickListener(new View.OnClickListener()
          {
              @Override
              public void onClick(View v) {
                  //TODO: footer2b handling
              }
          });
          footer3.setOnClickListener(new View.OnClickListener()
          {
              @Override
              public void onClick(View v) {
                  //TODO: Click for the link
              }
          });
  	      
          DrawChart drawChart = new DrawChart();
          String jsonString = jsonObject_charts.toString();
		  drawChart.execute(jsonString);
  	      
		  
		} catch (JSONException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    private class DrawChart extends AsyncTask<String,Void,Bitmap>
    {
        @Override
        protected Bitmap doInBackground(String... params)
        {
            try
            {
                 JSONObject jsonObject = new JSONObject(params[0]);
                 System.out.println(" My brand new jsonObject inside DrawChartclassis");
                 System.out.println(jsonObject);
//                String chart1Url = jsonObject.get("chartUrl1").toString();
//                String chart5Url = jsonObject.get("chartUrl5").toString();
//                String chart10Url = jsonObject.get("chartUrl10").toString();              
//                String chart1Url = jsonObject.get("chart").get("year1").toString();
//                String chart5Url = jsonObject.get("chart").get("years5").toString();
//                String chart10Url = jsonObject.get("chart").get("years10").toString();
//               completeAddress = jsonObject.getJSONObject("streetResponse").get("value").toString()+" ";
//               completeAddress+= jsonObject.getJSONObject("cityResponse").get("value").toString()+ " ";
//               completeAddress+= jsonObject.getJSONObject("stateResponse").get("value").toString()+" ";
//               completeAddress+= jsonObject.getJSONObject("zipResponse").get("value").toString();
                
        	      String chart1Url = jsonObject.getJSONObject("chart").get("year1").toString();
        	      String chart5Url = jsonObject.getJSONObject("chart").get("years5").toString();
        	      String chart10Url = jsonObject.getJSONObject("chart").get("years10").toString(); 
            	  String street = jsonObject.getJSONObject("result").get("street").toString();
            	  String city = jsonObject.getJSONObject("result").get("city").toString();
            	  String state = jsonObject.getJSONObject("result").get("state").toString();
            	  String zipcode = jsonObject.getJSONObject("result").get("zipcode").toString();

            	  System.out.println("chart1Url");
            	  System.out.println(chart1Url);
            	  System.out.println("chart5Url");
            	  System.out.println(chart5Url);
            	  System.out.println("chart10Url");
            	  System.out.println(chart10Url);
            	  System.out.println("street");
            	  System.out.println(street);
            	  System.out.println("city");
            	  System.out.println(city);
            	  System.out.println("state");
            	  System.out.println(state);
            	  System.out.println("zipcode");
            	  System.out.println(zipcode);
            	  
                 completeAddress = new String();
                 completeAddress = street+","+city+","+state+"-"+zipcode;

                    System.out.println("completeAddress");
                    System.out.println(completeAddress);


                InputStream in = new java.net.URL(chart1Url).openStream();
                bitmap1 = BitmapFactory.decodeStream(in);
                bitmaps.add(bitmap1);

                in = new java.net.URL(chart5Url).openStream();
                bitmap2 = BitmapFactory.decodeStream(in);
                bitmaps.add(bitmap2);

                in = new java.net.URL(chart10Url).openStream();
                bitmap3 = BitmapFactory.decodeStream(in);
                bitmaps.add(bitmap1);

                return bitmap1;
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap)
        {
            super.onPostExecute(bitmap);
            
            addressHeading.setText(completeAddress);
            if(bitmap!=null)
            {
            	historicalHeading.setText("Historical Zestimate for the past 1 year");
            	chartImage.setImageBitmap(Bitmap.createScaledBitmap(bitmap,1200, 850, false));
	            prevButton.setVisibility(View.VISIBLE);
	            nextButton.setVisibility(View.VISIBLE);
        	}   
            else
            	historicalHeading.setText("No chart info available");
            footer1.setVisibility(View.VISIBLE);
            footer2.setVisibility(View.VISIBLE);
            footer3.setVisibility(View.VISIBLE);

            footer2.setText(Html.fromHtml(
                    "Use is subject to "+
                            "<a href=\"http://www.zillow.com/wikipages/Privacy-and-Terms-of-Use/\">Terms of Use</a> "
            ));
            footer2.setMovementMethod(LinkMovementMethod.getInstance());

            footer3.setText(Html.fromHtml(

                    "<a href=\"http://www.zillow.com/zestimate/\">What's a Zestimate</a> "
            ));
            footer3.setMovementMethod(LinkMovementMethod.getInstance());


        }
    }
}
