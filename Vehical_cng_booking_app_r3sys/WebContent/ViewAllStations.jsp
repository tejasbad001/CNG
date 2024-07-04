<%@page import="com.r3sys.connection.*" %>
<%@page import="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Cng Station</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet"> 
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-secondary navbar-dark">
                <a href="Index.html" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary"><i class="fa fa-user-edit me-2"></i>"CNG<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PLAZA"</h3>
                </a>
                <div class="d-flex align-items-center ms-4 mb-4">
                    <div class="position-relative">
                        <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                        <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                    </div>
                    <div class="ms-3">
                        <h6 class="mb-0">CngHub</h6>
                        <span>Admin</span>
                    </div>
                </div>
               <div class="navbar-nav w-100">
                    <a href="Index.html" class="nav-item nav-link active"><i class="fa fa-tachometer-alt me-2"></i>Home</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>Admin</a>
                        <div class="dropdown-menu bg-transparent border-0">
                        <a href="Login.html" class="nav-item nav-link active">Log Out</a>
                         <ul>
						        <li><a href="LoginAdmin?action=ViewAllStations">View All Cng Stations</a></li>
						        <li><a href="LoginAdmin?action=ApproveStation">Approve Cng Stations</a></li>
						        <li><a href="LoginAdmin?action=DeleteStation">Delete Cng Station</a></li>
						    </ul>
                        
                        </div>
                    </div>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>Cng Stations</a>
                        <div class="dropdown-menu bg-transparent border-0">
                        <a href="LoginStation.html" class="nav-item nav-link active">Login Existing CS</a>
                        </div>
                    </div>
                     <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>User</a>
                        <div class="dropdown-menu bg-transparent border-0">
                        <a href="UserLogin.html" class="nav-item nav-link active">Login Existing User</a>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 3px solid #f2f2f2;
  padding: 8px;
}


#customers tr:nth-child(even){background-color: #ddd;}
#customers tr:nth-child(odd){background-color: #ddd;}
#customers tr:hover {background-color: #ffffff;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>

        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
            <nav class="navbar navbar-expand bg-secondary navbar-dark sticky-top px-4 py-0">
                <a href="Index.html" class="navbar-brand d-flex d-lg-none me-4">
                    <h2 class="text-primary mb-0"><i class="fa fa-user-edit"></i></h2>
                </a>
                <a href="#" class="sidebar-toggler flex-shrink-0">
                    <i class="fa fa-bars"></i>
                </a>
                <form class="d-none d-md-flex ms-4">
                <script>
				    function searchWithinPage() {
				      var searchText = document.getElementById("searchText").value;
				      if (searchText) {
				        if (window.find && window.getSelection) {
				          document.designMode = "on";
				          var sel = window.getSelection();
				          sel.collapse(document.body, 0);
				          while (window.find(searchText)) {
				            document.execCommand("HiliteColor", false, "yellow");
				            sel.collapseToEnd();
				          }
				          document.designMode = "off";
				        } else if (document.body.createTextRange) {
				          var textRange = document.body.createTextRange();
				          while (textRange.findText(searchText)) {
				            textRange.execCommand("BackColor", false, "yellow");
				            textRange.collapse(false);
				          }
				        }
				      }
				    }
				  </script>
                    <input class="form-control bg-dark border-0" type="text" id="searchText" placeholder="Enter text to search">
  					<button onclick="searchWithinPage()">Search</button>
                </form>
                <div class="navbar-nav align-items-center ms-auto">
                     <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            <i class="fa fa-envelope me-lg-2"></i>
                            <span class="d-none d-lg-inline-flex">Revived</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
                            <a href="#" class="dropdown-item">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                    <div class="ms-2">
                                        <h6 class="fw-normal mb-0">"Stay Gassed, stay on the go!"</h6>
                                    </div>
                                </div>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                    <div class="ms-2">
                                        <h6 class="fw-normal mb-0">"Gassing up for your next adventure."</h6>
                                    </div>
                                </div>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                    <div class="ms-2">
                                        <h6 class="fw-normal mb-0">"Gassing your ride for a greener tomorrow."</h6>
                                    </div>
                                </div>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="https://www.acko.com/car-guide/cng-car-maintenance-and-safety-guide/" class="dropdown-item text-center">See all Revived Message</a>
                        </div>
                    </div>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            <i class="fa fa-bell me-lg-2"></i>
                            <span class="d-none d-lg-inline-flex">Precaution Notifications</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
                            <a href="#" class="dropdown-item">
                                <h6 class="fw-normal mb-0">Avoid Gassing in severe weather.</h6>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item">
                                <h6 class="fw-normal mb-0">Properly detached and stow the Cng cable.</h6>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item">
                                <h6 class="fw-normal mb-0">Keep your Cng port clean</h6>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="https://www.acko.com/car-guide/cng-car-maintenance-and-safety-guide/" class="dropdown-item text-center">See all Precaution notifications</a>
                        </div>
                    </div>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            <img class="rounded-circle me-lg-2" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                            <span class="d-none d-lg-inline-flex">CngHub Incharge</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
                            <a href="Profile.html" class="dropdown-item">My Profile</a>
                        </div>
                    </div>
                </div>
            </nav>
            <!-- Navbar End -->
			<!-- Sale & Revenue Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    <div class="col-sm-20 col-xl-15">
                        <div class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
                            <i class="fa fa-chart-line fa-3x text-primary"></i>
                            <div class="ms-3">
                                <h1 class="mb-2"><center>CNG VEHICLE STATION FINDER</center></h1>
                                <h6 class="mb-0">System</h6>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- Sliding Img Start-->
            
            <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h3 class="mb-0"><u><i>"Clean Gas, Endless Journeys."</i></u></h3>
						<hr>
                    </div>
                    <div class="container-fluid pt-4 px-4">
                        <h3>"Gassed with Confidence, Drive with Pride."</h3>
				<br>
				<div style="max-width:100%">
	  			<img class="mySlides"  src="CngCS.jpg" width=1000 height=500 border=20>
	  			
	   			<img class="mySlides"  src="Cng4.jpeg" width=1000 height=500 border=20>
	   			<img class="mySlides"  src="Cng6.png" width=1000 height=500 border=20>
	   			
	   			<img class="mySlides"  src="Cng5.png" width=1000 height=500 border=20>
	   			<img class="mySlides"  src="Cng2.jpeg" width=1000 height=500 border=20>
				</div>
				<script>
				var myIndex = 0;
				carousel();
				function carousel() {
	    		var i;
			    var x = document.getElementsByClassName("mySlides");
	    		for (i = 0; i < x.length; i++) {
	       		x[i].style.display = "none";  
	    		}
	    		myIndex++;
			    if (myIndex > x.length) {myIndex = 1}    
			    x[myIndex-1].style.display = "block";  
			    setTimeout(carousel, 1000); // Change image every 2 seconds
				}	
				</script>
           		 </div>
               </div>
            </div>
          <!-- Sliding Img End-->
            
            
            <!-- Sale & Revenue End -->
 <div class="container-fluid">
            <div class="row h-100 align-items-left justify-content-left" style="min-height: 100vh;">
                <div class="col-15 col-sm-8 col-md-6 col-lg-6 col-xl-6">
                    <div class="bg-secondary rounded p-4 p-sm-5 my-4 mx-3">
                        <div class="d-flex align-items-left justify-content-between mb-3">
                            <h3>View Charging Stations</h3>
                        </div>
					</div> 
						<div class="progressbar-heading grids-heading">
						</div>
						<div class="panel panel-widget forms-panel">
							
							<table id="customers">
							  <thead>
							    <tr>
							    <tr>
								<th>ID</th>
								<th>Station Name</th>
								<th>Address</th>
								<th>City</th>
								<th>Taluka</th>
								<th>District</th>
								<th>Opening Time</th>
								<th>Closing Time</th>
								<th>Mobile Number</th>
								<th>Latitude</th>
								<th>Longitude</th>
								<th>Password</th>
								<th>Power</th>
								<th>Status</th>
								<th>Action</th>
							    </tr>
							  </thead>
							  
							   <tbody>
							  <%
							  	try
							  	{
							  		Connection con = Db_connection.connect();
							  		PreparedStatement ps = con.prepareStatement("select * from register_cs");
							  		ResultSet rs = ps.executeQuery();
							  		while(rs.next())
							  		{
							  		%>
							  			<tr>
									      <td><%=rs.getInt(1)%></td>
									      <td><%=rs.getString(2)%></td>
									      <td><%=rs.getString(3)%></td>
									      <td><%=rs.getString(4)%></td>
									      <td><%=rs.getString(5)%></td>
									      <td><%=rs.getString(6)%></td>
									      <td><%=rs.getString(7)%></td>
									      <td><%=rs.getString(8)%></td>
									      <td><%=rs.getString(9)%></td>
									      <td><%=rs.getString(10)%></td>
									      <td><%=rs.getString(11)%></td>
									      <td><%=rs.getString(12)%></td>
									      <td><%=rs.getString(13)%></td>
									      <td><%=rs.getString(14)%></td>
									      <td><a href="Deletestation.jsp?id=<%=rs.getString(1)%>" style="color:red;">Delete</a></td>
									    </tr>
									<%
							  		}
							  	}
							  	catch(Exception e)
							  	{
							  		e.printStackTrace();
							  	}
							  %>
							 	    
							  </tbody>
							</table>
							
							
						</div>
						</div>
			</div>
									

    </div>
   		
           <!-- Footer Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary rounded-top p-4">
                    <div class="row">
                        <div class="col-12 col-sm-6 text-center text-sm-start">
                            &copy; <a href="http://localhost:3306/Vehical_cng_booking_app_r3sys/">Cng Station Finder</a>, All Right Reserved. 
                        </div>
                        <div class="col-12 col-sm-6 text-center text-sm-end">
                            <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                            Designed By: <a href="https://htmlcodex.com">G-10</a>
                            <br>Distributed By: <a href="https://themewagon.com" target="_blank">r3sys</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Footer End -->
        </div>
        <!-- Content End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/chart/chart.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/tempusdominus/js/moment.min.js"></script>
    <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>
