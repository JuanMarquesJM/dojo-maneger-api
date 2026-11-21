INSERT INTO modalidades (nome) VALUES
('Jiu-Jitsu'),
('Muay Thai'),
('Boxe'),
('Karate'),
('Capoeira');

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 120.00 FROM modalidades WHERE nome = 'Jiu-Jitsu';

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Trimestral', 330.00 FROM modalidades WHERE nome = 'Jiu-Jitsu';

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 150.00 FROM modalidades WHERE nome = 'Boxe';

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 180.00 FROM modalidades WHERE nome = 'Karate';

INSERT INTO graduacoes (modalidade_id, nome)
SELECT id, 'Faixa branca' FROM modalidades WHERE nome = 'Jiu-Jitsu';

INSERT INTO graduacoes (modalidade_id, nome)
SELECT id, 'Faixa Azul' FROM modalidades WHERE nome = 'Jiu-Jitsu';

INSERT INTO graduacoes (modalidade_id, nome)
SELECT id, 'Faixa Roxa' FROM modalidades WHERE nome = 'Jiu-Jitsu';