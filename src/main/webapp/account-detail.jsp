<!DOCTYPE html>
<%@page import="model.customer"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Account Settings UI Design</title>
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="style-account-detail.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<section class="py-5 my-5">
		<div class="container">
		<%
		String error = request.getAttribute("error")+"";
		 error=(error.equals("null"))?"":error;
		%>
	<%
        	Object obj = session.getAttribute("Customer");
        	customer c2 = null;
        	if(obj!=null)
        	{
        		c2=(customer)obj;
        	}
    %>
			<h1 class="mb-5">Update gi ha <%=c2.getAccountName() %></h1>
			<%=error %>
			<div class="bg-white shadow rounded-lg d-block d-sm-flex">
				<div class="profile-tab-nav border-right">
					<div class="p-4">
						<div class="img-circle text-center mb-3">
							<img src="images/pic-user.png" alt="images/pic-user.png" class="shadow">
						</div>
						<h4 class="text-center"></h4>
					</div>
					<div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
						<a class="nav-link active" id="account-tab" data-toggle="pill" href="#account" role="tab" aria-controls="account" aria-selected="true">
							<i class="fa fa-home text-center mr-1"></i> 
							Account
						</a>
						<a class="nav-link" id="password-tab" data-toggle="pill" href="#password" role="tab" aria-controls="password" aria-selected="false">
							<i class="fa fa-key text-center mr-1"></i> 
							Password
						</a>
						<a class="nav-link" id="order-tab" data-toggle="pill" href="#order" role="tab" aria-controls="order" aria-selected="false">
							<i class="fa-solid fa-cart-shopping"></i>
							Current Order
						</a>
						<a class="nav-link" id="History-tab" data-toggle="pill" href="#history" role="tab" aria-controls="history" aria-selected="false">
							<i class="fa-solid fa-cart-shopping"></i>
							History Order
						</a>
						<a href="logout" class="nav-link">
						<i class="fa-solid fa-right-from-bracket"></i>
							Logout
						</a>
					</div>
				</div>
				<div class="tab-content p-4 p-md-5" id="v-pills-tabContent">
					<div class="tab-pane fade show active" id="account" role="tabpanel" aria-labelledby="account-tab">
					<div>
					</div>
					<form action="update" method="get">
						<h3 class="mb-4">Account Settings</h3>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Name</label>
								  	<input type="text" class="form-control" name="name" value="<%=c2.getName()%>">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Email</label>
								  	<input type="text" class="form-control" value="<%=c2.getEmail()%>" name="email">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Phone number</label>
								  	<input type="text" class="form-control" value="<%=c2.getPhone() %>" name="phone">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Address</label>
								  	<input type="text" class="form-control" value="<%=c2.getAddress() %>" name="address">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Gender</label>
								  	<select class="form-select" aria-label="Default select example" name="gender" >
								  		<option selected><%=c2.getGender() %></option>
										<option value="Male">Male</option>
										<option value="Female">Female</option>
									</select>
								</div>
							</div>
						</div>
						<div>
							<button class="btn btn-primary" type="submit">Update</button>
							<button class="btn btn-light">Cancel</button>
						</div>
					</form>
					</div>
					
					<div class="tab-pane fade" id="password" role="tabpanel" aria-labelledby="password-tab">
						<form action="changepassword" method="get">
						<h3 class="mb-4">Password Settings</h3>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Old password</label>
								  	<input type="password" class="form-control" name="oldPassWord">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
								  	<label>New password</label>
								  	<input type="password" class="form-control" name="newPassWord">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
								  	<label>Confirm new password</label>
								  	<input type="password" class="form-control" name="confirmNewPassWord">
								</div>
							</div>
						</div>
						
						<div>
							<button class="btn btn-primary" type="submit">Update</button>
							<button class="btn btn-light">Cancel</button>
						</div>
					</form>
					
					</div>
					<div class="tab-pane fade" id="order" role="tabpanel" aria-labelledby="order-tab">
						<div class="container">
							<header class="card-header"> My Orders / Tracking </header>
							<c:forEach items="${listod}" var = "o">
							<div class="card-body">
								<h6>Order ID: ${o.id_order}</h6>
								<article class="card">
									<div class="card-body row">
										<div class="col"> <strong>Order date time:</strong> <br>${o.order_date} </div>
										<div class="col"> <strong>Status:</strong> <br> ${o.status} </div>
										<div class="col"> <strong>Method Payment</strong> <br> ${o.method} </div>
										<div class="col"> <strong>Total</strong> <br> ${o.total_money} </div>
									</div>
								</article>
								</div>
								</c:forEach>
						</div>
					</div>
					<!-- History -->
					<div class="tab-pane fade" id="history" role="tabpanel" aria-labelledby="History-tab">
							<div class="container">
							<h3>History Orders</h3>
							<c:forEach items="${listod1}" var = "o1">
									<div class="bg-white shadow d-sm-flex justify-content-between my-4" style="border-radius: 10px;">
										<div class="media d-block d-sm-flex text-left text-sm-left">
						
											<div style=" margin-top: 10px; padding-left: 40px;">
												<h3 class="product-card-title font-weight-semibold border-0 pb-0"><a class="nav-link" id="Product-tab" data-toggle="pill" href="Order_Status.html" role="tab" aria-controls="Product" aria-selected="false">ID ORDER: ${o1.id_order}</a></h3>
												<div><span class="text-muted mr-2">Date Order:</span>${o1.order_date}</div>
												<div><span class="text-muted mr-2">Price</span>${o1.total_money} VND</div>
												<div><span class="text-muted mr-2">Date Delivery: </span>${o1.delivery_date}</div>
												<div><span class="text-muted mr-2">Status: </span>${o1.status}</div>
											</div>
										</div>
										<div class="pt-2 pt-sm-0 pl-sm-3 mx-auto mx-sm-0 text-center text-sm-left" style="max-width: 10rem; margin-top: 50px; padding-right: 10px; margin-bottom: 20px;">
											<a href="Status_History.html"><button class="btn btn-outline-secondary btn-sm btn-block mb-2" type="button"><polyline points="23 4 23 10 17 10"></polyline>
													<polyline points="1 20 1 14 7 14"></polyline>
													<i class="fa-solid fa-eye"></i>
													View Order</button></a>
											<button class="btn btn-outline-danger btn-sm btn-block mb-2" type="button">
													<polyline points="3 6 5 6 21 6"></polyline>
													<i class="fa-solid fa-trash-can"></i>
													<line x1="10" y1="11" x2="10" y2="17"></line>
													<line x1="14" y1="11" x2="14" y2="17"></line>
													Remove Order</button>
										</div>
									</div>
									</c:forEach>
							</div>
			</div>
		</div>
	</section>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>