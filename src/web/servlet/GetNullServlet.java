package web.servlet;

import doMain.User;
import doMain.PlInfo;
import service.IUserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 10:29 2019/9/17
 * @modified By
 */
@WebServlet("/getNullServlet")
public class GetNullServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");

        IUserService service = new UserServiceImpl();
        List<PlInfo> plInfos = service.getNullId();
        request.setAttribute("plInfos", plInfos);
        request.setAttribute("username", user.getUsername());
        request.getRequestDispatcher("/nullId.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
