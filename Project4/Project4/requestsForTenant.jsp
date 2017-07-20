<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="custom" uri="customTagLib" %>

<!DOCTYPE html >
<html>
	<head>
		<meta charset="utf-8" />
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
						<span class="icon-bar"></span> <span class="icon-bar"></span> 
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="Controller?command=tenantHome">Housing and communal services</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="Controller?command=tenantHome">Home</a></li>
						<li class="active"><a href="Controller?command=tenantRequest">My Requests</a></li>
						<li><a href="Controller?command=tenantAccount">My Account</a></li>
						<li><a href="Controller?command=logout">Sign out</a></li>
					</ul>
				</div>
			</div>
		</div>
		<br/><br/>
		<div class="container" style="width: 90%;">
			<c:if test="${createdNewRequest eq true}">
				<div class="alert alert-info"><p class="text-center">Request was successfully created</p></div>
			</c:if>
			<table class="table table-striped">
				<caption>My Requests</caption>
				<tr>
					<th>Status</th>
					<th>Kind of work</th>
					<th>Scope of work</th>
					<th>Desired execute date</th>
					<th>Application date</th>
					<th>Comment</th>
				</tr>
				<c:forEach items="${requests}" var="request">
					<tr>				
						<td><custom:statusRequest request="${request}"/></td>
						<td><c:out value="${kinds[request.kindOfWorkId]}"></c:out></td>
						<td><c:out value="${request.scopeOfWork}"></c:out></td>
						<td><fmt:formatDate value="${request.desiredExecutionDate}" pattern="dd-MM-yyyy" /></td>
						<td><fmt:formatDate value="${request.applicationDate}" pattern="dd-MM-yyyy" /></td>
						<td>${request.comment}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<br/>
		<div class="navbar-fixed-bottom row-fluid"
			style="font-size: 14px; background-color: #c0c0c0;">
			<div class="navbar-inner">
				<div class="container">
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
							<div class="copyright text-muted">© 2017, WebHCS, All rights
								reserved</div>
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
	</body>
</html>