package com.example.hw9_zillow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

	Button button;
	private static String var_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
        
        //Calling zillow.com on button click in main page
        ImageView Buttonone = (ImageView)findViewById(R.id.imageView1);
        Buttonone.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.zillow.com"));
                startActivity(intent);
            }
        });
    	
    	// validation of First Text Field
        final EditText textview1 = (EditText) findViewById(R.id.editText1);
        final TextView errorview1 = (TextView) findViewById(R.id.error1);
        textview1.addTextChangedListener(new TextWatcher() 
        {

    	         public void onTextChanged(CharSequence s, int start, int before,
    	                 int count) {
    	             if (textview1.getText().toString().equals("")) {
    	            	 System.out.println("The Text field is empty");
    	            	 errorview1.setVisibility(View.VISIBLE);
    	             } else{
    	            	 errorview1.setVisibility(View.INVISIBLE);
    	            	 }
    	         }
    	         
    	         public void beforeTextChanged(CharSequence s, int start, int count,
    	                 int after) {

    	         }

    	         public void afterTextChanged(Editable s) {

    	         }
    	         
        });
        
     // validation of Second Text Field
        final EditText textview2 = (EditText) findViewById(R.id.editText2);
        final TextView errorview2 = (TextView) findViewById(R.id.error2);
        textview2.addTextChangedListener(new TextWatcher() 
        {
    	         public void onTextChanged(CharSequence s, int start, int before,
    	                 int count) {
    	             if (textview2.getText().toString().equals("")) {
    	            	 System.out.println("The 2nd Text field is empty");
    	            	 errorview2.setVisibility(View.VISIBLE);
    	             } else{
    	            	 errorview2.setVisibility(View.INVISIBLE);
    	            	 }
    	         }
    	         
    	         public void beforeTextChanged(CharSequence s, int start, int count,
    	                 int after) {

    	         }

    	         public void afterTextChanged(Editable s) {

    	         }
    	         
        });        
    }

	public void addListenerOnButton() {
		 
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {                
				System.out.println("Hello World Im Inside button method");
				final TextView errorview3 = (TextView) findViewById(R.id.error3);
			    Spinner spinner1 =  (Spinner) findViewById(R.id.spinner);
			    String state_address = spinner1.getSelectedItem().toString();
			    
			    final EditText textview1 = (EditText) findViewById(R.id.editText1);
			    String street_address = textview1.getText().toString();
			    final EditText textview2 = (EditText) findViewById(R.id.editText2);
			    String city_address = textview2.getText().toString();
			    TextView errorview2 = (TextView) findViewById(R.id.error2);
			    TextView errorview1 = (TextView) findViewById(R.id.error1);
			    if(state_address.equals("Choose") && street_address.length() == 0 && city_address.length() == 0)
			    {
                  System.out.println("The spinner is empty");
                  errorview3.setVisibility(View.VISIBLE);
                  errorview2.setVisibility(View.VISIBLE);
                  errorview1.setVisibility(View.VISIBLE);
			    }else{
			    	System.out.println("The spinner is not empty");
			    	  errorview3.setVisibility(View.INVISIBLE);
	                  errorview2.setVisibility(View.INVISIBLE);
	                  errorview1.setVisibility(View.INVISIBLE);
			    }
                	    

			    
			    if(state_address.length() != 0 && street_address.length() != 0 &&  city_address.length()!= 0){
//                    TextView noMatchFound = (TextView) findViewById(R.id.error4);
//                    noMatchFound.setText("");
    				String var_street_address = street_address.replace(' ', '+');
    				String var_city_address = city_address.replace(' ', '+');
    				String var_state_address = state_address.replace(' ', '+');
    				var_url=new String("http://webtechhw-env.elasticbeanstalk.com/index.php/?street_address="+var_street_address+"&city_address="+var_city_address+"&state_address="+state_address); 
    			    System.out.println("The var_street_address:" + var_street_address);
    			    System.out.println("The var_city_address:" + var_city_address);
    			    System.out.println("The var_state_address:" + var_state_address);
    			    System.out.println("The var_url:" + var_url);
    			    new service_call().execute(var_url);
                    
			    }
			    
			}
 
		});
 
	}

	//end of validation of three text fields
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    private class service_call extends AsyncTask<String, Void, JSONObject> {
    	@Override 
        protected JSONObject doInBackground(String... params) {
            try
            {
            	JSONObject jsonObject;
                System.out.println(params[0]);
                HttpClient client = new DefaultHttpClient();
                HttpGet get = new HttpGet(params[0]);
                HttpResponse response = client.execute(get);
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                String json = reader.readLine();
                System.out.println("json");
                System.out.println(json);
                jsonObject = new JSONObject(json);
                return jsonObject;
            }

            catch (IOException e)
            {
                e.printStackTrace();
            }

            catch (JSONException e)
            {
                e.printStackTrace();
            }
            return null;
        }
    	
    	@Override
        protected void onPostExecute(JSONObject resultone) {
            // TODO Auto-generated method stub
            super.onPostExecute(resultone);
            try {
            	String valid = resultone.getJSONObject("result").get("err_code").toString();
                Integer a = Integer.parseInt(valid);
                System.out.println("valid"+valid);
                if(a == 0)
                {
                	System.out.println("Zillow gave values!!! ");
                    TextView noMatchFound = (TextView) findViewById(R.id.error4);
                    noMatchFound.setText("");
                    Intent intent = new Intent(getApplicationContext(), ResultActivity1.class);
                    intent.putExtra("jsonData",resultone.toString());
                    startActivity(intent);
                }
                else
                {
                	System.out.println("No values from zillow");
                    TextView noMatchFound = (TextView) findViewById(R.id.error4);
                    noMatchFound.setText("No exact match found--Verify that the\ngiven address is correct");
                    //noMatchFound.setVisibility(View.VISIBLE);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    
    

    
}
