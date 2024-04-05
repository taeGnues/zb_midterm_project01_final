<%@ page import="com.zerobase.zb_midterm_project01_final.PublicWifiService" %>
<%@ page import="com.zerobase.zb_midterm_project01_final.dtos.DataModel" %>
<%@ page import="com.zerobase.zb_midterm_project01_final.dtos.PublicWifiDetailInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zerobase.zb_midterm_project01_final.dtos.LocalPublicWifiDetailInfo" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>서울시 주변 공공 와이파이 조회 서비스</title>
    <style>
        table {
            width: 100%;
            border: black solid 1px;
        }
        td{
            text-align: center;
            height: 30px;
        }
        th{
            padding: 10px;
            color: white;
            background-color: lightseagreen;
        }
        .menus{
            display: inline;
            margin-top: 10px;
            margin-bottom: 10px;
            font-size: 10px;
        }
    </style>
</head>
<body>
<br/>
<h1>
    와이파이 정보 구하기
</h1>
<a class="menus" href="#">홈</a>
<p class="menus"> | </p>
<a class="menus" href="#">위치 히스토리 목록</a>
<p class="menus"> | </p>
<a class="menus" href="save-wifi-servlet">Open API 와이파이 정보 가져오기</a>

<form method="get" action="load-local-wifi-servlet" style="margin-bottom: 10px;">
    LAT :
    <input id="myposition-lat" name="my_lat"/>
    , LNT :
    <input id="myposition-lnt" name="my_lnt"/>
    <button type="button" id="myposition-get">내 위치 가져오기</button>
    <input type="submit" id="localwifiinfo-get" value="근처 WIFI 정보 보기"/>
</form>

<table>
    <thead>
        <tr>
            <th>거리(km)</th>
            <th>관리번호</th>
            <th>자치구</th>
            <th>와이파이명</th>
            <th>도로명주소</th>
            <th>상세주소</th>
            <th>설치위치(층)</th>
            <th>설치유형</th>
            <th>설치기관</th>
            <th>서비스구분</th>
            <th>망종류</th>
            <th>설치년도</th>
            <th>실내외구분</th>
            <th>WIFI접속환경</th>
            <th>X좌표</th>
            <th>Y좌표</th>
            <th>작업일자</th>
        </tr>
    </thead>
    <tbody>

            <% Object o = request.getAttribute("messages"); %>
            <% if (o==null){ %>
            <td colspan="17" style="height: 60px; font-size: 20px; text-align: center; font-weight: bold;"> 위치 정보를 입력한 후에 조회해 주세요 </td>
            <% } %>
            <%
                if (o!=null) {
                    List<LocalPublicWifiDetailInfo> messages = (List<LocalPublicWifiDetailInfo>) o;
                    for (LocalPublicWifiDetailInfo p : messages) {
                        out.write("<tr>");
                        out.write("<td>" + p.getWIFI_DISTANCE() + "</td>");
                        out.write("<td>" + p.getX_SWIFI_MGR_NO() + "</td>");
                        out.write("<td>" + p.getX_SWIFI_WRDOFC() + "</td>");
                        out.write("<td>" + p.getX_SWIFI_MAIN_NM() + "</td>");
                        out.write("<td>" + p.getX_SWIFI_ADRES1() + "</td>");
                        out.write("<td>" + p.getX_SWIFI_ADRES2() + "</td>");
                        out.write("<td>" + p.getX_SWIFI_INSTL_FLOOR() + "</td>");
                        out.write("<td>" + p.getX_SWIFI_INSTL_TY() + "</td>");
                        out.write("<td>" + p.getX_SWIFI_INSTL_MBY() + "</td>");
                        out.write("<td>" + p.getX_SWIFI_SVC_SE() + "</td>");
                        out.write("<td>" + p.getX_SWIFI_CMCWR() + "</td>");
                        out.write("<td>" + p.getX_SWIFI_CNSTC_YEAR() + "</td>");
                        out.write("<td>" + p.getX_SWIFI_INOUT_DOOR() + "</td>");
                        out.write("<td>" + p.getX_SWIFI_REMARS3() + "</td>");
                        out.write("<td>" + p.getLAT() + "</td>");
                        out.write("<td>" + p.getLNT() + "</td>");
                        out.write("<td>" + p.getWORK_DTTM() + "</td>");
                        out.write("</tr>");
                    }
                }
            %>

    </tbody>
</table>

</body>

<script src="./js/jquery-3.7.1.min.js"></script>
<script>
    $(document).ready(function() { // 내 위치를 가져오고, Servlet에 해당 위치를 DB에 저장하도록 요청함.
        function getMyPosition() {
            window.navigator.geolocation.getCurrentPosition(
                function(p) {
                    var lat = p.coords.latitude;
                    var lnt = p.coords.longitude;
                    $('#myposition-lat').val(lat);
                    $('#myposition-lnt').val(lnt);

                    // Servlet에 POST요청을 통해 DB에 저장.
                    // DB에 lat, lnt를 저장함.
                    $.ajax({
                        type: "POST",
                        url :"./save-my-position-servlet",
                        data: {lat:lat, lnt:lnt}
                    });
                },
                function(e) {
                    console.log(e.code);
                }
            );
        }

        $('#myposition-get').on('click', getMyPosition);
    });
</script>
</html>