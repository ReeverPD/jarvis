package com.eventhorizon.jarvis.opec.controller;

import com.eventhorizon.jarvis.entity.CMSUser;
import com.eventhorizon.jarvis.service.IOpecUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by iuriandreazza on 04/03/14.
 */
@Controller
@RequestMapping("/app/opec/user")
public class OpecUserController extends AbstractCrudController<IOpecUserService, CMSUser> {

    @Autowired
    private IOpecUserService opecUserService;


    protected IOpecUserService getService(){
        return this.opecUserService;
    }

    protected String getListPageName(){
        return "opec/list";
    }

    protected String getEditPageName(){
        return "opec/edit";
    }

}
