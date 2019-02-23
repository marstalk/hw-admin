package com.classm.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.classm.system.domain.GoodsDO;
import com.classm.system.service.GoodsService;
import com.classm.common.utils.PageUtils;
import com.classm.common.utils.Query;
import com.classm.common.utils.R;

/**
 * 
 * 
 * @author hw
 * @email hw@test.com
 * @date 2019-02-23 15:32:24
 */
 
@Controller
@RequestMapping("/system/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping()
	@RequiresPermissions("system:goods:goods")
	String Goods(){
	    return "system/goods/goods";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:goods:goods")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<GoodsDO> goodsList = goodsService.list(query);
		int total = goodsService.count(query);
		PageUtils pageUtils = new PageUtils(goodsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:goods:add")
	String add(){
	    return "system/goods/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:goods:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		GoodsDO goods = goodsService.get(id);
		model.addAttribute("goods", goods);
	    return "system/goods/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:goods:add")
	public R save( GoodsDO goods){
		if(goodsService.save(goods)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:goods:edit")
	public R update( GoodsDO goods){
		goodsService.update(goods);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:goods:remove")
	public R remove( Integer id){
		if(goodsService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:goods:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		goodsService.batchRemove(ids);
		return R.ok();
	}
	
}
