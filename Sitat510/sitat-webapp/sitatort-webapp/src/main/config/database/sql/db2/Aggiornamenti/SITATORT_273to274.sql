--------------------------------
-- AGGIORNAMENTO SITAT/VIGILANZA
-- Database: DB2
------------------------------



------------------------------
-- SITAT 2.7.4
--------------------------

------------------------------------------------------------------------------------------------
------------------------         MODIFICA STRUTTURA TABELLE             ------------------------
------------------------------------------------------------------------------------------------

ALTER TABLE SITATORT.CENTRICOSTO ADD COLUMN TIPOLOGIA NUMERIC(7);
REORG TABLE SITATORT.CENTRICOSTO;

ALTER TABLE SITATORT.AVVISO ADD COLUMN CODSISTEMA NUMERIC(7);
REORG TABLE SITATORT.AVVISO;
UPDATE SITATORT.AVVISO set CODSISTEMA = 1;

CREATE TABLE SITATORT.AVVISO_OLD
(	CODEIN VARCHAR(16) NOT NULL,
	IDAVVISO NUMERIC(10) NOT NULL,
	CODGARA NUMERIC(10), 
	CODLOTT NUMERIC(10), 
	TIPOAVV NUMERIC(7),
	DATAAVV TIMESTAMP,
	DESCRI VARCHAR(500),
	CIG VARCHAR(10),
	FILE_ALLEGATO BLOB (100 M ) LOGGED NOT COMPACT,
	CODSISTEMA NUMERIC(7)
) IN TBS_SITATSA_N0 INDEX IN TBS_SITATSA_N0;

INSERT INTO SITATORT.AVVISO_OLD (CODEIN, IDAVVISO, CODGARA, CODLOTT, TIPOAVV, DATAAVV, DESCRI, CIG, FILE_ALLEGATO, CODSISTEMA)
	SELECT CODEIN, IDAVVISO, CODGARA, CODLOTT, TIPOAVV, DATAAVV, DESCRI, CIG, FILE_ALLEGATO, CODSISTEMA from SITATORT.AVVISO;
DROP TABLE SITATORT.AVVISO;
   
CREATE TABLE SITATORT.AVVISO
(	CODEIN VARCHAR(16) NOT NULL,
	IDAVVISO NUMERIC(10) NOT NULL,
	CODSISTEMA NUMERIC(7) NOT NULL,
	CODGARA NUMERIC(10), 
	CODLOTT NUMERIC(10), 
	TIPOAVV NUMERIC(7),
	DATAAVV TIMESTAMP,
	DESCRI VARCHAR(500),
	CIG VARCHAR(10),
	FILE_ALLEGATO BLOB (100 M ) LOGGED NOT COMPACT
) IN TBS_SitatORT_N0 INDEX IN TBS_SitatORT_N0;
ALTER TABLE SITATORT.AVVISO ADD CONSTRAINT AVVISO_PK PRIMARY KEY (CODEIN, IDAVVISO, CODSISTEMA);

INSERT INTO SITATORT.AVVISO (CODEIN, IDAVVISO, CODSISTEMA, CODGARA, CODLOTT, TIPOAVV, DATAAVV, DESCRI, CIG, FILE_ALLEGATO)
	SELECT CODEIN, IDAVVISO, CODSISTEMA, CODGARA, CODLOTT, TIPOAVV, DATAAVV, DESCRI, CIG, FILE_ALLEGATO from SITATORT.AVVISO_OLD;
DROP TABLE SITATORT.AVVISO_OLD;

ALTER TABLE SITATORT.W9DOCGARA ADD COLUMN URL VARCHAR(2000);
REORG TABLE SITATORT.W9DOCGARA;

------------------------------------------------------------------------------------------------
------------------------         MODIFICA DATI                           -----------------------
------------------------------------------------------------------------------------------------

Insert into SITATORT.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E',null,'TIPOLOGIA.CENTRICOSTO.W9','W9CCTIPO','Tipologia','Tipologia','A100','W9019',null,'Tipologia');
Insert into SITATORT.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E',null,'CODSISTEMA.AVVISO.W9','W9CODSIS','Codice del sistema','Codice del sistema','N7',null,null,'Codice sistema');
Insert into SITATORT.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E',null,'URL.W9DOCGARA.W9','W9DGURL','URL documentazione','URL documentazione','A2000',null,null,'URL documentazione');

Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('W9019',1,'Giunta',null,1);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('W9019',2,'Consiglio',null,2);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('W9019',3,'Soggetto aggregatore',null,3);

Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('W3005',31,'Affidamento diretto per variante superiore al 20% dell''importo contrattuale',null,31);

Delete from SITATORT.TAB1 where tab1cod='Ag010';
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',1,'Italia',null,1);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',2,'Austria',null,16);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',3,'Belgio',null,22);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',4,'Danimarca',null,54);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',5,'Finlandia',null,65);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',6,'Francia',null,66);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',7,'Germania',null,71);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',8,'Grecia',null,78);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',9,'Irlanda',null,97);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',10,'Lussemburgo',null,134);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',11,'Olanda',null,165);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',12,'Portogallo',null,176);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',13,'Regno unito',null,178);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',14,'Spagna',null,210);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',15,'Svezia',null,218);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',16,'Andorra',null,5);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',17,'Emirati Arabi Uniti',null,59);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',18,'Afghanistan',null,2);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',19,'Antigua e Barbuda',null,9);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',20,'Anguilla',null,7);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',21,'Albania',null,3);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',22,'Armenia',null,13);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',23,'Antille Olandesi',null,10);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',24,'Angola',null,6);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',25,'Antartico',null,8);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',26,'Argentina',null,12);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',27,'Samoa Americane',null,196);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',28,'Australia',null,15);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',29,'Aruba',null,14);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',30,'Isole Aland',null,103);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',31,'Azerbaigian',null,17);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',32,'Bosnia-Erzegovina',null,30);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',33,'Barbados',null,21);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',34,'Bangladesh',null,20);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',35,'Burkina Faso',null,35);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',36,'Bulgaria',null,34);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',37,'Bahrain',null,19);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',38,'Burundi',null,36);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',39,'Benin',null,24);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',40,'Saint-Barthelemy',null,193);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',41,'Bermuda',null,25);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',42,'Brunei',null,33);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',43,'Bolivia',null,29);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',44,'Brasile',null,32);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',45,'Bahamas',null,18);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',46,'Bhutan',null,26);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',47,'Isola Bouvet',null,99);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',48,'Botswana',null,31);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',49,'Bielorussia',null,27);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',50,'Belize',null,23);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',51,'Canada',null,39);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',52,'Isole Cocos',null,105);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',53,'Repubblica Democratica del Congo',null,182);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',54,'Repubblica Centrafricana',null,180);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',55,'Repubblica del Congo',null,181);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',56,'Svizzera',null,219);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',57,'Costa d''''Avorio',null,50);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',58,'Isole Cook',null,106);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',59,'Cile',null,42);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',60,'Camerun',null,38);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',61,'Cina',null,43);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',62,'Colombia',null,46);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',63,'Costa Rica',null,51);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',64,'Cuba',null,53);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',65,'Capo Verde',null,40);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',66,'Isola Christmas',null,100);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',67,'Cipro',null,44);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',68,'Repubblica Ceca',null,179);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',69,'Gibuti',null,76);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',70,'Dominica',null,55);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',71,'Repubblica Dominicana',null,184);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',72,'Algeria',null,4);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',73,'Ecuador',null,56);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',74,'Estonia',null,61);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',75,'Egitto',null,57);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',76,'Sahara Occidentale',null,189);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',77,'Eritrea',null,60);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',78,'Etiopia',null,62);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',79,'Figi',null,63);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',80,'Isole Falkland',null,107);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',81,'Stati Federati di Micronesia',null,212);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',82,'Isole Faorer',null,108);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',83,'Gabon',null,67);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',84,'Grenada',null,79);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',85,'Georgia',null,69);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',86,'Guyana Francese',null,89);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',87,'Guernsey',null,84);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',88,'Ghana',null,72);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',89,'Gibilterra',null,75);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',90,'Groenlandia',null,80);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',91,'Gambia',null,68);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',92,'Guinea',null,85);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',93,'Guadalupa',null,81);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',94,'Guinea Equatoriale',null,86);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',95,'Georgia del Sud e isole Sandwich meridionali',null,70);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',96,'Guatemala',null,83);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',97,'Guam',null,82);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',98,'Guinea-Bissau',null,87);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',100,'Hong Kong',null,92);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',101,'Isole Heard e McDonald',null,109);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',102,'Honduras',null,91);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',103,'Croazia',null,52);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',104,'Haiti',null,90);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',105,'Ungheria',null,238);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',106,'Indonesia',null,94);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',107,'Israele',null,118);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',108,'Isola di Man',null,101);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',109,'India',null,93);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',110,'Territori Britannici dell''Oceano Indiano',null,223);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',111,'Iraq',null,96);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',112,'Iran',null,95);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',113,'Islanda',null,98);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',114,'Jersey',null,119);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',115,'Giamaica',null,73);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',116,'Giordania',null,77);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',117,'Giappone',null,74);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',118,'Kenya',null,121);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',119,'Kirghizistan',null,122);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',120,'Cambogia',null,37);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',121,'Kiribati',null,123);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',122,'Comore',null,47);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',123,'Saint Kitts e Nevis',null,190);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',124,'Corea del Nord',null,48);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',125,'Corea del Sud',null,49);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',126,'Kuwait',null,125);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',127,'Isole Cayman',null,104);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',128,'Kazakistan',null,120);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',129,'Laos',null,126);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',130,'Libano',null,129);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',131,'Santa Lucia',null,198);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',132,'Liechtenstein',null,132);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',133,'Sri Lanka',null,211);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',134,'Liberia',null,130);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',135,'Lesotho',null,127);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',136,'Lituania',null,133);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',137,'Lettonia',null,128);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',138,'Libia',null,131);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',139,'Marocco',null,143);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',140,'Monaco',null,150);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',141,'Moldavia',null,149);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',142,'Montenegro',null,152);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',143,'Saint-Martin',null,194);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',144,'Madagascar',null,137);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',145,'Isole Marshall',null,111);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',146,'Macedonia',null,136);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',147,'Mali',null,141);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',148,'Birmania',null,28);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',149,'Mongolia',null,151);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',150,'Macao',null,135);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',151,'Isole Marianne Settentrionali',null,110);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',152,'Martinica',null,144);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',153,'Mauritania',null,145);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',154,'Montserrat',null,153);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',155,'Malta',null,142);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',156,'Mauritius',null,146);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',157,'Maldive',null,139);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',158,'Malawi',null,138);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',159,'Messico',null,148);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',160,'Malesia',null,140);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',161,'Mozambico',null,154);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',162,'Namibia',null,155);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',163,'Nuova Caledonia',null,163);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',164,'Niger',null,159);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',165,'Isola Norfolk',null,102);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',166,'Nigeria',null,160);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',167,'Nicaragua',null,158);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',168,'Norvegia',null,162);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',169,'Nepal',null,157);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',170,'Nauru',null,156);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',171,'Niue',null,161);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',172,'Nuova Zelanda',null,164);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',173,'Oman',null,166);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',174,'Panama',null,169);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',175,'Peru''',null,172);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',176,'Polinesia Francese',null,173);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',177,'Papua Nuova Guinea',null,170);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',178,'Filippine',null,64);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',179,'Pakistan',null,167);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',180,'Polonia',null,174);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',181,'Saint Pierre e Miquelon',null,191);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',182,'Isole Pitcairn',null,113);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',183,'Porto Rico',null,175);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',184,'Territori Palestinesi Occupati',null,225);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',185,'Palau',null,168);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',186,'Paraguay',null,171);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',187,'Qatar',null,177);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',188,'Reunion',null,185);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',189,'Romania',null,186);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',190,'Serbia',null,202);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',191,'Russia',null,188);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',192,'Ruanda',null,187);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',193,'Arabia Saudita',null,11);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',194,'Isole Salomone',null,114);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',195,'Seychelles',null,203);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',196,'Sudan',null,215);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',197,'Singapore',null,205);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',198,'Sant''Elena',null,199);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',199,'Slovenia',null,208);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',200,'Svalbard',null,217);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',201,'Slovacchia',null,207);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',202,'Sierra Leone',null,204);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',203,'San Marino',null,197);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',204,'Senegal',null,201);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',205,'Somalia',null,209);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',206,'Suriname',null,216);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',207,'Sao Tome''e Principe',null,200);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',208,'El Salvador',null,58);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',209,'Siria',null,206);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',210,'Swaziland',null,220);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',211,'Isole Turks e Caicos',null,115);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',212,'Ciad',null,41);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',213,'Territori Francesi del Sud',null,224);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',214,'Togo',null,228);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',215,'Thailandia',null,226);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',216,'Tagikistan',null,221);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',217,'Tokelau',null,229);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',218,'Timor Est',null,227);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',219,'Turkmenistan',null,234);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',220,'Tunisia',null,232);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',221,'Tonga',null,230);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',222,'Turchia',null,233);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',223,'Trinidad e Tobago',null,231);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',224,'Tuvalu',null,235);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',225,'Repubblica di Cina',null,183);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',226,'Tanzania',null,222);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',227,'Ucraina',null,236);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',228,'Uganda',null,237);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',229,'Isole minori esterne degli Stati Uniti',null,112);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',230,'Stati Uniti d''America',null,213);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',231,'Uruguay',null,239);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',232,'Uzbekistan',null,240);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',233,'Citta''del Vaticano',null,45);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',234,'Saint Vincent e Grenadine',null,192);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',235,'Venezuela',null,242);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',236,'Isole Vergini Britanniche',null,117);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',237,'Isole Vergini Americane',null,116);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',238,'Vietnam',null,243);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',239,'Vanuatu',null,241);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',240,'Wallis e Futuna',null,244);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',241,'Samoa',null,195);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',242,'Yemen',null,245);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',243,'Mayotte',null,147);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',244,'Sudafrica',null,214);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',245,'Zambia',null,246);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',246,'Zimbabwe',null,247);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',247,'Guyana',null,88);
Insert into SITATORT.TAB1 (TAB1COD,TAB1TIP,TAB1DESC,TAB1MOD,TAB1NORD) values ('Ag010',248,'Kosovo',null,124);

Update SITATORT.TAB2 set tab2d1='247' where tab2cod='W3z12' and tab2d1='99';

INSERT INTO SITATORT.TAB1 (TAB1COD, TAB1TIP, TAB1DESC,TAB1MOD,TAB1NORD) values ('W3020',13,'Anagrafica semplificata e bando di gara',null,3);

UPDATE SITATORT.C0CAMPI set COC_DOM = null where C0C_MNE_BER = 'NOMEIN' and COC_DOM = 'NOTE';

--- Inizializzazione del campo W9FLUSSI.KEY02 per i flussi dell'area 3 (Avvisi)
UPDATE SITATORT.W9FLUSSI set KEY02=1 where AREA=3 and KEY03=989;

UPDATE SITATORT.ELDAVER SET NUMVER='2.7.4', DATVET=CURRENT_TIMESTAMP WHERE CODAPP='W9';

