package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.pojo.TbItemExample.Criteria;
import cn.e3mall.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper tbItemMapper;
	@Override
	public TbItem getById(long itemId) {
		// TODO Auto-generated method stub
		//TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
		TbItemExample example=new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//查询
		TbItemExample example=new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
		//取分页结果
		EasyUIDataGridResult result=new EasyUIDataGridResult();
		result.setRows(list);
		//取总记录数
		PageInfo<TbItem> pageInfo=new PageInfo<>(list);
		long total=pageInfo.getTotal();
		result.setTotal(total);
		return result;
	}

}
