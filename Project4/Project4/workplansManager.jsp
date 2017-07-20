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
					<li><a href="Controller?command=requestManager&scope=all">Request Manager</a></li>
					<li class="active"><a href="Controller?command=workplanManager&scope=all">Workplans Manager</a></li>
					<li><a href="Controller?command=dispatcherAccount">My Account</a></li>
					<li><a href="Controller?command=logout">Sign out</a></li>
				</ul>
			</div>
		</div>
	</div>
	<br/>
	<div class="container" style="width: 90%;">
		<c:choose>
			<c:when test="${param.scope eq 'all'}">
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="Controller?command=workplanManager&scope=all" style="color: #333333">All</a></li>
					<li role="presentation" class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="color: #333333">
						Status <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="Controller?command=workplanManager&scope=done">Done</a></li>
							<li><a href="Controller?command=workplanManager&scope=inProcess">In process</a></li>
						</ul>
					</li>
					<li role="presentation" class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="color: #333333">
						Kind of work <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="Controller?command=workplanManager&scope=Electric">Electric</a></li>
							<li><a href="Controller?command=workplanManager&scope=Pump">Pump</a></li>
							<li><a href="Controller?command=workplanManager&scope=Gas">Gas</a></li>
							<li><a href="Controller?command=workplanManager&scope=Joinery">Joinery</a></li>
						</ul>
					</li>
				</ul>
				<c:if test="${deletingAccessDenied eq true}">
					<div class="alert alert-danger"><p class="text-center">Access to deleting denied</p></div>
				</c:if>
			</c:when>
			<c:when test="${(param.scope eq 'done') or (param.scope eq 'inProcess')}">
				<ul class="nav nav-tabs">
					<li role="presentation"><a href="Controller?command=workplanManager&scope=all" style="color: #333333">All</a></li>
					<li role="presentation" class="dropdown active">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="color: #333333">
						Status <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="Controller?command=workplanManager&scope=done">Done</a></li>
							<li><a href="Controller?command=workplanManager&scope=inProcess">In process</a></li>
						</ul>
					</li>
					<li role="presentation" class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="color: #333333">
						Kind of work <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="Controller?command=workplanManager&scope=Electric">Electric</a></li>
							<li><a href="Controller?command=workplanManager&scope=Pump">Pump</a></li>
							<li><a href="Controller?command=workplanManager&scope=Gas">Gas</a></li>
							<li><a href="Controller?command=workplanManager&scope=Joinery">Joinery</a></li>
						</ul>
					</li>
				</ul>
				<c:if test="${deletingAccessDenied eq true}">
					<div class="alert alert-danger"><p class="text-center">Access to deleting denied</p></div>
				</c:if>	
			</c:when>
			<c:when test="${(param.scope eq 'Electric') or (param.scope eq 'Pump') or (param.scope eq 'Gas') or (param.scope eq 'Joinery')}">
				<ul class="nav nav-tabs">
					<li role="presentation"><a href="Controller?command=workplanManager&scope=all" style="color: #333333">All</a></li>
					<li role="presentation" class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="color: #333333">
						Status <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="Controller?command=workplanManager&scope=done">Done</a></li>
							<li><a href="Controller?command=workplanManager&scope=inProcess">In process</a></li>
						</ul>
					</li>
					<li role="presentation" class="dropdown active">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="color: #333333">
						Kind of work <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="Controller?command=workplanManager&scope=Electric">Electric</a></li>
							<li><a href="Controller?command=workplanManager&scope=Pump">Pump</a></li>
							<li><a href="Controller?command=workplanManager&scope=Gas">Gas</a></li>
							<li><a href="Controller?command=workplanManager&scope=Joinery">Joinery</a></li>
						</ul>
					</li>
				</ul>
				<c:if test="${deletingAccessDenied eq true}">
					<div class="alert alert-danger"><p class="text-center">Access to deleting denied</p></div>
				</c:if>
			</c:when>
		</c:choose>
		<table class="table table-striped">
			<tr>
				<th>Status</th>
				<th>Plan №</th>
				<th>Work team №</th>
				<th>Request №</th>
				<th>Kind of work</th>
				<th>Estimated start date</th>
				<th>Estimated execute date</th>
				<th></th>
			</tr>
			<c:forEach items="${workingPlans}" var="workplan">
				<tr>
					<td><custom:TagStatusRequestById requestId="${workplan.requestId}" /></td>
					<td><c:out value="${workplan.id}"></c:out></td>
					<td><c:out value="${workplan.workTeamId}"></c:out></td>
					<td><c:out value="${workplan.requestId}"></c:out></td>
					<td><c:out value="${planKindOfWork}"></c:out></td>
					<td><fmt:formatDate value="${workplan.estimatedExecutionDate}" pattern="dd-MM-yyyy" /></td>
					<td><fmt:formatDate value="${workplan.estimatedStartDate}" pattern="dd-MM-yyyy" /></td>
					<td>
						<c:if test="${workplanStatus eq 'Done'}">
							<button type="button" class="btn btn-warning"><a href="Controller?command=deleteWorkplan&workplanIdForRemoving=${workplan.id}&scope=${param.scope}" style="color: #ffffff">Close</a></button>
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
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>	
</body>
</html>