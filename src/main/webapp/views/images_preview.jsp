<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Main Image</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    .image-container {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
    }
    .image-item {
        cursor: pointer;
        border: 2px solid transparent;
        padding: 5px;
        transition: border-color 0.3s;
    }
    .image-item img {
        width: 300px;
        height: 200px;
        object-fit: contain;
    }
    .image-item.selected {
        border-color: #007bff;
    }
    button {
        margin-top: 20px;
        padding: 10px 20px;
        font-size: 16px;
        background-color: #007bff;
        color: white;
        border: none;
        cursor: pointer;
    }
    button:hover {
        background-color: #0056b3;
    }
</style>
<script>
    function selectImage(imageDiv, imagePath) {
        // Remove selection from previously selected image
        const previouslySelected = document.querySelector('.image-item.selected');
        if (previouslySelected) {
            previouslySelected.classList.remove('selected');
        }

        // Mark clicked image as selected
        imageDiv.classList.add('selected');

        // Update the hidden input value
        document.getElementById('mainImageInput').value = imagePath;
    }

    // Function to set the first image as the default selected
    function setDefaultSelection() {
        const firstImage = document.querySelector('.image-item');
        if (firstImage) {
            const imagePath = firstImage.getAttribute('data-image-path');
            firstImage.classList.add('selected');
            document.getElementById('mainImageInput').value = imagePath;
        }
    }

    // Initialize default selection on page load
    window.onload = setDefaultSelection;
</script>
</head>
<body>
    <h1>Select Main Image</h1>
    <form action="setMainImage" method="post">
        <div class="image-container">
            <c:forEach var="item" items="${productImages}">
                <div class="image-item" data-image-path="${item}" onclick="selectImage(this, '${item}')">
                    <img alt="Product Image" src="images/${item}">
                </div>
            </c:forEach>
        </div>
        <!-- Hidden input to store the selected image -->
        <input type="hidden" id="mainImageInput" name="mainImage" required>
        <input type="hidden" id="mainImageInput" name="productId" value="${id}" required>
        <button type="submit">Save Main Image</button>
    </form>
</body>
</html>
