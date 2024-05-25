<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="styles/main.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200..700&family=Reddit+Mono:wght@200..900&display=swap" rel="stylesheet">
</head>
<body>
    <div class="dashboard-container">
        <div class="dashboard-header">
            <h1>Dashboard</h1>
        </div>
        <div class="dashboard-content">
            <div class="dashboard-card">
                <h2>Users</h2>
                <p>Manage users</p>
                <a href="users.jsp">View</a>
            </div>
            <div class="dashboard-card">
                <h2>Products</h2>
                <p>Manage products</p>
                <a href="products.jsp">View</a>
            </div>
            <div class="dashboard-card">
                <h2>Orders</h2>
                <p>Manage orders</p>
                <a href="orders.jsp">View</a>
            </div>
        </div>

    </div>

</body>
</html>
