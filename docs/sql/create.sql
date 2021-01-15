create database unimanager_db;

use unimanager_db;

create user 'unimanager'@'localhost' identified by 'unimanager';

grant all privileges on unimanager_db.* to 'unimanager'@'localhost';

create table alunos (alu_id int not null auto_increment,
					 alu_nome varchar(60) not null,
					 alu_local varchar(30),
					 alu_dnsc date not null,
					 alu_sexo char(1) not null,
					 alu_email varchar(30),
					 alu_cur_id int,
					 primary key (alu_id));
		     		     
create table cursos (cur_id int not null auto_increment,
					 cur_nome varchar(40) not null,
					 primary key (cur_id));
		           
create table departamentos (dep_id int not null auto_increment,
						    dep_nome varchar(60) not null,
							dep_sigla char(3) not null,
							primary key (dep_id));	     
		           
create table disciplinas (dis_id int not null auto_increment,
						  dis_nome varchar(40) not null,
					      dis_creditos tinyint not null,
						  dis_dep_id int,
						  primary key (dis_id));
		    
create table planoestudos (pla_cur_id int not null,
						   pla_dis_id int not null,
						   pla_semestre tinyint not null,
						   primary key (pla_cur_id, pla_dis_id));		
		            		                 		     
create table inscricoes (ins_id int not null auto_increment,
						 ins_alu_id int not null,
						 ins_pla_cur_id int not null,
						 ins_pla_dis_id int not null,
						 ins_dt_inscricao date not null,
						 ins_dt_avaliacao date,
						 ins_nota decimal(4,2),
						 primary key (ins_id));

-- Chaves estrangeiras
alter table alunos add constraint alunos_fk_cursos
            foreign key (alu_cur_id) references cursos(cur_id) 
			ON DELETE NO ACTION ON UPDATE NO ACTION;
            
alter table disciplinas add constraint disciplinas_fk_departamentos
            foreign key (dis_dep_id) references departamentos(dep_id) 
			ON DELETE NO ACTION ON UPDATE NO ACTION;
            
alter table planoestudos add constraint planoestudos_fk_cursos
            foreign key (pla_cur_id) references cursos(cur_id) 
			ON DELETE NO ACTION ON UPDATE NO ACTION;            
            
alter table planoestudos add constraint planoestudos_fk_disciplinas
            foreign key (pla_dis_id) references disciplinas(dis_id) 
			ON DELETE NO ACTION ON UPDATE NO ACTION;            

alter table inscricoes add constraint inscricoes_fk_alunos
            foreign key (ins_alu_id) references alunos(alu_id) 
			ON DELETE NO ACTION ON UPDATE NO ACTION; 
                        
alter table inscricoes add constraint inscricoes_fk_planoestudos
            foreign key (ins_pla_cur_id,ins_pla_dis_id) references planoestudos(pla_cur_id,pla_dis_id) 
			ON DELETE NO ACTION ON UPDATE NO ACTION; 

