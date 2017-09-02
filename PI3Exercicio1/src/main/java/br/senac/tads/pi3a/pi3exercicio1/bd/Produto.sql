/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  diogo.sfelix
 * Created: 31/08/2017
 */


CREATE TABLE produto 
( 
id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT pk_produto PRIMARY KEY,
nome VARCHAR(100) NOT NULL, 
descricao VARCHAR(500), 
vl_compra DECIMAL(11,2) NOT NULL, 
vl_venda DECIMAL(11,2) NOT NULL, 
categoria VARCHAR(500), 
dt_cadastro TIMESTAMP NOT NULL 
);