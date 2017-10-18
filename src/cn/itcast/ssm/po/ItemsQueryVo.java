package cn.itcast.ssm.po;

/**
 * Created by czg on 2017/10/17.
 */

public class ItemsQueryVo {
    private Items items;
     private ItemsCustom itemsCustom;

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}
