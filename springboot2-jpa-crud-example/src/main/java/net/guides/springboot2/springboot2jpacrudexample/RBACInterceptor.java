import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RBACInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
            throws Exception {
        String role = getUserRole(request); 
        
        if ("admin".equals(role)) {
            return true; 
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false; 
        }
    }

    private String getUserRole(HttpServletRequest request) {
        return "user";
    }
}
