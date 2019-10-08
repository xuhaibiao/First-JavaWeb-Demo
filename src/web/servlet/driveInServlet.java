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
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author HaibiaoXu
 * @date Create in 23:51 2019/9/9
 */
@WebServlet("/driveInServlet")
public class driveInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String carNumber = request.getParameter("carNumberIn");
        String str = request.getParameter("id");
        int id = Integer.parseInt(str);

        plInfo car = new plInfo();

        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());

        car.setCarNumber(carNumber);
        car.setId(id);
        car.setTime(timeStamp);

        IPlInfoService service = new plInfoServiceImpl();
        service.driveIn(car);

        request.setAttribute("inResult","yes");
        request.getRequestDispatcher("/manager.jsp").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
