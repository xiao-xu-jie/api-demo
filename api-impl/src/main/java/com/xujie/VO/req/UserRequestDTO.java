package com.xujie.VO.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    /**
     * 用户ID
     */
    @NotNull(message = "请传入用户ID")
    private Long userId;
    /**
     * 国家编号
     */
    @NotEmpty(message = "请输入国家编号")
    @Pattern(regexp = "^[a-zA-Z-]+$", message = "国家编号只能包含大小写英文字母和连字符(-)")
    private String countryCode;
    /**
     * 省
     */
    @NotEmpty(message = "请输入省地区")
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区、街道（可选）
     */
    private String district;
}
