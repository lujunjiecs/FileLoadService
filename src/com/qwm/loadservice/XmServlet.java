package com.qwm.loadservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qiwenming
 * @date 2016/2/29 0029 上午 10:42
 * @ClassName: ${type_name}
 * @Project_Name:UploadTest
 * @Description:
 */
@WebServlet(name = "XmServlet")
public class XmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----post-------");
        response.getWriter().append("post------");
        response.getWriter().close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----get-------");
        response.getWriter().append("get------");
        response.getWriter().close();
    }
}
