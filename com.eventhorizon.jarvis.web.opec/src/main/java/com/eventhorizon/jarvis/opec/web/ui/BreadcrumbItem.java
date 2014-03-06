package com.eventhorizon.jarvis.opec.web.ui;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by iuriandreazza on 05/03/14.
 */
public class BreadcrumbItem {

    @Getter @Setter
    protected String url = "";

    @Getter @Setter
    protected String label = "";

    @Getter @Setter
    protected Boolean endItem = false;

    public BreadcrumbItem(String label, String url, Boolean endItem){
        this.setUrl(url);
        this.setLabel(label);
        this.setEndItem(endItem);
    }

}
