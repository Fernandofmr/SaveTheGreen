<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>-->

<!DOCTYPE html>
<html lang="es">
    <head>

        <meta charset="utf-8">
         <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>Save the green</title>



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

                $(".testimonial-content").hide();

                $(".service-box p").hide();

                $(".cd-testimonials-all-wrapper img").width(180).height(200).mouseover(function(){

                    $(this).stop().animate({

                        width:"300px",
                        height:"250px",

                    },1000,function(){

                        $(".testimonial-content").fadeIn(1000);

                    });

                });

                $(".cd-testimonials-all-wrapper img").mouseout(function(){

                    $(this).stop().animate({

                        width:"180px",
                        height:"200px"

                    },1000,function(){

                        $(".testimonial.content").hide();

                    });

                });

                $("#uno img").width(150).height(120).mouseover(function(){

                    $(this).stop().animate({

                        width:"300px",
                        height:"200px"

                    },1000,function(){

                        $("#p-uno").fadeIn(1000);

                        $("#p-dos").hide();

                    });

                });

                $("#uno img").mouseout(function(){

                    $(this).stop().animate({

                        width:"150px",
                        height:"120px"

                    },1000,function(){

                        $("#p-uno").hide();

                    });

                });

                $("#dos img").width(150).height(120).mouseover(function(){

                    $(this).stop().animate({

                        width:"300px",
                        height:"200px"

                    },1000,function(){

                        $("#p-dos").fadeIn(1000);

                        $("#p-uno").hide();

                    });

                });

                $("#dos img").mouseout(function(){

                    $(this).stop().animate({

                        width:"150px",
                        height:"120px"

                    },1000,function(){

                        $("#p-dos").hide();

                    });

                });



                $("#p-uno").mouseover(function(){

                    $(".img-circle").stop().animate({

                        width:"300px",
                        height:"200px"

                    },1000,function(){

                        $("#p-uno").fadeIn();

                    });

                });

                $("#p-uno").mouseout(function(){

                    $(".img-circle").stop().animate({

                        width:"150px",
                        height:"120px"

                    },1000,function(){

                        $("#p-uno").hide();

                    });

                });

                $("#p-dos").mouseover(function(){

                    $(".img-circle").stop().animate({

                        width:"300px",
                        height:"200px"

                    },1000,function(){

                        $("#p-dos").fadeIn();

                    });

                });

                $("#p-dos").mouseout(function(){

                    $(".img-circle").stop().animate({

                        width:"150px",
                        height:"120px"

                    },1000,function(){

                        $("#p-dos").hide();

                    });

                });

                $("#mueve").mouseover(function(){

                    $(this).stop().animate({

                        marginTop:"-150px",

                    },750);

                });

                $("#mueve").mouseout(function(){

                    $(this).stop().animate({

                        marginTop:"120px",

                    },1000);

                });

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
            
	<a href="index.jsp" class="logo"><img src="imagenes/savethegreen/logo.PNG" alt=""></a>
		<div class="containerEncabezado">
        	<h2> <span class="color-default">SAVE THE GREEN</span></h2>
            <p>Del campo a tu casa</p>
        </div>
        <br><br>
        
<!--FIN CONTENEDOR ENCABEZADO-->

<!--NAVEGADOR-->

            <nav class="main-nav navbar-collapse collapse" id="primary-nav" style="margin-top: -5%;">
				<ul class="nav nav-pills negrita">
                    <li class="dropdown active"><a href="#.">Inicio</a></li>
                    <li class="dropdown"><a href="">Sobre nosotros  <img src="imagenes/styled-select-arrow.png"> </a>
                        <ul class="dropdown-menu">
                            <li><a href="queEsTope.jsp"> ¿Qué es TOPE?</a></li>
                            <li><a href="saveGreen.jsp"> ¿Por qué SAVE THE GREEN?</a></li>
                            <li><a href="proyectoInt.jsp">Proyecto Integrador</a></li>

                        </ul>
                    </li>
                    <li class="dropdown"><a href="">Servicios  <img src="imagenes/styled-select-arrow.png" alt=""></a>
                        <ul class="dropdown-menu">
                            <li><a href="inicioSesion.jsp">Iniciar sesión</a></li>
                            <li><a href="formularioRegistro.jsp">Registrarse</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="#.">Para su interés  <img src="imagenes/styled-select-arrow.png" alt=""></a>
                        <ul class="dropdown-menu">
                            <li><a href="cambioClimatico.jsp">El cambio climático,  ¿qué es?</a></li>
                            <li><a href="alimSosten.jsp"> ¿Qué significa alimentación sostenible?</a></li>
                        </ul>
                    
                    <li class="dropdown"><a href="">Contacta con nosotros  <img src="imagenes/styled-select-arrow.png" alt=""></a>
                        <ul class="dropdown-menu">
                            <li><a href="formularioContacto.jsp">Correo electrónico</a></li>
                            <li><a href="ubicacion.jsp">Dirección. ¿Cómo llegar?</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
<!--FIN NAVEGADOR-->

</header>

<!-- FOTO PRINCIPAL -->
        <section class="cd-hero">
            <img src="imagenes/savethegreen/paisaje2.jpg" alt="" class="fotoprin" width="100%" height="750px">
		</section> 
		
<!-- / FIN FOTO PRINCIPAL -->


<!-- SECCIÓN BIENVENIDO A TOPE -->
        <section class="bg-blue">
            <div class="container">
				<div class="col-md-6 animate fadeInLeft">
                    <h2>Bienvenido a TOPE</h2>
                    <h3>Tu tienda de productos ecológicos</h3>
                    <div class="height-10"></div>
                    <p>Somos una empresa familiar, con más de 15 años de experiencia, que trata de vivir la vida acorde a unos principios que creemos son beneficiosos no sólo para nosotros, sino también para la sociedad y para la salud.
                    </p>
                    <div class="height-10"></div>
                    <p>Nuestra filosofía es ofrecer y consumir productos ecológicos, cuidar el medio ambiente, potenciar el consumo de productos locales y comprar directo al productor, agricultor y ganadero cercanos.</p>
                    <div class="height-20"></div>
                    <a href="about-us.html" class="btn btn-bordered-dark" data-text="leer más">leer más</a>
                    <div class="height-40"></div>
                </div>
                <div class="col-md-6 animate fadeInRight">
                    <div class="video-widget">
                        <iframe width="560" height="315" src="https://www.youtube.com/embed/-UW2cuYflv8" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
					</div>
                </div>
			</div>
        </section>

<!-- / FIN DE SECCIÓN BIENVENIDO A TOPE -->


<!-- SECCIÓN DE BENFICIOS -->

        <section class="text-center">
            <div class="two-items-carousel owl-carousel">
                <div class="image-and-text-box animate fadeInLeft beneficios">
                    <div class="bordered-thumb"><a href=""><img src="imagenes/savethegreen/manos.jpeg" alt=""></a></div>
                    <h3><a href="services.html"> ¿Por qué confiar en TOPE?</a></h3>
                    <p>Somos una empresa familiar, con más de 25 años de experiencia, que trata de vivir la vida acorde a unos principios que creemos son beneficiosos no sólo para nosotros, sino también para la sociedad y para la salud.</p>
                </div>
                <div class="image-and-text-box animate fadeInRight beneficios">
                    <h3><a href="services.html">SAVE THE GREEN</a></h3>
                    <p> Queremos compartir nuestro proyecto con todas aquellas personas sensibles y preocupadas por el fomento de un consumo responsable, contribuyendo a preservar la biodiversidad y cuidando los recursos naturales, porque el planeta es de todos.</p>
                    <div class="bordered-thumb"><a href=""><img src="imagenes/savethegreen/ninoSoplando.jpeg" alt=""></a></div>
                </div>
                <div class="image-and-text-box beneficios">
                    <div class="bordered-thumb"><a href=""><img src="imagenes/savethegreen/acrobacia.webp" alt=""></a></div>
                    <h3><a href="services.html">Porque tu salud nos importa</a></h3>
                    <p>Nuestros productos son de alta calidad, han sido seleccionados cuidadosamente por nuestros agricultores y ganaderos, la mayoría Nacionales. Por tanto, todos nuestros productos proceden de la agricultura ecológica 100% y son respetuosos con el medio ambiente</p>
                </div>
                <div class="image-and-text-box beneficios">
                    <h3><a href="services.html">Certificados de calidad</a></h3>
                    <p>Certificación oficial en cada gama de nuestros productos.</p>
                    <div class="bordered-thumb"><a href=""><img src="imagenes/savethegreen/grupoSaltando.jpeg" alt=""></a></div>
                </div>
                <div class="image-and-text-box beneficios">
                    <h3><a href="services.html">Consultanos tus dudas</a></h3>
                    <p>Nos encanta escuchar a todo el mundo que tenga algo que aportar. Así que si buscas un producto que no tenemos en nuestra tienda online, no lo dudes, haznos llegar tu sugerencia e intentaremos conseguirlo.</p>
                    <div class="bordered-thumb"><a href="l"><img src="imagenes/savethegreen/consulta.jpeg" alt=""></a></div>
                </div>
                <div class="image-and-text-box beneficios">
                    <div class="bordered-thumb"><a href=""><img src="imagenes/savethegreen/huerta.jpeg" alt=""></a></div>
                    <h3><a href="services.html">Galería de fotos de nuestra huerta</a></h3>
                    <p>Ponemos a tu disposición productos para una vida sana y sostenible.</p>
                </div>
            </div>
        </section>
        
<!-- / FIN DE SECCIÓN BENEFICIOS -->


<!-- MENSAJE EFECTO PARALLAX -->

        <div class="fotoparallax">
            <section class="different-services text-center parallax">
                <div class="heading animate bounceIn">
                    <h1 class="color-white">Amamos lo que hacemos</h1>
                    <p class="color-white">Desde el principio, buscamos llevar nuestro compromiso de salud y sostenibilidad no solo a nuestros productos, también a nuestro entorno.</p>
                </div>

            </section>
        </div>

<!-- / FIN DE MENSAJE EFECTO PARALLAX -->


<!-- SECCIÓN CONDICIONES DE USO -->

        <section class="bg-blue" id="mueve">
            <div class="container">
                <div class="services text-center">
                    <div class="three-items-carousel owl-carousel">

                        <div class="service-box" id="c-1">
                            <img src="imagenes/color-scheme/green/icon6.png" style="margin-left: 100px; width: 100px">
                            <h4>Formas de pago</h4>
                        </div>
                        <div class="service-box" id="c-2">
                            <img src="imagenes/color-scheme/green/icon7.png" style="margin-left: 100px; width: 100px">
                            <h4>Sistema de reparto</h4>
                        </div>

                        <div class="service-box animate fadeInUp" id="c-3">
                            <img src="imagenes/color-scheme/green/icon8.png" style="margin-left: 100px; width: 100px">
                            <h4>Consultas sobre tu compra</h4>
                        </div>
                        <div class="service-box animate fadeInUp" data-delay="100" id="c-4">
                            <img src="imagenes/color-scheme/green/icon2.png" style="margin-left: 100px; width: 100px">
                            <h4>Donaciones</h4>
                        </div>
                        <div class="service-box animate fadeInUp" data-delay="200" id="c-5">
                            <img src="imagenes/color-scheme/green/icon3.png" style="margin-left: 100px; width: 100px">
                            <h4>Seguridad de pago</h4>
                        </div>
                        <div class="service-box animate fadeInUp" data-delay="200" id="c-6">
                            <img src="imagenes/color-scheme/green/icon9.png" style="margin-left: 95px; width: 100px">
                            <h4>FAQs</h4>
                        </div>

                    </div>
                </div>

<!--FIN DE SECCIÓN CONDICIONES DE USO -->

<!-- SECCIÓN  ¿QUIÉN ESTÁ DETRÁS? -->

                <div class="row">
                    <div class="col-md-6 animate fadeInLeft">
                        <ul class="image-list-classic ">
                            <li><img src="imagenes/savethegreen/naranjasCampo.jpeg" alt="" style="border-radius: 5%; width: 450px; height: 350px;"></li>
                            <li><img src="imagenes/savethegreen/tomates.jpeg" alt="" style="border-radius: 5%; width: 350px; height: 250px;"></li>
                        </ul>
                    </div>
                    <div class="col-md-6 animate fadeInRight">
                        <h3> ¿Quién está detrás de este proyecto?</h3>
                        <p>Somos una familia repleta de agricultores que se ha ido adaptando a las necesidades que la sociedad ha va requiriendo. Nuestro propósito siempre será ofrecer a nuestros clientes la mejor calidad en nuestros productos y en cada servicio que ofrecemos.</p>
                        <p>Este proyecto está compuesto a partes iguales de ilusión, descubrimiento y ganas de poner un granito de arena positivo en este mundo que va tan rápido. </p>
                        <p>Cuando un cambio se opera de verdad en nuestro interior, orientando nuestros pasos a transformar esquemas mentales adquiridos, malos hábitos y costumbres que, en definitiva, no nos aportan felicidad €¦ te encuentras con algo nuevo.</p>
                        <p>La vida saludable no es algo que pueda ser impuesto ni forzado. Esos pequeños pasos en auto conocimiento nos regalan una alimentación mejor, un cuerpo y mente más equilibrados y la satisfacción de estar conectado.</p>

                    </div>
                </div>
            </div>
        </section>

<!--FIN DE SECCIÓN  ¿QUIÉN ESTÁ DETRÁS? -->

<!-- SECCIÓN CONÓCENOS -->

        <section class="meet-our-advisors">
            <div class="container">
                <div class="heading text-center animate bounceIn">
                    <h2>Conócenos y síguenos</h2>
                    <p>Sigue al instante las novedades, promociones y noticias.</p>
                </div>

                <div class="single-item-carousel owl-carousel">
                    <div class="row">
                        <div class="col-md-5 animate fadeInLeft"><img src="imagenes/savethegreen/hombre2.webp"></div>
                        <div class="col-md-7 animate fadeInRight">
                            <div class="meet-advisors-content">
                                <h3>Ramón Cuevas<span>Agricultor ecológico y propietario de TOPE</span></h3>
                                <p>Nieto, hijo, padre y marido de una amplia familia de agricultores apasionados con su trabajo y con un gran espíritu por conseguir mejorar y hacer lo mejor por este planeta cada día.</p>
                                <p>Para que nos sigas a "TOPE"</p>
                                <ul class="social-text">
                                    <li><a href="http://www.facebook.com" class="facebook" target="_blank">facebook</a></li>
                                    <li><a href="http://www.twitter.com" class="twitter" target="_blank">twitter</a></li>
                                    <li><a href="http://www.youtube.com" class="youtube" target="_blank">youtube</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5"><img src="imagenes/savethegreen/mujer.webp" alt=""></div>
                        <div class="col-md-7">
                            <div class="meet-advisors-content">
                                <h3>Elizabeth Soto<span>Responsable del servicio de calidad</span></h3>
                                <p>Su meta es garantizar que el producto y el servicio sea coherentes y cumplan con todos los requisitos externos e internos, bajo la máxima de que "un cliente satisfecho permitirá un mundo mejor".</p>
                                <p>Para que nos sigas a "TOPE"</p>
                                <ul class="social-text">
                                    <li><a href="http://www.facebook.com" class="facebook" target="_blank">facebook</a></li>
                                    <li><a href="http://www.twitter.com" class="twitter" target="_blank">twitter</a></li>
                                    <li><a href="http://www.youtube.com" class="youtube" target="_blank">youtube</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5"><img src="imagenes/savethegreen/hombre3.jpeg" height="35%"></div>
                        <div class="col-md-7">
                            <div class="meet-advisors-content">
                                <h3>Alejandro Campos<span>Responsable de la siembra y la recogida</span></h3>
                                <p>Ofrece todo el amor que los productos necesitan para conseguir la calidad que llega a nuestras casas. Desde la selección de las mejores semillas hasta el cuidado minucioso que requieren para crecer fuertes, sanas y con los frutos más sabrosos.</p>
                                <p>Para que nos sigas a "TOPE"</p>
                                <ul class="social-text">
                                    <li><a href="http://www.facebook.com" class="facebook" target="_blank">facebook</a></li>
                                    <li><a href="http://www.twitter.com" class="twitter" target="_blank">twitter</a></li>
                                    <li><a href="http://www.youtube.com" class="youtube" target="_blank">youtube</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

<!--FIN DE SECCIÓN CONÓCENOS -->

<!-- OPINIONES DE USUARIOS -->

        <section class="bg-blue">
            <div class="container">
                <div class="heading text-center animate bounceIn">
                    <h2>Nuestros clientes opinan</h2>
                    <p>Las valoraciones que recibimos son reales y están verificadas. Son un pequeño gesto de gran valor, porque nos ayudan a seguir mejorando y a ofrecerte un servicio de mayor calidad.</p>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="testimonial animate fadeInUp" id="uno">
                            <div class="testimonial-content" id="p-uno">
                                <p>Sois un gran equipo!Enhorabuena!Ninguna queja de todos mis pedidos.</p>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="testimonials-author">
                                        <img class="img-circle" src="imagenes/savethegreen/cara.webp" alt="">
                                        <p>Mari Rodríguez</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="testimonial animate fadeInUp" data-delay="100" id="dos">
                            <div class="testimonial-content" id="p-dos">
                                <p>Muy buen servicio. Volveré a comprar.</p>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="testimonials-author">
                                        <img class="img-circle" src="imagenes/savethegreen/cara4.webp" alt="">
                                        <p>Jose García</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="text-center">
                    <a class="btn btn-bordered-dark cd-see-all iconic animate fadeInUp" data-delay="200" href="javascript:void(0);" data-text="Ver todos"><i class="icon-img-grid"></i>Ver todos</a>
                </div>
            </div>

            <div class="cd-testimonials-all">
                <div class="cd-testimonials-all-wrapper">
                    <ul>
                        <li class="cd-testimonials-item">
                            <div class="testimonial" id="tres">
                                <div class="testimonial-content">
                                    <p>Para mí vuestro servicio ha sido excelente y sin problemas.</p>

                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="testimonials-author">
                                            <img class="img-circle" src="imagenes/savethegreen/cara2.webp" alt="">
                                            <p>Carmen Fernández</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <li class="cd-testimonials-item">
                            <div class="testimonial" id="cuatro">
                                <div class="testimonial-content">
                                    <p>Servicio rápido, comunicativo y con un buen embalaje.</p>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="testimonials-author">
                                            <img class="img-circle" src="imagenes/savethegreen/cara3.webp" alt="">
                                            <p>Manuel González</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <li class="cd-testimonials-item">
                            <div class="testimonial" id="cinco">
                                <div class="testimonial-content">
                                    <p>Buenos productos a un precio competitivo y con buen servicio.</p>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="testimonials-author">
                                            <img class="img-circle" src="imagenes/savethegreen/cara5.webp" alt="">
                                            <p>Ainoa López</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <li class="cd-testimonials-item">
                            <div class="testimonial" id="seis">
                                <div class="testimonial-content">
                                    <p>Os he recomendado a familiares y amigos.</p>

                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="testimonials-author">
                                            <img class="img-circle" src="imagenes/savethegreen/cara6.webp" alt="">
                                            <p>Lidia Moreno</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <li class="cd-testimonials-item">
                            <div class="testimonial" id="siete">
                                <div class="testimonial-content">
                                    <p>Máxima profesionalidad y rigurosidad.</p>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="testimonials-author">
                                            <img class="img-circle" src="imagenes/savethegreen/cara7.webp" alt="">
                                            <p>Mohamed Sánchez</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <li class="cd-testimonials-item">
                            <div class="testimonial" id="ocho">
                                <div class="testimonial-content">
                                    <p>Porque el cuidado del medio ambiente y nuestra salud son prioritarios.</p>

                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="testimonials-author">
                                            <img class="img-circle" src="imagenes/savethegreen/cara12.webp" alt="">
                                            <p>Héctor Hernández</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <li class="cd-testimonials-item">
                            <div class="testimonial" id="nueve">
                                <div class="testimonial-content">
                                    <p>Todos mis pedidos hasta ahora de 10,no puedo hablar mejor de esta página, los envíos rápidos, buen embalaje, todo perfecto, seguiré pidiendo sin duda.</p>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="testimonials-author">
                                            <img class="img-circle" src="imagenes/savethegreen/cara9.webp" alt="">
                                            <p>Victoria Muñoz</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <li class="cd-testimonials-item">
                            <div class="testimonial" id="diez">
                                <div class="testimonial-content">
                                    <p>Tenía una duda y enseguida me dieron respuesta. Un servicio de 10.</p>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="testimonials-author">
                                            <img class="img-circle" src="imagenes/savethegreen/cara15.jpeg" alt="">
                                            <p>María Concepción Pérez</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <li class="cd-testimonials-item">
                            <div class="testimonial" id="once">
                                <div class="testimonial-content">
                                    <p>Empresa seria y responsable. Cumple más que bien. Muy recomendable.</p>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="testimonials-author">
                                            <img class="img-circle" src="imagenes/savethegreen/cara14.webp" alt="">
                                            <p>Sebastián Moreno</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <li class="cd-testimonials-item">
                            <div class="testimonial" id="doce">
                                <div class="testimonial-content">
                                    <p>Envío rápido y producto en perfectas condiciones.</p>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="testimonials-author">
                                            <img class="img-circle" src="imagenes/savethegreen/cara17.webp" alt="">
                                            <p>Aurora Blanco</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <li class="cd-testimonials-item">
                            <div class="testimonial" id="trece">
                                <div class="testimonial-content">
                                    <p>Muy buena respuesta, rápida y eficiente.</p>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="testimonials-author">
                                            <img class="img-circle" src="imagenes/savethegreen/hombre.webp" alt="">
                                            <p>Rodrigo Delgado</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <li class="cd-testimonials-item">
                            <div class="testimonial" id="catorce">
                                <div class="testimonial-content">
                                    <p>Me ha encantado el servicio de atención al cliente, además de la calidad de los productos.</p>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="testimonials-author">
                                            <img class="img-circle" src="imagenes/savethegreen/cara18.webp" alt="">
                                            <p>Alfonso Jiménez</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>

                <a href="javascript:void(0);" class="close-btn">Close</a>

            </div>

        </section>
        
<!-- / FIN DE OPINIONES DE USUARIOS -->

<!--SECCIÓN ENVIAR OPINIÓN -->

        <section>
            <div class="request-a-callback clearfix animate fadeInUp">
                <div class="request-a-callback-content">
                    <h3>Envíanos tu opinión</h3>
                    <p>Nos encanta escuchar a todo el mundo que tenga algo que aportar. Así que si buscas un producto que no tenemos en nuestra tienda online, no lo dudes, haznos llegar tu sugerencia e intentaremos conseguirlo.</p>
				</div>
                <div class="request-a-callback-form">
                    <form>
                        <input type="text" placeholder="Tu nombre">
                        <input type="text" placeholder="Correo electrónico">
                        <input type="text" placeholder="Número de teléfono">
                        <div class="styled-select">
                            <select>
                                <option>Quiero dar mi opinión a:</option>
                                <option>Personal de la empresa</option>
                                <option>Reparto</option>
                                <option>Calidad</option>
                                <option>Otros</option>
                            </select>
                        </div>
                        <button data-text="Enviar" class="btn btn-primary">Enviar</button>
                    </form>
                </div>
            </div>
        </section>

<!-- / FIN DE SECCIÓN ENVIAR OPINIÓN -->

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
                                    <li><a href="index.html">Inicio</a></li>
                                    <li><a href="queEsTope.jsp">Sobre Nosotros</a></li>
                                    <li><a href="formularioRegistro.jsp">Inicia Sesión</a></li>
                                    <li><a href="cambioClimatico.jsp">Para su interés</a></li>
                                    <li><a href="formularioContacto.jsp">Contacta</a></li>
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




<!-- FOOTER SCRIPTS
================================================== -->
        <script src="js/jquery-2.2.0.js"></script>
        <script src="js/smooth-scroll.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/counter.js"></script>
        <script src="js/common.js"></script>
        <script src="js/scripts.js"></script>
        <script src="js/hero-slider.js"></script>


        <!-- DEMO -->
        <!--<script src="demo-files/js/jquery.cookie.js"></script>-->
        <!--<script src="demo-files/js/switcher.js"></script>-->


    </body>
</html>