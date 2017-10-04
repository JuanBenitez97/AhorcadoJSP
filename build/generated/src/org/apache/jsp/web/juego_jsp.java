package org.apache.jsp.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class juego_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
  
    if(request.getSession().getAttribute("usuario") == null){
        getServletContext().getRequestDispatcher("/index.html").forward(request, response);
    }

    

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Aplicaciçon de Ahorcado</title>\n");
      out.write("        <link type=\"text/css\" href=\"../css/jquery-ui-1.8.1.custom.css\" rel=\"Stylesheet\" /> \n");
      out.write("        <script type=\"text/javascript\" src=\"../js/jquery-1.4.2.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/jquery-ui-1.8.1.custom.min.js\"></script> \n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("            function esta(caracter, miarray) {\n");
      out.write("        //console.log(\"buscando \", caracter, \" en \", miarray)\n");
      out.write("                for (var j = 0; j < miarray.length; j++) {\n");
      out.write("                    if (caracter == miarray[j]) {\n");
      out.write("                        return true;\n");
      out.write("                    } else {\n");
      out.write("                        //console.log(\"el caracter \", caracter, \" no es el valor del array \",miarray[j] )\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function estanTodas(arrayAciertos, mipalabra) {\n");
      out.write("                for (var i = 0; i < mipalabra.length; i++) {\n");
      out.write("                    if (!esta(mipalabra.charAt(i), arrayAciertos))\n");
      out.write("                        return false;\n");
      out.write("                }\n");
      out.write("                return true;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        ////////////////////////////////////////////////////////////////////////////////\n");
      out.write("        // PALABRAS\n");
      out.write("        ////////////////////////////////////////////////////////////////////////////////\n");
      out.write("            \n");
      out.write("            var palabraEscogida = '");
      out.print( request.getSession().getAttribute("palabra") );
      out.write("';\n");
      out.write("            var aciertos = [];\n");
      out.write("\n");
      out.write("        console.log(palabraEscogida);\n");
      out.write("\n");
      out.write("            function escribePalabra(palabra, arrayAciertos) {\n");
      out.write("                //console.log(\"estoy en escribePalabra y arrat de aciertos es: \" , arrayAciertos);\n");
      out.write("                var texto = '';\n");
      out.write("                for (var i = 0; i < palabra.length; i++) {\n");
      out.write("                    texto += \"<span>\";\n");
      out.write("                    var cActual = palabra.charAt(i);\n");
      out.write("                    if (esta(cActual, arrayAciertos)) {\n");
      out.write("                        texto += cActual;\n");
      out.write("                    } else {\n");
      out.write("                        texto += '_';\n");
      out.write("                    }\n");
      out.write("                    texto += \"</span>\";\n");
      out.write("                    //console.log(cActual)\n");
      out.write("                }\n");
      out.write("                $(\"#letras\").html(texto);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ////////////////////////////////////////////////////////////////////////////////\n");
      out.write("        //// inicio todo!!!\n");
      out.write("        ////////////////////////////////////////////////////////////////////////////////\n");
      out.write("            $(document).ready(function () {\n");
      out.write("\n");
      out.write("                //creo los botones con las letras\n");
      out.write("                var letras = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];\n");
      out.write("                for (i = 0; i < letras.length; i++) {\n");
      out.write("                    //creo el span de la letra\n");
      out.write("                    letraActual = $('<span class=\"botonletra\">' + letras[i] + '</span>');\n");
      out.write("                    letraActual.data(\"letra\", letras[i]);\n");
      out.write("                    //lo convierto en un botón\n");
      out.write("                    letraActual.button();\n");
      out.write("                    letraActual.click(function () {\n");
      out.write("                        //traigo la letra pulsada\n");
      out.write("                        var miletra = $(this).data(\"letra\")\n");
      out.write("                        //miro si esa letra está en la palabra\n");
      out.write("                        if (palabraEscogida.indexOf(miletra) != -1) {\n");
      out.write("                            //si está, va para aciertos\n");
      out.write("                            aciertos.push(miletra);\n");
      out.write("                            escribePalabra(palabraEscogida, aciertos);\n");
      out.write("                            //miro si ha ganado\n");
      out.write("                            if (estanTodas(aciertos, palabraEscogida)) {\n");
      out.write("                                var caja = $('<div class=\"dialogletra\" title=\"Has Ganado!!\">Felicidades! has adivinado la palabra!!</div>');\n");
      out.write("                                caja.dialog({\n");
      out.write("                                    modal: true,\n");
      out.write("                                    width: 600,\n");
      out.write("                                    buttons: {\n");
      out.write("                                        \"Ok\": function () {\n");
      out.write("                                            $(this).dialog(\"close\");\n");
      out.write("                                        }\n");
      out.write("                                    }\n");
      out.write("                                });\n");
      out.write("                            }\n");
      out.write("                        } else {\n");
      out.write("                            //no estaba\n");
      out.write("                            numFallos++;\n");
      out.write("                            dibujaAhorado(numFallos);\n");
      out.write("                            //miro si se ha perdido\n");
      out.write("                            if (numFallos == 6) {\n");
      out.write("                                var caja = $('<div class=\"dialogletra\" title=\"Has Perdido!!\">Lo lamento!! la palabra era: ' + palabraEscogida + '</div>');\n");
      out.write("                                caja.dialog({\n");
      out.write("                                    modal: true,\n");
      out.write("                                    width: 600,\n");
      out.write("                                    buttons: {\n");
      out.write("                                        \"Ok\": function () {\n");
      out.write("                                            $(this).dialog(\"close\");\n");
      out.write("                                        }\n");
      out.write("                                    }\n");
      out.write("                                });\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                        //una vez pulsado el botón, lo desabilito y quito su evento click\n");
      out.write("                        $(this).button(\"disable\");\n");
      out.write("                        $(this).unbind(\"click\");\n");
      out.write("\n");
      out.write("                    })\n");
      out.write("                    $(\"#botonesletras\").append(letraActual);\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                //inicio el canvas\n");
      out.write("                dibujaAhorado(numFallos);\n");
      out.write("\n");
      out.write("                //inicio las palabras\n");
      out.write("                escribePalabra(palabraEscogida, aciertos);\n");
      out.write("\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        /////////////////////////////////\n");
      out.write("        //CANVAS\n");
      out.write("        /////////////////////////////////\n");
      out.write("            function cargaContextoCanvas(idCanvas) {\n");
      out.write("                var elemento = document.getElementById(idCanvas);\n");
      out.write("                if (elemento && elemento.getContext) {\n");
      out.write("                    var contexto = elemento.getContext('2d');\n");
      out.write("                    if (contexto) {\n");
      out.write("                        return contexto;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("            function borrarCanvas(contexto, anchura, altura) {\n");
      out.write("                contexto.clearRect(0, 0, anchura, anchura);\n");
      out.write("            }\n");
      out.write("            function dibujaHorca(ctx) {\n");
      out.write("                ctx.fillStyle = '#462501';\n");
      out.write("                ctx.fillRect(64, 9, 26, 237);\n");
      out.write("                ctx.fillRect(175, 193, 26, 53);\n");
      out.write("                ctx.fillRect(64, 193, 136, 15);\n");
      out.write("                ctx.fillRect(64, 9, 115, 11);\n");
      out.write("                ctx.beginPath();\n");
      out.write("                ctx.moveTo(64, 65);\n");
      out.write("                ctx.lineTo(64, 80);\n");
      out.write("                ctx.lineTo(133, 11);\n");
      out.write("                ctx.lineTo(118, 11);\n");
      out.write("                ctx.fill();\n");
      out.write("            }\n");
      out.write("            function dibujaCabeza(ctx) {\n");
      out.write("                var img = new Image();\n");
      out.write("                img.onload = function () {\n");
      out.write("                    ctx.fillStyle = '#f2d666';\n");
      out.write("                    ctx.drawImage(img, 150, 38);\n");
      out.write("                    ctx.fillRect(172, 12, 4, 28);\n");
      out.write("                }\n");
      out.write("                img.src = 'images/picture.jpg';\n");
      out.write("            }\n");
      out.write("            function dibujaCuerpo(ctx) {\n");
      out.write("                ctx.beginPath();\n");
      out.write("                ctx.moveTo(171, 82);\n");
      out.write("                ctx.lineTo(168, 119);\n");
      out.write("                ctx.lineTo(162, 147);\n");
      out.write("                ctx.lineTo(189, 149);\n");
      out.write("                ctx.lineTo(185, 111);\n");
      out.write("                ctx.lineTo(183, 83);\n");
      out.write("                ctx.fill()\n");
      out.write("            }\n");
      out.write("            function dibujaBrazoIzq(ctx) {\n");
      out.write("                ctx.beginPath();\n");
      out.write("                ctx.moveTo(173, 102);\n");
      out.write("                ctx.lineTo(140, 128);\n");
      out.write("                ctx.lineTo(155, 133);\n");
      out.write("                ctx.lineTo(178, 114);\n");
      out.write("                ctx.fill()\n");
      out.write("            }\n");
      out.write("            function dibujaBrazoDer(ctx) {\n");
      out.write("                ctx.beginPath();\n");
      out.write("                ctx.moveTo(180, 99);\n");
      out.write("                ctx.lineTo(222, 121);\n");
      out.write("                ctx.lineTo(209, 133);\n");
      out.write("                ctx.lineTo(183, 110);\n");
      out.write("                ctx.fill()\n");
      out.write("            }\n");
      out.write("            function dibujaPiernaIzq(ctx) {\n");
      out.write("                ctx.beginPath();\n");
      out.write("                ctx.moveTo(166, 142);\n");
      out.write("                ctx.lineTo(139, 175);\n");
      out.write("                ctx.lineTo(164, 178);\n");
      out.write("                ctx.lineTo(175, 144);\n");
      out.write("                ctx.fill()\n");
      out.write("            }\n");
      out.write("            function dibujaPiernaDer(ctx) {\n");
      out.write("                ctx.beginPath();\n");
      out.write("                ctx.moveTo(178, 145);\n");
      out.write("                ctx.lineTo(193, 178);\n");
      out.write("                ctx.lineTo(212, 170);\n");
      out.write("                ctx.lineTo(188, 142);\n");
      out.write("                ctx.fill()\n");
      out.write("            }\n");
      out.write("        ////////////////////////////////////////////////////////\n");
      out.write("        // GESTION DE FALLOS\n");
      out.write("        ////////////////////////////////////////////////////////\n");
      out.write("            var numFallos = 0;\n");
      out.write("            function dibujaAhorado(numerrores) {\n");
      out.write("                var contexto = cargaContextoCanvas('canvasahorcado');\n");
      out.write("                if (contexto) {\n");
      out.write("                    dibujaHorca(contexto);\n");
      out.write("                    if (numFallos > 0) {\n");
      out.write("                        dibujaCabeza(contexto)\n");
      out.write("                    }\n");
      out.write("                    contexto.fillStyle = '#1f3e18';\n");
      out.write("                    if (numFallos > 1) {\n");
      out.write("                        dibujaCuerpo(contexto)\n");
      out.write("                    }\n");
      out.write("                    if (numFallos > 2) {\n");
      out.write("                        dibujaBrazoIzq(contexto)\n");
      out.write("                    }\n");
      out.write("                    if (numFallos > 3) {\n");
      out.write("                        dibujaBrazoDer(contexto)\n");
      out.write("                    }\n");
      out.write("                    if (numFallos > 4) {\n");
      out.write("                        dibujaPiernaIzq(contexto)\n");
      out.write("                    }\n");
      out.write("                    if (numFallos > 5) {\n");
      out.write("                        dibujaPiernaDer(contexto)\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            body{\n");
      out.write("                font-size: 0.7em;\n");
      out.write("                font-family: Trebuchet MS, verdana, arial, sans-serif;\n");
      out.write("            }\n");
      out.write("            .botonletra{\n");
      out.write("                font-size: 0.9em;\n");
      out.write("                margin: 2px;\n");
      out.write("                width: 30px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .dialogletra{\n");
      out.write("                font-size: 3em;\n");
      out.write("                text-align: center;\n");
      out.write("                padding-top: 15px;\n");
      out.write("            }\n");
      out.write("            #botonesletras{\n");
      out.write("                width: 330px;\n");
      out.write("                clear: both;\n");
      out.write("            }\n");
      out.write("            #dibujoahorcado{\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("            }\n");
      out.write("            #letras{\n");
      out.write("                font-size: 3em;\n");
      out.write("                text-align:center;\n");
      out.write("                width: 320px;\n");
      out.write("                clear: both;\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("            }\n");
      out.write("            #letras span{\n");
      out.write("                width: 30px;\n");
      out.write("                text-align:center;\n");
      out.write("                padding-left: 5px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <h1>\n");
      out.write("                ");
      out.print( request.getSession().getAttribute("palabra") );
      out.write("\n");
      out.write("            </h1>\n");
      out.write("        <div id=\"dibujoahorcado\">\n");
      out.write("            <canvas id=\"canvasahorcado\" width=\"320\" height=\"250\">\n");
      out.write("                El Ahorcado sólo funciona en navegadores que soporten Canvas. Actualízate a Firefox o Chrome, por poner dos posibilidades.\n");
      out.write("            </canvas>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"letras\">\n");
      out.write("        </div>\n");
      out.write("        <div id=\"botonesletras\"></div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
