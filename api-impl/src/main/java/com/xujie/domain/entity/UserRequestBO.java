package com.xujie.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestBO {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 国家编号
     */
    private String countryCode;
    /**
     * 省
     */
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
