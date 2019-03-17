#一级菜单
create table web_menu(
  id int(10) not null auto_increment primary key,
  show_name varchar(20),#显示名称
  href varchar(100),#跳转链接
  params varchar(50),#传参
  iron varchar(50),#图标
  clazz varchar(20)#样式
);
#二级菜单
create  table web_menu_second(
  id int(10) not null auto_increment primary key,
  name varchar(10),#显示名称
  href varchar(20),#跳转链接
  params varchar(50),#传参
  first_id varchar(10)#一级菜单Id
)