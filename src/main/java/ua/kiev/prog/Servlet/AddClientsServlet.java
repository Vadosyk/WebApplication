package ua.kiev.prog.Servlet;

import ua.kiev.prog.Entity.EntityClient;
import javax.persistence.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddClientsServlet extends HttpServlet {

    static EntityManagerFactory emf;
    public static EntityManager em;
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        if (name.isEmpty() && surname.isEmpty() && email.isEmpty()
                && phone.isEmpty()) {
            resp.sendRedirect("index.jsp?correct=0");
        } else {

            try {
                emf = Persistence.createEntityManagerFactory("JPATest");
                em = emf.createEntityManager();
                try {
                    em.getTransaction().begin();
                    try {
                        EntityClient ec = new EntityClient(name, surname, email, phone);
                        em.persist(ec);
                        em.getTransaction().commit();
                    } catch (Exception ex) {
                        em.getTransaction().rollback();
                    }

                } finally {
                    em.close();
                    emf.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

}



