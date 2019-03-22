package cn.e3mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.service.ItemService;

@Controller
public class PageController {
	@RequestMapping("/")
	public String showIndex(){
	return "index";
	}
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
}
