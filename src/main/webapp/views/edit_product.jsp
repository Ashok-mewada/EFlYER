<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Product</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    .container {
        max-width: 600px;
        margin: 0 auto;
        padding: 20px;
        border: 1px solid #ddd;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        color: #333;
    }
    form {
        display: flex;
        flex-direction: column;
    }
    label {
        margin-top: 10px;
        font-weight: bold;
    }
    input, textarea, button {
        margin-top: 5px;
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ddd;
        border-radius: 4px;
    }
    textarea {
        resize: vertical;
    }
    button {
        background-color: #007bff;
        color: white;
        border: none;
        cursor: pointer;
    }
    button:hover {
        background-color: #0056b3;
    }
    .images-section img {
        margin-top: 10px;
        max-width: 100px;
        max-height: 100px;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Edit Product</h1>
        <form action="updateProduct" method="post" enctype="multipart/form-data">
            <input type="hidden" name="productId" value="${product.productId}">
            
            <label for="productName">Product Name</label>
            <input type="text" id="productName" name="productName" value="${product.productName}" required>
            
            <label for="productDesc">Description</label>
            <textarea id="productDesc" name="productDesc" rows="5" required>${product.productDesc}</textarea>
            
            <label for="actualPrice">Actual Price</label>
            <input type="text" id="actualPrice" name="actualPrice" value="${product.actualPrice}" required>
            
            <label for="offerPrice">Offer Price</label>
            <input type="text" id="offerPrice" name="offerPrice" value="${product.offerPrice}" required>
            
            <div class="images-section">
                <h3>Existing Images</h3>
                <c:forEach var="image" items="${product.productImages}">
                    <img src="images/${image.imageName}" alt="Product Image">
                </c:forEach>
            </div>
            
            <label for="newImages">Upload New Images</label>
            <input type="file" id="newImages" name="files" multiple>
            
            <button type="submit">Update Product</button>
        </form>
    </div>
</body>
</html>
