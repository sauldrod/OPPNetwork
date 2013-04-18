package com.example.android.BluetoothChat;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ContactList extends Activity {
	
	// Array for contacts
    private ArrayAdapter<String> mContactList;
    
    // Member
    private TextView uName;
    private ListView mContactView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_list);
		
		DatabaseHandler db = new DatabaseHandler(this);
		
        // Initialize the array adapter for the conversation thread
        mContactList = new ArrayAdapter<String>(this, R.layout.message);
        mContactView = (ListView) findViewById(R.id.contacts);
        mContactView.setAdapter(mContactList);

        List<Contact> contacts = db.getAllContacts();
        for (Contact cn : contacts) {
        	String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Probability: " + cn.getMac() + " ,Device: " + cn.getDeviceName();
        
        	// Writing Contacts to array
        	mContactList.add(log);
        
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_list, menu);
		return true;
	}

}
