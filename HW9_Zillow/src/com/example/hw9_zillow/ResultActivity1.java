package com.example.hw9_zillow;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TabHost;
 

public class ResultActivity1 extends TabActivity {
    /** Called when the activity is first created. */
	JSONObject jsonObject_result_activity1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	System.out.println("Inside ResultActivity1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity1);
        //getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.activity_result_activity1);
        
		try {
		    jsonObject_result_activity1 = new JSONObject(getIntent().getStringExtra("jsonData"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent1;
//      Intent intent2;
//      Intent intent;
 
        intent1 = new Intent().setClass(this, BasicInfo1.class);
        intent1.putExtra("jsonDataone",jsonObject_result_activity1.toString());
        spec = tabHost.newTabSpec("First").setIndicator("Basic Info").setContent(intent1);
        tabHost.addTab(spec);
        System.out.println("after tab1");
 
        intent1 = new Intent().setClass(this, Charts1.class);
        intent1.putExtra("jsonDataone",jsonObject_result_activity1.toString());
        spec = tabHost.newTabSpec("Second").setIndicator("Historical Zestimates").setContent(intent1);
        tabHost.addTab(spec);
        System.out.println("after tab2");
 
    }
}
