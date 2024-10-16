<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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


     <div class="container mt-5"> <!--cách phía trên 5 -->
        <div class="row"> <!-- luôn luôn đi kèm mt-5 -->
             <div class="col-md-6 col-12 mx-auto"> <!-- sẽ chiếm 6 cảu màn hình to, 12 của màn hình bé -->
                
                <!-- mx-auto có nghĩa là tự động căn trái phải cho vào giữa màn hình(trục 0x ý) -->
                
                <h3>Create a product</h3>
                <hr />







    <form:form method="post" action="/admin/product/create" modelAttribute = "newProduct" class="row" enctype = "multipart/form-data">
      <!-- khi class = row thì mới chia làm 2 cột đc -->
        <!-- form của html có 2 method chính là get và post, get nó đẩy dữ liệu lên url khi load lại không mất dữ liệu, còn post không đẩy lên url nhưng khi load lại thì mất -->




       <c:set var = "errorName">
              <form:errors path = "name" cssClass = "invalid-feedback" />
       </c:set>
       <c:set var = "errorPrice">
          <form:errors path = "price" cssClass = "invalid-feedback" />
        </c:set>
        <c:set var = "errorDetailDesc">
              <form:errors path = "detaiDesc" cssClass = "invalid-feedback" />
       </c:set>
       <c:set var = "errorShortDesc">
              <form:errors path = "shortDesc" cssClass = "invalid-feedback" />
       </c:set>
       <c:set var = "errorQuantity">
              <form:errors path = "quantity" cssClass = "invalid-feedback" />
       </c:set>

        <div class="mb-3 col-12 col-md-6">
          <label for="exampleInputName1" class="form-label">Name:</label>
          <form:input type="text" class="form-control ${not empty errorName ? 'is-invalid' : ''}" path = "name"/>
          ${errorName}
        </div>

        <div class="mb-3 col-12 col-md-6">
          <label for="exampleInputPassword1" class="form-label">Price:</label>
          <form:input type="number" class="form-control ${not empty errorPrice ? 'is-invalid' : '' }" path = "price"/>
          ${errorPrice}
        </div>
        
        <div class="form-group">
          <label for="exampleFormControlTextarea1">Detail Description:</label>
          <form:textarea class="form-control ${not empty errorDetailDesc ? 'is-invalid' : ''}" id="exampleFormControlTextarea1" rows="3" path = "detaiDesc"/>
          ${errorDetailDesc}
        </div>

        <div class="mb-3 col-12 col-md-6">
            <label for="exampleInputPassword1" class="form-label">Short description:</label>
            <form:input type="text" class="form-control ${not empty errorShortDesc ? 'is-invalid' : ''}" path = "shortDesc"/>
            ${errorShortDesc}
        </div>

        <div class="mb-3 col-12 col-md-6">
            <label for="exampleInputPassword1" class="form-label">Quantity:</label>
            <form:input type="number" class="form-control ${not empty errorQuantity ? 'is-invalid' : ''}" path = "quantity"/>
            ${errorQuantity}
        </div>
       




        <div class="mb-3 col-12 col-md-6">
          
          <label for="exampleInputPassword1" class="form-label">Factory:</label>
          <form:select class="form-select" aria-label="Default select example" path = "factory">
          <!-- tại sao role.name mà vẫn bắt được? vì ta chỉ lấy thuộc tính của biến Object role là name mà thôi-->
          <form:option value="Mac">Mac</form:option>
          <form:option value="Windows">Windows</form:option>
          <form:option value="Linux">Linux</form:option>
        </form:select>
        </div>

        <div class="mb-3 col-12 col-md-6">
          
          <label for="exampleInputPassword1" class="form-label">Target:</label>
          <form:select class="form-select" aria-label="Default select example" path = "target">
          <!-- tại sao role.name mà vẫn bắt được? vì ta chỉ lấy thuộc tính của biến Object role là name mà thôi-->
          <form:option value="Gaming">Gaming</form:option>
          <form:option value="Phụ kiện">Phụ kiện</form:option>
          <form:option value="Mỏng nhẹ">Mỏng nhẹ</form:option>
          <form:option value="Văn phòng">Văn phòng</form:option>
        </form:select>
        </div>

        
        <div class = "mb-3 col-12 col-md-6">
          <label for="avatarFile" class="form-label">Image:</label>
          <input class="form-control" type="file" id="avatarFile" accept=".png, .jpg, .jpeg" name = "proFile" />
    </div>


    <div class="col-12 mb-3">
      <img style="max-height: 250px; display: none;" alt="avatar preview" id="avatarPreview" />
    </div> 
    
    <div class = "col-12 mb-5">
      <button type="submit" class="btn btn-primary">Create</button>
    </div>
    
      </form:form>

  






    </div>
  </main>

</div>
</div>
</div>

<jsp:include page = "../layout/footer.jsp" />

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