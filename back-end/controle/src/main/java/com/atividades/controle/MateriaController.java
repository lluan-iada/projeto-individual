package com.atividades.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    private final JdbcTemplate jdbcTemplate;

    public MateriaController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Materia>> listar() {
        String sql = """
                SELECT * FROM materia
                """;
        List<Materia> materias = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Materia.class)
        );
        return ResponseEntity.status(200).body(materias);
    }
}
