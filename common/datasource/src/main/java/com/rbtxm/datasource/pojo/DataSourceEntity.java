package com.rbtxm.datasource.pojo;

import com.rbtxm.datasource.enums.DataSourceTypeEnums;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 数据源表
 * @author guanxiangkai
 * @version 1.0
 * @since 2023年04月12日  10时18分23秒
 **/
@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public class DataSourceEntity extends BaseEntity  {
    @Serial
    private static final long serialVersionUID = 11L;

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
