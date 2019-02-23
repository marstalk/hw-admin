package com.classm.system.dao;

import com.classm.system.domain.LikeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author hw
 * @email hw@test.com
 * @date 2019-02-23 15:32:24
 */
@Mapper
public interface LikeDao {

	LikeDO get(Integer id);
	
	List<LikeDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(LikeDO like);
	
	int update(LikeDO like);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
