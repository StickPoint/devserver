package com.dev.tool.common.exception;

/**
 * 基础 异常类
 *
 * @author pyj
 * @since 2021/11/15
 */
public class DevException extends RuntimeException {

    /**
     * 状态码
     */
    private final int code;

    /**
     * 构造方法
     *
     * @param code 状态码
     * @param msg  信息
     */
    public DevException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    /**
     * 构造方法
     *
     * @param code 状态码
     * @param msg  信息
     */
    public DevException(int code, String msg, Object... args) {
        super(String.format(msg, args));
        this.code = code;
    }

    /**
     * 构造方法
     *
     * @param code  状态码
     * @param msg   信息
     * @param cause 异常
     */
    public DevException(int code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    /**
     * 返回状态码
     *
     * @return 状态码
     */
    public int getCode() {
        return code;
    }

}
