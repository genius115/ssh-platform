package org.ssh.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Xss保护过滤器
 *
 * @author storezhang
 */
public class XssFilterJava  extends HttpServlet  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	System.out.println(filterConfig.getFilterName());
        System.out.println("Xss filter inited!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        XssHttpWrapper xssRequest = new XssHttpWrapper((HttpServletRequest) request);
        System.out.println("XssFilter:"+new Date());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Xss filter destroyed!");
    }
}
