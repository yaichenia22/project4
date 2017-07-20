<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
							<span class="icon-bar"></span> <span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="Controller?command=tenantHome">Housing and communal services</a>
					</div>
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="Controller?command=tenantHome">Home</a></li>
							<li><a href="Controller?command=tenantRequest">My Requests</a></li>
							<li><a href="Controller?command=tenantAccount">My Account</a></li>
							<li><a href="Controller?command=logout">Sign out</a></li>
						</ul>
					</div>
				</div>
			</div>
			<br/>
			<div class="container" style="width: 70%;">
				<div class="row centered">
					<div class="col-lg-8 col-lg-offset-2">
							<h4>Create a request</h4>
					</div>
				</div>
				<br/>
				<form class="form-horizontal" method="POST" action="Controller">
					<div class="form-group">
						<label class="col-sm-3 control-label">Kind of work:</label>
						<div class="col-sm-9">
							<c:choose>
								<c:when test="${empty oldKindOfWork}">
									<c:if test="${incorrectRequest == true}">
										<select class="form-control" name="kindOfWork">
											<option disabled="disabled" selected="selected" value="">Choose a kind of work</option>
											<option value="Electric">Electric</option>
											<option value="Pump">Pump</option>
											<option value="Gas">Gas</option>
											<option value="Joinery">Joinery</option>
										</select>
									</c:if>
									<c:if test="${incorrectRequest != true}">
										<select class="form-control" name="kindOfWork">
											<option disabled="disabled" selected="selected" value="">Choose a kind of work</option>
											<option value="Electric">Electric</option>
											<option value="Pump">Pump</option>
											<option value="Gas">Gas</option>
											<option value="Joinery">Joinery</option>
										</select>
									</c:if>
								</c:when>
								<c:when test="${oldKindOfWork == 'Electric'}">
									<select class="form-control" name="kindOfWork">
										<option disabled="disabled" value="">Choose a kind of work</option>
										<option value="Electric" selected="selected">Electric</option>
										<option value="Pump">Pump</option>
										<option value="Gas">Gas</option>
										<option value="Joinery">Joinery</option>
									</select>
								</c:when>
								<c:when test="${oldKindOfWork == 'Pump'}">
									<select class="form-control" name="kindOfWork">
										<option disabled="disabled" value="">Choose a kind of work</option>
										<option value="Electric">Electric</option>
										<option value="Pump" selected="selected">Pump</option>
										<option value="Gas">Gas</option>
										<option value="Joinery">Joinery</option>
									</select>
								</c:when>
								<c:when test="${oldKindOfWork == 'Gas'}">
									<select class="form-control" name="kindOfWork">
										<option disabled="disabled" value="">Choose a kind of work</option>
										<option value="Electric">Electric</option>
										<option value="Pump">Pump</option>
										<option value="Gas" selected="selected">Gas</option>
										<option value="Joinery">Joinery</option>
									</select>
								</c:when>
								<c:when test="${oldKindOfWork == 'Joinery'}">
									<select class="form-control" name="kindOfWork">
										<option disabled="disabled" value="">Choose a kind of work</option>
										<option value="Electric">Electric</option>
										<option value="Pump">Pump</option>
										<option value="Gas">Gas</option>
										<option value="Joinery" selected="selected">Joinery</option>
									</select>
								</c:when>
							</c:choose>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Desired execution
							date:</label>
						<div class="col-sm-9">
							<c:choose>
								<c:when test="${not empty olddesiredExecutionDate}">
									<div class="input-group">
										<input class="form-control" id="desiredExecutionDate" name="desiredExecutionDate"
											placeholder="Choose the date" type="text" value="${olddesiredExecutionDate}" />
										<div class="input-group-addon">
											<i class="fa fa-calendar-o"></i>
										</div>
									</div>
								</c:when>
								<c:when test="${(empty olddesiredExecutionDate) and (incorrectRequest == true)}">
									<div class="input-group">
										<input class="form-control" id="desiredExecutionDate" name="desiredExecutionDate"
											placeholder="Choose the date" type="text" />
										<div class="input-group-addon">
											<i class="fa fa-calendar-o"></i>
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="input-group">
										<input class="form-control" id="desiredExecutionDate" name="desiredExecutionDate"
											placeholder="Choose the date" type="text" />
										<div class="input-group-addon">
											<i class="fa fa-calendar-o"></i>
										</div>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Scope of work:</label>
						<div class="col-sm-9">
							<c:choose>
								<c:when test="${not empty oldScopeOfWork}">
									<input type="text" name="scopeOfWork" class="form-control"
									maxlength="30" placeholder="Input scope of work" value="${oldScopeOfWork}" />
								</c:when>
								<c:when test="${(empty oldScopeOfWork) and (incorrectRequest == true)}">
									<input type="text" name="scopeOfWork" class="form-control"
									maxlength="30" placeholder="Input scope of work"/>
								</c:when>
								<c:otherwise>
									<input type="text" name="scopeOfWork" class="form-control"
									maxlength="30" placeholder="Input scope of work" />
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Comment:</label>
						<div class="col-sm-9">
							<c:if test="${not empty oldComment}">
								<input type="text" name="comment" class="form-control"
									placeholder="Your comment" value="${oldComment}"/>
							</c:if>
							<c:if test="${empty oldComment}">
								<input type="text" name="comment" class="form-control"
									placeholder="Your comment" />
							</c:if>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="hidden" name="command" value="createRequest" />
						</div>
					</div>
					<c:if test="${not empty incorrectRequest}">
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-9">
								<div class="alert alert-danger"><p class="text-center">Incorrect data</p></div>
							</div>
						</div>
					</c:if>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-10">
							<input type="submit" value="Send request" class="btn btn-default" />
						</div>
					</div>
				</form>
			</div>
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
			    var date_input=$('input[name="desiredExecutionDate"]');
			    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
			    date_input.datepicker({
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