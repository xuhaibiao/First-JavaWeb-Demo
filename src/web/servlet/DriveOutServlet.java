package web.servlet;

import doMain.PlInfo;
import service.IManagerService;
import service.impl.ManagerServiceImpl;

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
public class DriveOutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String carNumber = request.getParameter("carNumberOut");

        PlInfo car = new PlInfo();

        car.setCarNumber(carNumber);

        IManagerService service = new ManagerServiceImpl();
        service.driveOut(car);

        request.setAttribute("outResult","yes");
        request.getRequestDispatcher("/manager.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
