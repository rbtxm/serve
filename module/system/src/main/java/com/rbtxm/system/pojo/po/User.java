package com.rbtxm.system.pojo.po;

import com.rbtxm.datasource.pojo.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @Author: guanxiangkai
 * @Description: UserPO
 * @Data: 2023年03月31日 周五 19时29分34秒
 **/
@Data
@Entity
@Table(name = "sso_user")
public class User extends BaseEntity {

    private String name;

    private String email;
}