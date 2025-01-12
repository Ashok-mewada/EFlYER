<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Products</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #007bff;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    tr:hover {
        background-color: #f1f1f1;
    }
    .action-buttons a, .add-product-btn, .toggle-btn {
        margin-right: 10px;
        padding: 5px 10px;
        text-decoration: none;
        color: white;
        background-color: #007bff;
        border-radius: 4px;
        display: inline-block;
        text-align: center;
    }
    .action-buttons a:hover, .add-product-btn:hover, .toggle-btn:hover {
        background-color: #0056b3;
    }
    .add-product-container {
        margin-bottom: 20px;
        display: flex;
        justify-content: flex-end;
    }

    /* Dim Hidden Products */
    .dimmed {
        opacity: 0.6;
        background-color: #f2f2f2;
    }

    /* Visibility button styles */
    .toggle-btn {
        cursor: pointer;
    }
    .toggle-btn.show {
        background-color: #28a745; /* Green for Show */
    }
    .toggle-btn.hide {
        background-color: #dc3545; /* Red for Hide */
    }

</style>
<script>
    function toggleProductVisibility(productId, currentStatus) {
        const newStatus = !currentStatus;
        console.log(`Product ID: ${productId}, New Status: ${newStatus}`);
        fetch("/EflyerShopping/toggleVisibility?id=" + productId + "&status=" + newStatus, {
            method: 'POST',
        })
        .then(response => {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error('Failed to update product visibility');
            }
        })
        .then(data => {
            alert(`Product visibility updated successfully`);
            location.reload(); // Reload page to reflect the changes
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }
</script>
</head>
<body>
    <h1>All Products</h1>
    
    <div class="add-product-container">
        <a href="upload" class="add-product-btn">Add Product</a>
    </div>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Main Image</th>
                <th>Visibility</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${products}">
                <tr class="${product.status ? '' : 'dimmed'}"> <!-- Dim the row if hidden -->
                    <td>${product.productId}</td>
                    <td>${product.productName}</td>
                    <td>${product.productDesc}</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty product.productImages}">
                                <c:forEach var="image" items="${product.productImages}">
                                    <c:if test="${image.mainImage}">
                                        <img src="images/${image.imageName}" 
                                             alt="${product.productName}" 
                                             style="width:100px; height:70px; object-fit:contain;">
                                    </c:if>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                No Image
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <button 
                            class="toggle-btn ${product.status ? 'show' : 'hide'}" 
                            onclick="toggleProductVisibility(${product.productId}, ${product.status})">
                            ${product.status ? 'Hide' : 'Show'}
                        </button>
                    </td>
                    <td class="action-buttons">
                        <a href="viewProduct?id=${product.productId}">View</a>
                        <a href="editProduct?id=${product.productId}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
