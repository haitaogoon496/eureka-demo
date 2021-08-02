package com.haitao.li.eurekademo.classes;


import java.io.Serializable;

public class ResultModel implements Serializable {
    private static final long serialVersionUID = -5892271675144714705L;
    private int ret = 0;
    private String msg = "";
    private Object data;

    public ResultModel() {
    }

    public ResultModel(Object data) {
        this.data = data;
    }

    public ResultModel(int ret, String msg) {
        this.ret = ret;
        this.msg = msg;
    }

    public ResultModel(LalaConstant.ErrorCodeEnum codeEnum) {
        this.ret = codeEnum.getCode();
        this.msg = codeEnum.getSummary();
    }

    public ResultModel(LalaConstant.ErrorCodeEnum codeEnum, String msg) {
        this.ret = codeEnum.getCode();
        this.msg = codeEnum.getSummary() + "|" + msg;
    }

    public int getRet() {
        return this.ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "ret=" + ret +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

