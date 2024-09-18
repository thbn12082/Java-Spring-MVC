<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Create Users</title>
            <!-- Latest compiled and minified CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

            <!-- Latest compiled JavaScript -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
            <!-- <link href="/css/demo.css" rel="stylesheet"> -->
        </head>

        <body>

     <div class="container mt-5"> <!--cách phía trên 5 -->
        <div class="row"> <!-- luôn luôn đi kèm mt-5 -->
             <div class="col-md-6 col-12 mx-auto"> <!--sẽ chiếm 6 cảu màn hình to, 12 của màn hình bé -->
                
                <!-- mx-auto có nghĩa là tự động căn trái phải cho vào giữa màn hình(trục 0x ý) -->
                
                <h3>Create a user</h3>
                <hr />

    <form:form method="post" action="/admin/user/create1" modelAttribute = "newUser">
        <!-- form của html có 2 method chính là get và post, get nó đẩy dữ liệu lên url khi load lại không mất dữ liệu, còn post không đẩy lên url nhưng khi load lại thì mất -->
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Email:</label>
          <form:input type="email" class="form-control" path = "email"/>
        </div>
        <div class="mb-3">
          <label for="exampleInputPassword1" class="form-label">Password</label>
          <form:input type="password" class="form-control" path = "password"/>
        </div>
        
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Phone number:</label>
            <form:input type="number" class="form-control" path = "phone"/>
        </div>

        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">FullName</label>
            <form:input type="text" class="form-control" path = "fullname"/>
        </div>


        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Address</label>
            <form:input type="text" class="form-control" path = "address"/>
        </div>


        <button type="submit" class="btn btn-primary">Submit</button>
      </form:form>

        </div>
    </div>
</div>



</body>
</html>