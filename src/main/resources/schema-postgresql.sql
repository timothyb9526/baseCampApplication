CREATE TABLE IF NOT EXISTS students (
    id UUID PRIMARY KEY NOT NULL,
    StudentName TEXT NOT NULL,
    SchoolDistrict TEXT NOT NULL,
    Age INTEGER NOT NULL,
    PhoneNumber TEXT NOT NULL,
    gradDate DATE NOT NULL,
    Aptitude TEXT NOT NULL,
    workEthic TEXT NOT NULL,
    passion TEXT NOT NULL,
    interviewDate DATE NOT NULL
);