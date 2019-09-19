
package com.shang.controller;

import com.github.pagehelper.PageInfo;
import com.shang.domain.Role;
import com.shang.domain.UserInfo;
import com.shang.service.RoleService;
import com.shang.service.UserInfoRoleService;
import com.shang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserInfoRoleService userInfoRoleService;

    /**
     * 查询所有用户
     *
     * @return
     * @throws Exception
     */

    // @RolesAllowed({"USER","ADMIN"})  //注意:在使用jsr-250 注解时可以省略"ROLE" 前缀

    //@Secured("ROLE_ADMIN") //注意:在使用@Secured 注解时,不可以省略"ROLE" 前缀

    //@PreAuthorize("authentication.principal.username=='aa'")
    // 此注解表示:在执行findAllUser()之前先判断principal中保存的当前用户的username是否为"aa"
    //@PreAuthorize("#username==authentication.principal.username or hasAuthority('ROLE_ADMIN')")
    //@PostAuthorize("hasRole('ROLE_ADMIN')")
    //这里表示在findAllUser()方法执行之前，判断方法参数username的值是否等于principal中保存的当前用户的username，
    //或者当前用户是否具有ROLE_ADMIN权限，两种符合其一，就可以访问该方法。
    /* @PreFilter 允许方法调用,但是必须在进入方法之前过滤输入值
     * @PostFilter 允许方法的调用,但是必须按照表达式对方法的结果进行过滤*/
    @RequestMapping("/findAllUser")
    public String findAllUser(Model model,
                              @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                              @RequestParam(name = "pageSize", required = true, defaultValue = "5") Integer pageSize) throws Exception {
        List<UserInfo> userList = userService.findAllUser(page, pageSize);
        System.out.println("打印用户信息:" + userList);
        //使用pageInfo对象将分页的信息传递到页面
        PageInfo pageInfo = new PageInfo(userList);
        model.addAttribute("userList", pageInfo);
        return "user-list";
    }

    /**
     * 添加用户
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveUserInfo")
    public String saveUserInfo(UserInfo userInfo) throws Exception {
        int n = userService.saveUserInfo(userInfo);
        if (n > 0) {
            //添加成功重定向到,查询所有用户的界面
            return "redirect:/user/findAllUser";
        }
        return "user-add";
    }

    /**
     * 根据id查询用户信息包含了用户所有的角色和权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findUserById")
    public ModelAndView findUserById(@RequestParam(name = "id", required = true) String id) throws Exception {
        UserInfo userInfo = userService.findUserById(id);
        System.out.println(userInfo);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    /**
     * 查询用户没有的角色信息
     *
     * @param model
     * @param userid
     * @return
     * @throws Exception
     */
    @RequestMapping("/findOtherRoleById")
    public String findOtherRoleById(Model model, @RequestParam(name = "userid") String userid) throws Exception {
        List<Role> roleList = roleService.findOtherRole(userid);
        model.addAttribute("userid", userid);
        model.addAttribute("roleList", roleList);
        return "user-role-add";
    }

    /**
     * 给用户添加角色
     *
     * @param userid
     * @param roleids
     * @return
     */
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userid", required = true) String userid,
                                @RequestParam(name = "roleids", required = true) List<String> roleids) {
        try {
            userInfoRoleService.addRoleToUser(userid, roleids);
            return "redirect:/user/findAllUser";
        } catch (Exception e) {
            return "user-role-add";
        }
    }

}
