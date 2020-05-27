<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>TOPE: Ubicación</title>
        <!-- Favicons
================================================== -->
        <link rel="icon" type="image/png" href="images/favicon.png">


        <!-- Fonts
================================================== -->
        <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700%7COpen+Sans:400,300,600,700' rel='stylesheet' type='text/css'>

        <!-- CSS
================================================== -->

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


        <!-- HEADER SCRIPTS

================================================== -->
        <script src="js/modernizr.js"></script>

        <script src="jquery-proyecto/jquery-3.4.1.min.js"></script>


        <script>

            $(document).ready(function(){

                $(".logo").hide().fadeIn(1000);

                $(".containerEncabezado").hide().fadeIn(1000);

                $(".nav-pills").hide().fadeIn(1000);

                $(".service-box p").hide();

                $("#contenedor_formulario").hide().fadeIn(1000);

                $("#registro").hide().fadeIn(3000);

                $(".titulo").hide().fadeIn(3000);



            });

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
            <!-- /FIN INFORMACIÓ“N DE ARRIBA, BARRA AZUL -->

            <!--CONTENEDOR ENCABEZADO-->
            <a href="indexCliente.jsp" class="logo"><img src="imagenes/savethegreen/logo.PNG" alt=""></a>

            
            <div class="containerEncabezado">
                <h2> <span class="color-default">SAVE THE GREEN</span></h2>
                <p>Del campo a tu casa</p>
            </div>
            <br><br>
            <!--FIN CONTENEDOR ENCABEZADO-->

           <!--NAVEGADOR-->
                <nav class="main-nav navbar-collapse collapse" id="primary-nav" style="margin-top: 2%;">

                    <ul class="nav nav-pills negrita">
                    <li class="dropdown"><a href="indexCliente.jsp"><strong>Inicio</strong></a>
    
                		</li>
                       
                       <li class="dropdown"><a href="<%= request.getContextPath()%>/productos">Tienda</a>

                        </li>
                        
                          <li class="dropdown"><a href="">Mi espacio personal  <img src="imagenes/styled-select-arrow.png" alt=""></a>
                            <ul class="dropdown-menu">
                                
                               <li><a href="<%= request.getContextPath() %>/productos?accion=Cesta">Cesta de la compra</a></li> 
                                 <li><a href="<%= request.getContextPath() %>/pedido?accion=historial">Compras anteriores</a></li>
                                <li><a href="<%= request.getContextPath() %>/perfil">Modificar perfil</a></li>
                            </ul>
                        </li>
                        
                        <li class="dropdown"><a href="">Contacta con nosotros  <img src="imagenes/styled-select-arrow.png" alt=""></a>
                            <ul class="dropdown-menu">
                                <li><a href="formularioContactoIniciados.jsp">Correo electrónico</a></li>
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
        <br>
        <!-- / FIN FOTO PRINCIPAL -->



        <!-- UBICACION-->
      
        <section class="bg-blue">
            <div class="container">

                <div class="col-md-6 animate fadeInLeft">
                    <h2 class="color-default">DÓNDE ENCONTRARNOS</h2>
<br><br>
                    <div class="height-10"></div>
                    <p>Puedes visitar nuestras instalaciones y conocer de primera mano quienes sómos y nuestro amor por lo que hacemos.
                    </p>
                    <div class="height-10"></div>
                    <p>Nuestra filosofía es ofrecer y consumir productos ecológicos, cuidar el medio ambiente, potenciar el consumo de productos locales y comprar directo al productor, agricultor y ganadero cercanos.</p>
                    <div class="height-20"></div>

                    <div class="height-40"></div>
                </div>
                <div class="col-md-6 animate fadeInRight">
                    <div class="video-widget">
                        <iframe  src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3036.775224089281!2d-3.6264331852760483!3d40.4359758793629!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd422f0b28f812d5%3A0x3fc63330503ea6a7!2sCalle%20de%20Julian%20Camarillo%2C%20Madrid!5e0!3m2!1ses!2ses!4v1585980546193!5m2!1ses!2ses" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>

                    </div>
                </div>

            </div>
        </section>


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

                        <!-- LINKS RÃPIDOS -->
                        <div class="col-md-6">
                            <div class="usefull-links-widget clearfix">
                                <h4>Links usados</h4>
                                <ul>
                                   <li><a href="indexCliente.jsp">Inicio</a></li>
                            		<li><a href="<%= request.getContextPath()%>/productos">Tienda</a></li>
		                            <li><a href="carrito.jsp">Cesta de la compra</a></li>
		                            <li><a href="queEsTope.jsp">Sobre Nosotros</a></li>
		                            <li><a href="formularioContactoIniciados.jsp">Escríbenos</a></li>
		                            <br>
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
                        <div class="col-md-6 col-sm-6"><p>Coyright  © 2016 SaveTheGreen. Todos los derechos reservados.</p></div>
                        <div class="col-md-6 col-sm-6"><p class="text-center">Diseñado por <a href="#.">Proyecto Integrador</a></p></div>
                    </div>
                </div>
            </div>
        </footer>
        <!--FIN FOOTER -->


    </body>


</html>