
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- CSS -->
      <!-- <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">-->
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

    </head>
    <body>
    <c:if test="${not pageContext.request.secure}">
    </c:if>
	<div class="top-content">
        	
            <div class="inner-bg" style="height: 400px; margin-top: 0px; margin-bottom: 0px; padding-top: 50px;">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>高校云平台</strong></h1>
                            <div class="description">
                            	<p>
	                            	This is a Cloud Times. 
	                            	
                            	</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>登录</h3>
                            		<!--<p>Enter your username and password to log on:</p>-->
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
  			<div class="form-bottom" id="login">
			   <form:form method="post" id="fm1" cssClass="fm-v clearfix" class="login-form" commandName="${commandName}" htmlEscape="true">
                  <form:errors path="*" id="msg" cssClass="errors" element="div" htmlEscape="false"/>
                
                     <div class="form-group">
			               <label class="sr-only" for="username">Username</label>
                           <c:if test="${not empty sessionScope.openIdLocalId}">
						   <strong>${sessionScope.openIdLocalId}</strong>
			               <input type="text" name="username" placeholder="用户名..." class="form-username form-control" id="username" >
			               </c:if>
                           
                            <c:if test="${empty sessionScope.openIdLocalId}">
							<spring:message code="screen.welcome.label.netid.accesskey" var="userNameAccessKey" />
							<form:input cssClass="required" cssErrorClass="error" id="username" placeholder="用户名..." class="form-username form-control" size="25"  style="width: 100%;" tabindex="1" accesskey="${userNameAccessKey}" path="username" autocomplete="false" htmlEscape="true" />
							</c:if>
                      </div>
			          <div class="form-group">
			                 <label class="sr-only" for="password">Password</label>
                               <spring:message code="screen.welcome.label.password.accesskey" var="passwordAccessKey" />        
			                  <input type="password"  cssClass="required" cssErrorClass="error" class="form-password form-control" id="password" name="password" placeholder="密码..."  tabindex="2" path="password"  accesskey="${passwordAccessKey}" htmlEscape="true" autocomplete="off"/>
			          </div>
			          <div class="form-group">
			                <label class="sr-only" for="company">Company</label>
                               <%-- <spring:message code="screen.welcome.label.netid.accesskey" var="companyAccessKey" /> --%>        			               
							<select id="company" name="company" class="form-control selectpicker" data-mobile="true" style="height:44px;" onclick="queryCompany()">
							  <!--<option value="廊坊师范学院">廊坊师范学院</option>
							  <option value="石家庄学院">石家庄学院</option>
							  <option value="保定学院">保定学院</option>-->
							  <c:forEach var="value" items="${companylist}">  
                                <option value="${value}">  
                                ${value}  
                                </option>  
                              </c:forEach>  
							</select>
					   </div>
								<input type="hidden" name="lt" value="${loginTicket}" />
								<input type="hidden" name="execution" value="${flowExecutionKey}" />
								<input type="hidden" name="_eventId" value="submit" />
								<button type="submit" class="btn" accesskey="l" tabindex="3" name="submit">登 录</button>

            </form:form>
          </div>
            <div id="sidebar">
				<%final String queryString = request.getQueryString() == null ? "" : request.getQueryString().replaceAll("&locale=([A-Za-z][A-Za-z]_)?[A-Za-z][A-Za-z]|^locale=([A-Za-z][A-Za-z]_)?[A-Za-z][A-Za-z]", "");%>
            </div>
        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->
		<script type="text/javascript" src="<c:url value="/js/cas.js" />"></script>
    </div>
    </div>
    </div>
    </div>
    </div>
    </body>

</html>