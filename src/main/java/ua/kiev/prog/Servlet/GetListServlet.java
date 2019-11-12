package ua.kiev.prog.Servlet;

import ua.kiev.prog.DAO.DAO;
import ua.kiev.prog.DAO.EntityDAO;
import ua.kiev.prog.DAO.GetClientsDAO;
import ua.kiev.prog.Entity.EntityClient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet ("/GetListServlet")
public class GetListServlet extends HttpServlet {
    EntityDAO ClientsDAO = new GetClientsDAO();
    static EntityManagerFactory emf;
    public static EntityManager em;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        resp.setContentType("text/html;charset=utf-8");
        emf = Persistence.createEntityManagerFactory("JPATest");
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            try {
                List<EntityClient> clientsList = ClientsDAO.getAllClients();
                for (EntityClient ec : clientsList) {

                    long id=ec.getId();
                    req.setAttribute("id",id);

                    String name=ec.getName();
                    req.setAttribute("name",name);

                    String surname=ec.getSurname();
                    req.setAttribute("surname",surname);

                    String email=ec.getEmail();
                    req.setAttribute("email",email);

                    String phone=ec.getPhone();
                    req.setAttribute("phone",phone);

                }
                req.setAttribute("clientsList", clientsList);
                getServletContext().getRequestDispatcher("/statistics.jsp").forward(req, resp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            em.close();
            emf.close();
        }

    }

}
