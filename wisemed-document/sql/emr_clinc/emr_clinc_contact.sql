drop table if exists emr_clinc_contact;
create table emr_clinc_contact(
    id varchar(50) not null comment '主键',
    phoneCategory varchar(100) not null comment '联系电话-类别',
    phoneCategoryCode varchar(100) not null comment '联系电话-类别代码',
    phoneNumber varchar(100) not null comment '联系电话-号码',
    email varchar(100) not null comment '电子邮件地址',
    primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='门(急)诊病历子集通讯表';