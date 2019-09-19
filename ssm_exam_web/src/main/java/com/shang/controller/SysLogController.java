package com.shang.controller;

import com.github.pagehelper.PageInfo;
import com.shang.domain.SysLog;
import com.shang.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAllLog")
    public String findAllLog(Model model,
                             @RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                             @RequestParam(name = "pageSize",required = true,defaultValue = "10")Integer pageSize) throws Exception{
        List<SysLog> sysLogList = sysLogService.findAllLog(page,pageSize);
        PageInfo pageInfo = new PageInfo(sysLogList);
        System.out.println("日志信息:"+sysLogList);
        model.addAttribute("sysLogs",pageInfo);
        return "syslog-list";
    }
}
