/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nguye
 */
public class ShoppingList extends HttpServlet {

    ArrayList<String> items = new ArrayList<>();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        
        if (req.getParameter("logout") != null) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, res);
            res.sendRedirect("register");
        }
        if (session != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/shoppingList.jsp").forward(req, res);
            res.sendRedirect("shoppingList");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, res);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String item = req.getParameter("item");
        session.setAttribute("username", username);
        items.add(item);
        session.setAttribute("itemList", items);

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/shoppingList.jsp").forward(req, res);

    }

}
