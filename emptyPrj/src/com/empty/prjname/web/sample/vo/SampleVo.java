package com.empty.prjname.web.sample.vo;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SampleVo {

    @ApiModelProperty(notes = "아이디", required = true)
    private int id;
    @ApiModelProperty(notes = "이름", required = true)
    private String name;
    @ApiModelProperty(value = "나이", allowEmptyValue = false)
    private int age;
    @ApiModelProperty(value = "지역", allowEmptyValue = true)
    private String contry;
    @NotEmpty(message = "이름이 있어야 합니다.")
    private String dateTime;
    
}
