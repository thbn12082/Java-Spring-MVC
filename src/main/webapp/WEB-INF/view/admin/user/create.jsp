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

            <script 
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>


            <script>
              $(document).ready(() => {
                // khi mà đoạn code chạy rồi mới chạy xuống 
              const avatarFile = $("#avatarFile");
              // avatar file chính là id mà ta đã tạo hahahah
              avatarFile.change(function (e) {
              const imgURL = URL.createObjectURL(e.target.files[0]);
              $("#avatarPreview").attr("src", imgURL);
              $("#avatarPreview").css({ "display": "block" });
              });
              });
              </script>
        </head>

        <body>

     <div class="container mt-5"> <!--cách phía trên 5 -->
        <div class="row"> <!-- luôn luôn đi kèm mt-5 -->
             <div class="col-md-6 col-12 mx-auto"> <!-- sẽ chiếm 6 cảu màn hình to, 12 của màn hình bé -->
                
                <!-- mx-auto có nghĩa là tự động căn trái phải cho vào giữa màn hình(trục 0x ý) -->
                
                <h3>Create a user</h3>
                <hr />

    <form:form method="post" action="/admin/user/create" modelAttribute = "newUser" class="row">
      <!-- khi class = row thì mới chia làm 2 cột đc -->
        <!-- form của html có 2 method chính là get và post, get nó đẩy dữ liệu lên url khi load lại không mất dữ liệu, còn post không đẩy lên url nhưng khi load lại thì mất -->
        <div class="mb-3 col-12 col-md-6">
          <label for="exampleInputEmail1" class="form-label">Email:</label>
          <form:input type="email" class="form-control" path = "email"/>
          
        </div>
        <div class="mb-3 col-12 col-md-6">
          <label for="exampleInputPassword1" class="form-label">Password</label>
          <form:input type="password" class="form-control" path = "password"/>
        </div>
        
        <div class="mb-3 col-12 col-md-6">
            <label for="exampleInputPassword1" class="form-label">Phone number:</label>
            <form:input type="number" class="form-control" path = "phone"/>
        </div>

        <div class="mb-3 col-12 col-md-6">
            <label for="exampleInputPassword1" class="form-label">FullName</label>
            <form:input type="text" class="form-control" path = "fullname"/>
        </div>


        <div class="mb-3 col-12 col-md-6">
            <label for="exampleInputPassword1" class="form-label">Address</label>
            <form:input type="text" class="form-control" path = "address"/>
        </div>
        <div class="mb-3 col-12 col-md-6">
          
          <label for="exampleInputPassword1" class="form-label">Role:</label>
          <select class="form-select" aria-label="Default select example">
          <option value="1">ADMIN</option>
          <option value="2">USER</option>
        </select>
        </div>

        




        <div class = "mb-3 col-12 col-md-6">
              <label for="avatarFile" class="form-label">Avatar:</label>
              <input class="form-control" type="file" id="avatarFile" accept=".png, .jpg, .jpeg">
        </div>
        <div class="col-12 mb-3">
          <img style="max-height: 250px; display: none;" alt="avatar preview" id="avatarPreview" />
        </div>
        
        <div class = "col-12 mb-5">
          <button type="submit" class="btn btn-primary">Create</button>
        </div>
        
      </form:form>

        </div>
    </div>
</div>



</body>
</html>