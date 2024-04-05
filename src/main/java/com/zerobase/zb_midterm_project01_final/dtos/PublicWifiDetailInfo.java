package com.zerobase.zb_midterm_project01_final.responsebody;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PublicWifiDetailInfo {

    String X_SWIFI_MGR_NO;
    String X_SWIFI_WRDOFC;
    String X_SWIFI_MAIN_NM;
    String X_SWIFI_ADRES1;
    String X_SWIFI_ADRES2;
    String X_SWIFI_INSTL_FLOOR;
    String X_SWIFI_INSTL_TY;
    String X_SWIFI_INSTL_MBY;
    String X_SWIFI_SVC_SE;
    String X_SWIFI_CMCWR;
    String X_SWIFI_CNSTC_YEAR;
    String X_SWIFI_INOUT_DOOR;
    String X_SWIFI_REMARS3;
    String LAT;
    String LNT;
    String WORK_DTTM;

    public String getX_SWIFI_MGR_NO() {
        return X_SWIFI_MGR_NO;
    }

    public String getX_SWIFI_WRDOFC() {
        return X_SWIFI_WRDOFC;
    }

    public String getX_SWIFI_MAIN_NM() {
        return X_SWIFI_MAIN_NM;
    }

    public String getX_SWIFI_ADRES1() {
        return X_SWIFI_ADRES1;
    }

    public String getX_SWIFI_ADRES2() {
        return X_SWIFI_ADRES2;
    }

    public String getX_SWIFI_INSTL_FLOOR() {
        return X_SWIFI_INSTL_FLOOR;
    }

    public String getX_SWIFI_INSTL_TY() {
        return X_SWIFI_INSTL_TY;
    }

    public String getX_SWIFI_INSTL_MBY() {
        return X_SWIFI_INSTL_MBY;
    }

    public String getX_SWIFI_SVC_SE() {
        return X_SWIFI_SVC_SE;
    }

    public String getX_SWIFI_CMCWR() {
        return X_SWIFI_CMCWR;
    }

    public String getX_SWIFI_CNSTC_YEAR() {
        return X_SWIFI_CNSTC_YEAR;
    }

    public String getX_SWIFI_INOUT_DOOR() {
        return X_SWIFI_INOUT_DOOR;
    }

    public String getX_SWIFI_REMARS3() {
        return X_SWIFI_REMARS3;
    }

    public String getLAT() {
        return LAT;
    }

    public String getLNT() {
        return LNT;
    }

    public String getWORK_DTTM() {
        return WORK_DTTM;
    }

    @Override
    public String toString() {
        return "PublicWifiDetailInfo{" +
                "X_SWIFI_MGR_NO='" + X_SWIFI_MGR_NO + '\'' +
                ", X_SWIFI_WRDOFC='" + X_SWIFI_WRDOFC + '\'' +
                ", X_SWIFI_MAIN_NM='" + X_SWIFI_MAIN_NM + '\'' +
                ", X_SWIFI_ADRES1='" + X_SWIFI_ADRES1 + '\'' +
                ", X_SWIFI_ADRES2='" + X_SWIFI_ADRES2 + '\'' +
                ", X_SWIFI_INSTL_FLOOR='" + X_SWIFI_INSTL_FLOOR + '\'' +
                ", X_SWIFI_INSTL_TY='" + X_SWIFI_INSTL_TY + '\'' +
                ", X_SWIFI_INSTL_MBY='" + X_SWIFI_INSTL_MBY + '\'' +
                ", X_SWIFI_SVC_SE='" + X_SWIFI_SVC_SE + '\'' +
                ", X_SWIFI_CMCWR='" + X_SWIFI_CMCWR + '\'' +
                ", X_SWIFI_CNSTC_YEAR='" + X_SWIFI_CNSTC_YEAR + '\'' +
                ", X_SWIFI_INOUT_DOOR='" + X_SWIFI_INOUT_DOOR + '\'' +
                ", X_SWIFI_REMARS3='" + X_SWIFI_REMARS3 + '\'' +
                ", LAT='" + LAT + '\'' +
                ", LNT='" + LNT + '\'' +
                ", WORK_DTTM='" + WORK_DTTM + '\'' +
                '}';
    }
}
