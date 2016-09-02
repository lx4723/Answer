package com.answer.util;

/**
 * Created by Administrator on 2016/9/1.
 */
public class ResultUtil {
    private boolean status;
    private int code;
    private Object data;

    public static final int SUCCESS = 200;
    public static final int ERROR = 400;
    public static final String JSON = "{" +
            "'200':'操作成功'," +
            "'201':'用户没有登录'," +
            "'202':'用户名或密码不正确'," +
            "'203':'用户登录超时或未登录'," +
            "'204':'无操作权限'," +
            "'205':'提交参数不正确'," +
            "'206':'已存在'," +
            "'207':'非法访问'," +
            "'208':'图片大小不能超过1M'," +
            "'209':'原密码不正确'," +
            "'210':'邮箱不能为空'," +
            "'211':'用户被提出登录'," +
            "'212':'手机已存在'," +
            "'213':'用户不存在或已被删除'," +
            "'501':'找不到项目的默认任务'," +
            "'502':'找不到项目类型'," +
            "'503':'更新项目名称失败'," +
            "'504':'更新项目状态失败'," +
            "'400':'系统异常'" +
            "}";

    public ResultUtil(boolean status,int code,Object data) {
        this.status = status;
        this.code = code;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
