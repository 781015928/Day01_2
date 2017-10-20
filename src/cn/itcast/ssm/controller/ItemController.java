package cn.itcast.ssm.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemService;

/**
 * Created by czg on 2017/10/18.
 */
@Controller
public class ItemController {
    Logger logger = Logger.getLogger(ItemController.class);

    @Autowired
    ItemService itemService;


    @RequestMapping(value = "/findItemsList")
    public String findItemsList(Model model, ItemsQueryVo itemsQueryVo) throws Exception {
        //相当 于request的setAttribut，在jsp页面中通过itemsList取数据
        String name = Thread.currentThread().getName();
        logger.error(name);
        System.out.println(name);
        if (itemsQueryVo != null && itemsQueryVo.getItems() != null) {
            List<ItemsCustom> itemsCustoms= itemService.findItemsList(itemsQueryVo);
            model.addAttribute("itemsList", itemsCustoms);
            return "items/itemsList";
        }
        model.addAttribute("itemsList", itemService.findItemsList(null));
        return "items/itemsList";
    }

    @RequestMapping(value = "/editItems", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView editItems(@RequestParam("id") int id) throws Exception {
        String name = Thread.currentThread().getName();
        System.err.println(name);
        logger.error(name);
        ModelAndView modelAndView = new ModelAndView();

        ItemsCustom itemsCustom = itemService.findItemsById(id);


        //相当 于request的setAttribut，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsCustom", itemsCustom);
        modelAndView.setViewName("items/editItems");
        return modelAndView;
    }

    @RequestMapping(value = "/editItemsSubmit", method = {RequestMethod.POST})
    public String editItemsSubmit(ItemsCustom itemsCustom) throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name);
        logger.error(name);
        itemService.updateItems(itemsCustom.getId(), itemsCustom);
        //    return "redirect:findItemsList.action";
        return "redirect:findItemsList.action";
    }


}
