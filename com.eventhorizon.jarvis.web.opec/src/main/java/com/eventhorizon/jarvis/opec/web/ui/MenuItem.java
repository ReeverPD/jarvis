package com.eventhorizon.jarvis.opec.web.ui;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author iuriandreazza
 */
public class MenuItem {

	@Getter @Setter
	protected String link = "#";
	
	@Getter @Setter
	protected String label;
	
	
	public MenuItem(String label, String link) {
		this.setLabel(label);
		this.setLink(link);
		
	}
	
}
