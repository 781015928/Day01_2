package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

/**
 * Created by czg on 2017/10/17.
 */

public interface ItemsMapperCustom {

    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;


}
