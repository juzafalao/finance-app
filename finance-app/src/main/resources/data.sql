-- Usuário Admin inicial
INSERT INTO users (id, full_name, email, password, role, enabled, created_at, updated_at)
VALUES (
           '00000000-0000-0000-0000-000000000001',
           'Admin User',
           'admin@example.com',
           '{noop}admin123',
           'ADMIN',
           TRUE,
           CURRENT_TIMESTAMP,
           CURRENT_TIMESTAMP
       );

-- Categorias iniciais
INSERT INTO category (id, name, type) VALUES
                                          (1, 'Alimentação', 'DESPESA'),
                                          (2, 'Transporte', 'DESPESA'),
                                          (3, 'Educação', 'DESPESA'),
                                          (4, 'Salário', 'RECEITA'),
                                          (5, 'Investimentos', 'RECEITA');

