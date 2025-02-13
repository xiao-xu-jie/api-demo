package com.xujie.infra.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "areas")
public class Areas {
    /**
     * 区域住建
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 国家代码
     */
    @TableField(value = "country_code")
    private String countryCode;

    /**
     * 省名称
     */
    @TableField(value = "province")
    private String province;

    /**
     * 城市名称
     */
    @TableField(value = "city")
    private String city;

    /**
     * 区（可选）
     */
    @TableField(value = "district")
    private String district;

    /**
     * 更新时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 删除标识
     */
    @TableLogic
    @TableField(value = "is_delete")
    private Integer isDelete;

    public static final String COL_ID = "id";

    public static final String COL_COUNTRY_CODE = "country_code";

    public static final String COL_PROVINCE = "province";

    public static final String COL_CITY = "city";

    public static final String COL_DISTRICT = "district";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_IS_DELETE = "is_delete";
}