package com.mycomp.web;

import com.mycomp.service.AccountService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();

        // 这个东西就是spring工厂
        WebApplicationContext applicationContext =
                WebApplicationContextUtils.getWebApplicationContext(servletContext);

        // 通过spring获取service对象
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.save();
    }

}
