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
                        <li class="breadcrumb-item active" aria-current="page">
                            Role
                        </li>
                    </ol>
                </nav>
                <h1 class="m-0">Role Dashboard</h1>
            </div>
            <div class="ml-auto">
                <a href="<c:url value="<%=UrlConstant.ROLE_ADD %>" />" class="btn btn-light"><i class="material-icons icon-16pt text-muted mr-1">add</i>
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
					<th class="col-4">
						Name
					</th>
					<th class="col-5">
						Description
					</th>
					<th class="col-3">
						Functions
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${roles}" var="role">
					<tr class="row">
						<td class="col-4">
							${role.name}
						</td>
						<td class="col-5">
							${role.description}
						</td>
				
						<td class="col-3 button-list d-flex flex-wrap">
							<a href="<c:url value="<%=UrlConstant.ROLE_UPDATE %>" />?id=${role.id}" class="btn btn-primary">
	                            <i class="material-icons">edit</i>
	                        </a>
	                        <a href="<c:url value="<%=UrlConstant.ROLE_DELETE %>" />?id=${role.id}" class="btn btn-danger">
	                            <i class="material-icons">delete_forever</i>
	                        </a>
						</td>
					</tr>
				</c:forEach>
				<c:if test="${roles == null}">
					<tr>
						<td>There is no data.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
</div>
