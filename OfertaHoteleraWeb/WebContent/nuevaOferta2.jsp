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
            <a class="navbar-brand" href="/">MyHotel</a>
        </div>
 		<ul class="nav navbar-nav">
            <li><a href="/OfertaHoteleraWeb/">Inicio</a></li>
            <li><a href="nuevoEstablecimiento.jsp">Establecimientos</a></li>
            <li><a href="/Web/Controlador?name=AltaOferta1">Ofertas de alojamientos</a></li>
        </ul>
    </div>
</nav>
<%
Hotel hotel = (Hotel) request.getAttribute("hotel");
out.print("<p>" + request.getAttribute("selectHotel") +"</p>");
out.print("<p>" + hotel.getNombre() +"</p>");
out.print(hotel.getNombre());
%>
<div class="container">
    <div class="starter-template">
        <h1>Oferta de Hotel</h1>
    </div>
    <form action="Controlador" method="get">

        <div class="form-group"> <!-- la forma de identificar el textfield es con name" -->
            <label>Nombre oferta:</label>
            <input type="text" id="nombreOferta" name="nombreOferta" class="form-control">
        </div>
        <div class="form-group">
            <label>Hotel:</label>
            <input type="text" id="nombreHotel" value="<%out.print(hotel.getNombre());%>" readonly
                   class="form-control">
        </div>
        <div class="form-group">
            <label>Fecha desde:</label>
            <input type="text" id="fecDesde" name="fecDesde"
                   class="form-control">
        </div>
        <div class="form-group">
            <label>Fecha hasta:</label>
            <input type="text" id="fecHasta" name="fecHasta"
                   class="form-control">
        </div>
        <div class="form-group">
            <label>Elegi un tipo de habitacion:</label>
                 <select class="form-control" name="selectHab">
                <%
        List<Habitacion> habitaciones = (List<Habitacion>) hotel.getHabitaciones();
    	for(Habitacion hab: habitaciones){
    		out.print("<option value=\""+hab.getId()+"\">"+hab.getTipo()+"</option>");
        }
%>
                </select>
        </div>
        <div class="form-group">
            <label>Estado:</label>
            <input type="text" id="estado" name="estado"
                   class="form-control">
        </div>
        <div class="form-group">
            <label>Cupo:</label>
            <input type="text" id="cupo" name="cupo"
                   class="form-control">
        </div>
        <div class="form-group">
            <label>Precio:</label>
                <div class="input-group">
                    <input type="text" class="form-control" name="precio" />
                    <span class="input-group-addon">$</span>
                </div>
        </div>
        <div class="form-group">
            <label>Politicas de capacitacion:</label>
            <input type="text" id="polCanc" name="polCanc"
                   class="form-control">
        </div>
        <input type="submit" value="AltaOferta3" name="name">
        <button type="reset">Cancelar</button>
    </form>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Hotel</th>
            <th>Fecha desde</th>
            <th>Fecha hasta</th>
            <th>Estado</th>
            <th>Cupo</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>7 dias en Miami</td>
            <td>Hilton</td>
            <td>04/11/2017</td>
            <td>11/11/2017</td>
            <td>Activo</td>
            <td>9</td>
        </tr>
        <tr>
            <td>2 dias en Paris</td>
            <td>Howard Johnson</td>
            <td>02/11/2017</td>
            <td>04/11/2017</td>
            <td>Activo</td>
            <td>3</td>
        </tr>
        </tbody>
    </table>
    <div id="response-content"></div>
</div>
</body>
</html>