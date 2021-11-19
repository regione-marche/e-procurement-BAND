------------------------------
-- AGGIORNAMENTO SITAT/VIGILANZA	
------------------------------

------------------------------
--  GENE 1.4.59
------------------------------

------------------------------
--  GENEWEB 2.0.16
------------------------------

------------------------------
-- SITATSA 2.7.1
--------------------------

------------------------------------------------------------------------------------------------
------------------------         MODIFICA STRUTURA TABELLE              ------------------------
------------------------------------------------------------------------------------------------

CREATE TABLE SITATSA.W9CF_MACROFASI (
	IDMACROFASE	NUMERIC(7) NOT NULL,
	IDSCHEDA NUMERIC(7) NOT NULL
);
ALTER TABLE SITATSA.W9CF_MACROFASI ADD CONSTRAINT W9CF_MACROFASI_PK PRIMARY KEY (IDMACROFASE, IDSCHEDA);

CREATE TABLE SITATSA.W9CF_REGPERMESSI (
	CODCONF NUMERIC(3) NOT NULL,
	NUMREG NUMERIC(3) NOT NULL,
	RUOLO NUMERIC(7),
	MACROFASE NUMERIC(7),
	PERMESSO NUMERIC(7)
);
ALTER TABLE SITATSA.W9CF_REGPERMESSI ADD CONSTRAINT W9CF_REGPERMESSI_PK PRIMARY KEY (CODCONF, NUMREG);
 
CREATE TABLE SITATSA.W9CF_MODPERMESSI_SA (
	CODCONF	NUMERIC(3) NOT NULL,
	CODEIN	VARCHAR(16) NOT NULL,
	APPLICA	VARCHAR(1)
);
ALTER TABLE SITATSA.W9CF_MODPERMESSI_SA ADD CONSTRAINT W9CF_MODPERMESSI_SA_PK PRIMARY KEY (CODCONF, CODEIN);

CREATE TABLE SITATSA.W9PERMESSI (
	CODGARA NUMERIC(10) NOT NULL,
	NUMREG NUMERIC(3) NOT NULL,
	RUOLO NUMERIC(7),
	MACROFASE NUMERIC(7),
	PERMESSO NUMERIC(7)
);
ALTER TABLE SITATSA.W9PERMESSI ADD CONSTRAINT W9PERMESSI_PK PRIMARY KEY (CODGARA, NUMREG);

--- VIEW PERMESSI e RUOLO della GARA
CREATE VIEW SITATSA.V_W9PERMESSI AS
SELECT PP.CODGARA, PP.NUMREG, PP.RUOLO, PP.MACROFASE, PP.PERMESSO FROM SITATSA.W9PERMESSI PP
UNION
SELECT G.CODGARA, T.TAB1TIP AS NUMREG, 14 AS RUOLO, T.TAB1TIP AS MACROFASE, 5 AS PERMESSO
FROM SITATSA.W9GARA G , SITATSA.TAB1 T WHERE T.TAB1COD='W9016' AND G.RUP IS NOT NULL AND NOT EXISTS (SELECT * FROM SITATSA.W9PERMESSI P WHERE P.CODGARA=G.CODGARA);


--- View RUOLO del TECNICO sulla GARA
CREATE VIEW SITATSA.V_RUOLOTECNICO as
SELECT I.CODGARA, I.CODLOTT, I.ID_RUOLO, I.CODTEC, G.CODEIN
  FROM SITATSA.W9INCA I, SITATSA.TECNI T, SITATSA.W9GARA G
 WHERE I.ID_RUOLO IN (15,16,17)
   AND I.CODTEC = T.CODTEC
   AND T.CGENTEI = G.CODEIN
   AND I.CODGARA = G.CODGARA
UNION
SELECT L.CODGARA, L.CODLOTT, 14 as ID_RUOLO, G.RUP as CODTEC, G.CODEIN
  FROM SITATSA.W9GARA G, SITATSA.W9LOTT L, SITATSA.TECNI T
 WHERE G.CODGARA = L.CODGARA
   AND G.RUP IS NOT NULL
   AND G.RUP = T.CODTEC
   AND G.CODEIN = T.CGENTEI;


------------------------------------------------------------------------------------------------
------------------------         MODIFICA AI DATI          -------------------------------------
------------------------------------------------------------------------------------------------

--- Definizione delle macro fasi
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (1,988);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (1,101);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (2,1);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (2,987);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (2,12);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (2,984);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (3,2);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (3,986);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (3,11);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (4,3);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (4,102);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (5,4);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (5,985);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (6,5);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (7,6);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (7,7);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (7,8);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (7,9);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (7,10);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (7,997);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (7,996);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (7,995);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (7,994);
INSERT INTO SITATSA.W9CF_MACROFASI (IDMACROFASE, IDSCHEDA) values (7,998);


--- Macro fasi di gara 
INSERT INTO SITATSA.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) VALUES ('W9016', 1,'Scelta del contraente');
INSERT INTO SITATSA.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) VALUES ('W9016', 2,'Aggiudicazione');
INSERT INTO SITATSA.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) VALUES ('W9016', 3,'Inizio esecuzione contratto');
INSERT INTO SITATSA.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) VALUES ('W9016', 4,'Esecuzione');
INSERT INTO SITATSA.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) VALUES ('W9016', 5,'Conclusione');
INSERT INTO SITATSA.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) VALUES ('W9016', 6,'Collaudo');
INSERT INTO SITATSA.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) VALUES ('W9016', 7,'Eventi significativi');

--- Permessi
INSERT INTO SITATSA.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) VALUES ('W9017', 1,'Nessun accesso');
INSERT INTO SITATSA.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) VALUES ('W9017', 2,'Sola lettura');
INSERT INTO SITATSA.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) VALUES ('W9017', 3,'Solo invio');
INSERT INTO SITATSA.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) VALUES ('W9017', 4,'Lettura/scrittura');
INSERT INTO SITATSA.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) VALUES ('W9017', 5,'Accesso completo');


INSERT INTO SITATSA.C0ENTIT (C0E_NOM, C0E_NUM, C0E_TIP, COE_ARG, C0E_DES, C0E_KEY, C0E_NOM_EX, COE_KEY_EX, C0E_FRM_RI, COE_FRM_CA, COE_FRM_RE) values ('W9CF_MODPERMESSI_SA.W9',80011180,'E','MODPERMSA','Attribuz. di modelli dei permessi alle stazioni appaltanti','CODCONF.W9CF_MODPERMESSI_SA.W9,CODEIN.W9CF_MODPERMESSI_SA.W9',null,null,null,null,'w9_cfpesa');
INSERT INTO SITATSA.C0ENTIT (C0E_NOM, C0E_NUM, C0E_TIP, COE_ARG, C0E_DES, C0E_KEY, C0E_NOM_EX, COE_KEY_EX, C0E_FRM_RI, COE_FRM_CA, COE_FRM_RE) values ('W9CF_REGPERMESSI.W9',80011185,'E','REGPERM','Regole per i modelli dei permessi di accesso alle schede','CODCONF.W9CF_REGPERMESSI.W9,NUMREG.W9CF_REGPERMESSI.W9',null,null,null,null,'w9_cfregp');
INSERT INTO SITATSA.C0ENTIT (C0E_NOM, C0E_NUM, C0E_TIP, COE_ARG, C0E_DES, C0E_KEY, C0E_NOM_EX, COE_KEY_EX, C0E_FRM_RI, COE_FRM_CA, COE_FRM_RE) values ('W9CF_MACROFASI.W9',80011190,'E','MACROFASI','Composizione macrofasi di gara','IDMACROFASE.W9CF_MACROFASI.W9,IDSCHEDA.W9CF_MACROFASI.W9',null,null,null,null,'w9_cfmfasi');
INSERT INTO SITATSA.C0ENTIT (C0E_NOM, C0E_NUM, C0E_TIP, COE_ARG, C0E_DES, C0E_KEY, C0E_NOM_EX, COE_KEY_EX, C0E_FRM_RI, COE_FRM_CA, COE_FRM_RE) values ('W9PERMESSI.W9',80012850,'E','PERMESSI','Regole per i permessi di accesso alle schede','CODGARA.W9PERMESSI.W9','W9GARA.W9','CODGARA.W9GARA.W9',null,null,'w9_perm0');


INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E','P','CODCONF.W9CF_MODPERMESSI_SA.W9','W9M1CODCONF','Codice della configurazione','Cod. configurazione','N3',null,null,'Codice della configurazione');
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E','P','CODEIN.W9CF_MODPERMESSI_SA.W9','W9M1CODEIN','Codice stazione appaltante','Cod. Staz.appaltante','A16',null,null,'Codice stazione appaltante');
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E',null,'APPLICA.W9CF_MODPERMESSI_SA.W9','W9M1APPLICA','Modello da applicare di default?','Default?','A2',null,'SN','Modello da applicare di default?');
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E','P','CODCONF.W9CF_REGPERMESSI.W9','W9RPCODCONF','Codice della configurazione','Cod. configurazione','N3',null,null,'Codice della configurazione');
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E','P','NUMREG.W9CF_REGPERMESSI.W9','W9RPNUMREG','Numero regola','Num. regola','N3',null,null,'Numero regola');
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E',null,'RUOLO.W9CF_REGPERMESSI.W9','W9RPRUOLO','Ruolo utente','Ruolo utente','A100','W3004',null,'Ruolo utente');
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E',null,'MACROFASE.W9CF_REGPERMESSI.W9','W9RPMFASE','Macrofase','Macrofase','A100','W9016',null,'Macrofase');
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E',null,'PERMESSO.W9CF_REGPERMESSI.W9','W9RPPERMESSO','Permesso assegnato','Permesso','A100','W9017',null,'Permesso assegnato');
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E','P','IDMACROFASE.W9CF_MACROFASI.W9','W9MAIDMFASI','Codice della macrofase','Cod. macrofase','A100','W9016',null,'Codice della macrofase');
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E','P','IDSCHEDA.W9CF_MACROFASI.W9','W9MAIDSCHEDA','Codice della scheda','Cod. scheda','A100','W3020',null,'Codice della scheda');
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E','P','CODGARA.W9PERMESSI.W9','W9PECODGARA','Codice della gara','Cod. gara','N10',null,null,'Codice della gara');
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E','P','NUMREG.W9PERMESSI.W9','W9PENUMREG','Numero regola','Num. regola','N3',null,null,'Numero regola');
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E',null,'RUOLO.W9PERMESSI.W9','W9PERUOLO','Ruolo utente','Ruolo utente','A100','W3004',null,'Ruolo utente');
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E',null,'MACROFASE.W9PERMESSI.W9','W9PEMFASE','Macrofase','Macrofase','A100','W9016',null,'Macrofase');
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E',null,'PERMESSO.W9PERMESSI.W9','W9PEPERMESSO','Permesso assegnato','Permesso','A100','W9017',null,'Permesso assegnato');

UPDATE SITATSA.C0CAMPI SET C0C_FS ='N4' WHERE C0C_MNE_BER = 'W3NLOTTO';

--- W_OGGETTI
DELETE FROM SITATSA.W_OGGETTI WHERE TIPO='SEZ' and OGGETTO ='W9.W9ESITO-A22-scheda.campiPubblicEsito';
INSERT INTO SITATSA.W_OGGETTI(TIPO,OGGETTO,DESCR,ORD) values ('SEZ', 'W9.W9ESITO-A22-scheda.campiPubblicazioneEsito', 'Sezione Pubblicazione esito', 3470);
INSERT INTO SITATSA.W_OGGETTI(TIPO,OGGETTO,DESCR,ORD) values ('SEZ', 'W9.W9INIZ-scheda.DETTFASE.campiPubblicazioneEsito', 'Sezione Pubblicazione esito', 3480);
INSERT INTO SITATSA.W_OGGETTI(TIPO,OGGETTO,DESCR,ORD) values ('SUBMENU', 'AMMINISTRAZIONE.AttribuzioneIncarichi', 'Attribuzine incarichi', 3490);
INSERT INTO SITATSA.W_OGGETTI(TIPO,OGGETTO,DESCR,ORD) VALUES ('MASC','W9.W9PERMESSI-scheda','Lista dei permessi di accesso alla gara',3500);
INSERT INTO SITATSA.W_OGGETTI(TIPO,OGGETTO,DESCR,ORD) VALUES ('FUNZ','ALT.W9.W9PERMESSI-Scheda.AttrubuisciModello','Attribuisci modello a fasi',3505);
INSERT INTO SITATSA.W_OGGETTI(TIPO,OGGETTO,DESCR,ORD) VALUES ('FUNZ','DEL.W9.W9PERMESSI-scheda.SCHEDA_A_LISTA','Cancella regole',3510);
INSERT INTO SITATSA.W_OGGETTI(TIPO,OGGETTO,DESCR,ORD) VALUES ('FUNZ','MOD.W9.W9PERMESSI-scheda.SCHEDA_A_LISTA','Modifica modello a fasi',3515);


--- W_OGGETTI
INSERT INTO SITATSA.W_OGGETTI (TIPO,OGGETTO,DESCR,ORD) VALUES ('PAGE','W9.W9LOTT-scheda.INCA','Pagina Incarichi professionali', 2215);
INSERT INTO SITATSA.W_OGGETTI (TIPO,OGGETTO,DESCR,ORD) VALUES ('MASC','W9.W9ESITO-A22-scheda','Scheda Comunicazione esito', 2282);

--- W_AZIONI
INSERT INTO SITATSA.W_AZIONI (TIPO,AZIONE,OGGETTO,DESCR,VALORE,INOR,VISELENCO,CRC) VALUES ('SUBMENU','VIS','AMMINISTRAZIONE.AttribuzioneIncarichi','Visualizza',0,1,1,2729422087);
INSERT INTO SITATSA.W_AZIONI (TIPO,AZIONE,OGGETTO,DESCR,VALORE,INOR,VISELENCO,CRC) VALUES ('SEZ','VIS','W9.W9ESITO-A22-scheda.campiPubblicazioneEsito','Visualizza',0,1,1,1009551400);
INSERT INTO SITATSA.W_AZIONI (TIPO,AZIONE,OGGETTO,DESCR,VALORE,INOR,VISELENCO,CRC) VALUES ('PAGE','VIS','W9.W9LOTT-scheda.INCA','Visualizza',0,1,1,1264033850);

UPDATE SITATSA.ELDAVER SET NUMVER='2.7.1', DATVET=CURRENT TIMESTAMP WHERE CODAPP='W9';

