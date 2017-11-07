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
            <li class="active"><a href="/">Inicio</a></li>
            <li><a href="newBoard">Establecimientos</a></li>
            <li><a href="oferta.jsp">Ofertas de alojamientos</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="starter-template">
        <h1>Oferta de Hotel</h1>
    </div>
    <form action="Controlador" method="get">

          
        <div class="form-group">
            <label>Elegi el hotel:</label>
                <select class="form-control" name="selectHotel">
                <%
List<Hotel> hoteles = (List<Hotel>) request.getAttribute("hoteles");
    if(hoteles != null){
    	for(Hotel h: hoteles){
    		out.print("<option value=\""+h.getId()+"\">"+h.getNombre()+"</option>");
        }
    }
%>
                </select>
        </div>
        <input type="submit" value="AltaOferta2" name="name">
        <button type="reset">Cancelar</button>
    </form>
</div>
</body>
</html>