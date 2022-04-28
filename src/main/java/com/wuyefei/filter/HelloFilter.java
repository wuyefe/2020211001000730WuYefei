package com.wuyefei.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//2 way of mapping filter to serlvet
//way 1 - use web.xml
//way 2 - use WebFilter
@WebFilter(filterName = "HelloFilter",
urlPatterns = {"/hello"})
//task 1: url /hello- filter is only for one servlet - HelloServlet
//task 2: url /*- this filter of for all servlet
//task 3: url - this filter  for these 3 url only
public class HelloFilter implements Filter {// remember
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in HelloFilter-->init()");
    }

    public void destroy() {
        System.out.println("i am in HelloFilter-->destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //request come here - before go to servlet -doGet() or doPost()
        System.out.println("i am in HellowFilter-->doFilter()- before servlet -(request come here)");


        chain.doFilter(request, response);// call next filter - if no next filter - then go to servlet
        //response after servlet come back here
        System.out.println("i am in HelloFilter-->doFilter()- AFTER servlet (response come here)");
    }
}
