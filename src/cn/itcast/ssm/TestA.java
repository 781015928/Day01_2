package cn.itcast.ssm;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

/**
 * Created by czg on 2017/10/18.
 */

public class TestA {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:WEB-INF/applicationContext-dao.xml");
        ItemsMapperCustom  itemsMapper = (ItemsMapperCustom) applicationContext.getBean("itemsMapperCustom");
        ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
        ItemsCustom itemsCustom1 = new ItemsCustom();
        itemsCustom1.setName("笔记");
        itemsQueryVo.setItemsCustom(itemsCustom1);
        List<ItemsCustom> itemsList = itemsMapper.findItemsList(itemsQueryVo);
        itemsList.forEach((itemsCustom -> System.out.println(itemsCustom)));
    }

}
