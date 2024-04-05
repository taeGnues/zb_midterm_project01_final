package com.zerobase.zb_midterm_project01_final.responsebody;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class TbPublicWifiInfo {

    int list_total_count;
    Result RESULT;
    List<PublicWifiDetailInfo> row;

    public int getList_total_count() {
        return list_total_count;
    }

    public Result getRESULT() {
        return RESULT;
    }

    public List<PublicWifiDetailInfo> getRow() {
        return row;
    }

    @Override
    public String toString() {
        return "TbPublicWifiInfo{" +
                "list_total_count=" + list_total_count +
                ", RESULT=" + RESULT +
                ", row=" + row +
                '}';
    }
}
