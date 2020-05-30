CREATE DATABASE kbc;

-- Drop table

-- DROP TABLE kbc.dbo.[User] GO

CREATE TABLE kbc.dbo.[User] (
	Id bigint NOT NULL IDENTITY(1,1),
	Login nvarchar(255) NOT NULL,
	FirstName nvarchar(255) NOT NULL,
	LastName nvarchar(255) NOT NULL,
	Status nvarchar(255) NOT NULL,
	CreateDate datetime2 DEFAULT (NULL),
	CreatedBy nvarchar(255) DEFAULT (NULL),
	ModifyDate datetime2 DEFAULT (NULL),
	ModifiedBy nvarchar(255) DEFAULT (NULL),
	CONSTRAINT pkUser PRIMARY KEY (Id)
)GO
CREATE INDEX IdxLogin ON kbc.dbo.[User] (Login) GO;

-- Drop table

-- DROP TABLE kbc.dbo.UserAccountRole GO

CREATE TABLE kbc.dbo.UserAccountRole (
	UserAccountRoleID tinyint NOT NULL,
	UserAccountRoleName varchar(32) NOT NULL,
	UpdateDate smalldatetime NOT NULL,
	LastUpdatedBy varchar(32) NOT NULL,
	CONSTRAINT pkUserAccountRole PRIMARY KEY (UserAccountRoleID)
) GO
CREATE UNIQUE INDEX akUserAccountRole ON kbc.dbo.UserAccountRole (UserAccountRoleName) GO;


-- Drop table

-- DROP TABLE kbc.dbo.UserAccountRole GO

CREATE TABLE kbc.dbo.UserRole (
	UserRoleID bigint NOT NULL IDENTITY(1,1),
	UserId bigint ,
	UserAccountRoleID tinyint NOT NULL,
	UpdateDate smalldatetime NOT NULL,
	LastUpdatedBy varchar(32) NOT NULL,
	CONSTRAINT pkUserRole PRIMARY KEY (UserRoleID),
	CONSTRAINT fkUserRole_User FOREIGN KEY (UserId) REFERENCES kbc.dbo.[User](Id) ON DELETE RESTRICT ON UPDATE RESTRICT
	CONSTRAINT fkUserRole_UserAccountRole FOREIGN KEY (UserAccountRoleID) REFERENCES kbc.dbo.[UserAccountRole](UserAccountRoleID) ON DELETE RESTRICT ON UPDATE RESTRICT
) GO

-- Drop table

-- DROP TABLE kbc.dbo.Match GO

CREATE TABLE kbc.dbo.[Match] (
	MatchId bigint NOT NULL IDENTITY(1,1),
	Name nvarchar(255) NOT NULL,
	Description nvarchar(255) NOT NULL,
	Status nvarchar(255) NOT NULL,
	CreateDate datetime2 DEFAULT (NULL),
	CreatedBy nvarchar(255) DEFAULT (NULL),
	ModifyDate datetime2 DEFAULT (NULL),
	ModifiedBy nvarchar(255) DEFAULT (NULL),
	CONSTRAINT pkMatch PRIMARY KEY (MatchId)
)GO
CREATE INDEX IdxMatch ON kbc.dbo.[Match] (MatchId) GO;


-- Drop table

-- DROP TABLE kbc.dbo.Question GO

CREATE TABLE kbc.dbo.Question (
	QuestionId bigint NOT NULL IDENTITY(1,1),
	QuestionContent nvarchar(255) NOT NULL,
	MatchId bigint,
	CONSTRAINT pkQuestion PRIMARY KEY (QuestionId),
	CONSTRAINT fkQuestion_Match FOREIGN KEY (MatchId) REFERENCES kbc.dbo.[Match](MatchId) ON DELETE RESTRICT ON UPDATE RESTRICT
) GO
CREATE INDEX IdxQuestion ON kbc.dbo.Question (QuestionId) GO;

CREATE TABLE kbc.dbo.[Option] (
	OptionId bigint NOT NULL IDENTITY(1,1),
	QuestionId bigint,
	OptionContent nvarchar(255) NOT NULL,
	CONSTRAINT pkOption PRIMARY KEY (OptionId),
	CONSTRAINT fkQuestion_Option FOREIGN KEY (QuestionId) REFERENCES kbc.dbo.[Question](QuestionId) ON DELETE RESTRICT ON UPDATE RESTRICT
) GO
CREATE INDEX IdxOption ON kbc.dbo.[Option] (OptionId) GO;


-- Drop table

-- DROP TABLE kbc.dbo.Answer GO

CREATE TABLE kbc.dbo.Answer (
	AnswerID bigint NOT NULL IDENTITY(1,1),
	QuestionId bigint,
	OptionId bigint,
	CONSTRAINT pkAnswer PRIMARY KEY (AnswerID),
	CONSTRAINT fkAnswer_Option FOREIGN KEY (OptionId) REFERENCES kbc.dbo.[Option](OptionId) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT fkAnswer_Question FOREIGN KEY (QuestionId) REFERENCES kbc.dbo.[Question](QuestionId) ON DELETE RESTRICT ON UPDATE RESTRICT
) GO
CREATE INDEX IdxAnswer ON kbc.dbo.Answer (AnswerId) GO;


-- Drop table

-- DROP TABLE kbc.dbo.Answer GO

CREATE TABLE kbc.dbo.Score (
	ScoreID bigint NOT NULL IDENTITY(1,1),
	UserId bigint,
	OldScore bigint,
	NewScore bigint,
	MatchId bigint,
	CreateDate datetime2 DEFAULT (NULL),
	CreatedBy nvarchar(255) DEFAULT (NULL),
	ModifyDate datetime2 DEFAULT (NULL),
	ModifiedBy nvarchar(255) DEFAULT (NULL),
	CONSTRAINT pkScore PRIMARY KEY (ScoreID),
	CONSTRAINT fkScore_User FOREIGN KEY (UserId) REFERENCES kbc.dbo.[User](Id)ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT fkScore_Match FOREIGN KEY (MatchId) REFERENCES kbc.dbo.[Match](MatchId) ON DELETE RESTRICT ON UPDATE RESTRICT
) GO
CREATE INDEX IdxScore ON kbc.dbo.Score (ScoreID) GO;

-- Drop table

-- DROP TABLE kbc.dbo.RewardType GO

CREATE TABLE kbc.dbo.RewardType (
	RewardTypeID tinyint NOT NULL,
	RewardTypeName varchar(60) NOT NULL,
	RewardTypeDesc varchar(255) NOT NULL,
	CONSTRAINT pkRewardType PRIMARY KEY (RewardTypeID)
) GO
CREATE UNIQUE INDEX akRewardType ON kbc.dbo.RewardType (RewardTypeName) GO;

-- Drop table

-- DROP TABLE kbc.dbo.ThresholdType GO

CREATE TABLE kbc.dbo.ThresholdType (
	ThresholdTypeId int NOT NULL,
	ThresholdTypeName nvarchar(255) NOT NULL,
	CreateDate datetime DEFAULT (NULL),
	CreatedBy nvarchar(255) DEFAULT (NULL),
	CONSTRAINT PK_ThresholdType_ThresholdTypeId PRIMARY KEY (ThresholdTypeId)
) GO;


CREATE TABLE kbc.dbo.Reward (
	RewardID bigint NOT NULL IDENTITY(1,1),
	RewardTypeID tinyint,
	ThresholdTypeId int,
	RewardTypeDesc varchar(255) NOT NULL,
	CONSTRAINT pkRewardID PRIMARY KEY (RewardID),
	CONSTRAINT fkReward_RewardType FOREIGN KEY (RewardTypeID) REFERENCES kbc.dbo.[RewardType](RewardTypeID) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT fkReward_ThresholdType FOREIGN KEY (ThresholdTypeId) REFERENCES kbc.dbo.[ThresholdType](ThresholdTypeId) ON DELETE RESTRICT ON UPDATE RESTRICT
) GO
CREATE UNIQUE INDEX akReward ON kbc.dbo.Reward (RewardID) GO;


CREATE TABLE kbc.dbo.UserReward (
	UserRewardID bigint NOT NULL IDENTITY(1,1),
	RewardID bigint,
	UserID bigint,
	ScoreID bigint,
	CreateDate datetime2 DEFAULT (NULL),
	CreatedBy nvarchar(255) DEFAULT (NULL),
	CONSTRAINT pkUserRewardID PRIMARY KEY (UserRewardID),
	CONSTRAINT fkUserReward_User FOREIGN KEY (RewardID) REFERENCES kbc.dbo.[Reward](RewardID)ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT fkUserReward_Score FOREIGN KEY (ScoreID) REFERENCES kbc.dbo.[Score](ScoreID)ON DELETE RESTRICT ON UPDATE RESTRICT
) GO;




