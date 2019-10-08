package web.servlet;

import doMain.User;
import service.IUserService;
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
 * @date Create in 22:40 2019/9/13
 */
@WebServlet("/changePasswordServlet")
public class changePasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String oldPassword = request.getParameter("old");
        String newPassword = request.getParameter("new");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (!user.getPassword().equals(oldPassword)) {
            response.sendRedirect("changePassword.jsp?error=yes");
        } else {

            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(newPassword);
            session.setAttribute("user", newUser);

            IUserService service = new userServiceImpl();
            service.changePassword(newUser, newPassword);

           // response.sendRedirect("userInfoServlet");
            response.sendRedirect("userInfoServlet?result=yes");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
