package web.servlet;

import doMain.User;
import service.IPlInfoService;
import service.IUserService;
import service.impl.plInfoServiceImpl;
import service.impl.userServiceImpl;

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
@WebServlet("/payServlet")
public class payServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        IUserService userService = new userServiceImpl();
        IPlInfoService plInfoService = new plInfoServiceImpl();

        userService.pay(user);
        plInfoService.driveOut(user);

        request.getRequestDispatcher("userInfoServlet").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
