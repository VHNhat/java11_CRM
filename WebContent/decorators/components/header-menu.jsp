<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cybersoft.java11.crm.utils.UrlConstant" %>
<div class="page__header mb-0">
    <div class="container page__container">
        <div class="navbar navbar-secondary navbar-light navbar-expand-sm p-0">
            <button class="navbar-toggler navbar-toggler-right" data-toggle="collapse" data-target="#navbarsExample03" type="button">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="navbar-collapse collapse" id="navbarsExample03">
                <ul class="nav navbar-nav flex">
                    <li class="nav-item">
                        <a class="nav-link active" href="<c:url value="<%=UrlConstant.HOME %>" />">
                            Dashboard
                        </a>
                    </li>
                    <li class="nav-item dropdown">
                        <a href="<c:url value="" />"" class="nav-link dropdown-toggle" data-toggle="dropdown">
                            Project
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="<c:url value="<%=UrlConstant.PROJECT_DASHBOARD %>" />">
                                Manage Project
                            </a>
                            <a class="dropdown-item" href="<c:url value="<%=UrlConstant.PROJECT_ADD %>" />">
                                Project Create Project
                            </a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a href="<c:url value="" />"" class="nav-link dropdown-toggle" data-toggle="dropdown">
                            User
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="<c:url value="<%=UrlConstant.USER_DASHBOARD %>" />">
                                User List
                            </a>
                            <a class="dropdown-item" href="<c:url value="<%=UrlConstant.USER_ADD %>" />">
                                Create User
                            </a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="<c:url value="" />"" data-toggle="dropdown">Task</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="<c:url value="<%=UrlConstant.TASK_DASHBOARD %>" />">
                                Task List
                            </a>
                            <a class="dropdown-item" href="<c:url value="<%=UrlConstant.TASK_ADD %>" />">
                                Create Task
                            </a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">
                            Role
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="<c:url value="<%=UrlConstant.ROLE_DASHBOARD %>" />"">
                                Dashboard
                            </a>
                            <a class="dropdown-item" href="<c:url value="<%=UrlConstant.ROLE_ADD %>" />"">
                                Create Role
                            </a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
