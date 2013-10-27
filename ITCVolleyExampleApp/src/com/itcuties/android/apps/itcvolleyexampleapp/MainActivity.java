package com.itcuties.android.apps.itcvolleyexampleapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.itcuties.android.apps.itcvolleyexampleapp.data.ItcJSONItem;
import com.itcuties.android.apps.itcvolleyexampleapp.ui.listeners.ListListener;
import com.itcuties.android.apps.itcvolleyexampleapp.util.listeners.ItcJSONResponseErrorListener;
import com.itcuties.android.apps.itcvolleyexampleapp.util.listeners.ItcJSONResponseListener;
import com.itcuties.apps.R;

/**
 * Main activity displaying a list of ATOM items
 * 
 * @author itcuties
 *
 */
public class MainActivity extends Activity {
 
    // Volley's request queue
    private RequestQueue requestQueue;
    
    // JSON feed items
    List<ItcJSONItem> jsonItems;
    
    /**
     * This method creates main application view
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set view
        setContentView(R.layout.activity_main);

        // Initialize the items list
        jsonItems = new ArrayList<ItcJSONItem>();
        
        // Get the reference to the ListView
        ListView itcItems = (ListView) findViewById(R.id.listMainView);
        
     	// Create a list adapter
        ArrayAdapter<ItcJSONItem> adapter = new ArrayAdapter<ItcJSONItem>(this,android.R.layout.simple_list_item_1, jsonItems);
        // Set list adapter for the ListView
        itcItems.setAdapter(adapter);
                     
        // Set list view item click listener
        itcItems.setOnItemClickListener(new ListListener(jsonItems, this));
        
        // Create the request queue
        requestQueue = Volley.newRequestQueue(this);

        // Read JSON data
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
        							Request.Method.GET,
        							"http://www.itcuties.com/feed/json",
        							null,
        							new ItcJSONResponseListener(this, adapter, jsonItems),
        							new ItcJSONResponseErrorListener(this));
        
        // Add the request to the queue
        requestQueue.add(jsonObjectRequest);
        
    }

}
