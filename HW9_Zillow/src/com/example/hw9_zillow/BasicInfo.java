package com.example.hw9_zillow;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

//import com.facebook.UiLifecycleHelper;

public class BasicInfo extends Fragment {
	
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState)
    {
        Bundle b = getArguments();
        String jsonString = b.getString("jsonObject");
        System.out.println("Inisde onCreateView of basicinfo before try");
        JSONObject jsonObject;
        String completeAddress;
        String link;
        View view = inflater.inflate(R.layout.activity_basic_info, container, false);
        try
        {   
        	System.out.println("Inisde onCreateView of basicinfo try");
            jsonObject = new JSONObject(jsonString);
//
//            completeAddress = new String();
//            completeAddress = jsonObject.getJSONObject("streetResponse").get("value").toString()+" ";
//            completeAddress+= jsonObject.getJSONObject("cityResponse").get("value").toString()+ " ";
//            completeAddress+= jsonObject.getJSONObject("stateResponse").get("value").toString()+ " ";
//            completeAddress+= jsonObject.getJSONObject("zipResponse").get("value").toString();
//
//            link = new String(jsonObject.getJSONObject("homeDetails").get("value").toString());
////TODO:Create the link for homeDetails and set it in the textView..
//            String htmlString=new String( "<a href=\""+link+"\">"+completeAddress+"</a>");
//            TextView tv_link = (TextView) view.findViewById(R.id.tv_link);
//            tv_link.setText(Html.fromHtml(htmlString));
//            tv_link.setMovementMethod(LinkMovementMethod.getInstance());
//
//            TextView textview1 = (TextView) view.findViewById(R.id.propertyType);
//            textview1.setText(jsonObject.getJSONObject("propertyType").get("value").toString());
//
//            TextView textview2 = (TextView) view.findViewById(R.id.yearBuilt);
//            textview2.setText(jsonObject.getJSONObject("yearBuilt").get("value").toString());
//
//            TextView textview3 = (TextView) view.findViewById(R.id.lotSize);
//            textview3.setText(jsonObject.getJSONObject("lotSize").get("value").toString());
//
//            TextView textview4 = (TextView) view.findViewById(R.id.finishedArea);
//            textview4.setText(jsonObject.getJSONObject("finishedArea").get("value").toString());
//
//            TextView textview5 = (TextView) view.findViewById(R.id.bathrooms);
//            textview5.setText(jsonObject.getJSONObject("bathrooms").get("value").toString());
//
//            TextView textview6 = (TextView) view.findViewById(R.id.bedrooms);
//            textview6.setText(jsonObject.getJSONObject("bedrooms").get("value").toString());
//
//            TextView textview7 = (TextView) view.findViewById(R.id.taxAssessmentYear);
//            textview7.setText(jsonObject.getJSONObject("taxAssessmentYear").get("value").toString());
//
//            TextView textview8 = (TextView) view.findViewById(R.id.taxAssessment);
//            textview8.setText(jsonObject.getJSONObject("taxAssessment").get("value").toString());
//
//            TextView textview9 = (TextView) view.findViewById(R.id.lastSoldPrice);
//            textview9.setText(jsonObject.getJSONObject("lastSoldPrice").get("value").toString());
//
//            TextView textview10 = (TextView) view.findViewById(R.id.lastSoldDate);
//            textview10.setText(jsonObject.getJSONObject("lastSoldDate").get("value").toString());
//
///* TODO: Setting the value for the date - php to be changed
//            TextView textView17 = (TextView) view.findViewById(R.id.zestimate_lhs);
//            textView17.setText(jsonObject.getJSONObject("zestimate").get("name").toString());
//*/
//            TextView textView18 = (TextView) view.findViewById(R.id.zestimate_line2);
//            String zestimate_name = jsonObject.getJSONObject("zestimate").get("name").toString();
//            
//            if(!zestimate_name.contains("NA"))
//            {
//            	String date = zestimate_name.substring(46,zestimate_name.length());
//            	textView18.setText(date);
//            }
//            else
//            	textView18.setText("as of NA");
//
//            TextView textview11 = (TextView) view.findViewById(R.id.zestimate);
//            textview11.setText(jsonObject.getJSONObject("zestimate").get("value").toString());
//
//            TextView textview12 = (TextView) view.findViewById(R.id.oChange);
//            //TODO: Remove the image string from the string and display it in an image view
//            String overallRentChange = jsonObject.getJSONObject("overallChange").get("value").toString();
//            if(!overallRentChange.contains("NA"))
//            {	
//            	String trimmedOverallChange = overallRentChange.substring(overallRentChange.indexOf('$'),overallRentChange.length());
//            	textview12.setText(trimmedOverallChange);
//            }
//            else
//            	textview12.setText("NA");
//            TextView textview13 = (TextView) view.findViewById(R.id.allChange);
//            if(!jsonObject.getJSONObject("allTimePropertyRange").get("value").toString().contains("NA"))
//            	textview13.setText(jsonObject.getJSONObject("allTimePropertyRange").get("value").toString());
//            else
//            	textview13.setText("NA");
//
//            TextView textview19 = (TextView) view.findViewById(R.id.r_zestimate_line2);
//            String rZestimate_name = jsonObject.getJSONObject("rentZestimate").get("name").toString();
//            
//            //TODO Check for NA before extracting the substring
//            if(!rZestimate_name.contains("NA"))
//            {	String rDate = rZestimate_name.substring(54,rZestimate_name.length());
//	        	textview19.setText(rDate);
//            }
//            else
//            	textview19.setText("as of NA");
//
//            TextView textview14 = (TextView) view.findViewById(R.id.rZestimate);
//            textview14.setText(jsonObject.getJSONObject("rentZestimate").get("value").toString());
//
//            TextView textview15 = (TextView) view.findViewById(R.id.rChange);
//            String  monthRentChange = jsonObject.getJSONObject("monthRentChange").get("value").toString();
//            if(!monthRentChange.contains("NA"))
//            {    String trimmedMonthRentChange = monthRentChange.substring(monthRentChange.indexOf('$'),monthRentChange.length());
//	            //TODO: Remove the image string from the string and display it an image view
//	            textview15.setText(trimmedMonthRentChange);
//            }
//            else
//            {
//	            textview15.setText("NA");
//	            
//            }
//            TextView textview16 = (TextView) view.findViewById(R.id.allRChange);
//            if(jsonObject.getJSONObject("allTimeRentChange").get("value").toString().contains("NA"))
//            {
//            	textview16.setText("NA");
//            }
//            else
//            	textview16.setText(jsonObject.getJSONObject("allTimeRentChange").get("value").toString());
//
//            TextView footer1;
//            TextView footer2;
//            TextView footer3;
//
//            footer1 = (TextView) view.findViewById(R.id.footer1);
//            footer2 = (TextView) view.findViewById(R.id.footer2);
//            footer3 = (TextView) view.findViewById(R.id.footer3);
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

        }

        catch (JSONException e) {
            e.printStackTrace();
        }
          return view;
    }
}
