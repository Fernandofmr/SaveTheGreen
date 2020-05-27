<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modelos.Producto" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>TOPE: tienda</title>

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
    
    <script type="text/javascript"></script>
    
    <script>
    $(document).ready(function(){

        $(".logo").hide().fadeIn(1000);

        $(".containerEncabezado").hide().fadeIn(1000);

        $(".nav-pills").hide().fadeIn(1000);
    
    
   		function confirmaCierre(){
   			
   			var respuesta=confirm("¿Estás seguro que deseas borrar tu compra?");
   			
   			if(respuesta){
   				
   				return true;
   				
   			}else{
   				
   				return false;
   			}
   			
   		}
   		
   		function confirmaCierre2(){
   			
   			var respuesta=confirm("¿Estás seguro que deseas cerrar tu sesión?");
   			
   			if(respuesta){
   				
   				window.location.href ="<%= request.getContextPath() %>/Logout" ;
   				
   			}else{
   				
   				window.location.href="indexCliente.jsp";
   			}
   			
   		}
    
    </script>
        
    
</head>


<body class="fixed-header">

    <header id="header">

    <!-- INFORMACIÓN DE ARRIBA, BARRA AZUL -->
    <div class="top-bar clearfix">
        <p>TOPE, 25 años de experiencia	-</p>
        <ul class="icono">
            <li><img src="imagenes/savethegreen/icono-telefono.jfif" width="35px" height="35px" style="border-radius: 50%;"> Tlf. 971 29 17 56</li>
            <li><img src="imagenes/savethegreen//ubicacion2.png" width="35px" height="35px" style="border-radius: 50%;"> C/Julián Camarillo, Madrid</li>
        </ul>
    </div>
    <!-- /FIN INFORMACIÓN DE ARRIBA, BARRA AZUL -->

    <!-- ENCABEZADO PÁGINA -->
    <a href="indexCliente.jsp" class="logo"><img src="imagenes/savethegreen/logo.PNG" width="400px" height="250px"></a>

    <div class="containerEncabezado">
        <h2> <span class="color-default">SAVE THE GREEN</span></h2>
        <p>Del campo a tu casa</p>
    </div>
    <!--FIN ENCABEZADO PÁGINA -->

         
     
              
        <!--NAVEGADOR-->
        
        <nav class="main-nav navbar-collapse collapse" id="primary-nav" style="margin-top: 0%;">

            <ul class="nav nav-pills negrita">
                <li class="dropdown"><a href="indexCliente.jsp">Inicio</a>
    
                </li>
                <%int cantidad = (int) request.getAttribute("cestaCantidadProd"); %> <!-- cantidad de productos en la cesta actual -->
                <li><a href="<%= request.getContextPath() %>/productos?accion=Cesta">(<%=cantidad%>)Mi cesta</a></li>
                   <li class="dropdown"><a href="">Mi espacio personal  <img src="imagenes/styled-select-arrow.png" alt=""></a>
                            <ul class="dropdown-menu"> 
                                <li><a href="<%= request.getContextPath() %>/pedido?accion=historial">Compras anteriores</a></li>
                                <li><a href="<%= request.getContextPath() %>/perfil">Modificar perfil</a></li>
                             </ul>
                    </li>
                 	<li class="dropdown"><a href="">Contacta con nosotros  <img src="imagenes/styled-select-arrow.png" alt=""></a>
                            <ul class="dropdown-menu">
                                <li><a href="formularioContactoIniciados.jsp">Correo electrónico</a></li>
                                <li><a href="ubicacionIniciados.jsp">Dirección. ¿Cómo llegar?</a></li>
                            </ul>
                    </li>
                    <li class="dropdown"><a href="<%= request.getContextPath() %>/Logout" onclick="confirmaCierre2()">Cerrar sesión</a>
	            </ul>
            </nav>
 		<!--FIN NAVEGADOR-->
         </header> 
         
       <!-- FOTO PRINCIPAL -->
        <section class="cd-hero">
            <img src="imagenes/savethegreen/campo1.jpg" alt="" class="fotoprin">

        </section> 
        <!-- / FIN FOTO PRINCIPAL -->      
            <!--/FIN CONTENEDOR ENCABEZADO-->
			
            <!--CONTENEDOR TIENDA-->
            <section class="bg-blue" style="margin-top: -10%;">
                <div class="container">     
                	<div class="heading text-center animate bounceIn informacion"> 
                	<br><br><br><h1 class="titulo">Todos nuestros productos</h1><br><br><br>
                	<table id="carrito">
 
                    	<% List<Producto> productos = (List<Producto>) request.getAttribute("productos"); %>
                        <!--  sacar la lista de productos que guardé en el servlet para poder recorrerla -->
                       	<% for(int i = 0; i < productos.size(); i++) { 
                           	Producto p = productos.get(i);
                           
                        	 //Cada vez que la i sea divisor de 4,creamos un <tr>
                           if(i % 4 == 0) { %>  
 
                    	<tr>
                        	<%	
                    		}
                    	%>

                    	<td class="productoHover">
                        	<h2> <span class="referenciaA"><%= p.getReferenciaProducto() %> </span><br> <%= p.getNombreProducto() %></h2>
                        	<img src="<%= request.getContextPath() %>/imagenes/savethegreen/productos/<%= p.getImagen() %>" style="border-radius: 10%; width: 300px; height: 200px;">
                        	<span class="referencia"><br><%= p.getPrecioProducto() %> €/unidad</span>
                        	<div>
                        		<form method="post" action="<%= request.getContextPath() %>/productos?accion=agregar"  id="taginline" >
                            		<input type="hidden" name="idProducto" value="<%= p.getId() %>">      
                            		<input type="hidden" name="accion" value="agregar">
                            		<button data-text="+" onclick="suma()" class="btn btn-primary anadir botonTienda" type="submit" style="margin-left: -50%; font-weigth: bold; font-size: 1.5em; background-color: #D7B845;">+</button>
                       		 	</form>
                       			<form method="post" action="<%= request.getContextPath() %>/productos?accion=quitar"  id="taginline">
                            		<input type="hidden" name="idProducto" value="<%= p.getId() %>">
                            		<input type="hidden" name="accion" value="quitar">
                            		<button data-text="-" onclick="resta()" class="btn btn-primary quitar botonTienda" style="background-color: #D7B845; margin-top: -34%; margin-left: 50%; font-weigth: bold; font-size: 1.5em;">-</button>
                            		
                        		</form>
                        	</div>
                        	
                    	</td>
                    
                       	 <!--  Cada vez que la siguiente i sea divisor de 4,cerramos el tr -->
                    		<% if((i + 1) % 4 == 0) { %>   
                  		  		</tr>
                			    <% } %>
              				  <% } %>
				
               					

								<tr>
                        <td><a href="<%= request.getContextPath()%>/carrito"><input type="button" value="Finalizar compra" id="finalizar" style="margin-left: 195%;"></a></td>
                        <td>
                            <img src="imagenes/savethegreen/carrito.jfif" class="iconoCarrito" width="150px" height="150px" style="margin-left: 160%;">
                        </td>
                    </tr>

                		</table>
                	</div>
                </div>
                
</section>
<!--FIN CONTENEDOR TIENDA-->

 <!-- FOOTER -->
 <footer id="footer">
    <div class="container">
        <div class="footer-top clearfix">

            <div class="row">
                <div class="col-md-3 col-sm-3">
                    <div class="footer-logo animate fadeInLeft"><a href="index.html"><img src="imagenes/savethegreen/frutaVerdura.jpeg" style="width: 250px; height: 150px; border-radius: 5%;"></a></div>
                </div>
                <div class="col-md-9 col-sm-9">
                    <p>La vida saludable no es algo que pueda ser impuesto ni forzado. Esos pequeños pasos en auto conocimiento nos regalan una alimentación mejor, un cuerpo y mente más equilibrados y la satisfacción de estar conectado</p>
                </div>
            </div>

            <div class="height-20"></div>
            <!-- INFORMACIÓN DE CONTACTO -->

            <div class="footer-aling">
                <div class="footer-address-widget clearfix">
                    <ul>
                        <li><img src="imagenes/savethegreen/icono-telefono2.jfif" width="35px" height="35px" style="margin-right: 2%;"><strong>971 29 17 56</strong><a href="mailto:support@advisor.com">tope@savethegreen.com</a></li>
                        <li><img src="imagenes/savethegreen/icono-direccion2.jfif" width="20px" height="25px" style="margin-right: 2%;"><strong>Madrid</strong><span>C/ Julián Camarillo, Madrid</span></li>
                    </ul>
                </div>
                <div class="height-50"></div>

                <!-- LINKS RÁPIDOS -->
                <div class="col-md-6">
                    <div class="usefull-links-widget clearfix">
                        <h4>Links usados</h4>
                        <ul>
                            <li><a href="indexCliente.jsp">Inicio</a></li>
		                    <li><a href="carrito.jsp">Cesta de la compra</a></li>
		                    <li><a href="queEsTope.jsp">Sobre Nosotros</a></li>
		                    <li><a href="formularioContactoIniciados.jsp">Escríbenos</a></li>
		                    <li><a href="ubicacionIniciados.jsp">Dónde encontrarnos</a></li><br>
		                    <li><h4>Webs amigas</h4></li>
		                    <li><a href=https://www.dietistasnutricionistas.es/10-consejos-para-seguir-una-alimentacion-sostenible target="_blank">Dietas sostenibles</a></li>
		                    <li><a href=https://www.renovablesverdes.com/alimentacion-sostenible target="_blank">Renovables Verdes</a></li>
                         	 
                        </ul>
                       
                         
 
                    </div>
                </div>

                <!-- SUSCRIBIRSE -->
                <div class="footer-right">
                    <div class="newsletter-widget">
                        <h4>Para saber más</h4>
                        <p>Pase a formar parte de nuestra newsletter y le enviaremos toda la información con las últimas novedades</p>
                        <div class="form">
                            <p class="subscribe_success" id="subscribe_success" style="display:none;"></p>
                            <p class="subscribe_error" id="subscribe_error" style="display:none;"></p>

                            <form name="subscribe_form" id="subscribe_form" method="post" action="#" onSubmit="return false">
                                <input type="text" data-delay="300" placeholder="Nombre" name="subscribe_name" id="subscribe_name" onKeyPress="removeChecks();" class="input" >
                                <input type="text" data-delay="300" placeholder="Correo electrónico" name="subscribe_email" id="subscribe_email" onKeyPress="removeChecks();" class="input" >
                                <button class="btn btn-primary" name="Subscribe" type="submit" data-text="Suscribirse" onClick="validateSubscription();">Suscribirse</button>
                            </form>

                        </div>

                        <ul class="social">
                            <li class="animate bounceIn"><a href="http://www.facebook.com" class="facebook redondo" target="_blank"><img src="imagenes/savethegreen/icono_facebook.jfif" width="70px" height="70px"></a></li>
                            <li class="animate bounceIn" data-delay="100"><a href="http://www.twitter.com" class="twitter cuadrado" target="_blank"><img src="imagenes/savethegreen/icono-twitter.jfif"  width="60px" height="60px"></a></li>
                            <li class="animate bounceIn" data-delay="200"><a href="http://www.youtube.com" class="youtube redondo" target="_blank"><img src="imagenes/savethegreen/icono-youtube2.jfif" width="70px" height="70px"></a></li>
                            <li class="animate bounceIn" data-delay="300"><a href="http://www.linkedin.es" class="linkedin cuadrado" target="_blank"><img src="imagenes/savethegreen/icono-linkedin.jfif" width="60px" height="60px"></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- DERECHOS -->
    <div>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-6"><p>Coyright © 2016 SaveTheGreen. Todos los derechos reservados.</p></div>
                <div class="col-md-6 col-sm-6"><p class="text-center">Diseñado por <a href="#.">Proyecto Integrador</a></p></div>
            </div>
        </div>
    </div>
</footer>
<!--FIN FOOTER -->


            <script>

                document.getElementById("display").value=0;

                document.getElementById("display-2").value=0;

                document.getElementById("display-3").value=0;

                document.getElementById("display-4").value=0;

                document.getElementById("display-5").value=0;

                document.getElementById("display-6").value=0;

                document.getElementById("display-7").value=0;

                document.getElementById("display-8").value=0;

                document.getElementById("display-9").value=0;

                document.getElementById("display-0").value=0;

                document.getElementById("display-11").value=0;

                document.getElementById("display-12").value=0;

            </script>
   
    
</body>


</html>