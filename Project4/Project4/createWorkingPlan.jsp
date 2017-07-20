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
			<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" /> 
			<link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />
			<style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso form button:hover{color: white !important;} .asteriskField{color: red;}</style>
			<link rel="stylesheet" href="https://cdnjs.Cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
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
							<li class="active"><a href="Controller?command=requestManager&scope=all">Request
									Manager</a></li>
							<li><a href="Controller?command=workplanManager&scope=all">Workplans
									Manager</a></li>
							<li><a href="Controller?command=tenantManager">Tenant
									Manager</a></li>
							<li><a href="Controller?command=employees">Employees</a></li>
							<li><a
								href="Controller?command=dispatcherAccount">My Account</a></li>
							<li><a href="Controller?command=logout">Sign out</a></li>
						</ul>
					</div>
				</div>
			</div>
			<br/>
			<div class="container" style="width: 70%;">
				<div class="row centered">
					<div class="col-lg-8 col-lg-offset-2">
							<h4>Create a working plan</h4>
					</div>
				</div>
				<br/>
				<form class="form-horizontal" method="POST" action="Controller">
					<div class="form-group">
						<label class="col-sm-3 control-label">Name of Team:</label>
						<div class="col-sm-9">
								<input type="text" name="workteamName" class="form-control"
									placeholder="Team name" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Team lead:</label>
						<div class="col-sm-9">
							<select class="form-control" name="leadForPlan">
								<option disabled="disabled" selected="selected" value="">Choose team lead</option>
								<c:forEach items="${leadsForPlan}" var="lead">
									<option value="${lead.id}">${lead.fullName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Team member №1:</label>
						<div class="col-sm-9">
							<select class="form-control" name="member1">
								<option disabled="disabled" selected="selected" value="">Choose team member</option>
								<c:forEach items="${employeeForPlan}" var="employee">
									<option value="${employee.id}">${employee.fullName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Team member №2:</label>
						<div class="col-sm-9">
							<select class="form-control" name="member2">
								<option disabled="disabled" selected="selected" value="">Choose team member</option>
								<c:forEach items="${employeeForPlan}" var="employee">
									<option value="${employee.id}">${employee.fullName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Team member №3:</label>
						<div class="col-sm-9">
							<select class="form-control" name="member3">
								<option disabled="disabled" selected="selected" value="">Choose team member</option>
								<c:forEach items="${employeeForPlan}" var="employee">
									<option value="${employee.id}">${employee.fullName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Team member №4:</label>
						<div class="col-sm-9">
							<select class="form-control" name="member4">
								<option disabled="disabled" selected="selected" value="">Choose team member</option>
								<c:forEach items="${employeeForPlan}" var="employee">
									<option value="${employee.id}">${employee.fullName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Team member №5:</label>
						<div class="col-sm-9">
							<select class="form-control" name="member5">
								<option disabled="disabled" selected="selected" value="">Choose team member</option>
								<c:forEach items="${employeeForPlan}" var="employee">
									<option value="${employee.id}">${employee.fullName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Estimated execution
							date:</label>
						<div class="col-sm-9">
							<div class="input-group">
								<input class="form-control" id="estimatedExecutionDate" name="estimatedExecutionDate"
									placeholder="Choose the date" type="text" value="" />
								<div class="input-group-addon">
									<i class="fa fa-calendar-o"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Estimated start
							date:</label>
						<div class="col-sm-9">
							<div class="input-group">
								<input class="form-control" id="estimatedStartDate" name="estimatedStartDate"
									placeholder="Choose the date" type="text" value="" />
								<div class="input-group-addon">
									<i class="fa fa-calendar-o"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Comment:</label>
						<div class="col-sm-9">
								<input type="text" name="comment" class="form-control"
									placeholder="Your comment" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<input type="hidden" name="command" value="createPlan" />
							<input type="hidden" name="scope" value="${scope}" />
							<input type="hidden" name="requestIdForProcess" value="${param.requestIdForProcess}" />
						</div>
					</div>
					<c:if test="${incorrectPlan eq true}">
						<div class="alert alert-danger"><p class="text-center">Incorrect input</p></div>
					</c:if>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<input type="submit" value="Create workplan" class="btn btn-default" />
						</div>
					</div>
				</form>
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
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>			
		<script type="text/javascript" src="https://cdnjs.Cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>			
		<script>
			  $(document).ready(function(){
			    var date_input_1=$('input[name="estimatedExecutionDate"]');
			    var date_input_2=$('input[name="estimatedStartDate"]');
			    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
			    date_input_1.datepicker({
			      format: 'mm/dd/yyyy',
			      container: container,
			      startDate: '+0d',
			      todayHighlight: true,
			      autoclose: true,
			    })
			    date_input_2.datepicker({
			      format: 'mm/dd/yyyy',
			      container: container,
			      startDate: '+0d',
			      todayHighlight: true,
			      autoclose: true,
			    })
			  })
		</script>
	</body>
</html>