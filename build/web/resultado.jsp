<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Resultado del Registro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6 text-center">
            <div class="alert alert-success shadow-sm" role="alert">
                <h1 class="display-6">¡Datos Procesados con Éxito!</h1>
                <hr>
                <p class="fs-5"><strong>Nombre recibido:</strong> <%= request.getAttribute("nombreUsuario") %></p>
                <p class="fs-5"><strong>Correo recibido:</strong> <%= request.getAttribute("correoUsuario") %></p>
            </div>
            <a href="index.html" class="btn btn-outline-primary mt-3">Volver al inicio</a>
        </div>
    </div>
</body>
</html>