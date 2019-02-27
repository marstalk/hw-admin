package com.classm.system.controller;

import com.classm.common.annotation.Log;
import com.classm.common.config.Constant;
import com.classm.common.controller.BaseController;
import com.classm.common.utils.R;
import com.classm.system.domain.RoleDO;
import com.classm.system.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/sys/role")
@Controller
public class RoleController extends BaseController {
	String prefix = "system/role";
	@Autowired
	RoleService roleService;

	@RequiresPermissions("sys:role:role")
	@GetMapping()
	String role() {
		return prefix + "/role";
	}

	@RequiresPermissions("sys:role:role")
	@GetMapping("/list")
	@ResponseBody()
	List<RoleDO> list() {
		List<RoleDO> roles = roleService.list();
		return roles;
	}

	@Log("NewRole")
	@RequiresPermissions("sys:role:add")
	@GetMapping("/add")
	String add() {
		return prefix + "/add";
	}

	@Log("编辑Role")
	@RequiresPermissions("sys:role:edit")
	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id, Model model) {
		RoleDO roleDO = roleService.get(id);
		model.addAttribute("role", roleDO);
		return prefix + "/edit";
	}

	@Log("SaveRole")
	@RequiresPermissions("sys:role:add")
	@PostMapping("/save")
	@ResponseBody()
	R save(RoleDO role) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许Update,完整体验请部署程序");
		}
		if (roleService.save(role) > 0) {
			return R.ok();
		} else {
			return R.error(1, "Save失败");
		}
	}

	@Log("更新Role")
	@RequiresPermissions("sys:role:edit")
	@PostMapping("/update")
	@ResponseBody()
	R update(RoleDO role) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许Update,完整体验请部署程序");
		}
		if (roleService.update(role) > 0) {
			return R.ok();
		} else {
			return R.error(1, "Save失败");
		}
	}

	@Log("DeleteRole")
	@RequiresPermissions("sys:role:remove")
	@PostMapping("/remove")
	@ResponseBody()
	R save(Long id) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许Update,完整体验请部署程序");
		}
		if (roleService.remove(id) > 0) {
			return R.ok();
		} else {
			return R.error(1, "Delete失败");
		}
	}
	
	@RequiresPermissions("sys:role:batchRemove")
	@Log("批量DeleteRole")
	@PostMapping("/batchRemove")
	@ResponseBody
	R batchRemove(@RequestParam("ids[]") Long[] ids) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许Update,完整体验请部署程序");
		}
		int r = roleService.batchremove(ids);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}
}
