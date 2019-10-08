package web.servlet;

import doMain.User;
import service.IUserService;
import service.impl.userServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HaibiaoXu
 * @date Create in 22:00 2019/9/12
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //��ȡ�����ݲ���װ��User����
        request.setCharacterEncoding("utf-8");

        User loginUser = new User();
//        Map<String, String[]> map = request.getParameterMap();
//        try {
//            BeanUtils.populate(loginUser,map);
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
        loginUser.setUsername(request.getParameter("username"));
        loginUser.setPassword(request.getParameter("password"));
        loginUser.setRole("user");
        //����service��
        IUserService service = new userServiceImpl();
        service.register(loginUser);

        //��Ӧ
        response.sendRedirect("login.jsp?result=yes");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
