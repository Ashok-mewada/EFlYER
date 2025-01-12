<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Product Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            max-width: 600px;
            margin: auto;
        }
        label {
            font-weight: bold;
        }
        input, select, textarea, button {
            width: 100%;
            margin: 10px 0;
            padding: 10px;
            font-size: 14px;
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
    </style>
</head>
<body>
    <h1>Admin Product Management</h1>
    <form action="add_product" method="post" enctype="multipart/form-data">
        <!-- Product Details -->
        <label for="productName">Product Name:</label>
        <input type="text" id="productName" name="productName" required>
        
        <label for="productDescription">Product Description:</label>
        <textarea id="productDescription" name="productDesc" rows="4" required></textarea>
        
        <label for="price">Price:</label>
        <input type="number" id="price" name="actualPrice" step="0.01" required>
        
        <label for="offerPrice">Offer Price:</label>
        <input type="number" id="offerPrice" name="offerPrice" step="0.01">
        
        <label for="stockStatus">Stock Status:</label>
        <select id="stockStatus" name="inStock" required>
            <option value="true">In Stock</option>
            <option value="false">Out of Stock</option>
        </select>
        
        <label for="productType">Product Type:</label>
        <select id="productType" name="productType" required>
            <option value="Electronics">Electronics</option>
            <option value="Jewelry">Jewelry</option>
            <option value="Fashion">Fashion</option>
            <option value="Others">Others</option>
        </select>
        
        <label for="status">Show on Webpage:</label>
        <select id="status" name="status" required>
            <option value="true">Yes</option>
            <option value="false">No</option>
        </select>
        
        <!-- Image Upload -->
        <label for="uploadedImages">Upload Product Images:</label>
        <input type="file" id="uploadedImages" name="files" accept="image/*" multiple required>
        
        <!-- Submit -->
        <button type="submit">Add Product</button>
    </form>
</body>
</html>
