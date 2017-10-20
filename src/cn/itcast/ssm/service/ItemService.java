package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

/**
 * Created by czg on 2017/10/18.
 */

public interface ItemService {

    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;


    ItemsCustom findItemsById(Integer id) throws Exception;

    void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;


}
