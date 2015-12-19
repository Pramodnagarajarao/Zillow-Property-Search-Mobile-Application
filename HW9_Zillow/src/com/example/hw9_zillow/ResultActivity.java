package com.example.hw9_zillow;
//
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import android.app.ActionBar;
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.app.Fragment;
//import android.content.DialogInterface;
//import android.content.pm.PackageInfo;
//import android.content.pm.PackageManager;
//import android.content.pm.PackageManager.NameNotFoundException;
//import android.content.pm.Signature;
//import android.os.Bundle;
//import android.util.Base64;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//
//
//
//public class ResultActivity extends Activity {
//	
//
//	Button fbShare;
//	String completeAddress;
//	String caption = new String("Property Information from Zillow.com");
//	String description;
//	String pictureUrl;
//	String homeDetailsLink;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_result);
//		System.out.println("Inside onCreate");
//		 ActionBar.Tab tab1;
//	     ActionBar.Tab tab2;
//	        try
//	        {
//	          JSONObject jsonObject = new JSONObject(getIntent().getStringExtra("jsonData"));
//	            Bundle args = new Bundle();
//	            args.putString("jsonObject",jsonObject.toString());
//                Fragment fragmentTab1 = new BasicInfo();
// 	            fragmentTab1.setArguments(args);
//
//	            Fragment fragmentTab2 = new Charts();
//	            fragmentTab2.setArguments(args);
//
//	            ActionBar actionBar = getActionBar();
//	            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//	            tab1 = actionBar.newTab().setText("BASIC INFO");
//	            tab2 = actionBar.newTab().setText("HISTORICAL ZESTIMATES");
//
//
//	            tab1.setTabListener(new MyTabListener(fragmentTab1));
//	            tab2.setTabListener(new MyTabListener(fragmentTab2));
//
//
//	            actionBar.addTab(tab1);
//	            actionBar.addTab(tab2);
//
//	        }
//
//	        catch (JSONException e) {
//	            e.printStackTrace();
//	        }
//	}
//	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.result, menu);
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
//	
//	
//}





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
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

//import com.facebook.FacebookException;
//import com.facebook.FacebookOperationCanceledException;
//import com.facebook.Request;
//import com.facebook.Response;
//import com.facebook.Session;
//import com.facebook.SessionState;
//import com.facebook.android.DialogError;
//import com.facebook.android.Facebook;
//import com.facebook.android.Facebook.DialogListener;
//import com.facebook.android.FacebookError;
//import com.facebook.model.GraphUser;
//import com.facebook.widget.WebDialog;
//import com.facebook.widget.WebDialog.OnCompleteListener;



public class ResultActivity extends Activity {
	//Facebook fb;
	Button fbShare;
	String completeAddress;
	String caption = new String("Property Information from Zillow.com");
	String description;
	String pictureUrl;
	String homeDetailsLink;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_result);
        //String APP_ID = getString(R.string.APP_ID);
        //fb = new Facebook(APP_ID);
        //fbShare = (Button) findViewById(R.id.fbShare);
        System.out.println("Inisde new result activity ");
        ActionBar.Tab tab1;
        ActionBar.Tab tab2;
        try
        {

            System.out.println("Inisde new result activity try part");
            JSONObject jsonObject = new JSONObject(getIntent().getStringExtra("jsonData"));
            Bundle args = new Bundle();
            args.putString("jsonObject",jsonObject.toString());

            Fragment fragmentTab1 = new BasicInfo();
            fragmentTab1.setArguments(args);

            Fragment fragmentTab2 = new Charts();
            fragmentTab2.setArguments(args);

            ActionBar actionBar = getActionBar();            
            System.out.println("Inisde new result NAVIGATION_MODE_TABS before");
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            System.out.println("Inisde new result NAVIGATION_MODE_TABS after");

            tab1 = actionBar.newTab().setText("BASIC INFO");
            tab2 = actionBar.newTab().setText("HISTORICAL ZESTIMATES");


            tab1.setTabListener(new MyTabListener(fragmentTab1));
            tab2.setTabListener(new MyTabListener(fragmentTab2));


            actionBar.addTab(tab1);
            actionBar.addTab(tab2);

        }

        catch (JSONException e) {
            e.printStackTrace();
        }
        
//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(
//                    "com.facebook.samples.hellofacebook", 
//                    PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//                }
//        } catch (NameNotFoundException e) {
//
//        } catch (NoSuchAlgorithmException e) {
//
//        }
//        
    }
    
//    private void publishToFacebook()
//    {
//    	if(fb.isSessionValid())
//    	{
//            try 
//            {
//				JSONObject jsonObject = new JSONObject(getIntent().getStringExtra("jsonData"));
//				//Extract the address from the JSON
//				completeAddress = new String();
//	            completeAddress = jsonObject.getJSONObject("streetResponse").get("value").toString()+" ";
//	            completeAddress+= jsonObject.getJSONObject("cityResponse").get("value").toString()+ " ";
//	            completeAddress+= jsonObject.getJSONObject("stateResponse").get("value").toString()+ " ";
//	            completeAddress+= jsonObject.getJSONObject("zipResponse").get("value").toString();
//	
//	            homeDetailsLink = new String();
//	            homeDetailsLink = jsonObject.getJSONObject("homeDetails").get("value").toString();
//	            
//	            description = new String();
//	            description = "Last Sold Price:";
//	            description += jsonObject.getJSONObject("lastSoldPrice").get("value").toString()+ ", ";
//	            description += "30 day Overall Change: ";
//	            description += jsonObject.get("fbOverallValueChange").toString();
//	            
//	            pictureUrl = new String(jsonObject.get("chartUrl1").toString());	            
//				
//				
//			} 
//            catch (JSONException e) 
//            {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//    	}
//    }
//	/*public void fbButtonClick(View view)
//    {
//		JSONObject jsonObject;
//		try {
//			
//		jsonObject = new JSONObject(getIntent().getStringExtra("jsonData"));
//
//		//Extract the address from the JSON
//		completeAddress = new String();
//        completeAddress = jsonObject.getJSONObject("streetResponse").get("value").toString()+" ";
//        completeAddress+= jsonObject.getJSONObject("cityResponse").get("value").toString()+ " ";
//        completeAddress+= jsonObject.getJSONObject("stateResponse").get("value").toString()+ " ";
//        completeAddress+= jsonObject.getJSONObject("zipResponse").get("value").toString();
//
//        homeDetailsLink = new String();
//        homeDetailsLink = jsonObject.getJSONObject("homeDetails").get("value").toString();
//        
//        description = new String();
//        description = "Last Sold Price:";
//        description += jsonObject.getJSONObject("lastSoldPrice").get("value").toString()+ ", ";
//        description += "30 day Overall Change: ";
//        description += jsonObject.get("fbOverallValueChange").toString();
//        
//        pictureUrl = new String(jsonObject.get("chartUrl1").toString());	     
//        
//		} catch (JSONException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		fbLogin();
//    }*/
//	
//	public void fbLogin()
//	{
//		Session.openActiveSession(this, true, new Session.StatusCallback() {
//
//			  // callback when session changes state
//			  @SuppressWarnings("deprecation")
//			@Override
//			  public void call(Session session, SessionState state, Exception exception) {
//			    if (session.isOpened()) {
//
//			      // make request to the /me API
//			      Request.executeMeRequestAsync(session, new Request.GraphUserCallback() { // *DEPRECATED
//
//			        // callback after Graph API response with user object
//			        @Override
//			        public void onCompleted(GraphUser user, Response response) {
//			          if (user != null) {
//			            publishFeedDialog();
//			          }
//			        }
//			      });
//			    }
//			  }
//			});
//	}
//    @SuppressWarnings("deprecation")
//	public void fbButtonClick(View view)
//    {
//    	AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(ResultActivity.this);
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
//    	
///*    	
//		JSONObject jsonObject;
//		try {
//			
//		jsonObject = new JSONObject(getIntent().getStringExtra("jsonData"));
//
//		//Extract the address from the JSON
//		completeAddress = new String();
//        completeAddress = jsonObject.getJSONObject("streetResponse").get("value").toString()+" ";
//        completeAddress+= jsonObject.getJSONObject("cityResponse").get("value").toString()+ " ";
//        completeAddress+= jsonObject.getJSONObject("stateResponse").get("value").toString()+ " ";
//        completeAddress+= jsonObject.getJSONObject("zipResponse").get("value").toString();
//
//        homeDetailsLink = new String();
//        homeDetailsLink = jsonObject.getJSONObject("homeDetails").get("value").toString();
//        
//        description = new String();
//        description = "Last Sold Price:";
//        description += jsonObject.getJSONObject("lastSoldPrice").get("value").toString()+ ", ";
//        description += "30 day Overall Change: ";
//        description += jsonObject.get("fbOverallValueChange").toString();
//        
//        pictureUrl = new String(jsonObject.get("chartUrl1").toString());	     
//        
//		} catch (JSONException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//    	Bundle params = new Bundle();
//    	params.putString("name", completeAddress);
//    	params.putString("caption", "Property Information from Zillow.com");
//    	params.putString("description", description);
//    	params.putString("link", homeDetailsLink);
//    	params.putString("picture", pictureUrl);
//    	switch(view.getId())
//    	{
//    	case R.id.fbShare:
//    		if(!fb.isSessionValid())
//    		{
//    			fb.authorize(ResultActivity.this, new DialogListener(){
//    		
//
//					@Override
//					public void onComplete(Bundle values) {
//						// TODO Auto-generated method stub
//						
//					}
//
//					@Override
//					public void onFacebookError(FacebookError e) {
//						// TODO Auto-generated method stub
//						
//					}
//
//					@Override
//					public void onError(DialogError e) {
//						// TODO Auto-generated method stub
//						
//					}
//
//					@Override
//					public void onCancel() {
//						// TODO Auto-generated method stub
//						Toast.makeText(getApplicationContext(), "Post Cancelled", Toast.LENGTH_LONG);
//					}
//    				
//    			});
//    		
//    		}
//    		fb.dialog(ResultActivity.this, "feed", params, new DialogListener() {
//				
//				@Override
//				public void onFacebookError(FacebookError e) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void onError(DialogError e) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void onComplete(Bundle values) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void onCancel() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//    		break;
//    	}*/	
//    }
//    
//    @SuppressWarnings("deprecation")
//	public void postToFb()
//    {
//    	
//		JSONObject jsonObject;
//		try {
//			
//		jsonObject = new JSONObject(getIntent().getStringExtra("jsonData"));
//
//		//Extract the address from the JSON
//		completeAddress = new String();
//        completeAddress = jsonObject.getJSONObject("streetResponse").get("value").toString()+" ";
//        completeAddress+= jsonObject.getJSONObject("cityResponse").get("value").toString()+ " ";
//        completeAddress+= jsonObject.getJSONObject("stateResponse").get("value").toString()+ " ";
//        completeAddress+= jsonObject.getJSONObject("zipResponse").get("value").toString();
//
//        homeDetailsLink = new String();
//        homeDetailsLink = jsonObject.getJSONObject("homeDetails").get("value").toString();
//        
//        description = new String();
//        description = "Last Sold Price:";
//        description += jsonObject.getJSONObject("lastSoldPrice").get("value").toString()+ ", ";
//        description += "30 day Overall Change: ";
//        description += jsonObject.get("fbOverallValueChange").toString();
//        
//        pictureUrl = new String(jsonObject.get("chartUrl1").toString());	     
//        
//		} catch (JSONException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//    	Bundle params = new Bundle();
//    	params.putString("name", completeAddress);
//    	params.putString("caption", "Property Information from Zillow.com");
//    	params.putString("description", description);
//    	params.putString("link", homeDetailsLink);
//    	params.putString("picture", pictureUrl);
//
//		if(!fb.isSessionValid())
//		{
//			fb.authorize(ResultActivity.this, new DialogListener(){
//		
//
//				@Override
//				public void onComplete(Bundle values) {
//					// TODO Auto-generated method stub
//					
//				}
//
//				@Override
//				public void onFacebookError(FacebookError e) {
//					// TODO Auto-generated method stub
//					
//				}
//
//				@Override
//				public void onError(DialogError e) {
//					// TODO Auto-generated method stub
//					
//				}
//
//				@Override
//				public void onCancel() {
//					// TODO Auto-generated method stub
//					Toast.makeText(getApplicationContext(), "Post Cancelled", Toast.LENGTH_LONG);
//				}
//				
//			});
//		
//		}
//		fb.dialog(ResultActivity.this, "feed", params, new DialogListener() {
//			
//			@Override
//			public void onFacebookError(FacebookError e) {
//				// TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(), "Some Error occurred", Toast.LENGTH_LONG);
//			}
//			
//			@Override
//			public void onError(DialogError e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void onComplete(Bundle values) {
//				// TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(), "Posted Story, ID: 8305869854571548_859754862536589652 ", Toast.LENGTH_LONG).show();
//			}
//			
//			@Override
//			public void onCancel() {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//    		
//    }
//    private void publishFeedDialog() {
//    	Bundle params = new Bundle();
//    	params.putString("name", completeAddress);
//    	params.putString("caption", "Property Information from Zillow.com");
//    	params.putString("description", description);
//    	params.putString("link", homeDetailsLink);
//    	params.putString("picture", pictureUrl);
//    	
//        WebDialog feedDialog = (
//            new WebDialog.FeedDialogBuilder(ResultActivity.this,
//                Session.getActiveSession(),
//                params))
//            .setOnCompleteListener(new OnCompleteListener() {
//
//                @Override
//                public void onComplete(Bundle values,
//                    FacebookException error) {
//                    if (error == null) {
//                        // When the story is posted, echo the success
//                        // and the post Id.
//                        final String postId = values.getString("post_id");
//                        if (postId != null) {
//                            Toast.makeText(ResultActivity.this,
//                                "Posted story, id: "+postId,
//                                Toast.LENGTH_SHORT).show();
//                        } else {
//                            // User clicked the Cancel button
//                            Toast.makeText(ResultActivity.this.getApplicationContext(), 
//                                "Publish cancelled", 
//                                Toast.LENGTH_SHORT).show();
//                        }
//                    } else if (error instanceof FacebookOperationCanceledException) {
//                        // User clicked the "x" button
//                        Toast.makeText(ResultActivity.this.getApplicationContext(), 
//                            "Publish cancelled", 
//                            Toast.LENGTH_SHORT).show();
//                    } else {
//                        // Generic, ex: network error
//                        Toast.makeText(ResultActivity.this.getApplicationContext(), 
//                            "Error posting story", 
//                            Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//            })
//            .build();
//        feedDialog.show();
//    }
}
