-- 用户登录信息表
CREATE TABLE UserInfo(U_Id integer NOT NULL PRIMARY KEY,U_Name varchar(50) NOT NULL,U_Password varchar(50) NOT NULL,U_Level integer NOT NULL,U_LoginTime datetime);

-- AGV通信表
CREATE TABLE AgvComInfo(A_Id integer NOT NULL PRIMARY KEY,A_Description varchar(50) NOT NULL,A_IPAddress varchar(50) NOT NULL,A_NetNo integer NOT NULL,A_LocalPort integer NOT NULL,A_DesPort integer NOT NULL,A_AgvType varchar(50) NOT NULL,A_IsUsing BOOLEAN);

-- RFID与坐标对应关系表
CREATE TABLE RfidToCoordinate(RfidNo integer NOT NULL PRIMARY KEY, RfidX integer default 0, RfidY integer default 0)

-- AGV位置表
CREATE TABLE AgvPosition(Agv_Id integer NOT NULL, RfidNo integer NOT NULL )

-- AGV状态表
CREATE TABLE AgvState(Agv_id integer NOT NULL PRIMARY KEY, error integer NOT NULL, updateTime integer NOT NULL)