package cn.itcast.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.service.ItemService;

/**
 * Created by czg on 2017/10/18.
 */
@Controller
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping("/findItemsList")
    public ModelAndView findItemsList() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //相当 于request的setAttribut，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemService.findItemsList(null));
        modelAndView.setViewName("items/itemsList");
        return modelAndView;
    }

}
