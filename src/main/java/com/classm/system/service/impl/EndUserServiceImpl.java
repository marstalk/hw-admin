package com.classm.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.classm.system.dao.EndUserDao;
import com.classm.system.domain.EndUserDO;
import com.classm.system.service.EndUserService;



@Service
public class EndUserServiceImpl implements EndUserService {
	@Autowired
	private EndUserDao endUserDao;
	
	@Override
	public EndUserDO get(Integer id){
		return endUserDao.get(id);
	}
	
	@Override
	public List<EndUserDO> list(Map<String, Object> map){
		return endUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return endUserDao.count(map);
	}
	
	@Override
	public int save(EndUserDO endUser){
		return endUserDao.save(endUser);
	}
	
	@Override
	public int update(EndUserDO endUser){
		return endUserDao.update(endUser);
	}
	
	@Override
	public int remove(Integer id){
		return endUserDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return endUserDao.batchRemove(ids);
	}
	
}
