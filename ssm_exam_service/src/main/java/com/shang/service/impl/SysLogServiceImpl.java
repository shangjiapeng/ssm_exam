package com.shang.service.impl;

import com.github.pagehelper.PageHelper;
import com.shang.dao.SysLogDao;
import com.shang.domain.SysLog;
import com.shang.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;
    /**
     * 添加日志
     *
     * @param sysLog
     * @throws Exception
     */
    @Override
    public void addSysLog(SysLog sysLog) throws Exception {
        sysLogDao.addSysLog(sysLog);

    }

    /**
     * 查询所有的日志信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<SysLog> findAllLog(Integer page ,Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return sysLogDao.findAllLog();
    }
}
