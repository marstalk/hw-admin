package com.classm.common.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classm.common.dao.GeneratorMapper;
import com.classm.common.service.GeneratorService;
import com.classm.common.utils.GenUtils;


@Service
public class GeneratorServiceImpl implements GeneratorService {
	@Autowired
	GeneratorMapper generatorMapper;

	@Override
	public List<Map<String, Object>> list() {
		List<Map<String, Object>> list = generatorMapper.list();
		return list;
	}

	@Override
	public byte[] generatorCode(String[] tableNames) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);
		for(String tableName : tableNames){
			//查询表Info
			Map<String, String> table = generatorMapper.get(tableName);
			//查询列Info
			List<Map<String, String>> columns = generatorMapper.listColumns(tableName);
			//生成代码
			GenUtils.generatorCode(table, columns, zip);
		}
		IOUtils.closeQuietly(zip);
		return outputStream.toByteArray();
	}

}
