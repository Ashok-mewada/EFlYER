<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Product</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #f4f4f9;
    }
    .container {
        max-width: 900px;
        margin: auto;
        background: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        color: #333;
    }
    .product-images {
        display: flex;
        justify-content: center;
        flex-wrap: wrap;
        margin-bottom: 20px;
    }
    .product-images img {
        width: 150px;
        height: 150px;
        object-fit: cover;
        margin: 10px;
        border-radius: 4px;
        border: 1px solid #ddd;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }
    .product-details {
        text-align: center;
        margin-bottom: 20px;
    }
    .product-details h2 {
        color: #007bff;
        margin-bottom: 10px;
    }
    .product-details p {
        color: #555;
        margin: 5px 0;
    }
    .product-details .price {
        font-size: 1.2em;
        margin: 10px 0;
    }
    .product-details .actual-price {
        text-decoration: line-through;
        color: #d9534f;
    }
    .product-details .offer-price {
        color: #5cb85c;
        font-weight: bold;
    }
    .back-button {
        display: block;
        text-align: center;
        margin-top: 20px;
    }
    .back-button a {
        text-decoration: none;
        color: white;
        background-color: #007bff;
        padding: 10px 20px;
        border-radius: 4px;
        transition: background-color 0.3s;
    }
    .back-button a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Product Details</h1>
        <div class="product-images">
            <c:forEach var="image" items="${product.productImages}">
                <img src="images/${image.imageName}" alt="${product.productName}">
            </c:forEach>
        </div>
        <div class="product-details">
            <h2>${product.productName}</h2>
            <p>${product.productDesc}</p>
            <p class="price">
                <span class="actual-price">${product.actualPrice}</span>
                &nbsp;&nbsp;
                <span class="offer-price">${product.offerPrice}</span>
            </p>
        </div>
        <div class="back-button">
            <a href="admin">Back to All Products</a>
        </div>
    </div>
</body>
</html>
