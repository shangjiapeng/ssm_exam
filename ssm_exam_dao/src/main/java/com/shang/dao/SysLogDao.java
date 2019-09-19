package com.shang.dao;

import com.shang.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 日志操作文件
 */
@Repository
public interface SysLogDao {
    /**
     * 添加日志
     * @param sysLog
     * @throws Exception
     */
    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void addSysLog(SysLog sysLog) throws Exception;

    /**
     * 查询所有的日志信息
     * @return
     * @throws Exception
     */
    @Select("select *from syslog")
    public List<SysLog>findAllLog() throws Exception;

}
