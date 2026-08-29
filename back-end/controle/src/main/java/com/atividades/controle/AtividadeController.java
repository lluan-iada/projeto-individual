package com.atividades.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/atividades")

public class AtividadeController {

    private final JdbcTemplate jdbcTemplate;

    public AtividadeController (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Atividade>> listar(){
        String sql = """
                SELECT * FROM atividade
                """;
        List<Atividade> atividades = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Atividade.class));
        return ResponseEntity.status(200).body(atividades);
    }
}
