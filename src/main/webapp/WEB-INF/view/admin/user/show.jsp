<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
    <meta name="author" content="Hỏi Dân IT" />
    <title>Dashboard - Hỏi Dân IT</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <link href="/css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
    <jsp:include page = "../layout/header.jsp"/>
    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <jsp:include page = "../layout/sidebar.jsp" />
            </nav>
        </div>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Manage Users</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active"><a href="/admin">Dashboard</a> /Users</li>
                    </ol>
                    <div class = "container mt-5">
      
                      <div class = "row">
                  
                      <div class="col-md-6 col-12 mx-auto">
                        
                  <!-- đây là để 2 thuộc tính của thẻ div này sẽ đc căn sang 2 bên, ở giữa sẽ trắng trơn -->
                          <div class = "d-flex justify-content-between"> 
                             
                          <h3>Table users</h3>
                          <a href = "/admin/user/create" class="btn btn-primary">Create a user</a>
                          </div>
                          <hr>
                  
                  
                      <table class="table table-hover">
                          <thead>
                            <tr>
                              <th scope="col">ID</th>
                              <th scope="col">Email</th>
                              <th scope="col">Full Name</th>
                              <th scope="col">Role</th>
                              <th scope="col">Action</th>
                            </tr>
                          </thead>
                          <tbody>
                        
                  
                            <c:forEach var="user" items="${users1}">
                              <!-- user là biến và user1 là giá trị cta lấy từ bên UserController -->
                  
                              <tr>
                              <th>${user.id}</th>
                              <td>${user.email}</td>
                              <td>${user.fullname}</td>
                              <td>${user.role.name}</td>
                              <td>
                                  <a class="btn btn-success" href="/admin/user/${user.id}">View</a>
                                  <a class="btn btn-warning" href="/admin/user/update/${user.id}">Update</a>
                                  <a type="button" class="btn btn-danger" href = "/admin/user/delete/${user.id}">Delete</a>
                              </td>
                            </tr>
                  
                            </c:forEach>
                          </tbody>
                        </table>
                  
                  
                      </div>
                  
                      </div>
                      
                      </div>
                </div>
            </main>
           <jsp:include page = "../layout/footer.jsp"/>
        </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="js/chart-area-demo.js"></script>
    <script src="js/chart-bar-demo.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
        crossorigin="anonymous"></script>
    <script src="js/datatables-simple-demo.js"></script>
</body>

</html>