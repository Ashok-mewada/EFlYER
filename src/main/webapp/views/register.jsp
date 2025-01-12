<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- banner bg main start -->
      <div class="banner_bg_main">
         <%@ include file="header.jsp" %>
         <div class="register_section layout_padding">
            <div class="container">
               <h1 class="fashion_taital text-center">Register</h1>
               <div class="register_form">
                  <form action="register.jsp" method="post">
                     <div class="form-group">
                        <label for="username">Username:</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required>
                     </div>
                     <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
                     </div>
                     <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
                     </div>
                     <div class="form-group">
                        <label for="address">Address:</label>
                        <textarea class="form-control" id="address" name="address" placeholder="Enter your address" rows="3" required></textarea>
                     </div>
                     <div class="form-group">
                        <label for="mobile">Mobile Number:</label>
                        <input type="tel" class="form-control" id="mobile" name="mobile" placeholder="Enter your mobile number" pattern="[0-9]{10}" required>
                     </div>
                     <div class="btn_main text-center">
                        <button type="submit" class="btn btn-primary">Register</button>
                     </div>
                  </form>
               </div>
            </div>
         </div>
         <%@ include file="footer.jsp" %>
      </div>
</body>
</html>