Istruzione per l'uso:

per fare il build della webapp BAND per Regione Marche bisogna eseguire
l'install del progetto Sitat, eseguendo il seguente comando:

   mvn clean install -Denv=nofilter -Dfilter=empty

Prima di lanciare il build, verificare la versione delle webapp Sitat
di cui si è appena fatto il build. Riportare la versione nella dipendenza
del pom di BAND.
Dopo di che, per fare il build della webapp con la configurazione per 
l'ambiente di test eseguire il comando:

   mvn clean package -Denv=dev -Dfilter=sviluppo

mentre per fare il build della webapp con la configurazione per 
l'ambiente di produzione eseguire il comando:

   mvn clean package -Denv=prod  -Dfilter=rilascio

