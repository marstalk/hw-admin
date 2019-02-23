package com.classm.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.classm.system.dao.GoodsPicDao;
import com.classm.system.domain.GoodsPicDO;
import com.classm.system.service.GoodsPicService;



@Service
public class GoodsPicServiceImpl implements GoodsPicService {
	@Autowired
	private GoodsPicDao goodsPicDao;
	
	@Override
	public GoodsPicDO get(Integer id){
		return goodsPicDao.get(id);
	}
	
	@Override
	public List<GoodsPicDO> list(Map<String, Object> map){
		return goodsPicDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return goodsPicDao.count(map);
	}
	
	@Override
	public int save(GoodsPicDO goodsPic){
		return goodsPicDao.save(goodsPic);
	}
	
	@Override
	public int update(GoodsPicDO goodsPic){
		return goodsPicDao.update(goodsPic);
	}
	
	@Override
	public int remove(Integer id){
		return goodsPicDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return goodsPicDao.batchRemove(ids);
	}
	
}
