<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visitor Page</title>
</head>
<body>
	<jsp:include page="headerPage.jsp" />
	<h2>Visitor Page</h2>
	
	<nav>
		<a href="index.jsp">Home</a>
	</nav>
	
	<%-- 
	
	<% String msg=(String) request.getAttribute("msg"); %>
	<% String age=(String) request.getAttribute("age"); %>
	
	<%if(msg!=null && age!=null)  {%>
	<p><strong><%=msg %> <em><%=age %></em></strong>
	
	<%} %>
	
--%>

	
	<c:choose>
		<c:when test="${msg==null }">
			<p>Welcome All </p>
		</c:when>
		<c:otherwise>
			<p><strong>${msg }<em>${age}</em></strong></p>
		</c:otherwise>
	</c:choose>
		
	<form action="vs">
		<label >title:
		<select name="title" required="required">
			<option value="">---SELECT---</option>
			<option value="Mr.">Mr.</option>
			<option value="Miss.">Miss.</option>
			<option value="Mrs.">Mrs.</option>
			<option value="Dr.">Doctor</option>
	</select>
	</label><br/>
	<label>FullNAME: <input type="text" name="fullName" required/></label><br/>
	<label>Date of Birth: <input type="date" name="dateOfBirth" required/></label>
	
	<button>submit</button>
</form>

</body>
</html>