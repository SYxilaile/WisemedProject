-- 创建用户信息表
drop table if exists sys_user ;
create table sys_user(
    id varchar(100) not null comment '主键',
    name varchar(100) comment '姓名',
    cellphone varchar(100) not null comment '手机号码',
    password varchar(100) not null comment '登录密码，采用MD5加密',
    identity varchar(100) not null comment '身份信息：0-行政人员，1-医生，2-护士',
    status varchar(2) not null default 1 comment '系统状态：0-禁用，1-启用',
    createUser varchar(100) not null comment '创建人',
    createTime timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    updateUser varchar(100) not null comment '修改人',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
    primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='系统用户信息表';