package com.empty.prjname.comm.model;

import lombok.Data;

@Data
// public class CommonHeader extends CommonVO {
public class CommonHeader {

    // private String id; // http status code
    private String code;// system error code
    private String message;
    private String description;
}
