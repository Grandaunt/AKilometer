package com.bcm.havoc.akilometer.Entity;

import java.io.Serializable;

/**
 * @Author misolamiso.
 * @Date 2018/8/17-15:16
 */
//@Table(name = "UserEntity")
public class OrderE implements Serializable {
    public OrderE() {
    }

    public OrderE(String id, String orderId, String photo, String status) {
        Id = id;
        OrderId = orderId;
        Photo = photo;
        Status = status;
    }

    //    @SerializedName("CODE")
//    @Expose(deserialize = true,serialize = false)
//    @Column(name = "Id", isId = true, autoGen = true)
    private String Id;


    //快递单编号
   private String OrderId;
//    //始发地
//    private String StartPosition;
//    //目的地
//    private String EndPosition;
//    //身份证
//    private String IdCard;
//    //开户银行
//    private String Bank;
//    //银行账号
//    private String BankAccount;
//    //邀请人
//    private String Inviter;
    //图片
    private String Photo;
    //快递单状态，0未上传，1是待上传，2是已上传
    private String Status;

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String OrderId) {
        OrderId = OrderId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "OrderE{" +
                "Id='" + Id + '\'' +
                ", OrderId='" + OrderId + '\'' +
                ", Photo='" + Photo + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
