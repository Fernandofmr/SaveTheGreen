<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modelos.DetallePedido" %>
<%@ page import="modelos.ProductoPedidoDetalle" %>
<%@ page import="java.text.DecimalFormat"%> 
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="" content="">
    <title>TOPE: factura</title>

    <!-- bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.css">

    <!-- advisor -->
    <link rel="stylesheet" href="css/advisor.css">

    <!-- plugins -->
    <link rel="stylesheet" href="css/plugins.css">	

    <!-- advisor color -->
    <link rel="stylesheet" id="color" href="css/color-default.css">

    <!-- hero slider -->
    <link rel="stylesheet" href="css/hero-slider.css">

    <!-- responsive -->
    <link rel="stylesheet" href="css/responsive.css">
    
     <script src="jquery-proyecto/jquery-3.4.1.min.js"></script>
    
  <!--   <script>
    
    $(document).ready(function(){
    	
    	alert("Su pedido se ha generado con éxito \n\n ¡GRACIAS POR CONFIAR EN TOPE!");
    	
    });
    
    </script>
--> 
</head>



<body class="fixed-header">

    <header id="header" class="inmovil">
    
    			<div>
                 <form action="">
                 <input type="button" class="imprimir" name="imprimir" value="Imprimir factura" onclick="window.print();" style="margin-left: 70%">
                 </form>
                 </div>

                 <a href="indexCliente.jsp" class="logo"><img src="imagenes/savethegreen/logo.PNG" width="400px" height="250px"></a>
                 
                 <div class="containerEncabezado" style="margin-left: 100px;">
                     <h2> <span class="color-default">SAVE THE GREEN</span></h2>
                     <p>Del campo a tu casa</p>
                 </div>
                 
        
                 
                 </header>
                 
                 <br><br><br><br>
                 
  <% DetallePedido detalle = (DetallePedido) request.getAttribute("detalle"); %>
    <% List<ProductoPedidoDetalle> productos = detalle.getProductos(); %>
                <div class="encabezadoFactura">
                    <div class="datosFactura">
                        <P><strong>DATOS EMISOR:</strong></P>
                        <p>TOPE S.L.</p>
                        <p>C/ Julián Camarillo nºX, Madrid</p>
                        <p>Actividad empresarial</p>
                        <p>971-42-17-86</p>
                        <p>www.tope.es</p>
                    </div>
                    <div class="datosFactura">
                        <P><strong>DATOS CLIENTE RECEPTOR:</strong></P>
                        <p><%= detalle.getCliente() %></p>
                        <p><%= detalle.getDireccionEnvio() %></p>
                    </div>
                    <div class="datosFactura">
                        <p><strong>PEDIDO Nº: </strong><%= detalle.getIdPedido() %></p>
                        <p><strong>FECHA: </strong><%= detalle.getFecha() %></p>
                        <p><strong>ESTADO PEDIDO: </strong><%= detalle.getEstado().toString() %></p>
                    </div>
                </div>

    
    
   <section class="bg-blue">
            <div class="container">

                <div class="col-md-6 animate fadeInLeft" >
                    <table class="tablaProductos" style="width: 200%;">
            
                <tr>
                    <th>CANTIDAD</th>
                    <th>NOMBRE</th>
                    <th>PRECIO UNITARIO</th>
                    <th>SUBTOTAL PRODUCTO</th>
                </tr>
                <% double total = 0; %>
            <% for(int i = 0; i < productos.size(); i++) { %>
            <% ProductoPedidoDetalle p = productos.get(i); %>
            
                <tr class="tamNombre">
                    <td><%= p.getUds() %></td>
                    <td>
                     <!--   <img src="<%= request.getContextPath() %>/imagenes/savethegreen/productos/<%= p.getImagen() %>" width="150" height="150" style="border-radius: 5%"> <!--saca atributo imagen del producto. Usa la ruta a partir de WebContent,que es donde nos localizamos aqui.-->
           			<%= p.getNombre() %>
                    </td>
                    
                   
                    <td><%= p.getPrecioUd() %></td>
                    <td><%= p.getPrecioUd() * p.getUds() %></td>
                    <% total += p.getPrecioUd() * p.getUds();  %>
                </tr>
                <% } %>
                 <tr class="tamNombre">
                    <td class="invisible"></td>
                    <td class="invisible"></td>
                    <td class="invisible"></td>
                    <%DecimalFormat formato = new DecimalFormat("0.00"); %>
                    <td><strong>TOTAL: <%=  formato.format(total) %></strong></td>
                </tr>
            </table>
        </div>
        </div>
    </section>
    
    <nav class="main-nav navbar-collapse">

                    <ul class="nav nav-pills">
                    
                    	<li class="menuFactura" style="font-size: 1.5em;"><a href="indexCliente.jsp">Volver al menú principal</a>
    
                		</li>
                        <li class="menuFactura" style="font-size: 1.5em;"><a href="<%= request.getContextPath() %>/Logout" onclick="confirmaCierre2()">Cerrar sesión</a>
                            
                        </li>
                        
                    </ul>

                </nav>

    <footer class="pie">
        <p>Gracias por confiar en TOPE, </p>
        <p>gracias por <em>Save the green</em></p>
            <a href="indexCliente.jsp" class="logo"><img src="imagenes/savethegreen/logo.PNG" width="130px" height="80px" style="margin-left: 50%; margin-top: -12%"></a>
    </footer>
    
</body>
</html>