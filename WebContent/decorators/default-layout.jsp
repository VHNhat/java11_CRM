<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.opensymphony.com/sitemesh/decorator" prefix = "dec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title/></title>
    <jsp:include page="/decorators/components/link-header.jsp"></jsp:include>
	<dec:head/>
</head>

<body class="layout-fixed">
	<div class="preloader"></div>
	
	<div class="mdk-header-layout js-mdk-header-layout">
		<!-- Header -->
		<jsp:include page="/decorators/components/header.jsp"/>

        <!-- END Header -->
        
        <!--  Header menu -->
		
		<!--  End Header menu -->     
		   
        <!--  Page content -->
        <div class="mdk-header-layout js-mdk-header-layout">
       		<jsp:include page="/decorators/components/header-menu.jsp"></jsp:include>
        	<dec:body/>
        </div>
        
        <!--  End Page content -->
        
    </div>
    <!--  Sponsor -->
    <jsp:include page="/decorators/components/sponsor.jsp"></jsp:include>
    <!--  End Sponsor -->
      
      <!--  Footer -->
    <jsp:include page="/decorators/components/footer.jsp"/>
</body>
</html>