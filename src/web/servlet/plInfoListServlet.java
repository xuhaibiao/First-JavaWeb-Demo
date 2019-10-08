package web.servlet;

import doMain.plInfo;
import service.IPlInfoService;
import service.impl.plInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 22:06 2019/9/11
 */
@WebServlet("/plInfoListServlet")
public class plInfoListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        IPlInfoService service = new plInfoServiceImpl();
        List<plInfo> plInfos = service.findAll();

        request.setAttribute("plInfos", plInfos);

        request.getRequestDispatcher("/information.jsp").forward(request,response);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

