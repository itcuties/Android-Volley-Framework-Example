package com.itcuties.android.apps.itcvolleyexampleapp.data;

/**
 * This class represents a post.
 * 
 * @author itcuties
 *
 */
public class ItcJSONItem {
	
	private String title;
	
	private String link;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return title;
	}

}
