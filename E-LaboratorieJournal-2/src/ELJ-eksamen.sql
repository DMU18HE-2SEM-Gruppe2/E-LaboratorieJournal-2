use master;
if db_id('ELJ') IS NOT NULL
drop database ELJ;

create database ELJ;
go

use ELJ;

create table class(
classID int identity NOT NULL,
className nvarchar(max) NOT NULL,

primary key(classID)
)

create table projectInfo(
projectID int identity NOT NULL,
dateCreated int NOT NULL,
themeName nvarchar(max) NOT NULL,
analyzeTitle nvarchar(max) NOT NULL,
comment nvarchar(max) NOT NULL,

primary key(projectID)
)

------------------- Above isn't dependent of anything -----------------

create table student(
studentID int identity NOT NULL,
studentName nvarchar(max) NOT NULL,
classID int NOT NULL,

primary key(studentID),

foreign key (classID) REFERENCES class(classID)
)

create table picture(
pictureID int identity NOT NULL,
picture image NOT NULL,

primary key(pictureID)
)

create table journal(
journalID int identity NOT NULL,
studentID int NOT NULL,
projectID int NOT NULL,
pictureID int NOT NULL,
formID int NOT NULL,
coworker nvarchar(max) NOT NULL,
traceability nvarchar(max) NOT NULL,
results nvarchar(max) NOT NULL,
calculations nvarchar(max) NOT NULL,
calcImage image NOT NULL,

primary key(journalID),

foreign key(studentID) REFERENCES student(studentID),
foreign key(projectID) REFERENCES projectInfo(projectID),
foreign key(pictureID) REFERENCES picture(pictureID)
)

create table form(
formID int identity NOT NULL,
studentID int NOT NULL,
projectID int NOT NULL,
formTypeID int NOT NULL,
reagentName nvarchar(max) NOT NULL,

primary key(formID),

foreign key(studentID) REFERENCES student(studentID),
foreign key(projectID) REFERENCES projectInfo(projectID),
)

create table substanceInfo(
substanceID int identity NOT NULL,
batchNo int NOT NULL,
lotNo nvarchar(max) NOT NULL,
supplier nvarchar(max) NOT NULL,

primary key(substanceID)
)

create table preparation(
preparationID int identity NOT NULL,
substanceID int NOT NULL,
formID int NOT NULL,
chemical nvarchar(max) NOT NULL,
casNo nvarchar(max) NOT NULL,
productNo nvarchar(max) NOT NULL,
weighed nvarchar(max) NOT NULL,
measured nvarchar(max) NOT NULL,
scaleNo nvarchar(max) NOT NULL,
pipetteNo nvarchar(max) NOT NULL,
endConcentration bit NOT NULL,

primary key(preparationID),

foreign key (formID) REFERENCES form(formID),
foreign key (substanceID) REFERENCES substanceInfo(substanceID)
)

create table form1(
formTypeID int identity NOT NULL,
formID int NOT NULL,
substanceID int NOT NULL,
volume nvarchar(max) NOT NULL,
accConcentration nvarchar(max) NOT NULL,
lifeTimeF nvarchar(max) NOT NULL,
storage nvarchar(max) NOT NULL,

primary key(formTypeID),

foreign key(formID) REFERENCES form(formID),
foreign key(substanceID) REFERENCES substanceInfo(substanceID)
)

create table form2(
formTypeID int identity NOT NULL,
formID int NOT NULL,
preparationID int NOT NULL,
pHSetting nvarchar(max) NOT NULL,
liquid nvarchar(max) NOT NULL,
treatment nvarchar(max) NOT NULL,
tag nvarchar(max) NOT NULL,
lifeTimeF nvarchar(max) NOT NULL,
storage nvarchar(max) NOT NULL,

primary key(formID),

foreign key(formID) REFERENCES form(formID)
)

create table form3(
formTypeID int identity NOT NULL,
formID int NOT NULL,
preparationID int NOT NULL,
pHSubstrate nvarchar(max) NOT NULL,
pHSterialized nvarchar(max) NOT NULL,
liquid nvarchar(max) NOT NULL,
sterializeTime nvarchar(max) NOT NULL,
sterializeC nvarchar(max) NOT NULL,
addAftSterialize nvarchar(max) NOT NULL,
pHAftSterialize nvarchar(max) NOT NULL,
sterile bit NOT NULL,
posControl nvarchar(max) NOT NULL,
negControl nvarchar(max) NOT NULL,

primary key(formID),

foreign key(formID) REFERENCES form(formID)
)

-------------------- Relations -----------------

create table journalForm(
journalID int NOT NULL,
formID int NOT NULL,

primary key (journalID, formID),
)

create table studentForm(
studentID int NOT NULL,
formID int NOT NULL,

primary key(studentID, formID),
)

INSERT INTO class VALUES ('DMU');
INSERT INTO student VALUES ('frank', 1)