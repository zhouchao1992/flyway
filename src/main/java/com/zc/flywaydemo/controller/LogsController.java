package com.zc.flywaydemo.controller;

import com.zc.flywaydemo.pojo.LogsInfo;
import com.zc.flywaydemo.service.LogsInfoService;
import com.zc.log.annotation.SystemControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/logs/")
@Api(value = "日志接口1",tags = "日志接口1")
public class LogsController {
    @Resource
    LogsInfoService logsInfoService;

    @Resource
    private SolrTemplate solrTemplate;

    @GetMapping("logsInfo")
    @ApiOperation(value="获取日志信息", notes="获取日志信息", produces = "application/json")
    @SystemControllerLog
    public List<LogsInfo> getLogsInof(String id,int currentPage,int pageSize){
        Map param = new HashMap();
        param.put("id",id);
        param.put("currentPage",currentPage);
        param.put("pageSize",pageSize);
        List<LogsInfo> alLogsInfo = logsInfoService.getAlLogsInfo(param);
        UpdateResponse my_core_one = solrTemplate.saveBeans("my_core_one", alLogsInfo);
        int status = my_core_one.getStatus();
        System.out.println(status);

        return alLogsInfo;
    }

    @GetMapping("updateLogsInfo")
    @ApiOperation(value="批量插入或者更新信息", notes="批量插入或者更新信息", produces = "application/json")
    @SystemControllerLog
    public int updateLogsInfo(String isAdd){//isAdd是否为新增，反之为更新
        List<LogsInfo>  data = new ArrayList<>();
        Map param = new HashMap();
        param.put("isAdd",isAdd);
        List<LogsInfo> alLogsInfo = getLogsInfo(data,isAdd);
        param.put("logsinfo",alLogsInfo);
        int ints = logsInfoService.updateLogInfo(param);
        return ints;
    }

    @SystemControllerLog
    public  List<LogsInfo> getLogsInfo( List<LogsInfo>  data,String isAdd ){
       if ("0".equals(isAdd)){
           for (int i=0;i<1000;i++){
               LogsInfo logsInfo = new LogsInfo();
               logsInfo.setId( UUID.randomUUID().toString());
               logsInfo.setHtmlname("新建"+i);
               logsInfo.setLogip("127.0.0.1");
               logsInfo.setLaddtime(new Date());
               logsInfo.setLadduser("111");
               logsInfo.setLogurl("http://127.0.0.1:8077//swagger-ui.html#/%E6%97%A5%E5%BF%97%E6%8E%A5%E5%8F%A3/getLogsInofUsingGET");
               data.add(logsInfo);
           }
       }else {
           LogsInfo logsInfo = new LogsInfo();
           logsInfo.setId("1");
           logsInfo.setHtmlname("修改");
           logsInfo.setLogip("127.0.0.1");
           logsInfo.setLaddtime(new Date());
           logsInfo.setLadduser("111");
           logsInfo.setLogurl("http://127.0.0.1:8077//swagger-ui.html#/%E6%97%A5%E5%BF%97%E6%8E%A5%E5%8F%A3/getLogsInofUsingGET");
           data.add(logsInfo);
       }
        return data;
    }
}
