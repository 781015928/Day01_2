package cn.itcast.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemService;

/**
 * Created by czg on 2017/10/18.
 */

public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;



    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }
}
