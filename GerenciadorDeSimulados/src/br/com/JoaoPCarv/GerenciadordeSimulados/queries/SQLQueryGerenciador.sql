create database GerenciadordeSimulados;

use GerenciadordeSimulados;

create table Administrador(adm_login varchar(50), adm_ID int, adm_senha varchar(50), adm_path varchar(1000));

insert into Administrador(adm_login, adm_ID, adm_senha, adm_path) values('SysAdmin_Master', 1, '12345678', 'C:\\Users\\Administrador.000\\.eclipse\\GerenciadorDeSimulados
  \\src\\br\\com\\JoaoPCarv\\GerenciadordeSimulados\\admins\\ADM1.txt');

  delete from Administrador where adm_ID = 4;

  select * from Administrador;

  Delete from Administrador