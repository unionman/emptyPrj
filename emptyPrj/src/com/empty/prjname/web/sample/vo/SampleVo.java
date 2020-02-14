package com.empty.prjname.web.sample.vo;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(/*value = "SampleVo",*/ description="샘플용 model")
public class SampleVo {

    @ApiModelProperty(value = "아이디", required = true)
    private int id;
    @ApiModelProperty(value = "이름", required = true)
    private String name;
    @ApiModelProperty(value = "나이")
    private int age;
    @ApiModelProperty(value = "지역", example="서울")
    private String contry;
    @ApiModelProperty(value = "시간", example="20200101" )
    @NotEmpty(message = "이름이 있어야 합니다.")
    private String dateTime;
    
}
