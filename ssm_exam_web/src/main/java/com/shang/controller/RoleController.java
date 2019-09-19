package com.shang.controller;

import com.github.pagehelper.PageInfo;
import com.shang.domain.Permission;
import com.shang.domain.Role;
import com.shang.domain.UserInfo;
import com.shang.service.PermissionService;
import com.shang.service.RolePermissionService;
import com.shang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 查询所有的角色
     * @param model
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAllRole")
    public String findAllRole(Model model,
                              @RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                              @RequestParam(name = "pageSize",required = true,defaultValue = "5")Integer pageSize)throws Exception{
        List<Role> roleList = roleService.findAllRole(page,pageSize);
        System.out.println("打印用户信息:"+roleList);
        //使用pageInfo对象将分页的信息传递到页面
        PageInfo pageInfo = new PageInfo(roleList);
        model.addAttribute("roleList",pageInfo);
        return "role-list";
    }

    /**
     * 添加角色
     * @param role
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveRole")
    public String saveRole(Role role) throws Exception{
       int n= roleService.saveRole(role);
       //添加成功之后跳转到角色列表页面
        if (n>0){
            return "redirect:/role/findAllRole";
        }
        //若添加失败,继续返回到添加角色的页面
        return "role-add";
    }

    /**
     * 查询角色详情
     * @param roleid
     * @return
     * @throws Exception
     */
    @RequestMapping("/findRoleByRoleId")
    public ModelAndView findRoleByRoleId(@RequestParam(name = "roleid",required = true)String roleid)throws  Exception{
        Role role=roleService.findRoleByRoleId(roleid);
        System.out.println(role);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("role",role);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }

    /**
     * 根据角色id查询当前角色所没有的权限
     * @param model
     * @param roleid
     * @return
     */
    @RequestMapping("/findOtherPermissionByRoleId")
    public String findOtherPermissionByRoleId(Model model,String roleid) throws Exception {
        List<Permission> permissionList=permissionService.findOtherPermissionByRoleId(roleid);
        model.addAttribute("roleid",roleid);
        model.addAttribute("permissionList",permissionList);
        return "role-permission-add";
    }

    /**
     * 给角色添加权限
     * @param roleid
     * @param permissionids
     * @return
     */
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleid",required = true)String roleid,
                                      @RequestParam(name = "permissionids",required = true)List<String>permissionids){
        try {
            rolePermissionService.addPermissionToRole(roleid,permissionids);
            return "redirect:/role/findAllRole";
        } catch (Exception e) {
            e.printStackTrace();
            return "role-permission-add";
        }

    }

}
