package cn.itcast.ssm.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.Size;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemService;

/**
 * Created by czg on 2017/10/18.
 */
@Controller
public class ItemController {
    private static final String PIC_PATH = "E:\\tomcat_dir\\pic\\";

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
            List<ItemsCustom> itemsCustoms = itemService.findItemsList(itemsQueryVo);
            model.addAttribute("itemsList", itemsCustoms);
            return "items/itemsList";
        }
        model.addAttribute("itemsList", itemService.findItemsList(null));
        return "items/itemsList";
    }

    @RequestMapping(value = "/editItems", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView editItems(@RequestParam("id") Integer id) throws Exception {
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
    public String editItemsSubmit(Model model,

                                  @RequestParam("id") Integer id,
                                  @RequestParam("name") @Size(min = 1, max = 30, message = "姓名不能超过30")
                                          String name,
                                  @RequestParam("price") Float price,
                                  @RequestParam("createtime") Date createtime,
                                  @RequestParam("detail") String detail , @RequestParam("pic")MultipartFile pic) throws Exception {


//
//        if (bindingResult.hasErrors()) {
//            bindingResult.getAllErrors().forEach((error) -> {
//                logger.error(error.getDefaultMessage());
//
//            });
//            model.addAttribute("allError", bindingResult.getAllErrors());
//
//            return "items/editItems";
//        }

        System.out.println(name);
        logger.error(name);
        ItemsCustom itemsCustom = new ItemsCustom();
        itemsCustom.setName(name);
        itemsCustom.setId(id);
        itemsCustom.setCreatetime(createtime);
        itemsCustom.setDetail(detail);
        itemsCustom.setPrice(price);
        if (pic != null) {
            String originalFilename = pic.getOriginalFilename();
            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.indexOf("."));
            File newFile = new File(PIC_PATH + newFileName);
            pic.transferTo(newFile);
            itemsCustom.setPic("/tmp/pic/" + newFileName);
        }

        itemService.updateItems(id, itemsCustom);
        //    return "redirect:findItemsList.action";
        return "redirect:findItemsList.action";
    }


}
