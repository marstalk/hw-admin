package com.classm.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.classm.system.dao.GoodsTypeDao;
import com.classm.system.domain.GoodsTypeDO;
import com.classm.system.service.GoodsTypeService;



@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
	@Autowired
	private GoodsTypeDao goodsTypeDao;
	
	@Override
	public GoodsTypeDO get(Integer id){
		return goodsTypeDao.get(id);
	}
	
	@Override
	public List<GoodsTypeDO> list(Map<String, Object> map){
		return goodsTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return goodsTypeDao.count(map);
	}
	
	@Override
	public int save(GoodsTypeDO goodsType){
		return goodsTypeDao.save(goodsType);
	}
	
	@Override
	public int update(GoodsTypeDO goodsType){
		return goodsTypeDao.update(goodsType);
	}
	
	@Override
	public int remove(Integer id){
		return goodsTypeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return goodsTypeDao.batchRemove(ids);
	}
	
}
