insert into fv_organization (ID, NAME, CODE, PARENT_ID, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('1E55B4E494B646E4B91134CDCF435FFC', '广电集团', '100001', '', null, 0, to_date('13-12-2016 09:54:13', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_organization (ID, NAME, CODE, PARENT_ID, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('E889E9ED780C43829A2158BE41F34A79', '广电运通', '200001', '1E55B4E494B646E4B91134CDCF435FFC', null, 0, to_date('13-12-2016 09:54:31', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_organization (ID, NAME, CODE, PARENT_ID, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('03065E231A924A00BA298374653470A4', '开发一部', '300001', 'E889E9ED780C43829A2158BE41F34A79', null, 0, to_date('13-12-2016 09:55:16', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_organization (ID, NAME, CODE, PARENT_ID, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('7C0AB2D8AF534ADA88F9C6509C278554', 'VTM测试部', '300006', 'E889E9ED780C43829A2158BE41F34A79', null, 0, to_date('13-12-2016 09:57:36', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_organization (ID, NAME, CODE, PARENT_ID, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('18F53EC2E8DE49A2B7EE227F1B92CDEF', '开发三部', '300003', 'E889E9ED780C43829A2158BE41F34A79', null, 0, to_date('13-12-2016 09:55:49', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_organization (ID, NAME, CODE, PARENT_ID, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('FE7AE7E40E35466F8D3F5D82DA63F13C', '开发二部', '300002', 'E889E9ED780C43829A2158BE41F34A79', null, 0, to_date('13-12-2016 09:55:33', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_organization (ID, NAME, CODE, PARENT_ID, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('F4BE8943B915426B97319C23AC594391', 'VTM产品部', '300004', 'E889E9ED780C43829A2158BE41F34A79', null, 0, to_date('13-12-2016 09:56:50', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_organization (ID, NAME, CODE, PARENT_ID, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('A138A62EF8384E54B1086F3595571030', 'VTM工程部', '300005', 'E889E9ED780C43829A2158BE41F34A79', null, 0, to_date('13-12-2016 09:57:16', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_permission (ID, NAME, CODE, URL, PARENT_ID, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('D894A9B0CE74493C9FACB5ED34DEBFD7', '用户管理', 'user:list', '/manager/user/list', '25DC8EE67AF54E468A90FCCF3D9A269B', null, 0, to_date('13-12-2016 10:04:04', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_permission (ID, NAME, CODE, URL, PARENT_ID, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('300A2643FD50450C999E23A965AE8FF0', '角色管理', 'role:list', '/manager/role/list', '25DC8EE67AF54E468A90FCCF3D9A269B', null, 0, to_date('13-12-2016 10:03:08', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_permission (ID, NAME, CODE, URL, PARENT_ID, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('DE41947DFD764B21AE9FD87EF4E898AF', '机构管理', 'organization:list', '/manager/organization/list', '25DC8EE67AF54E468A90FCCF3D9A269B', null, 0, to_date('13-12-2016 10:01:23', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_permission (ID, NAME, CODE, URL, PARENT_ID, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('3B187B0CE8714D43804CED1D605A2556', '雇员管理', 'employee:list', '/manager/employee/list', '25DC8EE67AF54E468A90FCCF3D9A269B', null, 0, to_date('13-12-2016 10:02:08', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_permission (ID, NAME, CODE, URL, PARENT_ID, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('25DC8EE67AF54E468A90FCCF3D9A269B', '组织机构', 'manager:organization', '/manager/organization', '', null, 0, to_date('13-12-2016 10:00:21', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_permission (ID, NAME, CODE, URL, PARENT_ID, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('9715B64D76FE442C81F4FB7D91BF844A', '权限管理', 'permission:list', '/manager/permission/list', '25DC8EE67AF54E468A90FCCF3D9A269B', null, 0, to_date('13-12-2016 10:02:39', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_role (ID, NAME, CODE, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('747D57DCF1A546AA8C562EEADF21C050', '普通管理员', '100002', null, 0, to_date('13-12-2016 10:05:16', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_role (ID, NAME, CODE, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('46D6BB067F61431382387DEEA85B6A31', '高级管理员', '100003', null, 0, to_date('13-12-2016 10:05:27', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_role (ID, NAME, CODE, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('580E154A67944D42BB04110FDD6AA15B', '一般管理员', '100001', null, 0, to_date('13-12-2016 10:05:02', 'dd-mm-yyyy hh24:mi:ss'), null, 'admin', '', '');

insert into fv_user (ID, NAME, SEX, CODE, ACCOUNT, PASSWORD, EMAIL, PHONE, ORG_ID, ADMIN, ACTIVE, VERSION, CREATE_TIME, UPDATE_TIME, CREATE_BY, UPDATE_BY, REMARKS)
values ('031771EC349F4227A0C03017BB3220C9', '张三', 1, 'zhangsan', 'admin', '123456', '', '', '', '1', null, 0, to_date('13-12-2016 09:05:02', 'dd-mm-yyyy hh24:mi:ss'), null, '', '', '');