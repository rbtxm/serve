package com.rbtxm.system.pojo.po;

import com.rbtxm.datasource.pojo.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@Table(name = "sso_user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    private String name;

    private String email;
}