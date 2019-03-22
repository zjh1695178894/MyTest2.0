package cn.e3mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.service.ItemCatService;
@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private TbItemCatMapper itemcatMapper;
	@Override
	public List<EasyUITreeNode> getItemCatlist(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemcatMapper.selectByExample(example);
		
		List<EasyUITreeNode> resultList=new ArrayList<>();
		for(TbItemCat tb:list){
			EasyUITreeNode node=new EasyUITreeNode();
			node.setId(tb.getId());
			node.setText(tb.getName());
			node.setState(tb.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		return resultList;
	}

}
