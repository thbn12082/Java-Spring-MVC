<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Create Product</title>
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
                
                <h3>Create a product</h3>
                <hr />

    <form:form method="post" action="/admin/product/create" modelAttribute = "newProduct" class="row" enctype = "multipart/form-data">
      <!-- khi class = row thì mới chia làm 2 cột đc -->
        <!-- form của html có 2 method chính là get và post, get nó đẩy dữ liệu lên url khi load lại không mất dữ liệu, còn post không đẩy lên url nhưng khi load lại thì mất -->
        <div class="mb-3 col-12 col-md-6">
          <label for="exampleInputEmail1" class="form-label">Name:</label>
          <form:input type="text" class="form-control" path = "name"/>
          
        </div>
        <div class="mb-3 col-12 col-md-6">
          <label for="exampleInputPassword1" class="form-label">Price:</label>
          <form:input type="number" class="form-control" path = "price"/>
        </div>
        

        <!-- <div class="mb-6 col-12 col-md-6">
            <label for="exampleInputPassword1" class="form-label">Detail Description:</label>
            <form:input type="text" class="form-control" path = "detaiDesc"/>
        </div> -->
        <div class="form-group">
          <label for="exampleFormControlTextarea1">Detail Description:</label>
          <form:textarea class="form-control" id="exampleFormControlTextarea1" rows="3" path = "detaiDesc"/>
        </div>







        <div class="mb-3 col-12 col-md-6">
            <label for="exampleInputPassword1" class="form-label">Short description:</label>
            <form:input type="text" class="form-control" path = "shortDesc"/>
        </div>

        <div class="mb-3 col-12 col-md-6">
            <label for="exampleInputPassword1" class="form-label">Quantity:</label>
            <form:input type="number" class="form-control" path = "quantity"/>
        </div>
       




        <div class="mb-3 col-12 col-md-6">
          
          <label for="exampleInputPassword1" class="form-label">Factory:</label>
          <form:select class="form-select" aria-label="Default select example" path = "factory">
          <!-- tại sao role.name mà vẫn bắt được? vì ta chỉ lấy thuộc tính của biến Object role là name mà thôi-->
          <form:option value="ADMIN">Mac</form:option>
          <form:option value="USER">Windows</form:option>
          <form:option value="USER">Linux</form:option>
        </form:select>
        </div>

        <div class="mb-3 col-12 col-md-6">
          
          <label for="exampleInputPassword1" class="form-label">Target:</label>
          <form:select class="form-select" aria-label="Default select example" path = "target">
          <!-- tại sao role.name mà vẫn bắt được? vì ta chỉ lấy thuộc tính của biến Object role là name mà thôi-->
          <form:option value="ADMIN">Gaming</form:option>
          <form:option value="USER">Phụ kiện</form:option>
          <form:option value="USER">Mỏng nhẹ</form:option>
          <form:option value="USER">Văn phòng</form:option>
        </form:select>
        </div>

        
        <div class = "mb-3 col-12 col-md-6">
          <label for="avatarFile" class="form-label">Image:</label>
          <input class="form-control" type="file" id="avatarFile" accept=".png, .jpg, .jpeg" name = "thebinhFile" />
    </div>




    <div class="col-12 mb-3">
      <img style="max-height: 250px; display: none;" alt="avatar preview" id="avatarPreview" />
    </div>
    
    <div class = "col-12 mb-5">
      <a type="submit" class="btn btn-primary" href="/admin/product">Create</a>
    </div>
    
      </form:form>

        </div>
    </div>
</div>



</body>
</html>