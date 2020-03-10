package com.zc.solr;

import com.zc.flywaydemo.pojo.LogsInfo;
import com.zc.flywaydemo.service.LogsInfoService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Component
public class InitSolrData {
    @Resource
    LogsInfoService logsInfoService;

    private int initSolrData(){
        List<LogsInfo> alLogsInfo = logsInfoService.getAlLogsInfo(new HashMap<>());
        return 1;
    }

}
