--用户表
CREATE TABLE USER
(
    ID VARCHAR(32) NOT NULL,
    NAME VARCHAR(100),
    SEX  INT,
    CODE VARCHAR(100),
    ACCOUNT VARCHAR(100),
    PASSWORD VARCHAR(100),
    EMAIL VARCHAR(100),
    PHONE VARCHAR(100),
    ORG_ID VARCHAR(32),
    ADMIN char(1),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

alter table USER add ADMIN char(1);

--机构表
CREATE TABLE ORGANIZATION
(
    ID VARCHAR(32) NOT NULL,
    NAME VARCHAR(100),
    CODE VARCHAR(100),
    LEVEL INT,
    PARENT_ID VARCHAR(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

--雇员表
CREATE TABLE EMPLOYEE
(
    ID VARCHAR(32) NOT NULL,
    NAME VARCHAR(100),
    CODE VARCHAR(100),
    SEX    INT,
    AGE    INT,
    IDCARD VARCHAR(50),
    BIRTH_DATE DATETIME,
    ORG_ID VARCHAR(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

--终端表
CREATE TABLE TERMINAL
(
    ID VARCHAR(32) NOT NULL,
    NAME VARCHAR(100),
    CODE VARCHAR(100),
    ORG_ID VARCHAR(32),
    STYLE_ID VARCHAR(32),
    IPADDR VARCHAR(100),
    HEARTBEAT DATETIME,
    STATUS char(1),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

alter table TERMINAL add HEARTBEAT DATETIME;
alter table TERMINAL add STATUS char(1);
alter table TERMINAL add IPADDR VARCHAR(100);

--终端类别表
CREATE TABLE STYLE
(
    ID VARCHAR(32) NOT NULL,
    NAME VARCHAR(100),
    CODE VARCHAR(100),
    TYPE INT,
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

--瞬时数据表
CREATE TABLE INSTANTANEOUS
(
    ID VARCHAR(32) NOT NULL,
    SAMPLE_TIME DATETIME,
    FORWARD_HAS INT,
    ASSEMBLE_NO INT,
    REVERSE_HAS INT,
    ASSEMBLE_REVERSE_NO INT,
    ASSEMBLE_HAS INT,
    DEGREE INT,
    TERMINAL_ID VARCHAR(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

--曲线数据表
CREATE TABLE CURVE
(
    ID VARCHAR(32) NOT NULL,
    SAMPLE_TIME DATETIME,
    ASSEMBLE_HAS INT,
    ASSEMBLE_NO INT,
    TOTALS INT,
    FORWARD_HAS INT,
    FORWARD_NO INT,
    REVERSE_HAS INT,
    REVERSE_NO INT,
    TERMINAL_ID VARCHAR(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

--日冻结数据表
CREATE TABLE FREEZEDAY
(
    ID VARCHAR(32) NOT NULL,
    SAMPLE_TIME DATETIME,
    ASSEMBLE_TOTALS INT,
    FORWARD_HAS INT,
    FORWARD_NO INT,
    REVERSE_HAS INT,
    REVERSE_NO INT,
    TOTALS INT,
    FORWARD_HAS_DAY INT,
    FORWARD_NO_DAY INT,
    REVERSE_HAS_DAY INT,
    REVERSE_NO_DAY INT,
    PEAK_TOTALS INT,
    FLAT_TOTALS INT,
    VALLEY_TOTALS INT,
    TIP_TOTALS INT,
    MORNING_TOTALS INT,
    MIDDAY_TOTALS INT,
    NIGHT_TOTALS INT,
    TERMINAL_ID VARCHAR(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

--月冻结数据表
CREATE TABLE FREEZEMONTH
(
    ID VARCHAR(32) NOT NULL,
    SAMPLE_TIME DATETIME,
    ASSEMBLE_TOTALS INT,
    FORWARD_HAS INT,
    FORWARD_NO INT,
    REVERSE_HAS INT,
    REVERSE_NO INT,
    TOTALS INT,
    FORWARD_HAS_MONTH INT,
    FORWARD_NO_MONTH INT,
    REVERSE_HAS_MONTH INT,
    REVERSE_NO_MONTH INT,
    PEAK_TOTALS INT,
    FLAT_TOTALS INT,
    VALLEY_TOTALS INT,
    TIP_TOTALS INT,
    MORNING_TOTALS INT,
    MIDDAY_TOTALS INT,
    NIGHT_TOTALS INT,
    TERMINAL_ID VARCHAR(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

--事件记录数据表
CREATE TABLE EVENT
(
    ID VARCHAR(32) NOT NULL,
    NAME VARCHAR(100),
    CODE VARCHAR(100),
    PARAM_VALUE VARCHAR(100),
    EQUIPMENT_CODE VARCHAR(100),
    ALARM_CODE VARCHAR(100),
    ACCIDENT_CODE VARCHAR(100),
    SAMPLE_TYPE INT,
    DEAL_STATUS VARCHAR(100),
    ACCIDENT_REASON VARCHAR(500),
    TERMINAL_ID VARCHAR(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

--权限表
CREATE TABLE PERMISSION
(
    ID VARCHAR(32) NOT NULL,
    NAME VARCHAR(100),
    CODE VARCHAR(100),
    URL VARCHAR(100),
    PARENT_ID VARCHAR(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

--角色表
CREATE TABLE ROLE
(
    ID VARCHAR(32) NOT NULL,
    NAME VARCHAR(100),
    CODE VARCHAR(100),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

--角色权限表
CREATE TABLE ROLE_PERMISSION
(
	ID VARCHAR(32) NOT NULL,
    ROLE_ID VARCHAR(32) NOT NULL,
    PERMISSION_ID VARCHAR(32) NOT NULL,
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

--角色机构表
CREATE TABLE ROLE_ORGANIZATION
(
	ID VARCHAR(32) NOT NULL,
    ROLE_ID VARCHAR(32) NOT NULL,
    ORGANIZATION_ID VARCHAR(32) NOT NULL,
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

--用户角色表
CREATE TABLE USER_ROLE
(
	ID VARCHAR(32) NOT NULL,
	USER_ID VARCHAR(32) NOT NULL,
    ROLE_ID VARCHAR(32) NOT NULL,
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

--指静脉表
CREATE TABLE FINGERVEIN
(
    ID VARCHAR(32) NOT NULL,
    SEQ VARCHAR(10),
    STATUS CHAR(1),
    FEATURE BLOB,
    EMPLOYEE_ID VARCHAR(32) NOT NULL,
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

--识别日志表
CREATE TABLE RECOGNITION_LOG
(
    ID VARCHAR(32) NOT NULL,
    NAME VARCHAR(100),
    CODE VARCHAR(100),
    SEQ VARCHAR(10),
    THRESHOLD VARCHAR(10),
    INDEXED INT,
    TYPE CHAR(1),
    STATUS CHAR(1),
    ORG_NAME VARCHAR(100),
    IPADDR VARCHAR(100),
    TERMINAL_ID VARCHAR(32),
    EMPLOYEE_ID VARCHAR(32),
    FINGERVEIN_ID VARCHAR(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

alter table RECOGNITION_LOG add TYPE char(1);

CREATE TABLE Test
(
    NAME VARCHAR(100),
    CODE VARCHAR(100)
)