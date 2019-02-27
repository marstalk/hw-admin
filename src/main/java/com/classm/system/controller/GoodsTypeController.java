package com.classm.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.classm.system.domain.GoodsTypeDO;
import com.classm.system.service.GoodsTypeService;
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
@RequestMapping("/system/goodsType")
public class GoodsTypeController {
	@Autowired
	private GoodsTypeService goodsTypeService;
	
	@GetMapping()
	@RequiresPermissions("system:goodsType:goodsType")
	String GoodsType(){
	    return "system/goodsType/goodsType";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:goodsType:goodsType")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<GoodsTypeDO> goodsTypeList = goodsTypeService.list(query);
		int total = goodsTypeService.count(query);
		PageUtils pageUtils = new PageUtils(goodsTypeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:goodsType:add")
	String add(){
	    return "system/goodsType/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:goodsType:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		GoodsTypeDO goodsType = goodsTypeService.get(id);
		model.addAttribute("goodsType", goodsType);
	    return "system/goodsType/edit";
	}
	
	/**
	 * Save
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:goodsType:add")
	public R save( GoodsTypeDO goodsType){
		if(goodsTypeService.save(goodsType)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * Update
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:goodsType:edit")
	public R update( GoodsTypeDO goodsType){
		goodsTypeService.update(goodsType);
		return R.ok();
	}
	
	/**
	 * Delete
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:goodsType:remove")
	public R remove( Integer id){
		if(goodsTypeService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * Delete
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:goodsType:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		goodsTypeService.batchRemove(ids);
		return R.ok();
	}
	
}
