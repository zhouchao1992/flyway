package com.zc.solr;

import com.zc.flywaydemo.dao.LogsInfoDao;
import com.zc.flywaydemo.pojo.LogsInfo;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InitSolrData implements ApplicationListener<ContextRefreshedEvent> {
    @Resource
    LogsInfoDao logsInfoDao;

    @Resource
    private SolrTemplate solrTemplate;
    @Resource
    SolrClient client;

    private void initSolrData(){
        Map<String,Object> param = new HashMap<>();
        param.put("currentPage",1);
        param.put("pageSize",1000);
        List<LogsInfo> alLogsInfo = logsInfoDao.getAlLogsInfo(param);
        /*pdateResponse my_core_one = solrTemplate.saveBeans("my_core_one", alLogsInfo);
        System.out.println("执行时间"+my_core_one.getQTime());
        System.out.println("执行结果"+my_core_one.getStatus());*/
      /*  try {
            client.addBeans(alLogsInfo);
            client.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //solrTemplate.commit("my_core_one");
        solrTemplate.saveBeans(alLogsInfo);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initSolrData();
    }
}
