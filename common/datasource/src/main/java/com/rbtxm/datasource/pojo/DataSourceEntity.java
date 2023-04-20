package com.rbtxm.datasource.pojo;

import com.rbtxm.core.enums.DeleteStatusEnum;
import com.rbtxm.core.enums.StatusEnum;
import com.rbtxm.core.pojo.BaseEntity;
import com.rbtxm.datasource.enums.DataSourceTypeEnums;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;


/**
 * 数据源表
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月12日  10时18分23秒
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class DataSourceEntity extends BaseEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private StatusEnum status;

    private String dataSourceName;

    private DataSourceTypeEnums type;

    private String host;

    private String port;

    private String dbName;

    private String dbParam;

    private String username;

    private String password;

    private String className;
}
