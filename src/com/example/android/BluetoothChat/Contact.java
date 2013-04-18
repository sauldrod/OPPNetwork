package com.example.android.BluetoothChat;

public class Contact {
 
    //private variables
    int _id;
    String _name;
    String _mac;
    String _device_name;
 
    // Empty constructor
    public Contact(){
 
    }
    public Contact(int _id, String _name, String _mac, String _device_name) {
		super();
		this._id = _id;
		this._name = _name;
		this._mac = _mac;
		this._device_name = _device_name;
	}

    public Contact(String _name, String _mac, String _device_name) {
		super();
		this._name = _name;
		this._mac = _mac;
		this._device_name = _device_name;
	}    
    
    // getting ID
    public int getID(){
        return this._id;
    }
 
    // setting id
    public void setID(int id){
        this._id = id;
    }
 
    // getting name
    public String getName(){
        return this._name;
    }
 
    // setting name
    public void setName(String name){
        this._name = name;
    }
    
    // getting mac
	public String getMac() {
		return _mac;
	}
	
	// setting mac
	public void setMac(String _mac) {
		this._mac = _mac;
	}
	
	// getting device_name
	public String getDeviceName() {
		return _device_name;
	}
	
	// setting device name
	public void setDeviceName(String _device_name) {
		this._device_name = _device_name;
	}
 

}
