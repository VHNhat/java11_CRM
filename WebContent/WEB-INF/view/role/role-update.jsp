<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cybersoft.java11.crm.utils.UrlConstant" %>
<!-- Breadcrumb -->
<title>Role Dashboard</title>
<div class="container page__heading-container">
    <div class="page__heading">
        <div class="d-flex align-items-center">
            <div>
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb mb-0">
                        <li class="breadcrumb-item"><a href="<c:url value="<%=UrlConstant.HOME %>" />">Home</a></li>
                        <li class="breadcrumb-item"><a href="<c:url value="<%=UrlConstant.ROLE_DASHBOARD %>" />">Role</a></li>
                        <li class="breadcrumb-item active" aria-current="page">
                            Edit role
                        </li>
                    </ol>
                </nav>
                <h1 class="m-0">Edit role</h1>
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
                <p><strong class="headings-color">Role naming convention</strong></p>
                <p class="text-muted">Role name should be capitalized.</p>
            </div>
            <div class="col-lg-8 card-form__body card-body">
                <form action='<c:url value="<%=UrlConstant.ROLE_UPDATE%>" />' method="post">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" id="name" name="role-name" value="${role.name }">
                    </div>
                    <div class="form-group">
                        <label for="description">Description:</label>
                        <input type="text" class="form-control" id="description" name="role-description"  value="${role.description }">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="id" name="role-id" value="${role.id }" readonly hidden>
                    </div>
                    <button type="submit" class="btn btn-lg btn-primary">Update</button>
                </form>
            </div>
        </div>
    </div>
</div>
