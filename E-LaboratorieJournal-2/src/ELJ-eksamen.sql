use master;
if db_id('ELJ') IS NOT NULL
drop database ELJ;

create database ELJ;
go

use ELJ;

create table student(
studentID int identity NOT NULL,
studentName nvarchar NOT NULL,
classID int NOT NULL,

primary key(studentID)
foreign key(classID) REFERENCES class(classID)
)

create table class(
classID int identity NOT NULL,
className nvarchar NOT NULL,

primary key(classID)
)

create table studentForm(
studentID int NOT NULL,
formID int NOT NULL,

primary key(studentID, formID)

foreign key(studentID) REFERENCES student(studentID)
foreign key(formID) REFERENCES form(formID)
)

-----------------------------------------------

create table journal(
journalID int identity NOT NULL,
studentID int NOT NULL,
projectID int NOT NULL,
formID int NOT NULL,
coworker nvarchar NOT NULL,
traceability nvarchar NOT NULL,
results nvarchar NOT NULL,
resultImage image NOT NULL,
calculations nvarchar NOT NULL,
calcImage image NOT NULL,

primary key(journalID)


foreign key(studentID) REFERENCES student(studentID)
foreign key(projectID) REFERENCES projectInfo(projectID)
foreign key(formID) REFERENCES picture(formID)
)

create table picture(
pictureID int identity NOT NULL,
journalID int NOT NULL,
picture image NOT NULL,

primary key(pictureID)

foreign key(journalID) REFERENCES journal(journalID)
)

-----------------------------------------------

create table journalForm(
journalID int NOT NULL,
formID int NOT NULL,

primary key (journalID, formID)

foreign key(journalID) REFERENCES journal(journalID)
foreign key(formID) REFERENCES form(formID)
)

create table projectInfo(
projectID int identity NOT NULL,
dateCreated int NOT NULL,
themeName nvarchar NOT NULL,
analyzeTitle nvarchar NOT NULL,
comment nvarchar NOT NULL,

primary key(projectID)
)

----------------------------------------------

create table form(
formID int identity NOT NULL,
studentID int NOT NULL,
projectID int NOT NULL,
journalID int NOT NULL,
reagentName nvarchar NOT NULL,
formTypeID int NOT NULL,

primary key(formID)

foreign key(studentID) REFERENCES student(studentID)
foreign key(projectID) REFERENCES projectInfo(projectID)
foreign key(journalID) REFERENCES journal(journalID)
foreign key(formTypeID) REFERENCES form1(formTypeID)
foreign key(formTypeID) REFERENCES form2(formTypeID)
foreign key(formTypeID) REFERENCES form3(formTypeID)
)

create table form1(
formTypeID int identity NOT NULL,
volume nvarchar NOT NULL,
accConcentration nvarchar NOT NULL,
lifeTimeF nvarchar NOT NULL,
storage nvarchar NOT NULL,

primary key(formTypeID)
)

create table form2(
formTypeID int identity NOT NULL,
preperationID int NOT NULL,
pHSetting nvarchar NOT NULL,
liquid nvarchar NOT NULL,
treatment nvarchar NOT NULL,
tag nvarchar NOT NULL,
lifeTimeF nvarchar NOT NULL,
storage nvarchar NOT NULL,

primary key(formTypeID)

foreign key(preparationID) REFERENCES preparation(preparationID)
)

create table form3(
formTypeID int identity NOT NULL,
preperationID int NOT NULL,
pHSubstrate nvarchar NOT NULL,
pHSterialized nvarchar NOT NULL,
liquid nvarchar NOT NULL,
sterializeTime nvarchar NOT NULL,
sterializeC nvarchar NOT NULL,
addAftSterialize nvarchar NOT NULL,
pHAftSterialize nvarchar NOT NULL,
sterile bit NOT NULL,
posControl nvarchar NOT NULL,
negControl nvarchar NOT NULL,

primary key(formTypeID)

foreign key(preparationID) REFERENCES preparation(preparationID)
)

create table preparation(
preparationID int identity NOT NULL,
formID int NOT NULL,
chemical nvarchar NOT NULL,
casNo nvarchar NOT NULL,
productNo nvarchar NOT NULL,
weighed nvarchar NOT NULL,
measured nvarchar NOT NULL,
scaleNo nvarchar NOT NULL,
pipetteNo nvarchar NOT NULL,
endConcentration bit NOT NULL,

primary key(preparationID)

foreign key(formID) REFERENCES form2(formID)
foreign key(formID) REFERENCES form3(formID)
)

create table substanceInfo(
substanceID int identity NOT NULL,
batchNo int NOT NULL,
lotNo nvarchar NOT NULL,
supplier nvarchar NOT NULL,

primary key(substanceID)
)