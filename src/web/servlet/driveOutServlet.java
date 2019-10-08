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

/**
 * @author HaibiaoXu
 * @date Create in 23:51 2019/9/9
 */
@WebServlet("/driveOutServlet")
public class driveOutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String carNumber = request.getParameter("carNumberOut");

        plInfo car = new plInfo();

        car.setCarNumber(carNumber);

        IPlInfoService service = new plInfoServiceImpl();
        service.driveOut(car);

        request.setAttribute("outResult","yes");
        request.getRequestDispatcher("/manager.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
