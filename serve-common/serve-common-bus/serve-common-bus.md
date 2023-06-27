# common-core模块
#### 本模块隶属于公共模块common，主要封装了常用的一些方法，定义了常用的枚举、常量等。
## 1. 枚举
### 1.1. 状态枚举
#### 1.1.1. isStartEnum 是否启用枚举
* `NOT_ENABLED`(label:未启用 value:0)
* `ENABLED`(label:已启用 value:1)
#### 1.1.2. isDelEnum 是否删除枚举
* `NOT_DELETED`(label:未删除 value:0)
* `DELETED`(label:已删除 value:1)
#### 1.1.3. isDefaultEnum 是否默认枚举
* `NOT_DEFAULT`(label:非默认 value:0)
* `DEFAULT`(label:默认 value:1)
#### 1.1.4. isLockEnum 是否锁定枚举
* `NOT_LOCKED`(label:未锁定 value:0)
* `LOCKED`(label:已锁定 value:1)
### 1.2. 用户枚举
#### 1.2.1. 性别枚举
* `MALE`(label:男 value:1)
* `FEMALE`(label:女 value:2)
* `UNKNOWN`(label:未知 value:0)
#### 1.2.2. 用户类型枚举
* `ADMIN`(label:管理员 value:1)
* `USER`(label:普通用户 value:2)
#### 1.2.3. 用户状态枚举
* `NORMAL`(label:正常 value:1)
* `LOCKED`(label:锁定 value:2)
* `DISABLED`(label:禁用 value:3)
* `DELETED`(label:注销 value:4)
* `EXPIRED`(label:过期 value:5)
#### 1.2.4. 用户来源枚举
* `SYSTEM`(label:系统 value:1)
* `WECHAT`(label:微信 value:2)
* `QQ`(label:QQ value:3)
* `GITHUB`(label:GitHub value:5)

## 2. 常量
### 2.1. 通用常量
#### 2.1.1. 通用状态常量
## 3. 工具类
### 3.1. 通用工具类
#### 3.1.1. 通用工具类



    // 创建一个完整的core
    // 所有模块通用的配置
    // 通用的工具类
    // 通用的配置类包含（常量、枚举、异常类、返回值封装）

    //常量（请求类型,redis的key,验证码有效时间,token有效时间等）
    //常量是不可修改的一些数据
    //枚举（性别、请求状态、删除状态、状态、用户类型、用户状态、用户来源）
    //枚举是可以修改的，这里是只剩声明一些常用的枚举，具体业务的枚举在业务模块中声明
    // 性别 男1、女2、未知0
    // 删除 未删除0、已删除1
    // 状态 启用1、禁用0
    // 用户类型 管理员1、普通用户2
    // 账户状态 正常1、锁定0
    // 激活状态 未激活0、已激活1
    // 登陆方式 账号密码1、手机号2、邮箱3、微信4、QQ5、微博6
    // 是否注销 未注销0、已注销1
    // 注册方式 手机号1、邮箱2、微信3、QQ4、微博5
    // 请求状态 200成功、400失败、401未授权、403无权限、404找不到、500服务器错误
    // 日志类型 操作日志1、异常日志2
    // 请求类型 GET1、POST2、PUT3、DELETE4
    // 操作类型 新增1、修改2、删除3、查询4、导出5、导入6、上传7、下载8、授权9、其他10
    // 阅读状态 未读0、已读1
    // 点赞状态 未点赞0、已点赞1
    //异常类（）
    // 写入异常
    // 读取异常
    // 删除异常
    // 更新异常
    // 查询异常
    // 上传异常
    // 下载异常
    // 导入异常
    // 导出异常
    // 授权异常
    // 其他异常

    //返回值封装（）
    // 表格分页数据对象
    // 操作消息提醒
    // 通知消息提

    // 工具类
    // 获取bean工具类
    // 时间的工具类
    // 字符串的工具类
