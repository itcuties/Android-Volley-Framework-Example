package com.itcuties.android.apps.itcvolleyexampleapp.util.listeners;

import java.util.List;

import org.json.JSONObject;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.android.volley.Response.Listener;
import com.itcuties.android.apps.itcvolleyexampleapp.data.ItcJSONItem;
import com.itcuties.android.apps.itcvolleyexampleapp.util.ItcJSONUtils;

/**
 * JSON Response listener
 * 
 * @author itcuties
 *
 */
public class ItcJSONResponseListener implements Listener<JSONObject> {
	// Main activity context reference
	private Context context;
	
	// JSON feed items
    List<ItcJSONItem> items;
    
    // List adapter reference
    private BaseAdapter adapter;
	
    // Initialize all the attributes
	public ItcJSONResponseListener(Context context, BaseAdapter adapter, List<ItcJSONItem> items) {
		this.context = context;
		this.items = items;
		this.adapter = adapter;
	}
	
	// Called when JSON data is ready to be parsed 
	public void onResponse(JSONObject response) {
		// Parse JSON results
		ItcJSONUtils.fillList(response, items);
		// Notify the list adapter that the item list is ready
		adapter.notifyDataSetChanged();
		// Display quick info to the user about the success
		Toast.makeText(context, "Loading done !", Toast.LENGTH_LONG).show();
	}

}
