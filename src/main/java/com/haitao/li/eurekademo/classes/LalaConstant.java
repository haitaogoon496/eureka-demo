package com.haitao.li.eurekademo.classes;


public interface LalaConstant {
    public interface CommonConstant {
        String LALA_PACKAGE = "cn.huolala.framework";
        String LALA_CHARSET = "UTF-8";
        String METHOD_POST = "POST";
        int RESULT_SUCCESS = 0;
        int HTTP_PORT = 8080;
        int RPC_PORT = 20881;
        int MONITOR_PORT = 40110;
        int PROCESSORS = Runtime.getRuntime().availableProcessors();
    }

    public interface ParamEnum{
       String HLANG = "hlang";
       String HTZONE = "htzone";
       String HCOUNTRY = "hcountry";
       String FROM = "from";
    }
    public static enum ErrorCodeEnum {
        S_FAIL("系统内部错误", 100),
        PARAM_FAIL("参数错误", 100),
        SYSTEM_BUSY("系统繁忙", 1),
        SESSION_INVALID("登录会话失效", 2),
        FORBIDDEN("没有操作权限", 3),
        PARAM_ERROR("请求路径无效", 404),
        JSON_INVALID("JSON转换异常", 5),
        LIMIT_IP("IP被限制访问", 6),
        SYSTEM_TIMEOUT("系统超时", 7),
        HEAET_BEAT("HeatBeat", 100),
        RPC_CLIENT_FAIL("RPC_Client异常", 400),
        RPC_SERVER_FAIL("RPC_SERVER异常", 500);

        private String summary;
        private int code;

        private ErrorCodeEnum(String summary, int code) {
            this.summary = summary;
            this.code = code;
        }

        public String getSummary() {
            return this.summary;
        }

        public int getCode() {
            return this.code;
        }
    }
}