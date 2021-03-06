------------------------------
-- AGGIORNAMENTO SITAT	
------------------------------
-- GENE 1.4.50
------------------------------


------------------------------
-- GENEWEB 2.0.0
------------------------------


------------------------------
-- PT 3.1.2
------------------------------

ALTER TABLE SITATORT.PTFLUSSI ADD FILE_ALLEGATO BLOB;
REORG TABLE SITATORT.PTFLUSSI;

Update SITATORT.IMMTRAI set ANNIMM=null;

UPDATE SITATORT.ELDAVER SET NUMVER='3.1.2' WHERE CODAPP='PT';

------------------------------
-- SITATORT 2.6.2
--------------------------


ALTER TABLE SITATORT.W9CONC ADD COLUMN ORE_LAVORATE NUMERIC(10,2);
REORG TABLE SITATORT.W9CONC;

ALTER TABLE SITATORT.W9CANT ADD COLUMN MAILRIC VARCHAR(100);
REORG TABLE SITATORT.W9CANT;

Insert into SITATORT.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E',null,'ORE_LAVORATE.W9CONC.W9','W9COORELAVO','Ore lavorate','Ore lavorate','F10.2',null,null,'Ore lavorate');
Insert into SITATORT.C0CAMPI (COC_CONTA,C0C_TIP,C0C_CHI,COC_MNE_UNI,C0C_MNE_BER,COC_DES,COC_DES_FRM,C0C_FS,C0C_TAB1,COC_DOM,COC_DES_WEB) values (0,'E',null,'MAILRIC.W9CANT.W9','W9CAMAILRIC','Indirizzo mail di ricezione attestato notifica preliminare','Mail ricezione att.','A100',null,null,'Indirizzo mail di ricezione attestato notifica preliminare');


DELETE FROM SITATORT.TAB1 WHERE TAB1COD='W9008';
INSERT INTO SITATORT.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) values ('W9008', 1, 'DPL');
INSERT INTO SITATORT.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) values ('W9008', 2, 'Comune');
INSERT INTO SITATORT.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) values ('W9008', 3, 'Casse edili');
INSERT INTO SITATORT.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) values ('W9008', 4, 'INAIL');
INSERT INTO SITATORT.TAB1 (TAB1COD, TAB1TIP, TAB1DESC) values ('W9008', 5, 'INPS');

Update SITATORT.TAB1 set tab1desc='Scheda cantiere/notifica preliminare' where TAB1COD='W3020' and tab1tip=998;
Update SITATORT.TAB1 set tab1desc='22' where TAB1COD='W9013' and tab1tip=1;


Delete from SITATORT.C0ENTIT WHERE C0E_NOM in 
('W9ACCO.W9','W9APPA.W9','W9APPAFORN.W9','W9APPALAV.W9','W9AVAN.W9','W9CANT.W9','W9COLL.W9','W9CONC.W9','W9COND.W9','W9CPV.W9','W9INASIC.W9','W9INCA.W9','W9INFOR.W9','W9INIZ.W9','W9LOTTCATE.W9',
'W9MISSIC.W9','W9REGCON.W9','W9RITA.W9','W9SIC.W9','W9SOSP.W9','W9SUBA.W9','W9TECPRO.W9','W9VARI.W9','W9AGGI.W9','W9FINA.W9','W9PUBB.W9','W9PUES.W9','W9REQU.W9','W9LOTT.W9','W9DOCGARA.W9','W9MOTI.W9','W9FASI.W9');

Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9ACCO.W9',80010500,'E','ACCORDI','Accordi bonari','CODGARA.W9ACCO.W9,CODLOTT.W9ACCO.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_accor');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9APPA.W9',80010700,'E','APPALTI','Appalti','CODGARA.W9APPA.W9,CODLOTT.W9APPA.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_appa0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9APPAFORN.W9',80010800,'E','APPAFORN','Modalit? di acquisizione forniture/servizi','CODGARA.W9APPAFORN.W9,CODLOTT.W9APPAFORN.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_appaf');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9APPALAV.W9',80010900,'E','TIPOLLAV','Tipologie del lavoro','CODGARA.W9APPALAV.W9,CODLOTT.W9APPALAV.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_appal');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9AVAN.W9',80011000,'E','AVANZ','Stati di avanzamento','CODGARA.W9AVAN.W9,CODLOTT.W9AVAN.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_avan0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9CANT.W9',80011100,'E','CANTIERI','Dati della scheda cantiere','CODGARA.W9CANT.W9,CODLOTT.W9CANT.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_cant0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9COLL.W9',80011200,'E','COLLAUDI','Collaudi','CODGARA.W9COLL.W9,CODLOTT.W9COLL.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_coll0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9CONC.W9',80011300,'E','CONCLUS','Fase di conclusione','CODGARA.W9CONC.W9,CODLOTT.W9CONC.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_conc0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9COND.W9',80011400,'E','CONDIZ','Condizioni che giustificano il ricorso proc.negoziata','CODGARA.W9COND.W9,CODLOTT.W9COND.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_cond0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9CPV.W9',80011500,'E','CPV','CPV','CODGARA.W9CPV.W9,CODLOTT.W9CPV.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_cpv0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9INASIC.W9',80012100,'E','INADEM','Inadempienze misure sicurezza','CODGARA.W9INASIC.W9,CODLOTT.W9INASIC.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_inas0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9INCA.W9',80012200,'E','INCARI','Incarichi dei tecnici','CODGARA.W9INCA.W9,CODLOTT.W9INCA.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_inca0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9INFOR.W9',80012300,'E','INFORT','Infortuni','CODGARA.W9INFOR.W9,CODLOTT.W9INFOR.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_info0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9INIZ.W9',80012400,'E','INIZ','Fase iniziale della gara','CODGARA.W9INIZ.W9,CODLOTT.W9INIZ.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_iniz0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9LOTTCATE.W9',80012600,'E','CATEG_LOT','Categorie del lotto di gara','CODGARA.W9LOTTCATE.W9,CODLOTT.W9LOTTCATE.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_lottc');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9MISSIC.W9',80012700,'E','MIS_AGG','Misure aggiuntive per la sicurezza','CODGARA.W9MISSIC.W9,CODLOTT.W9MISSIC.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_miss0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9REGCON.W9',80013100,'E','REG_CONTR','Esiti negativi regolarit? contrattuale','CODGARA.W9REGCON.W9,CODLOTT.W9REGCON.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_rego0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9RITA.W9',80013300,'E','RITARDI','Ritardi consegna lavori','CODGARA.W9RITA.W9,CODLOTT.W9RITA.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_rita0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9SIC.W9',80013500,'E','SCHE_SIC','Schede sicurezza','CODGARA.W9SIC.W9,CODLOTT.W9SIC.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_sicu0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9SOSP.W9',80013600,'E','SOSPENS','Sospensioni','CODGARA.W9SOSP.W9,CODLOTT.W9SOSP.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_sosp0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9SUBA.W9',80013700,'E','SUBAPP','Subappalti','CODGARA.W9SUBA.W9,CODLOTT.W9SUBA.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_suba0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9TECPRO.W9',80013800,'E','REQ_TEC','Esito negativo requisiti tecnico professionali','CODGARA.W9TECPRO.W9,CODLOTT.W9TECPRO.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_tecp0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9VARI.W9',80013900,'E','VARIANTI','Varianti','CODGARA.W9VARI.W9,CODLOTT.W9VARI.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_vari0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9AGGI.W9',80010600,'E','AGGIUD','Soggetti aggiudicatari','CODGARA.W9AGGI.W9,CODLOTT.W9AGGI.W9,NUM_APPA.W9AGGI.W9','W9APPA.W9','CODGARA.W9APPA.W9,CODLOTT.W9APPA.W9,NUM_APPA.W9APPA.W9',null,null,'w9_aggi0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9FINA.W9',80011800,'E','FINANZ','Finanziamenti','CODGARA.W9FINA.W9,CODLOTT.W9FINA.W9,NUM_APPA.W9FINA.W9','W9APPA.W9','CODGARA.W9APPA.W9,CODLOTT.W9APPA.W9,NUM_APPA.W9APPA.W9',null,null,'w9_fina0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9PUBB.W9',80012900,'E','PUBBLIC','Pubblicazioni','CODGARA.W9PUBB.W9,CODLOTT.W9PUBB.W9,NUM_APPA.W9PUBB.W9','W9APPA.W9','CODGARA.W9APPA.W9,CODLOTT.W9APPA.W9,NUM_APPA.W9APPA.W9',null,null,'w9_pubb0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9PUES.W9',80013000,'E','ESI_PUBB','Pubblicazioni degli esiti','CODGARA.W9PUES.W9,CODLOTT.W9PUES.W9,NUM_APPA.W9PUES.W9','W9APPA.W9','CODGARA.W9APPA.W9,CODLOTT.W9APPA.W9,NUM_APPA.W9APPA.W9',null,null,'w9_pues0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9REQU.W9',80013200,'E','REQUISITI','Requisiti di partecipazione/qualificazione','CODGARA.W9REQU.W9,CODLOTT.W9REQU.W9,NUM_APPA.W9REQU.W9','W9APPA.W9','CODGARA.W9APPA.W9,CODLOTT.W9APPA.W9,NUM_APPA.W9APPA.W9',null,null,'w9_requ0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9LOTT.W9',80012500,'E','LOTTI','Lotti di gara','CODGARA.W9LOTT.W9','W9GARA.W9','CODGARA.W9GARA.W9',null,null,'w9_lott0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9DOCGARA.W9',80011600,'P','DOCUM','Bando e documentazione di gara','CODGARA.W9DOCGARA.W9','W9GARA.W9','CODGARA.W9GARA.W9',null,null,'w9_docg0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9MOTI.W9',80012800,'E','MOTIVAZ','Motivazioni delle varianti','CODGARA.W9MOTI.W9,CODLOTT.W9MOTI.W9,NUM_VARI.W9MOTI.W9','W9VARI.W9','CODGARA.W9VARI.W9,CODLOTT.W9VARI.W9,NUM_VARI.W9VARI.W9',null,null,'w9_moti0');
Insert into SITATORT.C0ENTIT (C0E_NOM,C0E_NUM,C0E_TIP,COE_ARG,C0E_DES,C0E_KEY,C0E_NOM_EX,COE_KEY_EX,C0E_FRM_RI,COE_FRM_CA,COE_FRM_RE) values ('W9FASI.W9',80011700,'P','FASI','Fasi di esecuzione','CODGARA.W9FASI.W9,CODLOTT.W9FASI.W9,FASE_ESECUZIONE.W9FASI.W9,NUM.W9FASI.W9','W9LOTT.W9','CODGARA.W9LOTT.W9,CODLOTT.W9LOTT.W9',null,null,'w9_fasi0');






UPDATE SITATORT.ELDAVER SET NUMVER='2.6.2' WHERE CODAPP='W9';

