package com.example.android.BluetoothChat;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This Activity appears as a dialog. It lets the user to make change
 * his app name for the connection
 * the user name is sent back as a result
 * Activity in the result Intent.
 */


public class SelectUsername extends Activity {
	//This field returns the user name of the intent
	public static String USER_USERNAME = "username";
	public static String USER_STATUS = "status";
	public static String USER_PROBABILITY = "probability";
	
    // User information save spaces
    public static final String USER_PREF = "com.example.android.BluetoothChat.user";
    public static final String STATUS_PREF = "com.example.android.BluetoothChat.status";
    public static final String PROBABILITY_PREF = "com.example.android.BluetoothChat.probability";  
    
    // Layout Views
    private EditText uName; 
    private EditText uStatus; 
    
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Get preferences
        SharedPreferences settings = getSharedPreferences("com.example.android.BluetoothChat",0);
        String username = settings.getString(USER_PREF, "desconocido"); 
        String userstatus = settings.getString(STATUS_PREF, "desconocido"); 
        float probability = settings.getFloat(PROBABILITY_PREF, 0); 
        
        // Setup the window
        setContentView(R.layout.getname);

        // Set result CANCELED in case the user backs out
        setResult(Activity.RESULT_CANCELED);

        // Set default information
        uName = (EditText) findViewById(R.id.edit_user_name);
        if (!username.equals("desconocido")) uName.setText(username);
        uStatus = (EditText) findViewById(R.id.edit_status);
        if (!userstatus.equals("desconocido")) uStatus.setText(userstatus);
        uStatus = (EditText) findViewById(R.id.edit_probability);
        if (probability!=0) uStatus.setText(Float.toString(probability));
        
        // Initialize the button to perform device discovery
        Button setNameButton = (Button) findViewById(R.id.button_setname);
        setNameButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	changeName();
                v.setVisibility(View.GONE);
            }

        


        });

    }
    
	private void changeName() {

		EditText username = (EditText)findViewById(R.id.edit_user_name); 
		String user_result = username.getText().toString(); 
		
		EditText status = (EditText)findViewById(R.id.edit_status); 
		String status_result = status.getText().toString(); 
		
		EditText probability = (EditText)findViewById(R.id.edit_probability); 
		String probability_result = probability.getText().toString(); 
		
		
        // Create the result Intent and include the user name
        Intent intent = new Intent();
        intent.putExtra(USER_USERNAME, user_result);
        intent.putExtra(USER_STATUS, status_result);
        intent.putExtra(USER_PROBABILITY, probability_result);
        

        // Set result and finish this Activity
        setResult(Activity.RESULT_OK, intent);
        finish();
        
        
		
	}
}