<%--
  Created by IntelliJ IDEA.
  User: eduzuniga
  Date: 2024-04-30
  Time: 11:09 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Empleado Dashboard</title>
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="../styles/dashboard.min.css" rel="stylesheet">
</head>
<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="">
            <div class="sidebar-brand-text mx-3">Sistema Empleados</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="empleado">
                <span>Dashboard</span></a>
        </li>
        <!-- Divider -->
        <hr class="sidebar-divider">
        <!-- Nav Item -->
        <li class="nav-item">
            <form action ="/registrar" method="get">
                <input type="submit" value="Registrar Empleado" style="background:none;border:none;color:white;font-size: 1rem;font-weight: 400;line-height: 1.5">
            </form>
        </li>
        <li class="nav-item">
            <form action ="/bulk" method="post">
                <input type="submit" value="Registrar Empleados Bulk" style="background:none;border:none;color:white;font-size: 1rem;font-weight: 400;line-height: 1.5">
            </form>
        </li>
        <li class="nav-item">
            <form action ="/exportar-excel" method="post">
                <input type="submit" value="Exportar a Excel" style="background:none;border:none;color:white;font-size: 1rem;font-weight: 400;line-height: 1.5">
            </form>
        </li>
    </ul>
    <!-- Fin Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">
                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600">
                                Hola! ${sessionScope.user.primerNombre()}
                            </span>
                            <img class="img-profile rounded-circle" src=${sessionScope.user.fotoPerfilBase64()} style="width:65" alt="profile photo">

                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#">
                                Perfil
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                Salir
                            </a>
                        </div>
                    </li>
                </ul>
            </nav>
            <!-- Fin Topbar -->

            <!-- Inicio Page Content -->
            <div class="container-fluid">
                <div class="row">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-md-6">
                                <div class="card">
                                    <div class="card-header text-center">
                                        <h2>Editar Empleado</h2>
                                    </div>
                                    <div class="card-body">
                                        <form action="editar" method="post">
                                            <div class="form-group">
                                                <label for="nombres">Nombres</label>
                                                <input type="text" name="nombres" class="form-control" id="nombres"  >
                                            </div>
                                            <div class="form-group">
                                                <label for="apellidoPat">Apellido Paterno</label>
                                                <input type="text" name="apellidoPat" class="form-control" id="apellidoPat"  ">
                                            </div>
                                            <div class="form-group">
                                                <label for="apellidoMat">Apellido Materno</label>
                                                <input type="text" name="apellidoMat" class="form-control" id="apellidoMat"  >
                                            </div>
                                            <div class="form-group">
                                                <label for="idDepartamento">Departamento</label>
                                                <input type="text" name="idDepartamento" class="form-control" id="idDepartamento"  >
                                            </div>
                                            <div class="form-group">
                                                <label for="correo">Correo</label>
                                                <input type="email" name="correo" class="form-control" id="correo"  placeholder="Ingresa un correo valido">
                                            </div>
                                            <div class="form-group">
                                                <label for="salario">Salario</label>
                                                <input type="number" name="salario" class="form-control" id="salario" >
                                            </div>
                                            <div class="form-group">
                                                <label for="fechaNacimiento">Fecha Nacimiento:</label>
                                                <input type="text" class="form-control" id="fechaNacimiento" name="fechaNacimiento">
                                            </div>
                                            <button type="submit" class="btn btn-primary">Editar</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; 2023 Hecho para fines educativos</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">¿Seguro que quieres salir?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Selecciona "Salir" para cerrar tu sesion o "Cancelar" para volver </div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                <a class="btn btn-primary" href="login.html">Salir</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/chart-area-demo.js"></script>
<script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>
