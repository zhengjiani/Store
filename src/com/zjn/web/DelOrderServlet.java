package com.zjn.web;

import com.zjn.factory.BasicFactory;
import com.zjn.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelOrderServlet")
public class DelOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService service=BasicFactory.getFactory().getService(OrderService.class);
        //1.获取订单id
        String id=request.getParameter("id");
        //2.调用service中根据id删除订单的方法
        service.delOrderByID(id);
        //3.回到订单列表页面
        response.getWriter().write("订单删除成功");
        response.setHeader("Refresh","3;url=/OrderListServlet");
    }
}
