CREATE TABLE IF NOT EXISTS animes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    episodios INT NOT NULL,
    data_conclusao DATE NOT NULL,
    nota DECIMAL(3,1) NOT NULL,
    status VARCHAR(20) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    imagem_url VARCHAR(500)
);