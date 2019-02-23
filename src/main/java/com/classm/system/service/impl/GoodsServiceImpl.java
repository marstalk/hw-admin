package com.classm.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.classm.system.dao.GoodsDao;
import com.classm.system.domain.GoodsDO;
import com.classm.system.service.GoodsService;



@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public GoodsDO get(Integer id){
		return goodsDao.get(id);
	}
	
	@Override
	public List<GoodsDO> list(Map<String, Object> map){
		return goodsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return goodsDao.count(map);
	}
	
	@Override
	public int save(GoodsDO goods){
		return goodsDao.save(goods);
	}
	
	@Override
	public int update(GoodsDO goods){
		return goodsDao.update(goods);
	}
	
	@Override
	public int remove(Integer id){
		return goodsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return goodsDao.batchRemove(ids);
	}
	
}
