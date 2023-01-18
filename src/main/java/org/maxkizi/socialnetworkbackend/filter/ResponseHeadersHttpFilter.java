package org.maxkizi.socialnetworkbackend.filter;

import org.springframework.http.HttpHeaders;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/api/v1/*")
public class ResponseHeadersHttpFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader(
                HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // ...
    }

    @Override
    public void destroy() {
        // ...
    }
}
