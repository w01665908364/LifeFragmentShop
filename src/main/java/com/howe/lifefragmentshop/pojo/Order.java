package com.howe.lifefragmentshop.pojo;

public class Order {


    private int id;//订单id
    private int fragmentId;//生命碎片id
    private int sellerId;//销方id
    private int buyerId;//购方id
    private String buyTime;//购买时间
    private String finishTime;//完成时间
    private int status;//订单状态

    //无参构造器
    public Order(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFragmentId() {
        return fragmentId;
    }

    public void setFragmentId(int fragmenId) {
        this.fragmentId = fragmenId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }




}
