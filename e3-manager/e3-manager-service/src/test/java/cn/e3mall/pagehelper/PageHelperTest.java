package cn.e3mall.pagehelper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;

public class PageHelperTest {
	public void testPageHelper() throws Exception{
		//初始化spring容器
		ApplicationContext applicationContext = 
		new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//获得mapper代理对象
		TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);
		//设置分页
		PageHelper.startPage(1, 10);
		//执行查询
		TbItemExample tbItemExample = new TbItemExample();
		List<TbItem> list=tbItemMapper.selectByExample(tbItemExample);
		//取分页信息
		PageInfo<TbItem> pageInfo=new PageInfo<>(list);
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPages());
		System.out.println(pageInfo.getPageNum());
		System.out.println(pageInfo.getPageSize());
	}
}
