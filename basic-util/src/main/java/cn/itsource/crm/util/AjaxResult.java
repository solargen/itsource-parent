package cn.itsource.crm.util;

public class AjaxResult {

    private boolean success = true;
    private String message = "操作成功!";
    //状态码，如果为2则表示没有认证
    private int errorCode = 0;

    private Object resObj = null;//响应数据

    private AjaxResult() {
    }

    public static AjaxResult me(){
        return new AjaxResult();
    }

    public boolean isSuccess() {
        return success;
    }

    public AjaxResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public AjaxResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getResObj() {
        return resObj;
    }

    public AjaxResult setResObj(Object resObj) {
        this.resObj = resObj;
        return this;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
