package com.zc.flywaydemo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zc.flywaydemo.dao.LogsInfoDao;
import com.zc.flywaydemo.pojo.LogsInfo;
import com.zc.flywaydemo.service.LogsInfoService;
import com.zc.log.annotation.SystemServiceLog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LogsInfoServiceImpl implements LogsInfoService {
    @Resource
    LogsInfoDao logsInfoDao;

    @Override
    @SystemServiceLog
    public List<LogsInfo> getAlLogsInfo(Map<String,Object> param) {
        if (param.get("currentPage")!=null && param.get("pageSize")!=null){
            //分页插件的使用 第一个参数是当前页 第二个参数是每页显示的条数
            PageHelper.startPage(Integer.parseInt(String.valueOf(param.get("currentPage"))), Integer.parseInt(String.valueOf(param.get("pageSize"))));
        }
        Page<LogsInfo> page = (Page<LogsInfo>)logsInfoDao.getAlLogsInfo(param);
        System.out.println("第"+page.getPageNum()+"页");
        System.out.println("查询数据"+page.getEndRow()+"条");
        System.out.println("总页数"+page.getTotal());
        return page.getResult();
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    @SystemServiceLog
    public int updateLogInfo(Map<String, Object> param) {
        int count = logsInfoDao.updateLogInfo(param);
        return count;
    }
}
