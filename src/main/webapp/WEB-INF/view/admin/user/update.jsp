<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Update User</title>
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
                
                <h3>Update user ${id}</h3>
                <hr />


                <form:form method = "post" action = "/admin/user/update" modelAttribute = "newUser">
                    <div class="form-group" style="display: none;">
                      <label for="formGroupExampleInput" >Id:</label>
                      <form:input type="text" class="form-control" path = "id"/>
                    </div>
                    <br>
                    <div class="form-group">
                      <label for="formGroupExampleInput2">Email:</label>
                      <form:input type="text" class="form-control" path = "email"  disabled="true" />
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="formGroupExampleInput3">Phone number:</label>
                        <form:input type="text" class="form-control" path = "phone"/>
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="formGroupExampleInput4">FullName</label>
                        <form:input type="text" class="form-control" path = "fullname"/>
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="formGroupExampleInput5">Address</label>
                        <form:input type="text" class="form-control" path = "address"/>
                    </div>
                    <br>
                    <a class="btn btn-success" type = "button">Update</a>
                    <hr>
                  </form:form>

        </div>
    </div>
</div>



</body>
</html>