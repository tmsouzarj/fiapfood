insert into usuario (nome, email, login, senha, ativo, data_criacao, data_atualizacao) values ('Thiago Motta', 'thiago@restaurantetudibaum.com', 'us000001', '1234', 1, current_timestamp, null);
insert into usuario (nome, email, login, senha, ativo, data_criacao, data_atualizacao) values ('Usuario 2', 'usuario2@restaurantetudibaum.com', 'us000002', '1234', 1, current_timestamp, null);
insert into usuario (nome, email, login, senha, ativo, data_criacao, data_atualizacao) values ('Usuario 3', 'usuario3@restaurantetudibaum.com', 'us000003', '1234', 0, current_timestamp, current_timestamp);
insert into usuario (nome, email, login, senha, ativo, data_criacao, data_atualizacao) values ('Usuario 4', 'usuario4@restaurantetudibaum.com', 'us000004', '1234', 0, current_timestamp, current_timestamp);
insert into usuario (nome, email, login, senha, ativo, data_criacao, data_atualizacao) values ('Usuario 5', 'usuario5@restaurantetudibaum.com', 'us000005', '1234', 1, current_timestamp, null);
insert into usuario (nome, email, login, senha, ativo, data_criacao, data_atualizacao) values ('Usuario 6', 'usuario6@restaurantetudibaum.com', 'us000006', '1234', 1, current_timestamp, null);
insert into usuario (nome, email, login, senha, ativo, data_criacao, data_atualizacao) values ('Usuario 7', 'usuario7@restaurantetudibaum.com', 'us000007', '1234', 0, current_timestamp, current_timestamp);
insert into usuario (nome, email, login, senha, ativo, data_criacao, data_atualizacao) values ('Usuario 8', 'usuario8@restaurantetudibaum.com', 'us000008', '1234', 0, current_timestamp, current_timestamp);
insert into usuario (nome, email, login, senha, ativo, data_criacao, data_atualizacao) values ('Usuario 9', 'usuario9@restaurantetudibaum.com', 'us000009', '1234', 1, current_timestamp, null);
insert into usuario (nome, email, login, senha, ativo, data_criacao, data_atualizacao) values ('Usuario 10', 'usuario10@restaurantetudibaum.com', 'us000010', '1234', 1, current_timestamp, null);
insert into usuario (nome, email, login, senha, ativo, data_criacao, data_atualizacao) values ('Usuario 11', 'usuario11@restaurantetudibaum.com', 'us000011', '1234', 0, current_timestamp, current_timestamp);
insert into usuario (nome, email, login, senha, ativo, data_criacao, data_atualizacao) values ('Usuario 12', 'usuario12@restaurantetudibaum.com', 'us000012', '1234', 0, current_timestamp, current_timestamp);

insert into endereco (id_usuario, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep) 
values (1, 'São Gonçalo', 'Nova Cidade', 'Rio de Janeiro', 'Rua Aquidabã', '79', 'Casa 8', 1, '24455450');
insert into endereco (id_usuario, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep) 
values (2, 'São Gonçalo', 'Nova Cidade', 'Rio de Janeiro', 'Rua Aquidabã', null, null, 0, '24455450');
insert into endereco (id_usuario, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep) 
values (3, 'São Gonçalo', 'Nova Cidade', 'Rio de Janeiro', 'Rua Aquidabã', '79', 'Casa 8', 1, '24455450');
insert into endereco (id_usuario, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep) 
values (4, 'São Gonçalo', 'Nova Cidade', 'Rio de Janeiro', 'Rua Aquidabã', null, null, 0, '24455450');
insert into endereco (id_usuario, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep) 
values (5, 'São Gonçalo', 'Nova Cidade', 'Rio de Janeiro', 'Rua Aquidabã', '79', 'Casa 8', 1, '24455450');
insert into endereco (id_usuario, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep) 
values (6, 'São Gonçalo', 'Nova Cidade', 'Rio de Janeiro', 'Rua Aquidabã', null, null, 0, '24455450');
insert into endereco (id_usuario, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep) 
values (7, 'São Gonçalo', 'Nova Cidade', 'Rio de Janeiro', 'Rua Aquidabã', '79', 'Casa 8', 1, '24455450');
insert into endereco (id_usuario, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep) 
values (8, 'São Gonçalo', 'Nova Cidade', 'Rio de Janeiro', 'Rua Aquidabã', null, null, 0, '24455450');
insert into endereco (id_usuario, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep) 
values (9, 'São Gonçalo', 'Nova Cidade', 'Rio de Janeiro', 'Rua Aquidabã', '79', 'Casa 8', 1, '24455450');
insert into endereco (id_usuario, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep) 
values (10, 'São Gonçalo', 'Nova Cidade', 'Rio de Janeiro', 'Rua Aquidabã', null, null, 0, '24455450');
insert into endereco (id_usuario, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep) 
values (11, 'São Gonçalo', 'Nova Cidade', 'Rio de Janeiro', 'Rua Aquidabã', '79', 'Casa 8', 1, '24455450');
insert into endereco (id_usuario, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep) 
values (12, 'São Gonçalo', 'Nova Cidade', 'Rio de Janeiro', 'Rua Aquidabã', null, null, 0, '24455450');

insert into perfil_acesso (nome) values ('Dono');
insert into perfil_acesso (nome) values ('Cliente');