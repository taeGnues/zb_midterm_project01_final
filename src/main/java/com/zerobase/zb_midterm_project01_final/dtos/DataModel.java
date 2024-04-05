package com.zerobase.zb_midterm_project01_final.responsebody;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class DataModel {
    TbPublicWifiInfo TbPublicWifiInfo;

    public TbPublicWifiInfo getTbPublicWifiInfo() {
        return TbPublicWifiInfo;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "TbPublicWifiInfo=" + TbPublicWifiInfo +
                '}';
    }
}
