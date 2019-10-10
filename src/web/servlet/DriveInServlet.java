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
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author HaibiaoXu
 * @date Create in 23:51 2019/9/9
 */
@WebServlet("/driveInServlet")
public class DriveInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String carNumber = request.getParameter("carNumberIn");
        String str = request.getParameter("id");
        int id = Integer.parseInt(str);

        PlInfo car = new PlInfo();

        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());

        car.setCarNumber(carNumber);
        car.setId(id);
        car.setTime(timeStamp);

        IManagerService service = new ManagerServiceImpl();
        service.driveIn(car);

        request.setAttribute("inResult","yes");
        request.getRequestDispatcher("/manager.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
