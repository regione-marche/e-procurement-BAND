------------------------------
-- AGGIORNAMENTO SITAT	
--------------------------------------------
-- AGGIORNAMENTO GENE da 1.4.49 a 1.4.50  --
--------------------------------------------
INSERT INTO SITATSA.TAB1 (TAB1COD, TAB1TIP, TAB1DESC, TAB1NORD) VALUES ('Ag008',12,'Studio associato L.1815/39 (art.90 c.1/d DLgs 163/2006)',7);

INSERT INTO SITATSA.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) VALUES ('IMPR.GENE#18',80020256,'C','','Anagrafico delle IMPRESE','CODIMP.IMPR.GENE','V_GARE_AGGIUDICATE.GARE','DITTA.V_GARE_AGGIUDICATE.GARE','g_impr2','g_impr1','g_impr0');
INSERT INTO SITATSA.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) VALUES ('IMPR.GENE#19',80020256,'C','','Anagrafico delle IMPRESE','CODIMP.IMPR.GENE','RAGIMP.GENE', 'CODDIC.RAGIMP.GENE','g_impr2','g_impr1','g_impr0');

Delete from SITATSA.C0ENTIT where C0E_NOM='TEIM.GENE#2';
INSERT INTO SITATSA.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) VALUES ('TEIM.GENE#2',80020502,'C','','Anagrafe Tecnici Imprese','CODTIM.TEIM.GENE','V_GARE_AGGIUDICATE.GARE','CODLEG.V_GARE_AGGIUDICATE.GARE','','','g_teim0');

UPDATE SITATSA.ELDAVER SET NUMVER='1.4.50' WHERE CODAPP='G_';

---------------------------------------------
-- AGGIORNAMENTO GENEWEB da 1.6.6 a 2.0.0  --
---------------------------------------------

ALTER TABLE SITATSA.W_INVCOM ADD COLUMN COMMSGTIP VARCHAR(1);
REORG TABLE SITATSA.W_INVCOM;

Delete from SITATSA.W_OGGETTI WHERE TIPO='PAGE' AND OGGETTO in ('GENE.ImprScheda.CATEGARE','GENE.ImprScheda.CATE');
INSERT INTO SITATSA.W_OGGETTI (TIPO,OGGETTO, DESCR,ORD) VALUES ('PAGE','GENE.ImprScheda.CATEGARE','Pagina "Categorie iscrizione elenchi operatori"',937);
INSERT INTO SITATSA.W_OGGETTI (TIPO,OGGETTO, DESCR,ORD) VALUES ('PAGE','GENE.ImprScheda.CATE','Pagina "Attestazioni SOA"',933);

INSERT INTO SITATSA.C0CAMPI(COC_CONTA,C0C_TIP,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DES_WEB) VALUES (100000120,'P','COMMSGTIP.W_INVCOM.GENEWEB','COMMSGTIP','Testo del messaggio in formato HTML?','Testo in HTML?','SN',NULL,'Testo in HTML?');

UPDATE SITATSA.ELDAVER SET NUMVER='2.0.0' WHERE CODAPP='W_';
 
-------------------------------------------
--   AGGIORNAMENTO PT da 1.0.1 a 3.0.0   --
-------------------------------------------
CREATE TABLE SITATSA.PTCONTROLLI 
   (	CODCONTROLLO NUMERIC(7) NOT NULL,
	DESCCONTROLLO VARCHAR(2000),
	MSGCONTROLLO VARCHAR(2000),
	TIPOCONTROLLO VARCHAR(1)
   ) IN TBS_SITATSA_N0 INDEX IN TBS_SITATSA_N0;
ALTER TABLE SITATSA.PTCONTROLLI ADD CONSTRAINT PTCONTROLLI_PK PRIMARY KEY ( CODCONTROLLO );
GRANT SELECT,INSERT,UPDATE,DELETE ON TABLE SITATSA.PTCONTROLLI TO USER SITATSA;

ALTER TABLE SITATSA.PIATRI ADD COLUMN NOTSCHE2 VARCHAR(2000);
ALTER TABLE SITATSA.PIATRI ADD COLUMN NOTSCHE4 VARCHAR(2000);
REORG TABLE SITATSA.PIATRI;

ALTER TABLE SITATSA.INTTRI ADD COLUMN NPROGINT NUMERIC(5);
ALTER TABLE SITATSA.INTTRI ADD COLUMN TIPINT NUMERIC(7);
REORG TABLE SITATSA.INTTRI;

UPDATE SITATSA.INTTRI i SET TIPINT = (SELECT TIPROG FROM SITATSA.PIATRI p WHERE i.CONTRI=p.CONTRI);
UPDATE SITATSA.INTTRI SET NPROGINT = CONINT WHERE TIPINT=1;

UPDATE SITATSA.TABSCHE SET TABDESC='Adeguamento normativo/sismico' where TABCOD='S2016' AND TABCOD1='ADN';
UPDATE SITATSA.TABSCHE SET TABDESC='Manutenzione' where TABCOD='S2008' AND TABCOD4 = '6';
DELETE FROM SITATSA.TABSCHE WHERE TABCOD='S2008' AND TABCOD4 > '6';
Delete from SITATSA.TABSCHE WHERE TABCOD='S2015' AND TABCOD1='05';
INSERT INTO SITATSA.TABSCHE(TABCOD,TABCOD1,TABCOD2,TABDESC) VALUES('S2015','05','0','Locazione finanziaria');

INSERT INTO SITATSA.C0CAMPI(COC_CONTA,C0C_CHI,C0C_TIP,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DES_WEB) VALUES (678730021, 'E','P', 'CODCONTROLLO.PTCONTROLLI.PIANI','PTCONTCOD','Codice del controllo','Codice','N7',NULL,'Codice controllo');
INSERT INTO SITATSA.C0CAMPI(COC_CONTA,C0C_TIP,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DES_WEB) VALUES (678730022,'E','DESCCONTROLLO.PTCONTROLLI.PIANI','PTCONTDESC','Descrizione del controllo','Descrizione','NOTE',NULL,'Descrizione controllo');
INSERT INTO SITATSA.C0CAMPI(COC_CONTA,C0C_TIP,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DES_WEB) VALUES (678730023,'E','MSGCONTROLLO.PTCONTROLLI.PIANI','PTCONTMSG','Messaggio di errore','Messaggio','NOTE',NULL,'Messaggio di errore');
INSERT INTO SITATSA.C0CAMPI(COC_CONTA,C0C_TIP,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DES_WEB) VALUES (678730024,'E','TIPOCONTROLLO.PTCONTROLLI.PIANI','PTCONTTIPO','Tipo di controllo','Tipo controllo','A1',NULL,'Tipo controllo');

INSERT INTO SITATSA.C0CAMPI(COC_CONTA,C0C_TIP,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,COC_DOM,C0C_TAB1,COC_DES_WEB) VALUES (0, 'E','NOTSCHE2.PIATRI.PIANI','T2NOTSCH2','Note scheda 2','Note Scheda 2','A2000','NOTE',NULL,'Note scheda 2');
INSERT INTO SITATSA.C0CAMPI(COC_CONTA,C0C_TIP,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,COC_DOM,C0C_TAB1,COC_DES_WEB) VALUES (0, 'E','NOTSCHE4.PIATRI.PIANI','T2NOTSCH4','Note scheda 4','Note Scheda 4','A2000','NOTE',NULL,'Note scheda 4');

INSERT INTO SITATSA.C0CAMPI(COC_CONTA,C0C_TIP,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DES_WEB) VALUES (0,'E','NPROGINT.INTTRI.PIANI','T2NPROGINT','Numero progressivo','N.prog.','N5',NULL,'Numero progressivo');
INSERT INTO SITATSA.C0CAMPI(COC_CONTA,C0C_TIP,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DES_WEB) VALUES (0,'E','TIPINT.INTTRI.PIANI','T2TIPINT','Tipologia di intervento (lavori/forniture e servizi)','Tipologia','A100','W9002','Tipologia di intervento');

UPDATE SITATORT.TAB1 SET TAB1NORD = 0 WHERE TAB1COD='W3995';

UPDATE SITATSA.ELDAVER SET NUMVER='3.0.0' WHERE CODAPP='PT';

----------------------------------
---   AGGIORNAMENTO PT 3.1.0   ---
----------------------------------
ALTER TABLE SITATSA.CUPDATI ADD COLUMN UUID VARCHAR(40);
REORG TABLE SITATSA.CUPDATI;

INSERT INTO SITATSA.C0CAMPI(COC_CONTA,C0C_TIP,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DES_WEB) VALUES (678030067,'E','UUID.CUPDATI.PIANI','CUPDATIUUID','Identificativo univoco','Id. univoco','A40',NULL,'Id. univoco');

UPDATE SITATSA.ELDAVER SET NUMVER='3.1.0' WHERE CODAPP='PT';

------------------------------
-- SITATSA 2.4.3
--------------------------

ALTER TABLE SITATSA.W9GARA ADD COLUMN INDSEDE VARCHAR(100);
ALTER TABLE SITATSA.W9GARA ADD COLUMN COMSEDE VARCHAR(32);
ALTER TABLE SITATSA.W9GARA ADD COLUMN PROSEDE VARCHAR(2);
REORG TABLE SITATSA.W9APPA;
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) VALUES (0,'E',null,'INDSEDE.W9GARA.W9','W9GAINDSEDE','Indirizzo sede di gara','Indirizzo sede gara','A100',null,null,'Indirizzo sede di gara');
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) VALUES (0,'E',null,'COMSEDE.W9GARA.W9','W9GACOMSEDE','Comune sede di gara','Comune sede gara','A32',null,null,'Comune sede di gara');
INSERT INTO SITATSA.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) VALUES (0,'E',null,'PROSEDE.W9GARA.W9','W9GAPROSEDE','Provincia sede di gara','Provincia sede gara','A40','Agx15',null,'Provincia sede di gara');


-- Calcolo della situazione dei lotti e delle gare
Update SITATSA.W9LOTT l set SITUAZIONE=8 where exists (select 1 from SITATSA.W9ESITO t join SITATSA.W9FASI f on t.CODGARA=f.CODGARA and t.CODLOTT=f.CODLOTT join SITATSA.W9FLUSSI i on f.CODGARA=i.KEY01 and f.CODLOTT=i.KEY02 where f.FASE_ESECUZIONE=984 and l.CODGARA=t.CODGARA and l.CODLOTT=t.CODLOTT AND t.ESITO_PROCEDURA>1) and SITUAZIONE is null;
Update SITATSA.W9LOTT l set SITUAZIONE=5 where exists (select 1 from SITATSA.W9SOSP t join SITATSA.W9FASI f  on t.CODGARA=f.CODGARA and t.CODLOTT=f.CODLOTT join SITATSA.W9FLUSSI i on f.CODGARA=i.KEY01 and f.CODLOTT=i.KEY02 where f.FASE_ESECUZIONE=6 and l.CODGARA=t.CODGARA and l.CODLOTT=t.CODLOTT AND t.DATA_VERB_RIPR IS NULL) and SITUAZIONE is null;
Update SITATSA.W9LOTT l set SITUAZIONE=7 where exists (select 1 from SITATSA.W9FASI f join SITATSA.W9FLUSSI i on f.CODGARA=i.KEY01 and f.CODLOTT=i.KEY02 where f.FASE_ESECUZIONE=5 and l.CODGARA=i.KEY01 and l.CODLOTT=i.KEY02 ) and SITUAZIONE is null;
Update SITATSA.W9LOTT l set SITUAZIONE=6 where exists (select 1 from SITATSA.W9FASI f join SITATSA.W9FLUSSI i on f.CODGARA=i.KEY01 and f.CODLOTT=i.KEY02 where f.FASE_ESECUZIONE in (4,985) and l.CODGARA=i.KEY01 and l.CODLOTT=i.KEY02) and SITUAZIONE is null;
Update SITATSA.W9LOTT l set SITUAZIONE=4 where exists (select 1 from SITATSA.W9FASI f join SITATSA.W9FLUSSI i on f.CODGARA=i.KEY01 and f.CODLOTT=i.KEY02 where f.FASE_ESECUZIONE =3 and l.CODGARA=i.KEY01 and l.CODLOTT=i.KEY02) and SITUAZIONE is null;
Update SITATSA.W9LOTT l set SITUAZIONE=3 where exists (select 1 from SITATSA.W9FASI f join SITATSA.W9FLUSSI i on f.CODGARA=i.KEY01 and f.CODLOTT=i.KEY02 where f.FASE_ESECUZIONE in (2,986,11) and l.CODGARA=i.KEY01 and l.CODLOTT=i.KEY02) and SITUAZIONE is null;
Update SITATSA.W9LOTT l set SITUAZIONE=2 where exists (select 1 from SITATSA.W9FASI f join SITATSA.W9FLUSSI i on f.CODGARA=i.KEY01 and f.CODLOTT=i.KEY02 where f.FASE_ESECUZIONE in (1,987,12) and l.CODGARA=i.KEY01 and l.CODLOTT=i.KEY02) and SITUAZIONE is null;
Update SITATSA.W9LOTT l set SITUAZIONE=1 where SITUAZIONE is null;


Update SITATSA.W9GARA g set SITUAZIONE=8 where exists (select 1 from SITATSA.W9LOTT l where l.SITUAZIONE=8 and g.CODGARA=l.CODGARA) and not exists(select 1 from SITATSA.W9LOTT l where l.SITUAZIONE<>8 and g.CODGARA=l.CODGARA) and SITUAZIONE is null;
Update SITATSA.W9GARA g set SITUAZIONE=1 where exists (select 1 from SITATSA.W9LOTT l where l.SITUAZIONE=1 and g.CODGARA=l.CODGARA) and SITUAZIONE is null;
Update SITATSA.W9GARA g set SITUAZIONE=2 where exists (select 1 from SITATSA.W9LOTT l where l.SITUAZIONE=2 and g.CODGARA=l.CODGARA) and SITUAZIONE is null;
Update SITATSA.W9GARA g set SITUAZIONE=3 where exists (select 1 from SITATSA.W9LOTT l where l.SITUAZIONE=3 and g.CODGARA=l.CODGARA) and SITUAZIONE is null;
Update SITATSA.W9GARA g set SITUAZIONE=4 where exists (select 1 from SITATSA.W9LOTT l where l.SITUAZIONE=4 and g.CODGARA=l.CODGARA) and SITUAZIONE is null;
Update SITATSA.W9GARA g set SITUAZIONE=5 where exists (select 1 from SITATSA.W9LOTT l where l.SITUAZIONE=5 and g.CODGARA=l.CODGARA) and SITUAZIONE is null;
Update SITATSA.W9GARA g set SITUAZIONE=6 where exists (select 1 from SITATSA.W9LOTT l where l.SITUAZIONE=6 and g.CODGARA=l.CODGARA) and SITUAZIONE is null;
Update SITATSA.W9GARA g set SITUAZIONE=7 where exists (select 1 from SITATSA.W9LOTT l where l.SITUAZIONE=7 and g.CODGARA=l.CODGARA) and SITUAZIONE is null;


Update SITATSA.UFFINT set TIPOIN=NATGIU where TIPOIN is NULL;

Update SITATSA.AVVISO a set CIG=(Select CIG from SITATSA.W9LOTT l where l.CODGARA=a.CODGARA and l.CODLOTT=a.CODLOTT) where CIG is null; 

update SITATSA.C0CAMPI set COC_DOM=null where C0C_MNE_BER = 'W3PACIG';

UPDATE SITATSA.ELDAVER SET NUMVER='2.4.3' WHERE CODAPP='W9';

