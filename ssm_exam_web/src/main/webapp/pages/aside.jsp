<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="section" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sercurity" uri="http://www.springframework.org/security/tags" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user3-128x128.jpg"
                     class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p><sercurity:authentication property="principal.username"></sercurity:authentication></p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <li id="admin-index">
                <a href="${pageContext.request.contextPath}/main.jsp">
                    <i class="fa fa-dashboard"></i> <span>首页</span></a>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-cogs"></i>
                    <span>系统管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li id="system-setting">
                        <section:authorize access="hasRole('ROLE_ADMIN')">
                        <a href="${pageContext.request.contextPath}/user/findAllUser?page=1&pageSize=5">
                            <i class="fa fa-circle-o"></i> 用户管理
                        </a>
                        </section:authorize>
                    </li>

                    <li id="system-setting">
                        <section:authorize access="hasRole('ROLE_ADMIN')">
                        <a href="${pageContext.request.contextPath}/role/findAllRole?page=1&pageSize=5">
                            <i class="fa fa-circle-o"></i> 角色管理
                        </a>
                        </section:authorize>
                    </li>

                    <li id="system-setting">
                        <section:authorize access="hasRole('ROLE_ADMIN')">
                        <a href="${pageContext.request.contextPath}/permission/findAllPermission?page=1&pageSize=5">
                            <i class="fa fa-circle-o"></i> 资源权限管理
                        </a>
                        </section:authorize>
                    </li>

                    <li id="system-setting">
                        <section:authorize access="hasRole('ROLE_ADMIN')">
                        <a href="${pageContext.request.contextPath}/sysLog/findAllLog">
                            <i class="fa fa-circle-o"></i> 访问日志
                        </a>
                        </section:authorize>
                    </li>
                </ul>
            </li>
            <li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
                <span>基础数据</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>
            </a>
                <ul class="treeview-menu">

                    <li id="system-setting"><a
                            href="${pageContext.request.contextPath}/product/findAllProduct?page=1&pageSize=5">
                        <i class="fa fa-circle-o"></i> 产品管理
                    </a></li>
                    <%--<li id="system-setting"><a
                            href="${pageContext.request.contextPath}/orders/findAllOrders"> <i
                            class="fa fa-circle-o"></i> 订单管理
                    </a></li>--%>

                    <li id="system-setting"><a
                            href="${pageContext.request.contextPath}/orders/findAllOrders?page=1&pageSize=5"> <i
                            class="fa fa-circle-o"></i> 订单管理
                    </a></li>
                </ul>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>