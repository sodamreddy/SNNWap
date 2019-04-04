<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Account Registration</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
	$(function() {
		$('form[id="appRegForm"]').validate({
			rules : {
				firstName : 'required',
				lastName : 'required',
				gender : 'required',
				phoneNo : 'required',
				emailId : 'required',
				dateOfBirth : 'required',
			},//rules
			messages : {
				firstName : 'Please enter first name',
				lastName : 'please enter last name',
				emailId : 'Please enter a valid email',
				password : {
					required : 'Please enter password',
					minlength : 'Password must be at least 5 characters long'
				},
				dateOfBirth : 'Please select date',
				gender : '     Please select Gender',
				phoneNo : 'Please enter Phone No',
			},//messages
			errorPlacement : function(error, element) {
				if (element.is(":radio")) {
					error.appendTo(element.parents('.gender'));
				} else { // This is the default behavior of the script for all fields
					error.insertAfter(element);
				}
			},
			submitHandler : function(form) {
				form.submit();
			}
		});

		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			maxDate : new Date(),
			dateFormat : 'dd/mm/yy'
		});

		$("#emailId").blur(function() {
			var givenEmail = $("#emailId").val();
			var uri=window.location.href.toString();
			console.log(uri);
			$.ajax({
				url : window.location + "/uniqueMail",
				data : "emailId=" + givenEmail,
				success : function(result) {
					if (result == "Duplicate") {
						$("#emailMsg").html("Email  Already Exists.!!");
						$("#emailId").focus();
					} else {
						$("#emailMsg").html("");
					}
				}
			});
			
		});
	});
</script>
</head>
<body>
	<h1>SSN Enrollment</h1>
	<font color="green">${success}</font>
	<font color="red">${failed}</font>

	<form:form action="appReg" method="POST" id="appRegForm"
		modelAttribute="appModel">
		<table>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><form:input path="dateOfBirth" id="datepicker" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td class="gender">Male<form:radiobutton path="gender"
						value="Male" />Female <form:radiobutton path="gender"
						value="Female" /></td>
			</tr>
			<tr>
				<td>Email Id</td>
				<td><form:input path="emailId" />
			</tr>
			<tr>
				<td>Phone No</td>
				<td><form:input path="phoneNo" /></td>
			</tr>
			
			<tr>
				<td>State</td>
				<td><form:select path="state" items="${statesList}"></form:select>
			</tr>
			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="Submit" value="Enroll" id="submit"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>