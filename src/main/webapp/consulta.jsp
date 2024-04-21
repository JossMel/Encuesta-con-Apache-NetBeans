<%-- 
    Document   : consulta
    Created on : 17/09/2023, 03:53:20 PM
    Author     : JosselynMartinez
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
  <title>Consulta</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS v5.2.1 -->
  <!-- Bootstrap Icons CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" rel="stylesheet">

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>

<body>
  <header>
    <%@ include file="menu.jsp" %>
  </header>
  <main>
    
  <div class="container"><br>
    <center>
    <div class="container">
        <div class="card" style="width: 50rem;">
            <div class="card-header">
                <h3>ENCUESTA</h3>
            </div>
            <div class="card-body">
            <p class="card-text"><div class="mb-3"><br>
            <form method="post" action="ControllerEncuesta">
                <input type="hidden" name="action" value="agregar">
                <div class="mb-3 row">
                    <label for="inputName" class="col-4 col-form-label">Nombre</label>
                    <div class="col-8">
                        <input type="text" class="form-control" name="nombre" id="nombre" required placeholder="Ingrese el nombre">
                    </div>
                </div> 
                <div class="mb-3 row">
                    <label for="inputName" class="col-4 col-form-label">Sexo</label>
                    <div class="col-8">
                        <select id="sexo" name="sexo" class="form-control">
                            <option value="Femenino">Femenino</option>
                            <option value="Masculino">Masculino</option>
                        </select>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="inputName" class="col-4 col-form-label">Deporte Favoritos</label>
                    <div class="col-8">
                        <select id="sexo" name="deporte" required class="form-control">
                            <option value="" disabled selected>--Seleccione un deporte--</option>
                            <option value="Fútbol">Fútbol</option>
                            <option value="Básquetbol">Básquetbol</option>
                            <option value="Jockey">Jockey</option>
                            <option value="Beísbol">Beísbol</option>
                            <option value="Golf">Golf</option>
                        </select>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="inputName" class="col-4 col-form-label">Nivel de Estudio</label>
                    <div class="col-8">
                        <select id="sexo" name="estudio" required class="form-control">
                            <option value="" disabled selected>--Seleccione un nivel de estudio--</option>
                            <option value="Básico">Básico</option>
                            <option value="Bachilletaro">Bachilletaro</option>
                            <option value="Superior">Superior</option>
                        </select>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="inputName" class="col-4 col-form-label">Temas Favoritos</label>
                    <div class="col-8">
                        <select id="sexo" name="tema" required class="form-control">
                            <option value="" disabled selected>--Seleccione un tema de su preferencia--</option>
                            <option value="Television">Television</option>
                            <option value="Cocina">Cocina</option>
                            <option value="Tecnología">Tecnología</option>
                            <option value="Música">Música</option>
                            <option value="Deportes">Deportes</option>
                        </select>
                    </div>
                </div>
                <div class="mb-3 row">
                    <div class="offset-sm-4 col-sm-8">
                        <a href="ControllerEncuesta">
                            <button type="submit" class="btn btn-primary">Enviar Datos</button>
                        </a>
                    </div>
                </div>
            </form>
        </div>
    </div></center><br><br>
    
    <div class="table-responsive">
        <h3><center>Resumen de Encuestas</center></h3>
        <table class="table table-primary">
            <thead>
                <tr align="center">
                    <th scope="col">#</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Sexo</th>
                    <th scope="col">Deporte Favorito</th>
                    <th scope="col">Nivel de Estudio</th>
                    <th scope="col">Tema favorito</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="contador" value="0" />
                <c:forEach items="${consulta}" var="dato">
                <tr>
                    <c:set var="contador" value="${contador + 1}" />
                    <td align="center">${contador}</td>
                    <td align="center">${dato.nombre}</td>
                    <td align="center">${dato.sexo}</td>
                    <td align="center">${dato.deporte}</td>
                    <td align="center">${dato.estudio}</td>
                    <td align="center">${dato.tema}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table><br>
    </div>
</div>
  </div>
  </main>
  <footer>
    <!-- place footer here -->
  </footer>
  <!-- Bootstrap JavaScript Libraries -->
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
    integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
  </script>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
    integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
  </script>
</body>

</html>
