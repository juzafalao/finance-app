-- Usuário Admin
INSERT INTO users (id, username, email, password, role) VALUES
    (1, 'admin', 'admin@example.com', '{noop}admin123', 'ROLE_ADMIN');

-- Categorias
INSERT INTO category (id, name, type) VALUES
                                          (1, 'Alimentação', 'DESPESA'),
                                          (2, 'Transporte', 'DESPESA'),
                                          (3, 'Educação', 'DESPESA'),
                                          (4, 'Salário', 'RECEITA'),
                                          (5, 'Investimentos', 'RECEITA');
