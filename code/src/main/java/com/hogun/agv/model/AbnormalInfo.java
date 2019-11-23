package com.hogun.agv.model;

import java.sql.Date;

public class AbnormalInfo {
    private int Agv_id;
    private String statusInfo;  //异常状态
    private int  rfidNo;    //rfid
    private String occurTime; //发生时间

    public int getAgv_id() {
        return Agv_id;
    }

    public void setAgv_id(int agv_id) {
        Agv_id = agv_id;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public int getRfidNo() {
        return rfidNo;
    }

    public void setRfidNo(int rfidNo) {
        this.rfidNo = rfidNo;
    }

    public String getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(String occurTime) {
        this.occurTime = occurTime;
    }
}
