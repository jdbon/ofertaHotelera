<!DOCTYPE html>
<html>
<head>
<%@page import="com.ofertahotelera.entity.*"%>
<%@page import="java.util.List"%>
    <meta charset="utf-8">
    <title>REST API Console</title>

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>

<body>


<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">Oferta Hotelera</a>
        </div>
 		<ul class="nav navbar-nav">
            <li><a href="/OfertaHoteleraWeb/">Inicio</a></li>
            <li><a href="nuevoEstablecimiento.jsp">Establecimientos</a></li>
            <li><a href="/Web/Controlador?name=AltaOferta1">Ofertas de alojamientos</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="starter-template">
    <p>Me ha llegado <%= request.getAttribute("idHotel") %></p>
        <h1>Tipo de Habitacion</h1>
   <!--   <form action="/RESTExample/api/decision/my" method="post">-->
    <form action="Controlador" method="get">
<%
String n=request.getAttribute("idHotel").toString();

out.print("<input type=\"hidden\" name=\"idHotel\" value=\""+n+"\">");

%>

        <div class="form-group"> <!-- la forma de identificar el textfield es con name" -->
            <label>Descripcion:</label>
            <input type="text" id="nombre" name="descripcion" class="form-control">
        </div>
        <div class="form-group">
            <label>Cantidad de personas:</label>
            <input type="text" id="cantidad" name="cantidad"
                   class="form-control">
        </div>
        <div class="form-group">
            <label>Tipo:</label>
            <input type="text" id="tipo" name="tipo"
                   class="form-control">
        </div>
        <input id="input-b1" name="input-b1" type="file" class="file">
        <br/>
        <div class="form-group">
            <label>Servicios:</label>
            <div class="checkbox">
                <label><input type="checkbox" value="">Servicio al cuarto</label>
            </div>
            <div class="checkbox">
                <label><input type="checkbox" value="">Pay per view</label>
            </div>
        </div>
        <input type="submit" value="AltaHabitacion" name="name">
        <button type="reset">Cancelar</button>
    </form>

    <table class="table table-striped">
        <thead>
              <tr>
            <th>Descripcion</th>
            <th>Cantidad de personas</th>
            <th>Tipo</th>
        </tr>
        </thead>
        <tbody>
         <%
List<Habitacion> habitaciones = (List<Habitacion>) request.getAttribute("habitaciones");
    if(habitaciones != null){
    	for(Habitacion h: habitaciones){
        	out.print("<tr> <td> " +h.getDescripcion()+ "</td><td>"+ h.getCantPersonas()+ "</td><td>"+ h.getTipo()+ "</td></tr>");
        }

    }
    
%>
        </tbody>
    </table>
    
    <div id="response-content"></div>
</div>
</body>
</html>