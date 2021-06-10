<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@include file="BootStrapeCDN.jsp"%>
<%@ page import=" config.DBconnect,java.sql.*,storage.DBData"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	String email = (String) session.getAttribute("email");
	String name = "";
	int b_id = 0;
	if (email == null) {
		response.sendRedirect("index.jsp");
	} else {
		b_id = DBData.getBidderId(email);
		name = DBData.getBidderName(email);
	}
	%>
	<div class="container">
		<div class="row">
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">Auction Buddy</a>
					</div>
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="product_form.jsp?id=<%=b_id%>"><button class="btn btn-primary navbar-btn">Create Auction</button></a></li>
						<!-- 						<li><a href="#">Link</a></li> -->
						<!-- 						<li><a href="#">Link</a></li> -->
					</ul>
							<ul class="nav navbar-nav navbar-right">
								<li><a href="LogoutHandler.jsp"><button class="btn btn-danger navbar-btn">Logout</button></a></li>
							</ul>
				</div>
			</nav>
		</div>
		<div class="row">
			<h3 class="col-md-6 ">
				Welcome!
				<%=name%>
		</div>
		<div class="row">
			<!-- Live Bidding -->
		</div>
		<div class="row">
			<div class="col-md-4">
				<fieldset>
					<legend>Bidder Information</legend>
					<table>
						<%
						try {
							Connection con = DBconnect.getConnection();
							String query = "select * from bidder where email=?";
							PreparedStatement ps = con.prepareStatement(query);
							ps.setString(1, email);
							ResultSet rs = ps.executeQuery();
							if (rs.next()) {
								out.println("<tr><th>Name</th><td>" + rs.getString("name") + "</td></tr>");
								out.println("<tr><th>Email</th><td>" + rs.getString("email") + "</td></tr>");
								out.println("<tr><th>Occupation</th><td>" + rs.getString("occupation") + "</td></tr>");
								out.println("<tr><th>Networth</th><td>" + rs.getString("networth") + "</td></tr>");
								out.println("<tr><th>Location</th><td>" + rs.getString("location") + "</td></tr>");
								out.println("<tr><th>Mobile</th><td>" + rs.getString("mobile") + "</td></tr>");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						%>
						<!-- Bidder Info -->
						<tr>
							<th><button class="btn btn-sm btn-primary">Edit</button></th>
						</tr>
					</table>
				</fieldset>
			</div>
			<div class="col-md-6">
				<!-- Pass and upcoming auction -->
				<jsp:include page="BidderAuctionDetails.jsp">
					<jsp:param name="id" value="<%=b_id %>" />
				</jsp:include>
			</div>
		</div>
	</div>
</body>
</html>










