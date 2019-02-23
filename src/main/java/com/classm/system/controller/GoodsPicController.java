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

import com.classm.system.domain.GoodsPicDO;
import com.classm.system.service.GoodsPicService;
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
@RequestMapping("/system/goodsPic")
public class GoodsPicController {
	@Autowired
	private GoodsPicService goodsPicService;
	
	@GetMapping()
	@RequiresPermissions("system:goodsPic:goodsPic")
	String GoodsPic(){
	    return "system/goodsPic/goodsPic";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:goodsPic:goodsPic")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<GoodsPicDO> goodsPicList = goodsPicService.list(query);
		int total = goodsPicService.count(query);
		PageUtils pageUtils = new PageUtils(goodsPicList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:goodsPic:add")
	String add(){
	    return "system/goodsPic/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:goodsPic:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		GoodsPicDO goodsPic = goodsPicService.get(id);
		model.addAttribute("goodsPic", goodsPic);
	    return "system/goodsPic/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:goodsPic:add")
	public R save( GoodsPicDO goodsPic){
		if(goodsPicService.save(goodsPic)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:goodsPic:edit")
	public R update( GoodsPicDO goodsPic){
		goodsPicService.update(goodsPic);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:goodsPic:remove")
	public R remove( Integer id){
		if(goodsPicService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:goodsPic:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		goodsPicService.batchRemove(ids);
		return R.ok();
	}
	
}
