package com.shang.controller;

import com.github.pagehelper.PageInfo;
import com.shang.domain.Permission;
import com.shang.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    /**
     * 查询所有的权限
     * @return
     */
    @RequestMapping("/findAllPermission")
    public String findAllPermission(Model model,
                                    @RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                    @RequestParam(name = "pageSize",required = true,defaultValue = "5")Integer pageSize) throws Exception{
        List<Permission> permissionList = permissionService.findAllPermission(page,pageSize);
        PageInfo pageInfo = new PageInfo(permissionList);
        model.addAttribute("permissionList",pageInfo);
        return "permission-list";
    }

    @RequestMapping("/savePermission")
    public String savePermission(Permission permission) throws Exception{
        int n = permissionService.savePermission(permission);
        //添加成 重定向到资源权限列表页面
        if (n>0){
            return "redirect:/permission/findAllPermission";
        }
        //如果添加失败,返回权限添加页面
        return "permission-add";


    }
}
