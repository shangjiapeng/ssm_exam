package com.shang.service;

import com.shang.domain.SysLog;

import java.util.List;

public interface SysLogService {
    /**
     * 添加日志
     * @param sysLog
     * @throws Exception
     */
    public void addSysLog(SysLog sysLog) throws Exception;

    /**
     * 查询所有的日志信息
     * @return
     * @throws Exception
     */
    public List<SysLog>findAllLog(Integer page ,Integer pageSize) throws Exception;
}
