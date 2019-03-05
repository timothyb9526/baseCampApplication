CREATE TABLE IF NOT EXISTS students (
    id UUID PRIMARY KEY,
    StudentName TEXT,
    SchoolDistrict TEXT,
    Age INTEGER,
    Email TEXT,
    PhoneNumber TEXT,
    gradDate DATE,
    Aptitude TEXT,
    workEthic TEXT ,
    passion TEXT,
    interviewDate DATE
);



CREATE TABLE IF NOT EXISTS nonEligible (
    id UUID PRIMARY KEY,
    name TEXT,
    district TEXT,
    email TEXT
);