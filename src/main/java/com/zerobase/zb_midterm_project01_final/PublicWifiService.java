package com.zerobase.zb_midterm_project01_final.services;

import com.google.gson.Gson;
import com.zerobase.zb_midterm_project01_final.dtos.DataModel;
import com.zerobase.zb_midterm_project01_final.dtos.PublicWifiDetailInfo;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublicWifiService {

    /**
     * 총 1000건씩만 요청 가능.
     * @param pageStartIdx
     * @param pageEndIdx
     * @return 실패시 null / 성공시 DataModel 넘겨줌.
     */
    public static DataModel getWifiInfo(int pageStartIdx, int pageEndIdx) {

        String apikey = "57446351466869353435574758707a";

        String url = "http://openapi.seoul.go.kr:8088/" + apikey + "/json/TbPublicWifiInfo/" + pageStartIdx + "/" + pageEndIdx;

        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request)
                    .execute(); // 동기식

            String result = response.body().string();

            Gson gson = new Gson();
            DataModel info = gson.fromJson(result, DataModel.class);
            return info;

        } catch(Exception e) {
            return null;
        }

    }

    /**
     * Db에 wifi 정보 삽입해주기.
     * @param messages
     */
    public static void insertWifiInfosDb(List<PublicWifiDetailInfo> messages){

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "INSERT INTO " +
                "public_wifi_information " +
                "(x_swifi_mgr_no, " +
                "x_swifi_main_wrdofc, " +
                "x_swifi_main_nm, " +
                "x_swifi_adres1, " +
                "x_swifi_adres2, " +
                "x_swifi_instl_floor, " +
                "x_swifi_instl_ty, " +
                "x_swifi_mby, " +
                "x_swifi_svc_se, " +
                "x_swifi_cmcwr, " +
                "x_swifi_cnstc_year, " +
                "x_swifi_inout_door, " +
                "x_swifi_remars3, " +
                "lat, " +
                "lnt," +
                " work_dttm) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:/Users/gnues/Desktop/SpringBoots/zerobases/zb_midterm_project01_final/public_wifi_service.db");
            statement = connection.prepareStatement(sql);

            for (PublicWifiDetailInfo p : messages) {
                statement.setString(1, p.getX_SWIFI_MGR_NO());
                statement.setString(2, p.getX_SWIFI_WRDOFC());
                statement.setString(3, p.getX_SWIFI_MAIN_NM());
                statement.setString(4, p.getX_SWIFI_ADRES1());
                statement.setString(5, p.getX_SWIFI_ADRES2());
                statement.setString(6, p.getX_SWIFI_INSTL_FLOOR());
                statement.setString(7, p.getX_SWIFI_INSTL_TY());
                statement.setString(8, p.getX_SWIFI_INSTL_MBY());
                statement.setString(9, p.getX_SWIFI_SVC_SE());
                statement.setString(10, p.getX_SWIFI_CMCWR());
                statement.setString(11, p.getX_SWIFI_CNSTC_YEAR());
                statement.setString(12, p.getX_SWIFI_INOUT_DOOR());
                statement.setString(13, p.getX_SWIFI_REMARS3());
                statement.setString(14, p.getLAT());
                statement.setString(15, p.getLNT());
                statement.setString(16, p.getWORK_DTTM());

                int res = statement.executeUpdate();

            }

            connection.close();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * 현재 위치를 DB에 저장함.
     * @param lat
     * @param lnt
     */
    public static void insertCurrentPositionDb(String lat, String lnt){
        System.out.println(lat);
    }
}
