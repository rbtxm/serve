package com.rbtxm.datasource.pojo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 9823497238749L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String createBy;

    private Timestamp createTime;

    private String updateBy;

    private Timestamp updateTime;

    private Integer status;

    private Integer isDel;

    private String remark;
}