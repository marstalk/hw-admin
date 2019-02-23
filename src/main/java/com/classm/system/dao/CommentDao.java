package com.classm.system.dao;

import com.classm.system.domain.CommentDO;

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
public interface CommentDao {

	CommentDO get(Integer id);
	
	List<CommentDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CommentDO comment);
	
	int update(CommentDO comment);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
