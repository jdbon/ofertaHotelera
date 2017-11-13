<!DOCTYPE html>
<html>
<head>
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
        <h1>Alta de Hotel</h1>
    </div>
   <form action="Controlador" method="get">

        <div class="form-group"> <!-- la forma de identificar el textfield es con name" -->
            <label>Nombre:</label>
            <input type="text" id="nombre" name="nombre" class="form-control">
        </div>
        <div class="form-group"> <!-- la forma de identificar el textfield es con name" -->
            <label>Descripcion:</label>
            <input type="text" id="nombre" name="descripcion" class="form-control">
        </div>
        <div class="form-group">
            <label>Direccion:</label>
            <input type="text" id="direccion" name="direccion"
                   class="form-control">
        </div>
        <div class="form-group">
            <label>Estado:</label>
            <input type="text" id="estado" name="estado" value="Pendiente"
                   class="form-control" readonly>
        </div>
          <div class="form-group">
            <label>Foto URL:</label>
            <select class="form-control" name="selectFoto">
               
    	<option value="hotel1.jpg">Hotel1</option>
    	<option value="hotel2.jpg">Hotel2</option>
    	<option value="hotel3.jpg">Hotel3</option>
    	<option value="hotel4.jpg">Hotel4</option>
    	<option value="hotel5.jpg">Hotel5</option>    
                </select>
        </div>
       
  
        <div class="form-group">
            <label>Latitud:</label>
            <input type="text" id="latitud" name="latitud"
                   class="form-control">
        </div>
        <div class="form-group">
            <label>Longitud:</label>
            <input type="text" id="longitud" name="longitud"
                   class="form-control">
        </div>
        <div class="form-group">
            <label>E-mail:</label>
            <input type="text" id="email" name="email" class="form-control">
        </div>
        
        <div class="form-group">
            <label>Servicios:</label>
         
                <%
                @SuppressWarnings("unchecked")
List<String> servicios = (List<String>) request.getAttribute("nombresServicios");
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
                <label><input type="checkbox" value="">Wifi</label>
            </div>
            <div class="checkbox">
                <label><input type="checkbox" value="">Pileta climatizada</label>
            </div>
        </div>
        -->
        
        
        <!--
        <div class="form-group">
            <label>Medios de pago:</label>
            <div class="checkbox">
                <label><input type="radio" value="tarjeta" name="optradio">Tarjeta</label>
            </div>
            <div class="checkbox">
                <label><input type="radio" value="cheque" name="optradio">Cheque</label>
            </div>
            <div class="checkbox">
                <label><input type="radio" value="Pago_en_Destino" name="optradio">Pago en Destino</label>
            </div>
            <div class="checkbox">
                <label><input type="radio" value="Mercado_pago" name="optradio">Mercado Pago</label>
            </div>
            <div class="checkbox">
                <label><input type="radio" value="PayPal" name="optradio">PayPal</label>
            </div>
        </div>-->
        <div class="form-group">
            <label>Medios de pago:</label>
            <div class="checkbox">
                <label><input type="checkbox" value="Tarjeta" name="Tarjeta">Tarjeta</label>
            </div>
            <div class="checkbox">
                <label><input type="checkbox" value="Cheque" name="Cheque">Cheque</label>
            </div>
            <div class="checkbox">
                <label><input type="checkbox" value="Pago_en_Destino" name="Pago_en_Destino">Pago en Destino</label>
            </div>
            <div class="checkbox">
                <label><input type="checkbox" value="Mercado_Pago" name="Mercado_Pago">Mercado Pago</label>
            </div>
            <div class="checkbox">
                <label><input type="checkbox" value="PayPal" name="PayPal">PayPal</label>
            </div>
        </div>
        
        
        
        
        
        
        
        <div class="form-group">
            <label>Destino:</label>
            <select class="form-control" name="selectDestino">
        
        
        <option value="Arauco">Arauco</option>
<option value="Aminga">Aminga</option>
<option value="Chamical">Chamical</option>
<option value="Chilecito">Chilecito</option>
<option value="Villa Uni�n">Villa Uni�n</option>
<option value="Famatina">Famatina</option>
<option value="General �ngel Vicente Pe�aloza">General �ngel Vicente Pe�aloza</option>
<option value="General Belgrano">General Belgrano</option>
<option value="General Juan Facundo Quiroga">General Juan Facundo Quiroga</option>
<option value="General Lamadrid">General Lamadrid</option>
<option value="Ortiz de Ocampo">Ortiz de Ocampo</option>
<option value="General San Mart�n">General San Mart�n</option>
<option value="Independencia">Independencia</option>
<option value="La Rioja">La Rioja</option>
<option value="Rosario Vera Pe�aloza">Rosario Vera Pe�aloza</option>
<option value="San Blas de Los Sauces">San Blas de Los Sauces</option>
<option value="Sanagasta">Sanagasta</option>
<option value="Vinchina">Vinchina</option>
<option value="Caleta Olivia">Caleta Olivia</option>
<option value="Comandante Luis Piedrabuena">Comandante Luis Piedrabuena</option>
<option value="El Calafate">El Calafate</option>
<option value="Gobernador Gregores">Gobernador Gregores</option>
<option value="Las Heras">Las Heras</option>
<option value="Los Antiguos">Los Antiguos</option>
<option value="Perito Moreno">Perito Moreno</option>
<option value="Pico Truncado">Pico Truncado</option>
<option value="Puerto Deseado">Puerto Deseado</option>
<option value="Puerto San Juli�n">Puerto San Juli�n</option>
<option value="Puerto Santa Cruz">Puerto Santa Cruz</option>
<option value="R�o Gallegos">R�o Gallegos</option>
<option value="R�o Turbio">R�o Turbio</option>
<option value="Veintiocho de Noviembre">Veintiocho de Noviembre</option>
<option value="Tres Lagos">Tres Lagos</option>
<option value="Jaramillo">Jaramillo</option>
<option value="Hip�lito Yrigoyen">Hip�lito Yrigoyen</option>
<option value="El Chalt�n">El Chalt�n</option>
<option value="Ca�ad�n Seco">Ca�ad�n Seco</option>
<option value="Koluel Kayke">Koluel Kayke</option>
<option value="R�o Grande">R�o Grande</option>
<option value="Tolhuin">Tolhuin</option>
<option value="Ushuaia">Ushuaia</option>
<option value="Allen">Allen</option>
<option value="Campo Grande">Campo Grande</option>
<option value="Catriel">Catriel</option>
<option value="Cervantes">Cervantes</option>
<option value="Chichinales">Chichinales</option>
<option value="Chimpay">Chimpay</option>
<option value="Choele Choel">Choele Choel</option>
<option value="Cinco Saltos">Cinco Saltos</option>
<option value="Cipolletti">Cipolletti</option>
<option value="Comallo">Comallo</option>
<option value="Contralmirante Cordero">Contralmirante Cordero</option>
<option value="Coronel Belisle">Coronel Belisle</option>
<option value="Darwin">Darwin</option>
<option value="El Bols�n">El Bols�n</option>
<option value="General Conesa">General Conesa</option>
<option value="General Enrique Godoy">General Enrique Godoy</option>
<option value="General Fern�ndez Oro">General Fern�ndez Oro</option>
<option value="General Roca">General Roca</option>
<option value="Guardia Mitre">Guardia Mitre</option>
<option value="Ingeniero Jacobacci">Ingeniero Jacobacci</option>
<option value="Ingeniero Luis A. Huergo">Ingeniero Luis A. Huergo</option>
<option value="Lamarque">Lamarque</option>
<option value="Los Menucos">Los Menucos</option>
<option value="Luis Beltr�n">Luis Beltr�n</option>
<option value="Mainqu�">Mainqu�</option>
<option value="Maquinchao">Maquinchao</option>
<option value="Ministro Ramos Mexia">Ministro Ramos Mexia</option>
<option value="�orquinc�">�orquinc�</option>
<option value="Pilcaniyeu">Pilcaniyeu</option>
<option value="Pomona">Pomona</option>
<option value="R�o Colorado">R�o Colorado</option>
<option value="San Antonio Oeste">San Antonio Oeste</option>
<option value="San Carlos de Bariloche">San Carlos de Bariloche</option>
<option value="Sierra Colorada">Sierra Colorada</option>
<option value="Sierra Grande">Sierra Grande</option>
<option value="Valcheta">Valcheta</option>
<option value="Viedma">Viedma</option>
<option value="Villa Regina">Villa Regina</option>
<option value="Aguada de Guerra">Aguada de Guerra</option>
<option value="Aguada Cecilio">Aguada Cecilio</option>
<option value="Aguada Guzm�n">Aguada Guzm�n</option>
<option value="Arroyo Los Berros">Arroyo Los Berros</option>
<option value="Arroyo de La Ventana">Arroyo de La Ventana</option>
<option value="Cerro Policia">Cerro Policia</option>
<option value="Cona Niyeu">Cona Niyeu</option>
<option value="Clemente Onelli">Clemente Onelli</option>
<option value="Cubanea">Cubanea</option>
<option value="Chelforo">Chelforo</option>
<option value="Chipauquil">Chipauquil</option>
<option value="Col�n Conhue">Col�n Conhue</option>
<option value="Comic�">Comic�</option>
<option value="Dina Huapi">Dina Huapi</option>
<option value="El Ca�n">El Ca�n</option>
<option value="El Cuy">El Cuy</option>
<option value="El Manso">El Manso</option>
<option value="Laguna Blanca">Laguna Blanca</option>
<option value="Mamuel Choique">Mamuel Choique</option>
<option value="Mencu�">Mencu�</option>
<option value="Nahuel Niyeu">Nahuel Niyeu</option>
        </select></div>
        
        <br />
        <br />
        
      <!--   <input type="submit" value="AltaHotel" name="name"> -->
        <button type="submit" name="name" value="AltaHotel">Crear Establecimiento</button>
    </form>
</div>
</body>
</html>