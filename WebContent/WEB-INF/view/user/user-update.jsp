<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cybersoft.java11.crm.utils.UrlConstant" %>
<!-- Breadcrumb -->
<title>Edit User</title>
<div class="container page__heading-container">
    <div class="page__heading">
        <div class="d-flex align-items-center">
            <div>
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb mb-0">
                        <li class="breadcrumb-item"><a href="<c:url value="<%=UrlConstant.HOME %>" />">Home</a></li>
                        <li class="breadcrumb-item"><a href="<c:url value="<%=UrlConstant.USER_DASHBOARD %>" />">User</a></li>
                        <li class="breadcrumb-item active" aria-current="page">
                            Edit user
                        </li>
                    </ol>
                </nav>
                <h1 class="m-0">Edit user</h1>
            </div>
            
        </div>
    </div>
</div>
<!-- End Breadcrumb -->
<div class="container page__container">
	<div class="card card-form">
		<c:if test="${msg != null }">
			<div class="alert alert-dismissible bg-danger text-white border-0 fade show" role="alert">
	            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	                <span aria-hidden="true">&times;</span>
	            </button>
	            <strong>Error - </strong> ${msg}
	        </div>
		</c:if>
        <div class="row no-gutters">
            <div class="col-lg-4 card-body">
                <p><strong class="headings-color">User naming convention</strong></p>
                <p class="text-muted">User name should be capitalized.</p>
            </div>
            <div class="col-lg-8 card-form__body card-body">
                <form action='<c:url value="<%=UrlConstant.USER_UPDATE%>" />' method="post">
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="text" class="form-control" id="email" name="user-email" value="${user.email }">
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control" id="password" name="user-password" value="${user.password }">
                    </div>
                    <div class="form-group">
                        <label for="fullname">Fullname:</label>
                        <input type="text" class="form-control" id="fullname" name="user-fullname" value="${user.fullname }">
                    </div>
                    <div class="form-group">
                        <label for="address">Address:</label>
                        <input type="text" class="form-control" id="address" name="user-address" value="${user.address }">
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone:</label>
                        <input type="text" class="form-control" id="phone" name="user-phone" value="${user.phone }">
                    </div>
                    <div class="form-group">
                        <label for="roleId">Role Id:</label>
                        <input type="text" class="form-control" id="roleId" name="user-roleid" value="${user.role.id }">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="id" name="id" value="${user.id }" readonly hidden>
                    </div>
                    <button type="submit" class="btn btn-lg btn-primary">Update</button>
                </form>
            </div>
        </div>
    </div>
</div>
