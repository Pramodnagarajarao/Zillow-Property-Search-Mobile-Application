package com.example.hw9_zillow;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;


// Addded new packages for android fb functionality
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;
import com.facebook.model.GraphUser;
import com.facebook.widget.WebDialog;
import com.facebook.widget.WebDialog.OnCompleteListener;

 
public class BasicInfo1 extends Activity
{
	//facebook
	Facebook fb;
	Button fbShare;
	String completeAddress;
	String caption = new String("Property Information from Zillow.com");
	String description;
	String pictureUrl;
	String homeDetailsLink;
	String lastsold;
	String estimatev;
	//facebook
    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO Auto-generated method stub
        System.out.println("Inside BasicInfo1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_info1);
        // facebook
        String APP_ID = getString(R.string.facebook_app_id);
        System.out.println("My APP ID is:"+APP_ID);
        fb = new Facebook(APP_ID);
        fbShare = (Button) findViewById(R.id.fbShare);
        
        
        try {
        	    System.out.println("valid value before basic info1:");
            	JSONObject jsonObject_basicinfo = new JSONObject(getIntent().getStringExtra("jsonDataone"));
        	    System.out.println("valid value after basic info1:"+jsonObject_basicinfo);

        	    String homedetails = jsonObject_basicinfo.getJSONObject("result").get("homedetails").toString();
        	    String street = jsonObject_basicinfo.getJSONObject("result").get("street").toString();
        	    String city = jsonObject_basicinfo.getJSONObject("result").get("city").toString();
        	    String state = jsonObject_basicinfo.getJSONObject("result").get("state").toString();
        	    String zipcode = jsonObject_basicinfo.getJSONObject("result").get("zipcode").toString();
        	    String latitude = jsonObject_basicinfo.getJSONObject("result").get("latitude").toString();
        	    String longitude = jsonObject_basicinfo.getJSONObject("result").get("longitude").toString();
        	    
        	    
        	    //String uparrow = new String("<a href=\"http://cs-server.usc.edu:45678/hw/hw6/up_g.gif\">"+estimateValueChange+"</a>");
        	    //TextView textview13 = (TextView) findViewById(R.id.oChange);
                //textview13.setText(Html.fromHtml(uparrow));
                //textview13.setMovementMethod(LinkMovementMethod.getInstance());
        	    
        	    //String downarrow = new String("<a href=\"http://cs-server.usc.edu:45678/hw/hw6/down_r.gif\">"+estimateValueChange+"</a>");
        	    //TextView textview14 = (TextView) findViewById(R.id.oChange);
                //textview14.setText(Html.fromHtml(downarrow));
                //textview14.setMovementMethod(LinkMovementMethod.getInstance());
        	    
        	    //String estimateValueChangeSign = jsonObject_basicinfo.getJSONObject("result").get("estimateValueChangeSign").toString();
//        	    if(estimateValueChangeSign == "+")
//                {
//              //String uparrow = new String("<a href=\"http://cs-server.usc.edu:45678/hw/hw6/up_g.gif\">"+estimateValueChange+"</a>");
        	    //TextView textview13 = (TextView) findViewById(R.id.oChange);
                //textview13.setText(Html.fromHtml(uparrow));
                //textview13.setMovementMethod(LinkMovementMethod.getInstance());
//                }else if(estimateValueChangeSign == "-"){
//              //String downarrow = new String("<a href=\"http://cs-server.usc.edu:45678/hw/hw6/down_r.gif\">"+estimateValueChange+"</a>");
        	    //TextView textview14 = (TextView) findViewById(R.id.oChange);
                //textview14.setText(Html.fromHtml(downarrow));
                //textview14.setMovementMethod(LinkMovementMethod.getInstance());
//                }
        	    
        	    String link = street+","+city+","+state+"-"+zipcode;
                String htmlString=new String("<a href=\""+homedetails+"\">"+link+"</a>");
                TextView textview_link = (TextView) findViewById(R.id.tv_link);
                textview_link.setText(Html.fromHtml(htmlString));
                textview_link.setMovementMethod(LinkMovementMethod.getInstance());
        	    
//        	    TextView textview18 = (TextView) findViewById(R.id.tv_link);
//        	    textview18.setText(link);
        	    
        	    String useCode = jsonObject_basicinfo.getJSONObject("result").get("useCode").toString();
        	    TextView textview1 = (TextView) findViewById(R.id.propertyType);
        	    textview1.setText(useCode);
        	    
        	    String yearBuilt = jsonObject_basicinfo.getJSONObject("result").get("yearBuilt").toString();
        	    TextView textview2 = (TextView) findViewById(R.id.yearBuilt);
        	    textview2.setText(yearBuilt);
        	    
        	    String lotSizeSqFt = jsonObject_basicinfo.getJSONObject("result").get("lotSizeSqFt").toString();
        	    TextView textview3 = (TextView) findViewById(R.id.lotSize);
        	    textview3.setText(lotSizeSqFt);
        	    
        	    String finishedSqFt = jsonObject_basicinfo.getJSONObject("result").get("finishedSqFt").toString();
        	    TextView textview4 = (TextView) findViewById(R.id.finishedArea);
        	    textview4.setText(finishedSqFt);
        	    
        	    String bathrooms = jsonObject_basicinfo.getJSONObject("result").get("bathrooms").toString();
        	    TextView textview5 = (TextView) findViewById(R.id.bathrooms);
        	    textview5.setText(bathrooms);
        	    
        	    String bedrooms = jsonObject_basicinfo.getJSONObject("result").get("bedrooms").toString();
        	    TextView textview6 = (TextView) findViewById(R.id.bedrooms);
        	    textview6.setText(bedrooms);
        	    
        	    String taxAssessmentYear = jsonObject_basicinfo.getJSONObject("result").get("taxAssessmentYear").toString();
        	    TextView textview7 = (TextView) findViewById(R.id.taxAssessmentYear);
        	    textview7.setText(taxAssessmentYear);
        	    
        	    String taxAssessment = jsonObject_basicinfo.getJSONObject("result").get("taxAssessment").toString();
        	    TextView textview8 = (TextView) findViewById(R.id.taxAssessment);
        	    textview8.setText(taxAssessment);
        	    
        	    String lastSoldPrice = jsonObject_basicinfo.getJSONObject("result").get("lastSoldPrice").toString();
        	    TextView textview9 = (TextView) findViewById(R.id.lastSoldPrice);
        	    textview9.setText(lastSoldPrice);
        	    
        	    String lastSoldDate = jsonObject_basicinfo.getJSONObject("result").get("lastSoldDate").toString();
        	    TextView textview10 = (TextView) findViewById(R.id.lastSoldDate);
        	    textview10.setText(lastSoldDate);
        	    
        	    String estimateLastUpdate = jsonObject_basicinfo.getJSONObject("result").get("estimateLastUpdate").toString();
        	    TextView textview11 = (TextView) findViewById(R.id.zestimate_line2);
        	    textview11.setText(estimateLastUpdate);
        	    
        	    String estimateAmount = jsonObject_basicinfo.getJSONObject("result").get("estimateAmount").toString();
        	    TextView textview12 = (TextView) findViewById(R.id.zestimate);
        	    textview12.setText(estimateAmount);
        	    
        	    String estimateValueChange = jsonObject_basicinfo.getJSONObject("result").get("estimateValueChange").toString();
//        	    TextView textview13 = (TextView) findViewById(R.id.oChange);
//        	    textview13.setText(estimateValueChange);
        	    
        	    
        	    String estimateValueChangeSign = jsonObject_basicinfo.getJSONObject("result").get("estimateValueChangeSign").toString();
        	    if(estimateValueChangeSign.equals("+"))
                {
        	    TextView textview13 = (TextView) findViewById(R.id.oChange);
        	    textview13.setCompoundDrawablesWithIntrinsicBounds(R.drawable.up_g,0,0,0);
        	    textview13.setText(estimateValueChange);
//                String uparrow = new String("<img src='http://cs-server.usc.edu:45678/hw/hw6/up_g.gif'/>"+estimateValueChange);
//                TextView textview13 = (TextView) findViewById(R.id.oChange);
//                textview13.setText(Html.fromHtml(uparrow));
//                textview13.setMovementMethod(LinkMovementMethod.getInstance());
                }else if(estimateValueChangeSign.equals("-")){
            	    TextView textview13 = (TextView) findViewById(R.id.oChange);
            	    textview13.setCompoundDrawablesWithIntrinsicBounds(R.drawable.down_r,0,0,0);
            	    textview13.setText(estimateValueChange);
//                String downarrow = new String("<img src='http://cs-server.usc.edu:45678/hw/hw6/down_r.gif'/>"+estimateValueChange);
//        	      TextView textview14 = (TextView) findViewById(R.id.oChange);
//                textview14.setText(Html.fromHtml(downarrow));
//                textview14.setMovementMethod(LinkMovementMethod.getInstance());
                }
        	    
        	    
        	    String restimateValueChange = jsonObject_basicinfo.getJSONObject("result").get("restimateValueChange").toString();
                String restimateValueChangeSign = jsonObject_basicinfo.getJSONObject("result").get("restimateValueChangeSign").toString();
        	    if(restimateValueChangeSign.equals("+"))
                {
        	    	TextView textview16 = (TextView) findViewById(R.id.rChange);
        	    	textview16.setCompoundDrawablesWithIntrinsicBounds(R.drawable.up_g,0,0,0);
            	    textview16.setText(restimateValueChange);	
                }else if(restimateValueChangeSign.equals("-")){
        	    	TextView textview16 = (TextView) findViewById(R.id.rChange);
        	    	textview16.setCompoundDrawablesWithIntrinsicBounds(R.drawable.down_r,0,0,0);
            	    textview16.setText(restimateValueChange);	
                	
                }
        	    
        	    
        	    
        	    
        	    
        	    
        	    
        	    String estimateValuationRangeLow = jsonObject_basicinfo.getJSONObject("result").get("estimateValuationRangeLow").toString();
        	    String estimateValuationRangeHigh = jsonObject_basicinfo.getJSONObject("result").get("estimateValuationRangeHigh").toString();
        	    String all_time_property_range = "$ "+estimateValuationRangeHigh+" - "+" $ "+estimateValuationRangeLow; 
        	    TextView textview14 = (TextView) findViewById(R.id.allChange);
        	    textview14.setText(all_time_property_range);
        	    
        	    String restimateLastUpdate = jsonObject_basicinfo.getJSONObject("result").get("restimateLastUpdate").toString();
        	    TextView textview15 = (TextView) findViewById(R.id.r_zestimate_line2);
        	    textview15.setText(restimateLastUpdate);
        	    
        	    String restimateAmount = jsonObject_basicinfo.getJSONObject("result").get("restimateAmount").toString();
        	    TextView textview19 = (TextView) findViewById(R.id.rZestimate);
        	    textview19.setText(restimateAmount);
        	    
//        	    String restimateValueChange = jsonObject_basicinfo.getJSONObject("result").get("restimateValueChange").toString();
//        	    TextView textview16 = (TextView) findViewById(R.id.rChange);
//        	    textview16.setText(restimateValueChange);
        	    
        	    String restimateValuationRangeLow = jsonObject_basicinfo.getJSONObject("result").get("restimateValuationRangeLow").toString();
        	    String restimateValuationRangeHigh = jsonObject_basicinfo.getJSONObject("result").get("restimateValuationRangeHigh").toString();
        	    String restimateValuationRange = "$ "+restimateValuationRangeHigh+" - "+restimateValuationRangeLow;
        	    TextView textview17 = (TextView) findViewById(R.id.allRChange);
        	    textview17.setText(restimateValuationRange);
        	    
        	    //String taxAssessment = jsonObject_basicinfo.getJSONObject("result").get("restimateValueChange").toString();
        	    //String lastSoldPrice = jsonObject_basicinfo.getJSONObject("result").get("lastSoldPrice").toString();
        	    //String lastSoldDate = jsonObject_basicinfo.getJSONObject("result").get("lastSoldDate").toString();
        	    //String estimateAmount = jsonObject_basicinfo.getJSONObject("result").get("estimateAmount").toString();
        	    //String estimateValueChangeSign = jsonObject_basicinfo.getJSONObject("result").get("estimateValueChangeSign").toString();
        	    String imgn = jsonObject_basicinfo.getJSONObject("result").get("imgn").toString();
        	    String imgp = jsonObject_basicinfo.getJSONObject("result").get("imgp").toString();
        	    //String restimateLastUpdate = jsonObject_basicinfo.getJSONObject("result").get("restimateLastUpdate").toString();
        	    
        	    //String restimateValueChangeSign = jsonObject_basicinfo.getJSONObject("result").get("restimateValueChangeSign").toString();
        	    String year1 = jsonObject_basicinfo.getJSONObject("chart").get("year1").toString();
        	    String years5 = jsonObject_basicinfo.getJSONObject("chart").get("years5").toString();
        	    String years10 = jsonObject_basicinfo.getJSONObject("chart").get("years10").toString(); 

        	    System.out.println("link"+link);
        	    System.out.println("homedetails:"+homedetails);
        	    System.out.println("street:"+street);
        	    System.out.println("city:"+city);
        	    System.out.println("state:"+state);
        	    System.out.println("zipcode:"+zipcode);
        	    System.out.println("latitude:"+latitude);
        	    System.out.println("longitude:"+longitude);
        	    System.out.println("useCode:"+useCode);
        	    System.out.println("lastSoldPrice:"+lastSoldPrice);
        	    System.out.println("yearBuilt:"+yearBuilt);
        	    System.out.println("lastSoldDate:"+lastSoldDate);
        	    System.out.println("lotSizeSqFt:"+lotSizeSqFt);
        	    System.out.println("estimateLastUpdate:"+estimateLastUpdate);
        	    System.out.println("estimateAmount:"+estimateAmount);
        	    System.out.println("finishedSqFt:"+finishedSqFt);
        	    System.out.println("estimateValueChangeSign:"+estimateValueChangeSign);
        	    System.out.println("imgn:"+imgn);
        	    System.out.println("imgp:"+imgp);
        	    //System.out.println("estimateValueChange:"+estimateValueChange);
        	    System.out.println("bathrooms:"+bathrooms);
        	    System.out.println("estimateValuationRangeLow:"+estimateValuationRangeLow);
        	    System.out.println("estimateValuationRangeHigh:"+estimateValuationRangeHigh);
        	    System.out.println("bedrooms:"+bedrooms);
        	    System.out.println("restimateLastUpdate:"+restimateLastUpdate);
        	    System.out.println("restimateAmount:"+restimateAmount);
        	    System.out.println("taxAssessmentYear:"+taxAssessmentYear);
        	    System.out.println("restimateValueChangeSign:"+restimateValueChangeSign);
        	    System.out.println("restimateValueChange:"+restimateValueChange);
        	    System.out.println("taxAssessment:"+taxAssessment);
        	    System.out.println("restimateValuationRangeLow:"+restimateValuationRangeLow);
        	    System.out.println("restimateValuationRangeHigh:"+restimateValuationRangeHigh);
        	    System.out.println("year1:"+year1);
        	    System.out.println("years5:"+years5);
        	    System.out.println("years10:"+years10);
        	    
        	    TextView footerone;
                TextView footertwo;
                TextView footerthree;
                footerone = (TextView) findViewById(R.id.footer1);
                footertwo = (TextView) findViewById(R.id.footer2);
                footerthree = (TextView) findViewById(R.id.footer3);
                footertwo.setText(Html.fromHtml(
                        "Use is subject to "+
                                "<a href=\"http://www.zillow.com/wikipages/Privacy-and-Terms-of-Use/\">Terms of Use</a> "
                ));
                footertwo.setMovementMethod(LinkMovementMethod.getInstance());
                footerthree.setText(Html.fromHtml(

                        "<a href=\"http://www.zillow.com/zestimate/\">What's a Zestimate</a> "
                ));
                footerthree.setMovementMethod(LinkMovementMethod.getInstance());
            	} catch (JSONException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.facebook.samples.hellofacebook", 
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
                
                }
        } catch (NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
 
    }
    
    //facebook code
    private void publishToFacebook()
    {
    	if(fb.isSessionValid())
    	{
            try 
            {
	            JSONObject jsonObject_basicinfo = new JSONObject(getIntent().getStringExtra("jsonDataone"));

        	    homeDetailsLink = new String();
        	    homeDetailsLink = jsonObject_basicinfo.getJSONObject("result").get("homedetails").toString();    
        	    completeAddress = new String();
        	    completeAddress = jsonObject_basicinfo.getJSONObject("result").get("street").toString()+","+jsonObject_basicinfo.getJSONObject("result").get("city").toString()+","+jsonObject_basicinfo.getJSONObject("result").get("state").toString()+"-"+jsonObject_basicinfo.getJSONObject("result").get("zipcode").toString();
//		        lastsold = new String();
//		        lastsold = jsonObject_basicinfo.getJSONObject("result").get("lastSoldPrice").toString();
//		        estimatev = new String();
//		        estimatev = jsonObject_basicinfo.getJSONObject("result").get("estimateValueChange").toString();
//	            description = new String();
//	            description = "Last Sold Price: "+lastsold+"30 day Overall Change: "+estimatev;
		        description = new String();
		        description = "Last Sold Price:";
		        description += jsonObject_basicinfo.getJSONObject("result").get("lastSoldPrice").toString()+ ", ";
		        description += "30 day Overall Change: ";
		        description += jsonObject_basicinfo.getJSONObject("result").get("estimateValueChange").toString();

	            
	            pictureUrl = new String();
	            pictureUrl = jsonObject_basicinfo.getJSONObject("chart").get("year1").toString();	            
				
				
			} 
            catch (JSONException e) 
            {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    	}
    }
    
	  @SuppressWarnings("deprecation")
		public void fbButtonClick(View view)
	    {
	    	AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(BasicInfo1.this);
	    	
	    	// Setting Dialog Message
	    	alertDialog2.setMessage("Post to Facebook");

	    	// Setting Positive "Yes" Btn
	    	alertDialog2.setPositiveButton("Post Property Details",
	    	        new DialogInterface.OnClickListener() {
	    	            public void onClick(DialogInterface dialog, int which) {
	    	            	postToFb();
	    	            }
	    	        });
	    	// Setting Negative "NO" Btn
	    	alertDialog2.setNegativeButton("Cancel",
	    	        new DialogInterface.OnClickListener() {
	    	            public void onClick(DialogInterface dialog, int which) {
	    	                // Write your code here to execute after dialog
	    	                Toast.makeText(getApplicationContext(),
	    	                        "Post Cancelled !", Toast.LENGTH_SHORT)
	    	                        .show();
	    	                dialog.cancel();
	    	            }
	    	        });

	    	// Showing Alert Dialog
	    	alertDialog2.show();
	    }
//    @SuppressWarnings("deprecation")
//	public void fbButtonClick(View view)
//    {
//    	AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(BasicInfo1.this);
//    	
//    	// Setting Dialog Message
//    	alertDialog2.setMessage("Post to Facebook");
//
//    	// Setting Positive "Yes" Btn
//    	alertDialog2.setPositiveButton("Post Property Details",
//    	        new DialogInterface.OnClickListener() {
//    	            public void onClick(DialogInterface dialog, int which) {
//    	            	postToFb();
//    	            }
//    	        });
//    	// Setting Negative "NO" Btn
//    	alertDialog2.setNegativeButton("Cancel",
//    	        new DialogInterface.OnClickListener() {
//    	            public void onClick(DialogInterface dialog, int which) {
//    	                // Write your code here to execute after dialog
//    	                Toast.makeText(getApplicationContext(),
//    	                        "Post Cancelled", Toast.LENGTH_SHORT)
//    	                        .show();
//    	                dialog.cancel();
//    	            }
//    	        });
//
//    	// Showing Alert Dialog
//    	alertDialog2.show();
//    }
	public void fbLogin()
	{
		Session.openActiveSession(this, true, new Session.StatusCallback() {

			  // callback when session changes state
			  @SuppressWarnings("deprecation")
			@Override
			  public void call(Session session, SessionState state, Exception exception) {
			    if (session.isOpened()) {

			      // make request to the /me API
			      Request.executeMeRequestAsync(session, new Request.GraphUserCallback() { // *DEPRECATED

			        // callback after Graph API response with user object
			        @Override
			        public void onCompleted(GraphUser user, Response response) {
			          if (user != null) {
			            publishFeedDialog();
			          }
			        }
			      });
			    }
			  }
			});
	}
	
	    
	  
	    private void publishFeedDialog() {
	    	Bundle params = new Bundle();
	    	params.putString("name", completeAddress);
	    	params.putString("caption", "Property Information from Zillow.com");
	    	params.putString("description", description);
	    	params.putString("link", homeDetailsLink);
	    	params.putString("picture", pictureUrl);
	    	
	        WebDialog feedDialog = (
	            new WebDialog.FeedDialogBuilder(BasicInfo1.this,
	                Session.getActiveSession(),
	                params))
	            .setOnCompleteListener(new OnCompleteListener() {

	                @Override
	                public void onComplete(Bundle values,
	                    FacebookException error) {
	                    if (error == null) {
	                        // When the story is posted, echo the success
	                        // and the post Id.
	                        final String postId = values.getString("post_id");
	                        if (postId != null) {
	                            Toast.makeText(BasicInfo1.this,
	                                "Posted story, id: "+postId,
	                                Toast.LENGTH_SHORT).show();
	                        } else {
	                            // User clicked the Cancel button
	                            Toast.makeText(BasicInfo1.this.getApplicationContext(), 
	                                "Publish cancelled", 
	                                Toast.LENGTH_SHORT).show();
	                        }
	                    } else if (error instanceof FacebookOperationCanceledException) {
	                        // User clicked the "x" button
	                        Toast.makeText(BasicInfo1.this.getApplicationContext(), 
	                            "Publish cancelled", 
	                            Toast.LENGTH_SHORT).show();
	                    } else {
	                        // Generic, ex: network error
	                        Toast.makeText(BasicInfo1.this.getApplicationContext(), 
	                            "Error posting story", 
	                            Toast.LENGTH_SHORT).show();
	                    }
	                }

	            })
	            .build();
	        feedDialog.show();
	    }
	    @SuppressWarnings("deprecation")
		public void postToFb()
	    {
	    	
			//JSONObject jsonObject;
			try {
	            JSONObject jsonObject_basicinfo = new JSONObject(getIntent().getStringExtra("jsonDataone"));

        	    homeDetailsLink = new String();
        	    homeDetailsLink = jsonObject_basicinfo.getJSONObject("result").get("homedetails").toString();    
        	    completeAddress = new String();
        	    completeAddress = jsonObject_basicinfo.getJSONObject("result").get("street").toString()+","+jsonObject_basicinfo.getJSONObject("result").get("city").toString()+","+jsonObject_basicinfo.getJSONObject("result").get("state").toString()+"-"+jsonObject_basicinfo.getJSONObject("result").get("zipcode").toString();
//		        lastsold = new String();
//		        lastsold = jsonObject_basicinfo.getJSONObject("result").get("lastSoldPrice").toString();
//		        estimatev = new String();
//		        estimatev = jsonObject_basicinfo.getJSONObject("result").get("estimateValueChange").toString();
//	            description = new String();
//	            description = "Last Sold Price: "+lastsold+"30 day Overall Change: "+estimatev;
		        description = new String();
		        description = "Last Sold Price:";
		        description += jsonObject_basicinfo.getJSONObject("result").get("lastSoldPrice").toString()+ ", ";
		        description += "30 day Overall Change: ";
		        description += jsonObject_basicinfo.getJSONObject("result").get("estimateValueChange").toString();

	            
	            pictureUrl = new String();
	            pictureUrl = jsonObject_basicinfo.getJSONObject("chart").get("year1").toString();	            
				
	        
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	Bundle params = new Bundle();
	    	params.putString("name", completeAddress);
	    	params.putString("caption", "Property Information from Zillow.com");
	    	params.putString("description", description);
	    	params.putString("link", homeDetailsLink);
	    	params.putString("picture", pictureUrl);

			if(!fb.isSessionValid())
			{
				fb.authorize(BasicInfo1.this, new DialogListener(){
			

					@Override
					public void onComplete(Bundle values) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onFacebookError(FacebookError e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onError(DialogError e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onCancel() {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), "Post Cancelled", Toast.LENGTH_LONG).show();
					}
					
				});
			
			}
			fb.dialog(BasicInfo1.this, "feed", params, new DialogListener() {
				
				@Override
				public void onFacebookError(FacebookError e) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "Some Error occurred", Toast.LENGTH_LONG);
				}
				
				@Override
				public void onError(DialogError e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onComplete(Bundle values) {
					// TODO Auto-generated method stub
				   	final String postId = values.getString("post_id");
	                   if (postId != null) {
	                       Toast.makeText(BasicInfo1.this,
	                           "Posted story, id: "+postId,
	                           Toast.LENGTH_SHORT).show();
	                   }
				}
				
				@Override
				public void onCancel() {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "Post Cancelled !", Toast.LENGTH_LONG).show();
				}
			});
	    		
	    }

}
