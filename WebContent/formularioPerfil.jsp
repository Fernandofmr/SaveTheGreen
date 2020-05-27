<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="modelos.Usuario" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>TOPE: Modificar perfil</title>

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

        <script src="jquery-proyecto/jquery.validate.min.js"></script>

        <script>

            $(document).ready(function(e){

                $(".logo").hide().fadeIn(1000);

                $("#contenedor_formulario").hide().fadeIn(1000);
                
                $(".nav-pills").hide().fadeIn(1000);

                $("#registro").hide().fadeIn(3000);

                $(".titulo").hide().fadeIn(3000);

                $("#registro").validate({

                    rules:{

                        
                        telefono:{
                            number:true,
                            rangelength:[9,9]
                        },
                        contrasena:{
                            
                            rangelength:[8,16]
                        },
                        confirma:{
                            equalTo:"#contrasena"
                        },
                        email2:{
                            
                            email:true,
                        },
                        edad:{
                            number:true,
                            range:[15,105]
                        },
                        

                    },

                    messages:{

                        
                        telefono:{
                            number:"debe ser un dato numérico",
                            range:"el número debe contener 9 cifras"
                        },
                        contrasena:{
                            
                            rangelength:"entre 8 y 16 caracteres"
                        },
                        confirma:{
                            equalTo:"no coincide con el campo contraseña"
                        },
                        email2:{
                            email:"el formato es erróneo",
                            
                        },
                        edad:{
                            number:"debe ser un dato numérico",
                            range:"entre 15 y 105"
                        },
                        

                    }

                });

            });
            
			function confirmaCierre2(){
       			
       			var respuesta=confirm("¿Estás seguro que deseas cerrar tu sesión?");
       			
       			if(respuesta){
       				
       				return true;
       				
       			}else{
       				
       				return false;
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

        <!--ENCABEZADO PÁGINA-->
        <a href="indexCliente.jsp" class="logo"><img src="imagenes/savethegreen/logo.PNG" width="400px" height="250px"></a>

        <div class="containerEncabezado">
            <h2> <span class="color-default">SAVE THE GREEN</span></h2>
            <p>Del campo a tu casa</p>
        </div>
        
      <!--NAVEGADOR-->
                <nav class="main-nav navbar-collapse collapse" id="primary-nav" >
                
              

                    <ul class="nav nav-pills negrita">
                    
                    <li class="dropdown"><a href="indexCliente.jsp">Inicio</a>
    
                </li>
                       
                       <li class="dropdown"><a href="<%= request.getContextPath()%>/productos">Tienda</a>

                        </li>
                        
                        <li class="dropdown"><a href="">Mi espacio personal  <img src="imagenes/styled-select-arrow.png" alt=""></a>
                            <ul class="dropdown-menu">
                                
                               <li><a href="<%= request.getContextPath() %>/productos?accion=Cesta">Cesta de la compra actual</a></li> 
                                 <li><a href="<%= request.getContextPath() %>/pedido?accion=historial">Compras anteriores</a></li>
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
            <img src="imagenes/savethegreen/paisaje1.jpg" alt="" class="fotoprin">

        </section> 
        <!-- / FIN FOTO PRINCIPAL -->
       
 <!--FIN ENCABEZADO PÁGINA-->

            <!-- FORMULARIO MODIFICAR DATOS -->

            <section class="bg-blue">    
                <div class="container">
                    <div class="heading text-center animate bounceIn informacion"> 
                    <h1 class="titulo">Modifica tus datos</h1>                  
          <div class="request-a-callback-form" style="margin-left: 25%">
           <% Usuario u = (Usuario) request.getAttribute("usuario"); %>
              <form action="<%= request.getContextPath() %>/perfil"  method="post" name="registro" id="registro">   
                    <input type="text" name="nombre" id="nombre" class="izquierda" value="<%= u.getNombre() %>" placeholder="Tu nombre">
                    <input type="text" name="apellido1" id="apellidos" class="izquierda" value="<%= u.getApellido1() %>" placeholder="Primer Apellido">
                    <input type="text" name="apellido2" id="apellidos" class="izquierda" value="<%= u.getApellido2() %>" placeholder="Segundo Apellido">
                    <input type="text" name="login" id="usuario" class="izquierda" value="<%= u.getLogin() %>" placeholder="Nombre usuario">
                    <input type="text" name="dni" id="dni" class="izquierda" value="<%= u.getDni() %>" placeholder="DNI-(12345678A)">
                    <input type="text" name="fecha_nacimiento" id="fecha_nacimiento" class="izquierda"  value="<%= u.getFechaNacimiento() %>" placeholder="Fecha de nacimiento">
                    <input type="text" name="direccion" id="direccion" class="izquierda" value="<%= u.getDireccion() %>" placeholder="Dirección">
                    <input type="text" name="ccaa" id="ccaa" class="izquierda" value="<%=u.getCcaa() %>" placeholder="Comunidad Autónoma">
                    <input type="text" name="email2" id="email2" class="izquierda" value="<%= u.getEmail() %>" placeholder="Correo electrónico">
                    <input type="text" name="telefono" id="telefono" class="izquierda" value="<%= u.getTelefono() %>" placeholder="Teléfono">
                    <input type="password" name="contrasena" id="contrasena" class="izquierda" placeholder="Contraseña" required title="Campo obligatorio">
                    <input type="password" name="confirma" id="confirma" class="izquierda" placeholder="Confirmar contraseña" required title="Campo obligatorio">
                   <br>
                   <button data-text="Modificar" class="btn btn-primary" >Modificar</button>
                </form>
            </div> 
        
        </div>
        </div>
</section>
    
        <!-- /FIN FORMULARIO REGISTRO -->
       
       
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
                            		<li><a href="<%= request.getContextPath()%>/productos">Tienda</a></li>
		                            <li><a href="carrito.jsp">Cesta de la compra</a></li>
		                            <li><a href="queEsTope.jsp">Sobre Nosotros</a></li>
		                            <li><a href="formularioContactoIniciados.jsp">Contacta</a></li><br>
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
            <div class="footer-bottom">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-sm-6"><p>Coyright © 2016 SaveTheGreen. Todos los derechos reservados.</p></div>
                        <div class="col-md-6 col-sm-6"><p class="text-center">Diseñado por <a href="#.">Proyecto Integrador</a></p></div>
                    </div>
                </div>
            </div>
        </footer>
        <!--FIN FOOTER -->
    </body>


</html>