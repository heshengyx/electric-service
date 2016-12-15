--用户表
CREATE TABLE FV_USER
(
    ID VARCHAR2(32) NOT NULL,
    NAME VARCHAR2(100),
    SEX  INT,
    CODE VARCHAR2(100),
    ACCOUNT VARCHAR2(100),
    PASSWORD VARCHAR2(100),
    EMAIL VARCHAR2(100),
    PHONE VARCHAR2(100),
    ORG_ID VARCHAR2(32),
    ADMIN char(1),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);

--机构表
CREATE TABLE FV_ORGANIZATION
(
    ID VARCHAR2(32) NOT NULL,
    NAME VARCHAR2(100),
    CODE VARCHAR2(100),
    PARENT_ID VARCHAR2(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);

--雇员表
CREATE TABLE FV_EMPLOYEE
(
    ID VARCHAR2(32) NOT NULL,
    NAME VARCHAR2(100),
    CODE VARCHAR2(100),
    SEX    INT,
    AGE    INT,
    IDCARD VARCHAR2(50),
    BIRTH_DATE DATE,
    ORG_ID VARCHAR2(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);

--终端表
CREATE TABLE FV_TERMINAL
(
    ID VARCHAR2(32) NOT NULL,
    NAME VARCHAR2(100),
    CODE VARCHAR2(100),
    ORG_ID VARCHAR2(32),
    STYLE_ID VARCHAR2(32),
    IPADDR VARCHAR2(100),
    LOCATION VARCHAR2(100),
    HEARTBEAT DATE,
    STATUS char(1),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);
--alter table FV_TERMINAL add LOCATION VARCHAR2(100) 
--终端类别表
CREATE TABLE FV_STYLE
(
    ID VARCHAR2(32) NOT NULL,
    NAME VARCHAR2(100),
    CODE VARCHAR2(100),
    TYPE INT,
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);

--瞬时数据表
CREATE TABLE FV_INSTANTANEOUS
(
    ID VARCHAR2(32) NOT NULL,
    SAMPLE_TIME DATE,
    FORWARD_HAS INT,
    ASSEMBLE_NO INT,
    REVERSE_HAS INT,
    ASSEMBLE_REVERSE_NO INT,
    ASSEMBLE_HAS INT,
    DEGREE INT,
    TERMINAL_ID VARCHAR2(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);

--曲线数据表
CREATE TABLE FV_CURVE
(
    ID VARCHAR2(32) NOT NULL,
    SAMPLE_TIME DATE,
    ASSEMBLE_HAS INT,
    ASSEMBLE_NO INT,
    TOTALS INT,
    FORWARD_HAS INT,
    FORWARD_NO INT,
    REVERSE_HAS INT,
    REVERSE_NO INT,
    TERMINAL_ID VARCHAR2(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);

--日冻结数据表
CREATE TABLE FV_FREEZEDAY
(
    ID VARCHAR2(32) NOT NULL,
    SAMPLE_TIME DATE,
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
    TERMINAL_ID VARCHAR2(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);

--月冻结数据表
CREATE TABLE FV_FREEZEMONTH
(
    ID VARCHAR2(32) NOT NULL,
    SAMPLE_TIME DATE,
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
    TERMINAL_ID VARCHAR2(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);

--事件记录数据表
CREATE TABLE FV_EVENT
(
    ID VARCHAR2(32) NOT NULL,
    NAME VARCHAR2(100),
    CODE VARCHAR2(100),
    PARAM_VALUE VARCHAR2(100),
    EQUIPMENT_CODE VARCHAR2(100),
    ALARM_CODE VARCHAR2(100),
    ACCIDENT_CODE VARCHAR2(100),
    SAMPLE_TYPE INT,
    DEAL_STATUS VARCHAR2(100),
    ACCIDENT_REASON VARCHAR2(500),
    TERMINAL_ID VARCHAR2(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);

--权限表
CREATE TABLE FV_PERMISSION
(
    ID VARCHAR2(32) NOT NULL,
    NAME VARCHAR2(100),
    CODE VARCHAR2(100),
    URL VARCHAR2(100),
    PARENT_ID VARCHAR2(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);

--角色表
CREATE TABLE FV_ROLE
(
    ID VARCHAR2(32) NOT NULL,
    NAME VARCHAR2(100),
    CODE VARCHAR2(100),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);

--角色权限表
CREATE TABLE FV_ROLE_PERMISSION
(
    ID VARCHAR2(32) NOT NULL,
    ROLE_ID VARCHAR2(32) NOT NULL,
    PERMISSION_ID VARCHAR2(32) NOT NULL,
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);

--角色机构表
CREATE TABLE FV_ROLE_ORGANIZATION
(
    ID VARCHAR2(32) NOT NULL,
    ROLE_ID VARCHAR2(32) NOT NULL,
    ORGANIZATION_ID VARCHAR2(32) NOT NULL,
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);

--用户角色表
CREATE TABLE FV_USER_ROLE
(
    ID VARCHAR2(32) NOT NULL,
    USER_ID VARCHAR2(32) NOT NULL,
    ROLE_ID VARCHAR2(32) NOT NULL,
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);

--指静脉表
CREATE TABLE FV_FINGERVEIN
(
    ID VARCHAR2(32) NOT NULL,
    SEQ VARCHAR2(10),
    STATUS CHAR(1),
    FEATURE BLOB,
    EMPLOYEE_ID VARCHAR2(32) NOT NULL,
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);

--识别日志表
CREATE TABLE FV_RECOGNITION_LOG
(
    ID VARCHAR2(32) NOT NULL,
    NAME VARCHAR2(100),
    CODE VARCHAR2(100),
    SEQ VARCHAR2(10),
    THRESHOLD VARCHAR2(10),
    INDEXED INT,
    TYPE CHAR(1),
    STATUS CHAR(1),
    ORG_NAME VARCHAR2(100),
    IPADDR VARCHAR2(100),
    FILE_PATH VARCHAR2(100),
    TERMINAL_ID VARCHAR2(32),
    EMPLOYEE_ID VARCHAR2(32),
    FINGERVEIN_ID VARCHAR2(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATE,
    UPDATE_TIME DATE,
    CREATE_BY VARCHAR2(100),
    UPDATE_BY VARCHAR2(100),
    REMARKS VARCHAR2(1000),
    PRIMARY KEY (ID)
);
--alter table FV_RECOGNITION_LOG add FILE_PATH VARCHAR2(100) 