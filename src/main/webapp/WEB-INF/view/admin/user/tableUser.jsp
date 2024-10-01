<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- <link href="/css/demo.css" rel="stylesheet"> -->
</head>
<body>




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
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          <!-- private Long id;

          private String email;
          private String password;
          private String fullname;
          private String address;
          private String phone; -->

          <c:forEach var="user" items="${users1}">
            <!-- user là biến và user1 là giá trị cta lấy từ bên UserController -->

            <tr>
            <th scope="row">${user.id}</th>
            <td>${user.email}</td>
            <td>${user.fullname}</td>
            <td>
                <a class="btn btn-success" href="/admin/user/${user.id}">View</a>
                <a class="btn btn-warning" href="/admin/user/update/${user.id}">Update</a>
                <button type="button" class="btn btn-danger">Delete</button>
            </td>
          </tr>

          </c:forEach>
        </tbody>
      </table>


    </div>
    </div>
    </div>
</body>
</html>