package com.itcuties.android.apps.itcvolleyexampleapp.util;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.itcuties.android.apps.itcvolleyexampleapp.data.ItcJSONItem;
/**
 * JSON utility class
 * 
 * @author itcuties
 *
 */
public class ItcJSONUtils {

	/**
	 * Method fills list with data from the JSON response.
	 */
	public static void fillList(JSONObject response, List<ItcJSONItem> items) {
		try{
			// Get the data array containing posts
            JSONArray jsonArray = response.getJSONArray("posts");
            
            // Get each post data
            for(int i=0; i < jsonArray.length(); i++){
            		// Get an object which represents post
                    JSONObject jsonPostObject = jsonArray.getJSONObject(i);
                    
                    // Create a data object and fill it with data 
                    ItcJSONItem item = new ItcJSONItem();
                    item.setTitle(jsonPostObject.optString("title"));
                    item.setLink(jsonPostObject.optString("permalink"));
                  
                    // Add new object to the list
                    items.add(item);
            }
        }
        catch(Exception e) {
        	// Report problems
            Log.e("ITCVolleyExample::ItcJSONParser", "JSON parsing error!");
        }
	}
	
}
