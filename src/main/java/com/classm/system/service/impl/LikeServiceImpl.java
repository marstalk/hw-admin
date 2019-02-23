package com.classm.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.classm.system.dao.LikeDao;
import com.classm.system.domain.LikeDO;
import com.classm.system.service.LikeService;



@Service
public class LikeServiceImpl implements LikeService {
	@Autowired
	private LikeDao likeDao;
	
	@Override
	public LikeDO get(Integer id){
		return likeDao.get(id);
	}
	
	@Override
	public List<LikeDO> list(Map<String, Object> map){
		return likeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return likeDao.count(map);
	}
	
	@Override
	public int save(LikeDO like){
		return likeDao.save(like);
	}
	
	@Override
	public int update(LikeDO like){
		return likeDao.update(like);
	}
	
	@Override
	public int remove(Integer id){
		return likeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return likeDao.batchRemove(ids);
	}
	
}
