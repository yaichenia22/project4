<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
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
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				<a class="navbar-brand" href="Controller?command=dispatcherMain">Housing and communal services</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="Controller?command=dispatcherMain">Home</a></li>
					<li><a href="Controller?command=requestManager&scope=all">Request Manager</a></li>
					<li><a href="Controller?command=workplanManager&scope=all">Workplans Manager</a></li>
					<li class="active"><a href="Controller?command=dispatcherAccount">My Account</a></li>
					<li><a href="Controller?command=logout">Sign out</a></li>
					</ul>
				</div>
			</div>
		</div>
			<div class="panel panel-default">
				<div class="panel-heading"/>
				<div class="panel-body">
					<table class="table table-condensed">
						<caption>My account</caption>
						<tr>				
							<td>Username:</td>
							<td>${user.login}</td>
						</tr>
						<tr>				
							<td>Full name:</td>
							<td>${user.fullName}</td>
						</tr>
						<tr>				
							<td>Phone number:</td>
							<td>${user.phoneNumber}</td>
						</tr>
					</table>
				</div>
			</div>
		<div class="footer-bottom">
			<div class="navbar-fixed-bottom row-fluid" style="font-size: 14px; background-color: #c0c0c0;">
				<div class="navbar-inner">
					<div class="container">
						<div class="row">
							<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
								<div class="copyright text-muted">© 2017, WebHCS, All rights reserved</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-muted">
								<a href="https://www.facebook.com/White-INC-153833988475947">Franchisee
								</a> | 
								<a href="https://www.facebook.com/White-INC-153833988475947">Web
									housing & communal services by White Inc.</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>