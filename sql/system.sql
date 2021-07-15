/**
  * SQL
  * @author QianLinGooo
  * create in 2021/07/15
 */

create table if not exists sys_dict
(
    id          varchar(32)                        not null comment '编号'
        primary key,
    dict_name   varchar(100)                       not null comment '字典名称',
    dict_code   varchar(100)                       not null comment '字典编码',
    description varchar(255)                       null comment '描述',
    del_flag    int                                null comment '删除状态',
    create_by   varchar(32)                        null comment '创建人',
    create_time datetime                           null comment '创建时间',
    update_by   varchar(32)                        null comment '更新人',
    update_time datetime                           null comment '更新时间',
    type        int(1) unsigned zerofill default 0 null comment '字典类型0为string,1为number',
    constraint indextable_dict_code
        unique (dict_code),
    constraint uk_sd_dict_code
        unique (dict_code)
)
    comment '字典表' charset = utf8;

create table if not exists sys_dict_item
(
    id          varchar(32)  not null comment '编号'
        primary key,
    dict_id     varchar(32)  null comment '字典id',
    item_text   varchar(100) not null comment '字典项文本',
    item_value  varchar(100) not null comment '字典项值',
    description varchar(255) null comment '描述',
    sort_order  int          null comment '排序',
    status      int          null comment '状态（1启用 0不启用）',
    create_by   varchar(32)  null,
    create_time datetime     null,
    update_by   varchar(32)  null,
    update_time datetime     null
)
    comment '字典项数据表' charset = utf8;

create index idx_sdi_dict_val
    on sys_dict_item (dict_id, item_value);

create index idx_sdi_role_dict_id
    on sys_dict_item (dict_id);

create index idx_sdi_role_sort_order
    on sys_dict_item (sort_order);

create index idx_sdi_status
    on sys_dict_item (status);

create index index_table_dict_id
    on sys_dict_item (dict_id);

create index index_table_dict_status
    on sys_dict_item (status);

create index index_table_sort_order
    on sys_dict_item (sort_order);

create table if not exists sys_permission
(
    id                   varchar(36)             not null comment '主键id'
        primary key,
    parent_id            varchar(32)             null comment '父id',
    name                 varchar(100)            null comment '菜单标题',
    url                  varchar(255)            null comment '路径',
    component            varchar(255)            null comment '组件',
    component_name       varchar(100)            null comment '组件名字',
    redirect             varchar(255)            null comment '一级菜单跳转地址',
    menu_type            int                     null comment '菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)',
    perms                varchar(255)            null comment '菜单权限编码',
    perms_type           varchar(10) default '0' null comment '权限策略1显示2禁用',
    sort_no              double(8, 2)            null comment '菜单排序',
    always_show          tinyint(1)              null comment '聚合子路由: 1是0否',
    icon                 varchar(100)            null comment '菜单图标',
    is_route             tinyint(1)  default 1   null comment '是否路由菜单: 0:不是  1:是（默认值1）',
    is_leaf              tinyint(1)              null comment '是否叶子节点:    1:是   0:不是',
    keep_alive           tinyint(1)              null comment '是否缓存该页面:    1:是   0:不是',
    hidden               int         default 0   null comment '是否隐藏路由: 0否,1是',
    description          varchar(255)            null comment '描述',
    create_by            varchar(36)             null comment '创建人',
    create_time          datetime                null comment '创建时间',
    update_by            varchar(36)             null comment '更新人',
    update_time          datetime                null comment '更新时间',
    del_flag             int         default 0   null comment '删除状态 0正常 1已删除',
    rule_flag            int         default 0   null comment '是否添加数据权限1是0否',
    status               varchar(2)              null comment '按钮权限状态(0无效1有效)',
    internal_or_external tinyint(1)              null comment '外链菜单打开方式 0/内部打开 1/外部打开'
)
    comment '菜单权限表' charset = utf8;

create index idx_sp_del_flag
    on sys_permission (del_flag);

create index idx_sp_hidden
    on sys_permission (hidden);

create index idx_sp_is_leaf
    on sys_permission (is_leaf);

create index idx_sp_is_route
    on sys_permission (is_route);

create index idx_sp_menu_type
    on sys_permission (menu_type);

create index idx_sp_parent_id
    on sys_permission (parent_id);

create index idx_sp_sort_no
    on sys_permission (sort_no);

create index idx_sp_status
    on sys_permission (status);

create index index_menu_hidden
    on sys_permission (hidden);

create index index_menu_status
    on sys_permission (status);

create index index_menu_type
    on sys_permission (menu_type);

create index index_prem_del_flag
    on sys_permission (del_flag);

create index index_prem_is_leaf
    on sys_permission (is_leaf);

create index index_prem_is_route
    on sys_permission (is_route);

create index index_prem_pid
    on sys_permission (parent_id);

create index index_prem_sort_no
    on sys_permission (sort_no);

create table if not exists sys_project
(
    id                varchar(36)      not null comment '编号'
        primary key,
    project_team_id   varchar(36)      null comment '项目组编号',
    project_name      varchar(500)     null comment '项目名称',
    create_by         varchar(32)      null comment '创建人',
    create_time       datetime         null comment '创建时间',
    update_by         varchar(32)      null comment '更新人',
    update_time       datetime         null comment '更新时间',
    if_query_local_db int(1) default 1 not null comment '是否查询部署项目所属数据源(0:按用户填写的数据源进行信息获取,1:按项目部署所属数据源进行信息获取)',
    status            int    default 1 not null comment '状态(0:禁用,1:启用)'
)
    comment '项目表' charset = utf8;

create index index_project_group_name
    on sys_project (project_team_id);

create index index_project_name
    on sys_project (project_name);

create table if not exists sys_project_datasource
(
    id          varchar(36)               not null comment '编号'
        primary key,
    project_id  varchar(36)               not null comment '项目表编号',
    url         text                      not null comment '数据源URL',
    username    varchar(500) charset utf8 not null comment '数据源用户名',
    password    varchar(500) charset utf8 not null comment '数据源密码',
    driver_name varchar(36) charset utf8  not null comment '数据源驱动,从字典表取值',
    create_by   varchar(32) charset utf8  null comment '创建人',
    create_time datetime                  null comment '创建时间',
    update_by   varchar(32) charset utf8  null comment '更新人',
    update_time datetime                  null comment '更新时间',
    status      int default 1             not null comment '状态(0:禁用,1:启用)'
)
    comment '项目数据源表';

create table if not exists sys_role
(
    id              varchar(36)  not null comment '主键id'
        primary key,
    role_name       varchar(200) null comment '角色名称',
    role_code       varchar(100) not null comment '角色编码',
    description     varchar(255) null comment '描述',
    create_by       varchar(32)  null comment '创建人',
    create_time     datetime     null comment '创建时间',
    update_by       varchar(32)  null comment '更新人',
    update_time     datetime     null comment '更新时间',
    project_team_id varchar(64)  null comment '项目组编号',
    status          int          null comment '状态',
    constraint uniq_sys_role_role_code
        unique (role_code)
)
    comment '角色表' charset = utf8;

create index idx_sr_role_code
    on sys_role (role_code);

create table if not exists sys_role_permission
(
    id            varchar(36) not null
        primary key,
    role_id       varchar(36) null comment '角色id',
    permission_id varchar(36) null comment '权限id',
    create_by     varchar(36) null comment '创建人',
    create_time   datetime    null comment '操作时间'
)
    comment '角色权限表' charset = utf8;

create index idx_srp_permission_id
    on sys_role_permission (permission_id);

create index idx_srp_role_id
    on sys_role_permission (role_id);

create index idx_srp_role_per_id
    on sys_role_permission (role_id, permission_id);

create index index_group_per_id
    on sys_role_permission (permission_id);

create index index_group_role_id
    on sys_role_permission (role_id);

create index index_group_role_per_id
    on sys_role_permission (role_id, permission_id);

create table if not exists sys_team
(
    id          varchar(36)               null comment '编号',
    team_name   varchar(200) charset utf8 null comment '项目小组名称',
    create_by   varchar(36)               null comment '创建人',
    create_time datetime                  null comment '创建时间',
    update_by   varchar(36)               null comment '修改人',
    update_time datetime                  null comment '修改时间',
    status      int default 1             null comment '状态(0:禁用,1:启用)'
)
    comment '项目组表';

create table if not exists sys_user
(
    id              varchar(36)          not null comment '主键id'
        primary key,
    user_name       varchar(100)         null comment '登录账号',
    realname        varchar(100)         null comment '真实姓名',
    password        varchar(255)         null comment '密码',
    salt            varchar(45)          null comment 'md5密码盐',
    avatar          varchar(255)         null comment '头像',
    sex             tinyint(1)           null comment '性别(0-默认未知,1-男,2-女)',
    email           varchar(45)          null comment '电子邮件',
    phone           varchar(45)          null comment '电话',
    project_team_id varchar(64)          null comment '项目组编号',
    status          tinyint(1) default 1 null comment '删除状态(0-正常,1-已删除)',
    work_no         varchar(100)         null comment '工号，唯一键',
    create_by       varchar(32)          null comment '创建人',
    create_time     datetime             null comment '创建时间',
    update_by       varchar(32)          null comment '修改人',
    update_time     datetime             null comment '修改时间',
    constraint index_user_name
        unique (user_name),
    constraint uniq_sys_user_email
        unique (email),
    constraint uniq_sys_user_phone
        unique (phone),
    constraint uniq_sys_user_username
        unique (user_name),
    constraint uniq_sys_user_work_no
        unique (work_no)
)
    comment '用户表' charset = utf8;

create index idx_su_status
    on sys_user (status);

create index idx_su_username
    on sys_user (user_name);

create index index_user_status
    on sys_user (status);

create table if not exists sys_user_role
(
    id      varchar(36) not null comment '主键id'
        primary key,
    user_id varchar(36) null comment '用户id',
    role_id varchar(36) null comment '角色id'
)
    comment '用户角色表' charset = utf8;

create index idx_sur_role_id
    on sys_user_role (role_id);

create index idx_sur_user_id
    on sys_user_role (user_id);

create index idx_sur_user_role_id
    on sys_user_role (user_id, role_id);

create index index2_groupuu_ole_id
    on sys_user_role (role_id);

create index index2_groupuu_user_id
    on sys_user_role (user_id);

create index index2_groupuu_useridandroleid
    on sys_user_role (user_id, role_id);

