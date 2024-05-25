<%--
  Created by IntelliJ IDEA.
  User: eduzuniga
  Date: 2024-05-06
  Time: 10:02 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 Error - Recurso no encontrado</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f5f5f5;
        }
        .error-container {
            text-align: center;
        }
        .error-image {
            max-width: 100%;
            height: auto;
        }
        .error-message {
            font-size: 24px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="error-container">
    <h1 class="error-message">Pagina no encontrada 😭</h1>
    <img class="error-image" src="../assets/404.jpeg" alt="404 Error">
</div>
</body>
</html>
