package com.zerobase.zb_midterm_project01_final;

import com.zerobase.zb_midterm_project01_final.responsebody.DataModel;
import com.zerobase.zb_midterm_project01_final.services.PublicWifiService;
import com.zerobase.zb_midterm_project01_final.responsebody.PublicWifiDetailInfo;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static java.lang.System.out;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private int wifiCount=0;

    public void init() {
        int pageStartIdx=0;
        int pageEndIdx=999;
        while (true){
            // 1. pageNo부터 pageSize까지 만큼 api 요청
            DataModel d = PublicWifiService.getWifiInfo(pageStartIdx, pageEndIdx);

            // 2. 1번 과정이 null 아니라면, DB에 저장. 만약 null이라면 break.
            if (d!=null && d.getTbPublicWifiInfo()!=null){
                wifiCount+=d.getTbPublicWifiInfo().getRow().size(); // 개수 확인 후 더해주기
                pageStartIdx+=1000;
                pageEndIdx+=1000;
                PublicWifiService.DbInsert(d.getTbPublicWifiInfo().getRow()); // DB에 저장.
            }else{
                break;
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf8");
        request.setAttribute("wifiCount", wifiCount);
        ServletContext app = this.getServletContext();
        RequestDispatcher dispatcher = app.getRequestDispatcher("/load-wifi.jsp"); // index.jsp로 데이터 전달해주기
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            out.println(e);
        }
    }

    public void destroy() {
    }
}