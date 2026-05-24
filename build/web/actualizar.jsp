<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Actualizar Usuario - Evidencia SENA</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <div class="row justify-content-content-center">
        <div class="col-md-6">
            <h2 class="mb-4 text-center">Actualizar Datos de Usuario</h2>
            
            <form action="ActualizarServlet" method="POST" class="card p-4 shadow-sm">
                <div class="mb-3">
                    <label for="id" class="form-label">ID del Usuario a Modificar:</label>
                    <input type="number" class="form-control" id="id" name="id" required placeholder="Ej: 1">
                </div>
                
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nuevo Nombre Completo:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                </div>
                
                <div class="mb-3">
                    <label for="correo" class="form-label">Nuevo Correo Electrónico:</label>
                    <input type="email" class="form-control" id="correo" name="correo" required>
                </div>
                
                <button type="submit" class="btn btn-warning w-100">Actualizar Datos</button>
                <a href="dashboard.html" class="btn btn-outline-secondary w-100 mt-2">Volver al Inicio</a>
            </form>
        </div>
    </div>
</body>
</html>