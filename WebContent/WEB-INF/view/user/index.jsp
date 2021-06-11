<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cybersoft.java11.crm.utils.UrlConstant" %>
<!-- Breadcrumb -->
<title>User Dashboard</title>
<div class="container page__heading-container">
    <div class="page__heading">
        <div class="d-flex align-items-center">
            <div>
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb mb-0">
                        <li class="breadcrumb-item"><a href="<c:url value="<%=UrlConstant.HOME %>" />">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">
                            User
                        </li>
                    </ol>
                </nav>
                <h1 class="m-0">User Dashboard</h1>
            </div>
            <div class="ml-auto">
                <a href="<c:url value="<%=UrlConstant.USER_ADD %>" />" class="btn btn-light"><i class="material-icons icon-16pt text-muted mr-1">add</i>
    Add</a>
            </div>
        </div>
    </div>
</div>
<!-- End Breadcrumb -->
<div class="container page__container">
	<div class="table">
		<table class="table mb-0 thead-border-top-0">
			<thead>
				<tr class="row">
					<th class="col-3">
						Email
					</th>
					<th class="col-3">
						Fullname
					</th>
					<th class="col-2">
						Address
					</th>
					<th class="col-2">
						Phone
					</th>
					<th class="col-2">
						Funtion
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr class="row">
						<td class="col-3">
							${user.email}
						</td>
						<td class="col-3">
							${user.fullname}
						</td>
						<td class="col-2">
							${user.address}
						</td>
						<td class="col-2">
							${user.phone}
						</td>
				
						<td class="col-2 button-list d-flex flex-wrap">
							<a href="<c:url value="<%=UrlConstant.USER_UPDATE %>" />?id=${user.id}" class="btn btn-primary">
	                            <i class="material-icons">edit</i>
	                        </a>
	                        <a href="<c:url value="<%=UrlConstant.USER_DELETE %>" />?id=${user.id}" class="btn btn-danger">
	                            <i class="material-icons">delete_forever</i>
	                        </a>
						</td>
					</tr>
				</c:forEach>
				<c:if test="${users == null}">
					<tr>
						<td>There is no data.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
</div>