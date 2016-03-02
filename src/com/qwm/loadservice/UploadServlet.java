package com.qwm.loadservice;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author qiwenming
 * @date 2016/2/29 0029 上午 10:14
 * @Project_Name:UploadTest
 * @Description: 文件上传
 */
//@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----post-------");
        doGet(request, response);
//        response.getWriter().append("post------");
//        response.getWriter().close();
    }

    /**
     * 这个方法是接受get请求的
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("---get----");
//        String path=request.getRealPath("/heads");

        String path="e:/xmwebtest";
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload sfu=new ServletFileUpload(factory);
        sfu.setHeaderEncoding("UTF-8");  //处理中文问题
        sfu.setSizeMax(10*1024*1024);   //限制文件大小
        StringBuilder sb = new StringBuilder();

        try {
            List<FileItem> fileItems= sfu.parseRequest(request);  //解码请求 得到所有表单元素
            for (FileItem fi : fileItems) {
                //有可能是 文件，也可能是普通文字
                if (fi.isFormField()) { //这个选项是 文字
                    System.out.println("表单值为："+fi.getString());
                }else{
                    // 是文件
                    String fn= System.currentTimeMillis() + fi.getName();
                    System.out.println("文件名是："+fn);  //文件名
                    // fn 是可能是这样的 c:\abc\de\tt\fish.jpg
                    fi.write(new File(path,fn));
                }
            }
            response.getWriter().append("success---");
            response.getWriter().flush();
//            response.sendRedirect("ok.html");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().append(  e.getMessage());
        }

//        showParams(request);
    }


    private void showParams(HttpServletRequest request) {
        Map map = new HashMap();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();

            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
        }

        Set<Map.Entry<String, String>> set = map.entrySet();
        System.out.println("------------------------------");
        for (Map.Entry entry : set) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("------------------------------");
    }




//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        resp.getWriter().append("ddddd------");
//        resp.getWriter().close();
//    }
//
//    public void doGet1(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        System.out.print("---get----");
//        String path=request.getRealPath("/heads");
//
//
//        DiskFileItemFactory factory=new DiskFileItemFactory();
//        ServletFileUpload sfu=new ServletFileUpload(factory);
//        sfu.setHeaderEncoding("UTF-8");  //处理中文问题
//        sfu.setSizeMax(1024*1024);   //限制文件大小
//        StringBuilder sb = new StringBuilder();
//
//        try {
//            List<FileItem> fileItems= sfu.parseRequest(request);  //解码请求 得到所有表单元素
//            for (FileItem fi : fileItems) {
//                //有可能是 文件，也可能是普通文字
//                if (fi.isFormField()) { //这个选项是 文字
//                    System.out.println("表单值为："+fi.getString());
//                }else{
//                    // 是文件
//                    String fn=fi.getName();
//                    System.out.println("文件名是："+fn);  //文件名
//                    // fn 是可能是这样的 c:\abc\de\tt\fish.jpg
//                    fi.write(new File(path,fn));
//
//                    if (fn.endsWith(".jpg")) {
//                        piclist.add(fn);  //把图片放入集合
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        //去显示上传的文件
//        request.setAttribute("pics", piclist);
//        request.getRequestDispatcher("show").forward(request, response);
//        for (int i = 0; i < piclist.size(); i++) {
//            response.getWriter().append(piclist.get(i)+"------");
//        }
//        response.getWriter().close();
//    }
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        System.out.print("---post----");
//        // fix 修改过
//        doGet(request, response);
//    }
//
//    /**
//     * Initialization of the servlet. <br>
//     *
//     * @throws ServletException if an error occurs
//     */
//    public void init() throws ServletException {
//        // Put your code here
//    }


}
