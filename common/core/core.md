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
