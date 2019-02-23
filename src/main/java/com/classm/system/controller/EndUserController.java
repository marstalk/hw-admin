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

import com.classm.system.domain.EndUserDO;
import com.classm.system.service.EndUserService;
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
@RequestMapping("/system/endUser")
public class EndUserController {
	@Autowired
	private EndUserService endUserService;
	
	@GetMapping()
	@RequiresPermissions("system:endUser:endUser")
	String EndUser(){
	    return "system/endUser/endUser";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:endUser:endUser")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<EndUserDO> endUserList = endUserService.list(query);
		int total = endUserService.count(query);
		PageUtils pageUtils = new PageUtils(endUserList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:endUser:add")
	String add(){
	    return "system/endUser/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:endUser:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		EndUserDO endUser = endUserService.get(id);
		model.addAttribute("endUser", endUser);
	    return "system/endUser/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:endUser:add")
	public R save( EndUserDO endUser){
		if(endUserService.save(endUser)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:endUser:edit")
	public R update( EndUserDO endUser){
		endUserService.update(endUser);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:endUser:remove")
	public R remove( Integer id){
		if(endUserService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:endUser:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		endUserService.batchRemove(ids);
		return R.ok();
	}
	
}
