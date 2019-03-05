package io.thgroupproject.basecampnomination.repositories;

import io.thgroupproject.basecampnomination.modal.UEstudents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UEstudentRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public UEstudentRepository(JdbcTemplate jdbtemplate) {
        jdbc = jdbtemplate;
    }

    public void saveStudent(UEstudents uEstudents) {
        uEstudents.id = UUID.randomUUID();

        jdbc.update("INSERT INTO nonEligible (id, name, district, email) VALUES (?, ?, ?, ?)", uEstudents.id, uEstudents.name,
                uEstudents.district, uEstudents.email);
    }

    public Optional<UEstudents> findById(UUID id) {
        return Optional.ofNullable(jdbc.queryForObject("SELECT id, name, district, email FROM nonEligible WHERE id= ?",
                this::mapRowToStory, id));
    }

    public List<UEstudents> findAll() {
        return jdbc.query("SELECT id, name, district, email FROM nonEligible", this::mapRowToStory);
    }

    private UEstudents mapRowToStory(ResultSet rs, int rowNum) throws SQLException {
        return new UEstudents(UUID.fromString(rs.getString("id")), rs.getString("name"), rs.getString("district"), rs.getString("email"));
    }


}
