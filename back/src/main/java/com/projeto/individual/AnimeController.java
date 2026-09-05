package com.projeto.individual;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/animes")
public class AnimeController {

    private final JdbcTemplate jdbcTemplate;

    public AnimeController (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final List<String> GENEROS_VALIDOS = List.of(
            "Ação",
            "Aventura",
            "Comédia",
            "Drama",
            "Fantasia"
    );

    private static final List<String> STATUS_VALIDOS = List.of(
            "Finalizado",
            "Assistindo",
            "Pausado"
    );


    @GetMapping
    public ResponseEntity<List<Anime>> listar(){
        String sql = """
                SELECT * FROM animes
                """;

        List<Anime> animes = jdbcTemplate.query(
                sql, new BeanPropertyRowMapper<>(Anime.class)
        );
        return ResponseEntity.status(200).body(animes);
    }

    @PostMapping
    public ResponseEntity<Anime> cadastrar(
            @RequestBody Anime cadastrarAnime
    ) {

        List<String> statusValidos = List.of(
                "Finalizado",
                "Assistindo",
                "Pausado"
        );

        if (cadastrarAnime.getTitulo() == null
                || cadastrarAnime.getTitulo().isBlank()
                || cadastrarAnime.getEpisodios() == null
                || cadastrarAnime.getEpisodios() <= 0
                || cadastrarAnime.getDataConclusao() == null
                || cadastrarAnime.getDataConclusao().isAfter(LocalDate.now())
                || cadastrarAnime.getNota() == null
                || cadastrarAnime.getNota() < 0
                || cadastrarAnime.getNota() > 10
                || cadastrarAnime.getStatus() == null
                || !STATUS_VALIDOS.contains(cadastrarAnime.getStatus())
                || cadastrarAnime.getGenero() == null
                || !GENEROS_VALIDOS.contains(cadastrarAnime.getGenero())) {

            return ResponseEntity.badRequest().build();
        }

        String sqlExiste = """
            SELECT COUNT(*) FROM animes
            WHERE titulo = ?
            """;

        Integer quantidade = jdbcTemplate.queryForObject(
                sqlExiste,
                Integer.class,
                cadastrarAnime.getTitulo()
        );

        if (quantidade != null && quantidade > 0) {
            return ResponseEntity.status(409).build();
        }

        String sql = """
        INSERT INTO animes (titulo, episodios, data_conclusao, nota, status, genero)
        VALUES (?, ?, ?, ?, ?, ?)
        """;

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            statement.setString(1, cadastrarAnime.getTitulo());
            statement.setInt(2, cadastrarAnime.getEpisodios());
            statement.setObject(3, cadastrarAnime.getDataConclusao());
            statement.setDouble(4, cadastrarAnime.getNota());
            statement.setString(5, cadastrarAnime.getStatus());
            statement.setString(6, cadastrarAnime.getGenero());

            return statement;
        }, keyHolder);

        if (keyHolder.getKey() !=null){
            cadastrarAnime.setId(keyHolder.getKey().intValue());
        }
        return ResponseEntity.status(201).body(cadastrarAnime);
    }

    @GetMapping("/generos")
    public ResponseEntity<List<String>> listarGeneros() {
        return ResponseEntity.ok(GENEROS_VALIDOS);
    }
}
