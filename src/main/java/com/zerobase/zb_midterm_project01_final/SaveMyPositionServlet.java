package com.zerobase.zb_midterm_project01_final;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 입력받은 x, y를 DB에 저장해주는 역할.
 */
@WebServlet(name = "saveMyPositionServlet", value = "/save-my-position-servlet")
public class SaveMyPositionServlet extends HttpServlet {

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // lat, lnt 값 가져오기
        request.setCharacterEncoding("utf8");
        String lat = request.getParameter("lat");
        String lnt = request.getParameter("lnt");
        // 요청받는 데이터를 DB에 저장함.
        PublicWifiService.insertCurrentPositionDb(lat, lnt);
    }

    public void destroy() {
    }
}