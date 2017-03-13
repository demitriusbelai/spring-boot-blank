
CREATE TABLE unidade (
    id          SERIAL PRIMARY KEY,
    nome        VARCHAR(50) NOT NULL
);

CREATE TABLE unidade_telefone (
    id          SERIAL PRIMARY KEY,
    id_unidade  INTEGER NOT NULL
        REFERENCES unidade(id),
    ddd         CHAR(2) NOT NULL,
    numero      VARCHAR(10) NOT NULL
);

CREATE TABLE departamento (
    id          SERIAL PRIMARY KEY,
    nome        VARCHAR(50) NOT NULL,
    id_unidade  INTEGER NOT NULL
        REFERENCES unidade(id)
);

INSERT INTO unidade (nome) VALUES ('FAAC'), ('FC'), ('FEB');

INSERT INTO unidade_telefone (id_unidade, ddd, numero) VALUES
    ((SELECT id FROM unidade WHERE nome = 'FC'), '14', '3103-6000'),
    ((SELECT id FROM unidade WHERE nome = 'FC'), '14', '3103-6008');

INSERT INTO departamento (nome, id_unidade) VALUES
    ('Informática', (SELECT id FROM unidade WHERE nome = 'FC')),
    ('Educação', (SELECT id FROM unidade WHERE nome = 'FC')),
    ('Engenharia', (SELECT id FROM unidade WHERE nome = 'FEB')),
    ('Design', (SELECT id FROM unidade WHERE nome = 'FAAC'));
