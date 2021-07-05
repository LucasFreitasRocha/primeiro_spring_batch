create database spring_batch;
use spring_batch;

show tables;

-- quantas vezes o job foi executado
select * from batch_job_instance;
-- total de execução, mesmo se houve falha
select * from batch_job_execution;
-- pode salvar dados na execução do job, ele está na tabela
select * from batch_job_execution_context;
-- tabela que informa os parametros de um job
select * from batch_job_execution_params;
-- Quais step foram executados
select * from batch_step_execution;
-- salvar dados do step
select * from batch_step_execution_context;

create database app;



