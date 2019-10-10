package web.servlet;

import doMain.User;
import service.IUserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 22:43 2019/9/13
 */
@WebServlet("/userInfoServlet")
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        IUserService service = new UserServiceImpl();

        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");

        if ("user".equals(user.getRole())) {
            List<Object> info = service.getInfo(user);
            int money = service.getMoney(user);
            info.add(money);

            request.setAttribute("myInfo", info);
            request.setAttribute("username", user.getUsername());
            request.getRequestDispatcher("/myInfo.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/manager.jsp").forward(request, response);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
