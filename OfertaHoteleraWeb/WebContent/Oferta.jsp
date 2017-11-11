<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Controlador" method="get">
Crear Oferta </br>
</br>

nombre Oferta: <input type="text" name="nombreOferta" ></br></br>
hotel Nombre: <input type="text" name="nombreHotel" ></br></br>
habitacion: <input type="text" name="idHab" ></br></br>
fecha desde: <input type="text" name="fecDesde" ></br></br>
fecha hasta:  <input type="text" name="fecHasta" ></br></br>
precio: <input type="text" name="precio" ></br></br>
cupo: <input type="text" name="cupo" ></br></br>
estado: <input type="text" name="estado" ></br></br>
Politica Cancelacion: <input type="text" name="polCanc" ></br></br>

<input type="submit" value="AltaOferta" name="name">
</body>
</html>