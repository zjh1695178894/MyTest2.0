package cn.e3mall.service;


import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.pojo.TbItem;

public interface ItemService {
	TbItem getById(long itemId);
	EasyUIDataGridResult getItemList(int total,int rows);
}
