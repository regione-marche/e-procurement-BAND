--#SET TERMINATOR ;

SET SCHEMA = SITATORT;

DECLARE LOAD_CURS CURSOR FOR SELECT CODEIN,IDAVVISO,CODSISTEMA,1,'Avviso',FILE_ALLEGATO from AVVISO; 

load from LOAD_CURS of cursor messages W9DOCAVVISO.log INSERT into W9DOCAVVISO  NONRECOVERABLE;