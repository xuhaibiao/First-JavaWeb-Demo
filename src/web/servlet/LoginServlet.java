package web.servlet;

import doMain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.IUserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author HaibiaoXu
 * @date Create in 17:01 2019/9/8
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        User loginUser = new User();

//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);

        Map<String, String[]> map = request.getParameterMap();

        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        IUserService service = new UserServiceImpl();
        User user = service.login(loginUser);

        if (user == null) {
            //µÇÂ¼Ê§°Ü
            response.sendRedirect("login.jsp?error=yes");
        }else {
            //µÇÂ¼³É¹¦
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            request.setAttribute("username",user.getUsername());
           // response.sendRedirect("userInfoServlet");
            request.getRequestDispatcher("userInfoServlet").forward(request,response);
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
