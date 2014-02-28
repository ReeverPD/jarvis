package com.eventhorizon.jarvis.opec.web.ui;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author iuriandreazza
 *
 */
public class NavBar {

	@Setter
	protected List<Menu> menus;

	protected void buildMenus() {
		if(menus == null) {
			menus = new ArrayList<>();
		}
		
		Menu menu = new Menu("Cadastros");
		menu.addMenuItem(new MenuItem("FAQ", ""));
		menu.addMenuItem(new MenuItem("Verticais", ""));
		menu.addMenuItem(new MenuItem("Usuários Opec", ""));
		menu.addMenuItem(new MenuItem("Usuários Tiz.com", ""));
		menus.add(menu);
		
		menu = new Menu("Fincanceiro");
		menu.addMenuItem(new MenuItem("Invoices", ""));
		menu.addMenuItem(new MenuItem("Controle de Cobrança", ""));
		menus.add(menu);
		
		menu = new Menu("Marketing");
		menu.addMenuItem(new MenuItem("Contatos Ferramenta", ""));
		menus.add(menu);
		
		menu = new Menu("Sistema");
		menu.addMenuItem(new MenuItem("Parametro Aplicativo", ""));
		menu.addMenuItem(new MenuItem("Jobs Sistema", ""));
		menus.add(menu);
        
	}
	
	public List<Menu> getMenus() {
		if(menus == null) {
			buildMenus();
		}
		return this.menus;
	}
	
}
