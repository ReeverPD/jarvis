

DROP TABLE IF EXISTS User;
CREATE TABLE User (
  Id bigint(20) NOT NULL AUTO_INCREMENT,
  Profile_Id varchar(255) DEFAULT NULL,
  Profile_Picture varchar(255) DEFAULT NULL,
  Profile_Token varchar(255) DEFAULT NULL,
  Profile_Link varchar(255) DEFAULT NULL,
  Profile_Cover varchar(45) DEFAULT NULL,
  Social_Media_Type char(1) DEFAULT 'F' COMMENT 'F->Facebook\nG->Google\nT->Twitter',
  ActivationToken varchar(255) DEFAULT NULL,
  Username varchar(255) DEFAULT NULL,
  Password varchar(255) DEFAULT NULL,
  Nome varchar(255) DEFAULT NULL,
  Sobrenome varchar(255) DEFAULT NULL,
  Email varchar(255) DEFAULT NULL,
  Descricao text,
  TipoUsuario char(1) DEFAULT 'P' COMMENT 'E->Empresa\nC->Consultor\nP->Profissional',
  PRIMARY KEY (Id)
);


DROP TABLE IF EXISTS Agenda;
CREATE TABLE Agenda (
  Id bigint(20) NOT NULL AUTO_INCREMENT,
  NomeAgenda varchar(45) DEFAULT NULL,
  DiaSemanaInicio int(11) DEFAULT NULL,
  DiaSemanaFim int(11) DEFAULT NULL,
  Aberta char(1) DEFAULT NULL,
  Id_User bigint(20) NOT NULL,
  MinutosCompromisso float DEFAULT NULL,
  PRIMARY KEY (Id),
  CONSTRAINT fk_Agenda_User1 FOREIGN KEY (Id_User) REFERENCES User (Id) ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS CMSUsers;
CREATE TABLE CMSUsers (
  Id bigint(20) NOT NULL AUTO_INCREMENT,
  Username varchar(255) DEFAULT NULL,
  Password varchar(255) DEFAULT NULL,
  Ativo varchar(45) DEFAULT NULL,
  Email varchar(45) DEFAULT NULL,
  Picture varchar(255) DEFAULT NULL,
  Token varchar(255) DEFAULT NULL,
  PRIMARY KEY (Id)
);


DROP TABLE IF EXISTS Compromisso;
CREATE TABLE Compromisso (
  Id bigint(20) NOT NULL,
  Id_Agenda bigint(20) NOT NULL,
  Id_User_From bigint(20) NOT NULL,
  Id_User_To bigint(20) NOT NULL,
  Titulo varchar(255) DEFAULT NULL,
  Descricao text,
  PRIMARY KEY (Id),
  CONSTRAINT fk_Compromisso_Agenda1 FOREIGN KEY (Id_Agenda) REFERENCES Agenda (Id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_Compromisso_User1 FOREIGN KEY (Id_User_From) REFERENCES User (Id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_Compromisso_User2 FOREIGN KEY (Id_User_To) REFERENCES User (Id) ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS Contato;
CREATE TABLE Contato (
  Id bigint(20) NOT NULL AUTO_INCREMENT,
  Nome varchar(255) DEFAULT NULL,
  Email varchar(255) DEFAULT NULL,
  Assunto varchar(255) DEFAULT NULL,
  Mensagem text,
  Id_User bigint(20) DEFAULT NULL,
  PRIMARY KEY (Id),
  CONSTRAINT fk_Contato_User FOREIGN KEY (Id_User) REFERENCES User (Id) ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS ConversaCompromisso;
CREATE TABLE ConversaCompromisso (
  Id bigint(20) NOT NULL AUTO_INCREMENT,
  Id_Compromisso bigint(20) NOT NULL,
  Id_User bigint(20) NOT NULL,
  Data datetime DEFAULT NULL,
  Texto text,
  PRIMARY KEY (Id),
  CONSTRAINT fk_ConversaCompromisso_Compromisso1 FOREIGN KEY (Id_Compromisso) REFERENCES Compromisso (Id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_ConversaCompromisso_User1 FOREIGN KEY (Id_User) REFERENCES User (Id) ON DELETE NO ACTION ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS DadosCobranca;
CREATE TABLE DadosCobranca (
  Id bigint(20) NOT NULL AUTO_INCREMENT,
  Nome varchar(255) DEFAULT NULL,
  Endereco varchar(255) DEFAULT NULL,
  IsBoleto char(1) DEFAULT NULL,
  DiaVencimento char(2) DEFAULT NULL,
  Id_User bigint(20) NOT NULL,
  TipoPagamento char(1) DEFAULT 'C' COMMENT 'C-> Cartao de Credito\nB-> Boleto\n',
  Documento varchar(45) DEFAULT NULL,
  PRIMARY KEY (Id),
  CONSTRAINT fk_DadosCobranca_User1 FOREIGN KEY (Id_User) REFERENCES User (Id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS Faq;
CREATE TABLE Faq (
  Id bigint(20) NOT NULL AUTO_INCREMENT,
  Titulo varchar(255) DEFAULT NULL,
  Descricao text,
  QuantUtil int(11) DEFAULT NULL,
  QuantInutil int(11) DEFAULT NULL,
  Nro int(11) DEFAULT NULL,
  PRIMARY KEY (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS HistoricoCobranca;
CREATE TABLE HistoricoCobranca (
  Id bigint(20) NOT NULL AUTO_INCREMENT,
  Id_DadosCobranca bigint(20) NOT NULL,
  CodigoCobranca bigint(20) NOT NULL,
  StatusCobranca char(1) DEFAULT 'A',
  StatusAnterior char(1) DEFAULT NULL,
  DataCobranca datetime DEFAULT NULL,
  ValorTotal float DEFAULT NULL,
  TotalCompromissos int(11) DEFAULT NULL,
  ValorUnitario float DEFAULT NULL,
  IdMoipCobranca varchar(255) NOT NULL,
  StatusProcessamento char(1) DEFAULT NULL COMMENT '1 -> Pago\n2 -> N��o Pago\n3 -> Ag. Processamento\n4 -> N��o Fechado',
  TotalDesconto float DEFAULT NULL,
  Obs text,
  PRIMARY KEY (Id),
  CONSTRAINT fk_HistoricoCobranca_DadosCobranca1 FOREIGN KEY (Id_DadosCobranca) REFERENCES DadosCobranca (Id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS Horario;
CREATE TABLE Horario (
  Id bigint(20) NOT NULL AUTO_INCREMENT,
  DIa date DEFAULT NULL,
  HorarioInicio time DEFAULT NULL,
  HorarioFim time DEFAULT NULL,
  Id_Compromisso bigint(20) NOT NULL,
  Status char(1) DEFAULT NULL COMMENT 'A->Aceito\nC->Cancelado\nD->Desmarcado\n',
  Obs varchar(45) DEFAULT NULL,
  Id_Horario_Pai bigint(20) DEFAULT NULL,
  PRIMARY KEY (Id),
  CONSTRAINT fk_Horario_Compromisso1 FOREIGN KEY (Id_Compromisso) REFERENCES Compromisso (Id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_Horario_Horario1 FOREIGN KEY (Id_Horario_Pai) REFERENCES Horario (Id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS ItemCobranca;
CREATE TABLE ItemCobranca (
  Id bigint(20) NOT NULL AUTO_INCREMENT,
  Nome varchar(255) DEFAULT NULL,
  ValorUnitario float DEFAULT NULL,
  Itens int(11) DEFAULT NULL,
  Taxa float DEFAULT NULL,
  Id_HistoricoCobranca bigint(20) NOT NULL,
  PRIMARY KEY (Id),
  CONSTRAINT fk_ItemCobranca_HistoricoCobranca1 FOREIGN KEY (Id_HistoricoCobranca) REFERENCES HistoricoCobranca (Id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS JOB;
CREATE TABLE JOB (
  Id bigint(20) NOT NULL AUTO_INCREMENT,
  Nome varchar(45) DEFAULT NULL,
  CronTime varchar(45) DEFAULT NULL,
  InstanceName varchar(255) DEFAULT NULL,
  PRIMARY KEY (Id)
);

DROP TABLE IF EXISTS JOB_Exection;
CREATE TABLE JOB_Exection (
  Id bigint(20) NOT NULL AUTO_INCREMENT,
  Id_JOB bigint(20) NOT NULL,
  ExecTime datetime DEFAULT NULL,
  EndTime datetime DEFAULT NULL,
  Output text,
  PRIMARY KEY (Id),
  CONSTRAINT fk_JOB_Exection_JOB1 FOREIGN KEY (Id_JOB) REFERENCES JOB (Id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS ParametroAplicativo;
CREATE TABLE ParametroAplicativo (
  Id bigint(20) NOT NULL AUTO_INCREMENT,
  Grupo varchar(255) DEFAULT NULL,
  Parametro varchar(45) DEFAULT NULL,
  Valor varchar(255) DEFAULT NULL,
  Ativo varchar(1) DEFAULT NULL,
  PRIMARY KEY (Id)
);


DROP TABLE IF EXISTS Vertical;
CREATE TABLE Vertical (
  Id bigint(20) NOT NULL AUTO_INCREMENT,
  Nome varchar(45) DEFAULT NULL,
  Ativo char(1) DEFAULT NULL,
  Id_VerticalPai bigint(20) DEFAULT NULL,
  PRIMARY KEY (Id),
  CONSTRAINT fk_Vertical_Vertical1 FOREIGN KEY (Id_VerticalPai) REFERENCES Vertical (Id) ON DELETE NO ACTION ON UPDATE NO ACTION
) DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS VerticalUser;
CREATE TABLE VerticalUser (
  Id bigint(20) NOT NULL,
  Id_Vertical bigint(20) NOT NULL,
  Id_User bigint(20) NOT NULL,
  PRIMARY KEY (Id),
  CONSTRAINT fk_VerticalUser_User1 FOREIGN KEY (Id_User) REFERENCES User (Id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_VerticalUser_Vertical1 FOREIGN KEY (Id_Vertical) REFERENCES Vertical (Id) ON DELETE NO ACTION ON UPDATE NO ACTION
);
