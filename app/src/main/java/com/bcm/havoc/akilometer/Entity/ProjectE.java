package com.bcm.havoc.akilometer.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author misolamiso.
 * @Date 2018/8/17-15:16
 */
//@Table(name = "UserEntity")
public class ProjectE implements Serializable {
    public ProjectE() {
    }

    public ProjectE(String id, String startTime, String endTime, String projectNo, String sendType, String startPosition, String endPosition, String driverNo, String phone, String carNo, String status, List<OrderE> oderEList) {
        Id = id;
        StartTime = startTime;
        EndTime = endTime;
        ProjectNo = projectNo;
        SendType = sendType;
        StartPosition = startPosition;
        EndPosition = endPosition;
        DriverNo = driverNo;
        Phone = phone;
        CarNo = carNo;
        Status = status;
        this.oderEList = oderEList;
    }

    //    @SerializedName("CODE")
//    @Expose(deserialize = true,serialize = false)
//    @Column(name = "Id", isId = true, autoGen = true)
    private String Id;
    //开始时间
    private String StartTime;
    //结束时间
    private String EndTime;

    //任务编号
    private String ProjectNo;
    //配送类型 1:全天配送 2：顺路配送
    private String SendType;
    //始发地
    private String StartPosition;
    //目的地
    private String EndPosition;
    //司机编号
    private String DriverNo;
    //联系方式
    private String Phone;
    //汽车编号
    private String CarNo;
    //任务状态
    private String Status;
    //快递list
    private List<OrderE> oderEList;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getProjectNo() {
        return ProjectNo;
    }

    public void setProjectNo(String projectNo) {
        ProjectNo = projectNo;
    }

    public String getSendType() {
        return SendType;
    }

    public void setSendType(String sendType) {
        SendType = sendType;
    }

    public String getStartPosition() {
        return StartPosition;
    }

    public void setStartPosition(String startPosition) {
        StartPosition = startPosition;
    }

    public String getEndPosition() {
        return EndPosition;
    }

    public void setEndPosition(String endPosition) {
        EndPosition = endPosition;
    }

    public String getDriverNo() {
        return DriverNo;
    }

    public void setDriverNo(String driverNo) {
        DriverNo = driverNo;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCarNo() {
        return CarNo;
    }

    public void setCarNo(String carNo) {
        CarNo = carNo;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<OrderE> getOderEList() {
        return oderEList;
    }

    public void setOderEList(List<OrderE> oderEList) {
        this.oderEList = oderEList;
    }

    @Override
    public String toString() {
        return "ProjectE{" +
                "Id='" + Id + '\'' +
                ", StartTime='" + StartTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", ProjectNo='" + ProjectNo + '\'' +
                ", SendType='" + SendType + '\'' +
                ", StartPosition='" + StartPosition + '\'' +
                ", EndPosition='" + EndPosition + '\'' +
                ", DriverNo='" + DriverNo + '\'' +
                ", Phone='" + Phone + '\'' +
                ", CarNo='" + CarNo + '\'' +
                ", Status='" + Status + '\'' +
                ", oderEList=" + oderEList +
                '}';
    }
}
