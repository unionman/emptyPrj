package com.empty.prjname.comm.exception;

public class CustomInterfaceException extends AbstractErrorCodeException {

    private static final long serialVersionUID = 8219904766024419444L;

    private String errorCode;
    private String response;

    @Override
    public String getCode() {
        return this.errorCode;
    }

    public void setCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getResponse() {
        return this.response;
    }

    public CustomInterfaceException(String errorCode, String[] args, String response) {
        super();
        this.errorCode = errorCode;
        this.response = response;
        this.args = args;
    }
}
