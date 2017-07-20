<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="custom" uri="customTagLib" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Housing and communal services</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="Controller?command=tenantHome">Housing
					and communal services</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="Controller?command=dispatcherMain">Home</a></li>
					<li class="active"><a href="Controller?command=requestManager&scope=all">Request Manager</a></li>
					<li><a href="Controller?command=workplanManager&scope=all">Workplans Manager</a></li>
					<li><a href="Controller?command=dispatcherAccount">My Account</a></li>
					<li><a href="Controller?command=logout">Sign out</a></li>
				</ul>
			</div>
		</div>
	</div>
	<br/>
	<div class="container" style="width: 70%;">
		<c:choose>
			<c:when test="${param.scope eq 'all'}">
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="Controller?command=requestManager&scope=all" style="color: #333333">All (${allReqCount})</a></li>
					<li role="presentation"><a href="Controller?command=requestManager&scope=done" style="color: #333333">Done (${doneReqCount})</a></li>
					<li role="presentation"><a href="Controller?command=requestManager&scope=inProgress" style="color: #333333">In progress (${inProgReqCount})</a></li>
					<li role="presentation"><a href="Controller?command=requestManager&scope=unconsidered" style="color: #333333">Unconsidered (${unconsReqCount})</a></li>
				</ul>
				<c:if test="${not empty deletedRequestId}">
					<div class="alert alert-warning"><p class="text-center">Request №<c:out value="${deletedRequestId}"></c:out> was successfully deleted</p></div>
				</c:if>
			</c:when>
			<c:when test="${param.scope eq 'done'}">
				<ul class="nav nav-tabs">
					<li role="presentation"><a href="Controller?command=requestManager&scope=all" style="color: #333333">All (${allReqCount})</a></li>
					<li role="presentation" class="active"><a href="Controller?command=requestManager&scope=done" style="color: #333333">Done (${doneReqCount})</a></li>
					<li role="presentation"><a href="Controller?command=requestManager&scope=inProgress" style="color: #333333">In progress (${inProgReqCount})</a></li>
					<li role="presentation"><a href="Controller?command=requestManager&scope=unconsidered" style="color: #333333">Unconsidered (${unconsReqCount})</a></li>
				</ul>
				<c:if test="${not empty deletedRequestId}">
					<div class="alert alert-warning"><p class="text-center">Request №<c:out value="${deletedRequestId}"></c:out> was successfully deleted</p></div>
				</c:if>
			</c:when>
			<c:when test="${param.scope eq 'inProgress'}">
				<ul class="nav nav-tabs">
					<li role="presentation"><a href="Controller?command=requestManager&scope=all" style="color: #333333">All (${allReqCount})</a></li>
					<li role="presentation"><a href="Controller?command=requestManager&scope=done" style="color: #333333">Done (${doneReqCount})</a></li>
					<li role="presentation" class="active"><a href="Controller?command=requestManager&scope=inProgress" style="color: #333333">In progress (${inProgReqCount})</a></li>
					<li role="presentation"><a href="Controller?command=requestManager&scope=unconsidered" style="color: #333333">Unconsidered (${unconsReqCount})</a></li>
				</ul>
				<c:if test="${not empty deletedRequestId}">
					<div class="alert alert-warning"><p class="text-center">Request №<c:out value="${deletedRequestId}"></c:out> was successfully deleted</p></div>
				</c:if>
			</c:when>
			<c:when test="${param.scope eq 'unconsidered'}">
				<ul class="nav nav-tabs">
					<li role="presentation"><a href="Controller?command=requestManager&scope=all" style="color: #333333">All (${allReqCount})</a></li>
					<li role="presentation"><a href="Controller?command=requestManager&scope=done" style="color: #333333">Done (${doneReqCount})</a></li>
					<li role="presentation"><a href="Controller?command=requestManager&scope=inProgress" style="color: #333333">In progress (${inProgReqCount})</a></li>
					<li role="presentation" class="active"><a href="Controller?command=requestManager&scope=unconsidered" style="color: #333333">Unconsidered (${unconsReqCount})</a></li>
				</ul>
				<c:if test="${not empty deletedRequestId}">
					<div class="alert alert-warning"><p class="text-center">Request №<c:out value="${deletedRequestId}"></c:out> was successfully deleted</p></div>
				</c:if>
			</c:when>
		</c:choose>
		<table class="table table-striped">
			<tr>
				<th>Status</th>
				<th>Kind of work</th>
				<th>Scope of work</th>
				<th>Desired execute date</th>
				<th></th>
			</tr>
			<c:forEach items="${requestsForManager}" var="request">
				<tr>
					<td onclick="window.location.href='Controller?command=requestForDispatcher&requestForDisp=${request.id}&scope=${param.scope}&requestStatusName=${requestStatusName}'; return false" style="cursor: pointer"><custom:statusRequest request="${request}" /></td>
					<td onclick="window.location.href='Controller?command=requestForDispatcher&requestForDisp=${request.id}&scope=${param.scope}&requestStatusName=${requestStatusName}'; return false" style="cursor: pointer"><c:out value="${kinds[request.kindOfWorkId]}"></c:out></td>
					<td onclick="window.location.href='Controller?command=requestForDispatcher&requestForDisp=${request.id}&scope=${param.scope}&requestStatusName=${requestStatusName}'; return false" style="cursor: pointer"><c:out value="${request.scopeOfWork}"></c:out></td>
					<td onclick="window.location.href='Controller?command=requestForDispatcher&requestForDisp=${request.id}&scope=${param.scope}&requestStatusName=${requestStatusName}'; return false" style="cursor: pointer"><fmt:formatDate value="${request.desiredExecutionDate}"
							pattern="dd-MM-yyyy" /></td>
					<td>
						<c:if test="${requestStatusName eq 'Unconsidered'}">
							<button type="button" class="btn btn-primary"><a href="Controller?command=goToCreatePlan&requestIdForProcess=${request.id}&scope=${param.scope}" style="color: #ffffff">Process</a></button>
							<button type="button" class="btn btn-danger"><a href="Controller?command=deleteRequest&requestIdForRemoving=${request.id}&scope=${param.scope}" style="color: #ffffff">Delete</a></button>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br/>
	<div class="footer-bottom">
		<div class="navbar-fixed-bottom row-fluid"
			style="font-size: 14px; background-color: #c0c0c0;">
			<div class="navbar-inner">
				<div class="container">
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
							<div class="copyright text-muted">© 2017, WebHCS, All
								rights reserved</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-muted">
							<a href="https://www.facebook.com/White-INC-153833988475947">Franchisee
							</a> | <a href="https://www.facebook.com/White-INC-153833988475947">Web
								housing &amp; communal services by White Inc.</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>