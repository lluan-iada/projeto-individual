CREATE TABLE materia (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE atividade (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    descricao TEXT,
    materia_id INT NOT NULL,
    data_vencimento DATE NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    nota_maxima DECIMAL(5,2),
    avaliativa BOOLEAN NOT NULL DEFAULT FALSE,
    entrega BOOLEAN NOT NULL DEFAULT FALSE,
    entregue BOOLEAN NOT NULL DEFAULT FALSE,
    data_entrega DATE,
    CONSTRAINT fk_atividade_materia
        FOREIGN KEY (materia_id)
        REFERENCES materia(id)
);

