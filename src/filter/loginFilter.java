package filter;

import doMain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 16:41 2019/10/7
 * @modified By
 */
@WebFilter(filterName = "loginFilter",urlPatterns = "*.jsp")
public class loginFilter implements Filter {
    private static List<String> urls = new ArrayList<>();
    static {
        urls.add("/login.jsp");
        urls.add("/register.jsp");
        urls.add("/loginServlet");
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String uri = request.getRequestURI();

        for (String url : urls) {
            if (uri.contains(url)) {
                chain.doFilter(req, resp);
                return;
            }
        }
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
        } else {
            chain.doFilter(req, resp);
        }
    }


    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
