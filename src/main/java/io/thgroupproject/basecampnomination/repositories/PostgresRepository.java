package io.thgroupproject.basecampnomination.repositories;


import io.thgroupproject.basecampnomination.modal.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PostgresRepository{
        private JdbcTemplate jdbc;

        @Autowired
        public PostgresRepository(JdbcTemplate jdbtemplate) {
            jdbc = jdbtemplate;
        }

        public void save(Student student) {
            student.id = UUID.randomUUID();

            jdbc.update("INSERT INTO students (id, StudentName, SchoolDistrict, Age, PhoneNumber, gradDate, Aptitude, workEthic, passion, interviewDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", student.id, student.StudentName,
                    student.SchoolDistrict, student.Age, student.PhoneNumber, student.gradDate, student.Aptitude, student.workEthic, student.passion, student.interviewDate);
        }

        public Optional<Student> findById(UUID id) {
            return Optional.ofNullable(jdbc.queryForObject("SELECT id, studentName, SchoolDistrict, Age, PhoneNumber, gradDate, Aptitude, workEthic, passion, interviewDate FROM students WHERE id= ?",
                    this::mapRowToStory, id));
        }

        public List<Student> findAll() {
            return jdbc.query("SELECT id, StudentName, SchoolDistrict, Age, PhoneNumber, gradDate, Aptitude, workEthic, passion, interviewDate FROM students", this::mapRowToStory);
        }

        private Student mapRowToStory(ResultSet rs, int rowNum) throws SQLException {
            return new Student(UUID.fromString(rs.getString("id")), rs.getString("StudentName"), rs.getString("SchoolDistrict"),
                    rs.getInt("Age"), rs.getString("PhoneNumber"), rs.getDate("gradDate"), rs.getString("Aptitude"), rs.getString("workEthic"), rs.getString("passion"), rs.getDate("interviewDate"));
        }
    }
