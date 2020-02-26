package com.zc.flywaydemo.service;

import com.zc.flywaydemo.pojo.LogsInfo;

import java.util.List;
import java.util.Map;

public interface LogsInfoService {
    List<LogsInfo> getAlLogsInfo(Map<String,Object> param);

    int updateLogInfo(Map<String,Object> param);
}
