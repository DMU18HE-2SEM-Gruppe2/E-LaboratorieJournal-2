use master;
if db_id('ELJ-DB') IS NOT NULL
drop database [ELJ-DB];

create database [ELJ-DB];
go

use [ELJ-DB];


create table course(
courseID int identity(1,1) NOT NULL,
courseName nvarchar(max) NOT NULL,

primary key(courseID)
)

create table analyzeInformation(
analyzeID int identity(1,1) NOT NULL,
dateCreated bigint NOT NULL,
themeName nvarchar(max) NOT NULL,
analyzeTitle nvarchar(max) NOT NULL,
comment nvarchar(max) NOT NULL,

primary key(analyzeID)
)


------------------- Above isn't dependent of anything -----------------


create table student(
studentID int identity(1,1)  NOT NULL,
firstname nvarchar(max) NOT NULL,
lastname nvarchar(max) NOT NULL,
courseID int NOT NULL,


primary key(studentID),

foreign key (courseID) REFERENCES course(courseID)
)


------------------- Below is right side of Data Diagram -----------------


create table journal(
journalID int identity(1,1) NOT NULL,
analyzeID int NOT NULL,
formID int NOT NULL,
coworker nvarchar(max) NOT NULL,
traceability nvarchar(max) NOT NULL,
results nvarchar(max) NOT NULL,
calculations nvarchar(max) NOT NULL,
calcImage image NOT NULL,

primary key(journalID),

foreign key(analyzeID) REFERENCES analyzeInformation(analyzeID)
)


create table picture(
pictureID int identity NOT NULL,
journalID int NOT NULL,
picture image NOT NULL,

primary key(pictureID),

foreign key(journalID) REFERENCES journal(journalID)
)


------------------- Below is left side of Data Diagram -----------------


create table formInformation(
formID int identity(1,1)  NOT NULL,
analyzeID int NOT NULL,
reagentName nvarchar(max) NOT NULL,


primary key(formID),

foreign key(analyzeID) REFERENCES AnalyzeInformation(analyzeID),
)


create table preparation(
preparationID int identity(1,1) NOT NULL,
analyzeID int NOT NULL,
chemical nvarchar(max) NOT NULL,
casNo nvarchar(max) NOT NULL,
productNo nvarchar(max) NOT NULL,
weighed nvarchar(max) NOT NULL,
measured nvarchar(max) NOT NULL,
scaleNo nvarchar(max) NOT NULL,
pipetteNo nvarchar(max) NOT NULL,
endConcentration nvarchar(max) NOT NULL,
batchNo nvarchar(max) NOT NULL,
lotNo nvarchar(max) NOT NULL,
supplier nvarchar(max) NOT NULL,

foreign key(analyzeID) REFERENCES analyzeInformation(analyzeID),

primary key(preparationID)
)


create table reagent_Chem(
formTypeID int identity NOT NULL,
analyzeID int NOT NULL,
volume nvarchar(max) NOT NULL,
accConcentration nvarchar(max) NOT NULL,
lifeTimeF nvarchar(max) NOT NULL,
storage nvarchar(max) NOT NULL,
batchNo nvarchar(max) NOT NULL,
lotNo nvarchar(max) NOT NULL,
supplier nvarchar(max) NOT NULL,
scaleNo nvarchar(max) NOT NULL,
measurements nvarchar(max) NOT NULL,

primary key(formTypeID),

foreign key(analyzeID) REFERENCES analyzeInformation(analyzeID)
)


create table reagent_Bio(
formTypeID int identity NOT NULL,
analyzeID int NOT NULL,
pHSetting nvarchar(max) NOT NULL,
treatment nvarchar(max) NOT NULL,
tag nvarchar(max) NOT NULL,
lifeTimeF nvarchar(max) NOT NULL,
storage nvarchar(max) NOT NULL,
fluidAd nvarchar(max) NOT NULL,

primary key(formTypeID),

foreign key(analyzeID) REFERENCES analyzeInformation(analyzeID)
)


create table substrate_Bio(
formTypeID int identity NOT NULL,
analyzeID int NOT NULL,
pHSubstrate nvarchar(max) NOT NULL,
pHSterialized nvarchar(max) NOT NULL,
sterializeTime nvarchar(max) NOT NULL,
sterializeC nvarchar(max) NOT NULL,
addAftSterialize nvarchar(max) NOT NULL,
pHAftSterialize nvarchar(max) NOT NULL,
sterile bit NOT NULL,
posControl nvarchar(max) NOT NULL,
negControl nvarchar(max) NOT NULL,
fluidAd nvarchar(max) NOT NULL,

primary key(formTypeID),

foreign key(analyzeID) REFERENCES analyzeInformation(analyzeID)
)


-------------------- Below is relationtables -----------------


create table journalForm(
journalID int NOT NULL,
formID int NOT NULL,

primary key (journalID, formID),
)


create table student_analyzeInformation(
studentID int NOT NULL,
analyzeID int NOT NULL,

primary key(studentID, analyzeID),
)


--Test af indsætning


INSERT INTO course VALUES ('DMU');
INSERT INTO student VALUES ('Frank', 'Christensen', 1);
INSERT INTO student VALUES ('Jóhan', 'Gaardbo', 1);
INSERT INTO student VALUES ('Rasmus', 'Gyldenløv', 1);
INSERT INTO student VALUES ('Casper', 'Jacobsen', 1);