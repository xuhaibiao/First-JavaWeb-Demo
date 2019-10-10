package web.servlet;

import doMain.User;
import service.IUserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author HaibiaoXu
 * @date Create in 22:43 2019/9/13
 */
@WebServlet("/addMoneyServlet")
public class AddMoneyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int money = Integer.parseInt(request.getParameter("money"));

        IUserService service = new UserServiceImpl();
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");

        service.addMoney(user,money);

        request.getRequestDispatcher("/userInfoServlet").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
