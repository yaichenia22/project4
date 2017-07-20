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
				<a class="navbar-brand" href="Controller?command=dispatcherMain">Housing
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
	<div class="panel panel-default">
		<div class="panel-heading" />
		<div class="panel-body">
			<table class="table table-condensed">
				<caption>Request №${requestId}</caption>
				<tr>
					<td>Tenant:</td>
					<td>${tenantName}</td>
				</tr>
				<tr>
					<td>Address:</td>
					<td>${fullAddress}</td>
				</tr>
				<tr>
					<td>Kind of work:</td>
					<td>${kinds[requestForDispatcher.kindOfWorkId]}</td>
				</tr>
				<tr>
					<td>Scope of work:</td>
					<td>${requestForDispatcher.scopeOfWork}</td>
				</tr>
				<tr>
					<td>Desired execution date:</td>
					<td><fmt:formatDate value="${requestForDispatcher.desiredExecutionDate}" pattern="dd-MM-yyyy" /></td>
				</tr>
				<tr>
					<td>Application date:</td>
					<td><fmt:formatDate value="${requestForDispatcher.applicationDate}" pattern="dd-MM-yyyy" /></td>
				</tr>
				<tr>
					<td>Comment:</td>
					<td>${requestForDispatcher.comment}</td>
				</tr>
				<tr>
					<td><p></p></td>
					<td><p></p></td>
				</tr>
				<tr>
					<td><a href="Controller?command=requestManager&scope=all">&lt;&lt; back to all requests</a></td>
					<td>
						<c:if test="${param.requestStatusName eq 'Unconsidered'}">
							<button type="button" class="btn btn-primary"><a href="Controller?command=goToCreatePlan&requestIdForProcess=${param.requestForDisp}&scope=${param.scope}" style="color: #ffffff">Process</a></button>
							<button type="button" class="btn btn-danger"><a href="Controller?command=deleteRequest&requestIdForRemoving=${param.requestForDisp}&scope=${param.scope}" style="color: #ffffff">Delete</a></button>
						</c:if>
					</td>
				</tr>
			</table>
		</div>
	</div>
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