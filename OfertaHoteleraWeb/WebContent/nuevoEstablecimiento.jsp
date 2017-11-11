<!DOCTYPE html>
<html>
<head>
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
            <input type="text" id="estado" name="estado"
                   class="form-control" readonly>
        </div>
        <input id="input-b1" name="input-b1" type="file" class="file">
        <br/>
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
            <div class="checkbox">
                <label><input type="checkbox" value="">Wifi</label>
            </div>
            <div class="checkbox">
                <label><input type="checkbox" value="">Pileta climatizada</label>
            </div>
        </div>
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
        <input type="submit" value="AltaHotel" name="name">
    </form>
</div>
</body>
</html>