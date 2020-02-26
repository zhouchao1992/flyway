package com.zc.flywaydemo.dao;

import com.zc.flywaydemo.pojo.LogsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface LogsInfoDao {
    /*简单查询*/
    List<LogsInfo>  getAlLogsInfo(@Param("params")Map<String,Object> param);

    /*批量插入和更新*/
    int updateLogInfo(@Param("params")Map<String,Object> param);

}
