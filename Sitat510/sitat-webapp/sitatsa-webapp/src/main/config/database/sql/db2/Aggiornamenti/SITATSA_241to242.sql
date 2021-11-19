------------------------------
-- AGGIORNAMENTO SITAT	
------------------------------
-- GENE 1.4.50
------------------------------

UPDATE SITATSA.ELDAVER SET NUMVER='1.4.50' WHERE CODAPP='G_';

------------------------------
-- GENEWEB 2.0.0
------------------------------

UPDATE SITATSA.ELDAVER SET NUMVER='2.0.0' WHERE CODAPP='W_';

------------------------------
-- SITATSA 2.4.2
--------------------------

-- W_PROAZI
INSERT INTO SITATSA.W_PROAZI (COD_PROFILO,TIPO,AZIONE,OGGETTO,VALORE,CRC) VALUES ('SA-APPA','SEZ','VIS','GENE.SchedaTeim.ALT',0,3279515167);
INSERT INTO SITATSA.W_PROAZI (COD_PROFILO,TIPO,AZIONE,OGGETTO,VALORE,CRC) VALUES ('SA-PIATRI','SEZ','VIS','GENE.SchedaTeim.ALT',0,3279515167);
INSERT INTO SITATSA.W_PROAZI (COD_PROFILO,TIPO,AZIONE,OGGETTO,VALORE,CRC) VALUES ('SA-APPA','FUNZ','VIS','INS.GENE.ImprScheda.LEGALI.INS-G_IMPCOL',0,1319656519);
INSERT INTO SITATSA.W_PROAZI (COD_PROFILO,TIPO,AZIONE,OGGETTO,VALORE,CRC) VALUES ('SA-PIATRI','FUNZ','VIS','INS.GENE.ImprScheda.LEGALI.INS-G_IMPCOL',0,1319656519);

-- CANCELLAZIONE DELLE PERSONALIZZAZIONI PROFILI PER VISUALIZZARE IL CAMPO GENE.UFFINT.NATGIU
DELETE FROM SITATSA.W_PROAZI WHERE TIPO='COLS' AND AZIONE='VIS' AND OGGETTO = 'GENE.UFFINT.NATGIU' AND VALORE=1 AND CRC=61481610;

UPDATE SITATSA.ELDAVER SET NUMVER='2.4.2' WHERE CODAPP='W9';

