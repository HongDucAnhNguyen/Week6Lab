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
        String action = req.getParameter("action");
        //if user wants to logout
        if (action != null && action.equals("logout")) {
            //invalidates session and forward back to register page
            items.clear();
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, res);
            return;
        }

        if (session.getAttribute("username") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/shoppingList.jsp").forward(req, res);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, res);
        }

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
       

        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String action = req.getParameter("action");
        String item = req.getParameter("item");
        String[] userItems = req.getParameterValues("userItems");
        
        try{
        if (action.equals("register")) {
            session.setAttribute("username", username);

        } else if (action.equals("add")) {
            items.add(item);
            session.setAttribute("itemList", items);
        }
        else if (action.equals("delete")) {
            for (int i = 0; i < userItems.length; i++) {
                for(int j = 0; j < items.size(); j++){
                    if (userItems[i].equals(items.get(j))) {
                    items.remove(j);
                    session.setAttribute("itemList", items);

                }
                }
                
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/shoppingList.jsp").forward(req, res);
        }
         catch(Exception e){
            req.setAttribute("message", "no items to delete");
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/shoppingList.jsp").forward(req, res);
        }

    }

    

}
