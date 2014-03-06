package com.eventhorizon.jarvis.opec.controller;

import com.eventhorizon.jarvis.entity.AbstractEntity;
import com.eventhorizon.jarvis.opec.util.UrlMapping;
import com.eventhorizon.jarvis.service.IService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by iuriandreazza on 04/03/14.
 */
abstract public class AbstractCrudController <S extends IService, T extends AbstractEntity<Long>> extends AbstractController {


    protected T entity;

    abstract protected S getService();


    @RequestMapping(method = RequestMethod.GET, value = UrlMapping.LIST_URL)
    public ModelAndView List(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        List<T> lst = this.getService().findAll();
        model.addAttribute("lst", lst);
        return new ModelAndView(this.getListPageName(), model);
    }

    @Secured("ROLE_ADMIN")
    public ModelAndView save(@PathVariable Long Id,
                             HttpServletRequest request, HttpServletResponse response, ModelMap model){
        return new ModelAndView("redirect:"+this.getListPageName());
    }

    @Secured("ROLE_ADMIN")
    public ModelAndView edit(@PathVariable Long Id,
            HttpServletRequest request, HttpServletResponse response, ModelMap model){
        this.entity = (T)this.getService().findById(Id);
        return new ModelAndView(this.getEditPageName(), model);
    }

    protected abstract String getListPageName();
    protected abstract String getEditPageName();

}
