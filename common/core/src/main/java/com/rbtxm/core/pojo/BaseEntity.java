package com.rbtxm.core.pojo;

import com.rbtxm.core.enums.DeleteStatusEnum;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月20日  13时21分47秒
 **/
@Getter
public class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String createBy;

    private Timestamp createTime;

    private String updateBy;

    private Timestamp updateTime;

    private DeleteStatusEnum deleteStatus;
}
