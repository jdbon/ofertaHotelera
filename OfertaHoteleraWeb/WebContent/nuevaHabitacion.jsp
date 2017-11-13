<!DOCTYPE html>
<html>
<head>
<%@page import="com.ofertahotelera.dto.*"%>
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
            <li class="active"><a href="/OfertaHoteleraWeb/Controlador?name=ObtenerServicios">Establecimientos</a></li>
            <li><a href="/OfertaHoteleraWeb/Controlador?name=AltaOferta1">Ofertas de alojamientos</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="starter-template">
    <%String nombre=request.getAttribute("nombre").toString();
    String n=request.getAttribute("idHotel").toString();%>
<!--     <p>Me ha llegado <%= request.getAttribute("idHotel") %></p> -->
        <h1>Tipo de Habitacion</h1>
   <!--   <form action="/RESTExample/api/decision/my" method="post">-->
    <form action="Controlador" method="get">
<%


out.print("<input type=\"hidden\" name=\"idHotel\" value=\""+n+"\">");
out.print("<input type=\"hidden\" name=\"nombre\" value=\""+nombre+"\">");

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
               <div class="form-group">
            <label>Foto URL:</label>
            <select class="form-control" name="selectFoto">
               
    	<option value="hab1.jpg">Habitacion1</option>
    	<option value="hab2.jpg">Habitacion2</option>
    	<option value="hab3.jpg">Habitacion3</option>
    	<option value="hab4.jpg">Habitacion4</option>
    	<option value="hab5.jpg">Habitacion5</option>    
                </select>
        </div>
        
        
           <div class="form-group">
            <label>Servicios:</label>
         
                <%
                @SuppressWarnings("unchecked")
List<String> servicios = (List<String>) request.getAttribute("serviciosHab");
                if(servicios != null){
   int cantServ = servicios.size();
   out.print("<input type=\"hidden\" name=\"cantServ\" value=\""+cantServ+"\">");
  
    
    	for(int i=0;i<servicios.size();i++){
    		out.print(" <div class=\"checkbox\"><label><input type =\"checkbox\" value=\""+servicios.get(i)+"\" name =\""+i+"\">"+servicios.get(i)+"</label></div>");
        }
    }
%>
</div>

        
        
        
        
        
        
        
   <!--     <div class="form-group">
            <label>Servicios:</label>
            <div class="checkbox">
                <label><input type="checkbox" value="">Servicio al cuarto</label>
            </div>
            <div class="checkbox">
                <label><input type="checkbox" value="">Pay per view</label>
            </div>
        </div> -->
        <!-- <input type="submit" value="AltaHabitacion" name="name"> -->
         <button type="submit" name="name" value="AltaHabitacion">Crear Habitacion</button>
        <button type="reset">Cancelar</button>
        
    </form>
</div>
    <br />
    <br />
    
   <form action="Controlador" method="get">
     <%
	
     out.print("<input type=\"hidden\" name=\"idHotel\" value=\""+n+"\">");
	out.print("<input type=\"hidden\" name=\"nombre\" value=\""+nombre+"\">");
	
	%>
	<input type="submit" value="EnviarSolicitud" name="name">
    
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
@SuppressWarnings("unchecked")
List<HabitacionDTO> habitaciones = (List<HabitacionDTO>) request.getAttribute("habitaciones");
    if(habitaciones != null){
    	for(HabitacionDTO h: habitaciones){
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