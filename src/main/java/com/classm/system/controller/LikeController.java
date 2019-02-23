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

import com.classm.system.domain.LikeDO;
import com.classm.system.service.LikeService;
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
@RequestMapping("/system/like")
public class LikeController {
	@Autowired
	private LikeService likeService;
	
	@GetMapping()
	@RequiresPermissions("system:like:like")
	String Like(){
	    return "system/like/like";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:like:like")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<LikeDO> likeList = likeService.list(query);
		int total = likeService.count(query);
		PageUtils pageUtils = new PageUtils(likeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:like:add")
	String add(){
	    return "system/like/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:like:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		LikeDO like = likeService.get(id);
		model.addAttribute("like", like);
	    return "system/like/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:like:add")
	public R save( LikeDO like){
		if(likeService.save(like)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:like:edit")
	public R update( LikeDO like){
		likeService.update(like);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:like:remove")
	public R remove( Integer id){
		if(likeService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:like:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		likeService.batchRemove(ids);
		return R.ok();
	}
	
}
