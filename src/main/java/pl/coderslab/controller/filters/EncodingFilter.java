package pl.coderslab.controller.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {

    private final String CHARSET_ENCODING = "utf-8";
    private final String CONTENT_TYPE = "text/html";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(CHARSET_ENCODING);
        resp.setContentType(CONTENT_TYPE);
        resp.setCharacterEncoding(CHARSET_ENCODING);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
