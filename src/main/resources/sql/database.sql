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
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

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

--终端表
CREATE TABLE TERMINAL
(
    ID VARCHAR(32) NOT NULL,
    NAME VARCHAR(100),
    CODE VARCHAR(100),
    ORG_ID VARCHAR(32),
    STYLE_ID VARCHAR(32),
    ACTIVE INT,
    VERSION INT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    CREATE_BY VARCHAR(100),
    UPDATE_BY VARCHAR(100),
    REMARKS VARCHAR(1000),
    PRIMARY KEY (ID)
)

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