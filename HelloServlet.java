package com.example.demo1;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")  // L'URL pour accéder à cette servlet
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Récupération des paramètres
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        // Si aucun paramètre n'est fourni, demander à l'utilisateur d'entrer ses infos
        response.getWriter().println("<html><head><title>Bonjour</title></head><body>");

        if (firstName != null && lastName != null) {
            response.getWriter().println("<h1>Bonjour, " + firstName + " " + lastName + "!</h1><hr>");
        }

        // Formulaire pour entrer son nom et prénom
        response.getWriter().println("<h2>Entrez votre nom et prénom :</h2>");
        response.getWriter().println("<form action='HelloServlet' method='GET'>");
        response.getWriter().println("Prénom: <input type='text' name='firstName' required><br><br>");
        response.getWriter().println("Nom: <input type='text' name='lastName' required><br><br>");
        response.getWriter().println("<input type='submit' value='Envoyer'>");
        response.getWriter().println("</form>");

        response.getWriter().println("</body></html>");
    }
}
