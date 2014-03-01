package com.eventhorizon.jarvis.opec.web.ui;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author iuriandreazza
 */
public class Menu {

	@Getter @Setter
	protected String label;
	
	@Getter @Setter
	protected List<MenuItem> items;
	
	public Menu(String label) {
		this.setLabel(label);
	}
	
	
	public void addMenuItem(MenuItem item) {
		if(items == null) {
			items = new ArrayList<MenuItem>();
		}
		items.add(item);
	}
	
	
	public void removeMenuItem(MenuItem item) {
		if(items == null) {
			items = new ArrayList<MenuItem>();
		}
		items.add(item);
	}
	
}
