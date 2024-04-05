package com.zerobase.zb_midterm_project01_final.responsebody;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Result {
    String CODE;
    String MESSAGE;

    public String getCODE() {
        return CODE;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }
}
