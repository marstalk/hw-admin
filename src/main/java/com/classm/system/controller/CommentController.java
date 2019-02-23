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

import com.classm.system.domain.CommentDO;
import com.classm.system.service.CommentService;
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
@RequestMapping("/system/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@GetMapping()
	@RequiresPermissions("system:comment:comment")
	String Comment(){
	    return "system/comment/comment";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:comment:comment")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CommentDO> commentList = commentService.list(query);
		int total = commentService.count(query);
		PageUtils pageUtils = new PageUtils(commentList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:comment:add")
	String add(){
	    return "system/comment/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:comment:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		CommentDO comment = commentService.get(id);
		model.addAttribute("comment", comment);
	    return "system/comment/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:comment:add")
	public R save( CommentDO comment){
		if(commentService.save(comment)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:comment:edit")
	public R update( CommentDO comment){
		commentService.update(comment);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:comment:remove")
	public R remove( Integer id){
		if(commentService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:comment:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		commentService.batchRemove(ids);
		return R.ok();
	}
	
}
