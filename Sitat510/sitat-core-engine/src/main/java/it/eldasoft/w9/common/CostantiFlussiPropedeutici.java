package it.eldasoft.w9.common;

import java.util.HashMap;

/**
 * Codifica flussi propedeutici utilizzati in Sitat e in Simog
 */
public class CostantiFlussiPropedeutici {
  
    public static final HashMap<Integer, String> flussiSitat = new HashMap<Integer, String>();
    public static final HashMap<Integer, String> flussiSimog = new HashMap<Integer, String>();
    
    static {
    
    // Righe commentate perche' i 6 flussi sono flussi liberi (senza flussi propedeutici) e quindi 
    // richiedono sono che sia stata inviata l'anagrafica gara lotto. Ma questa e' la condizione 
    // che permette di creare fasi, quindi questi flussi sono sempre inviabili.

    // Condizione flussi propedeutici per Sitat
    flussiSitat.put(CostantiW9.A22, CostantiW9.A22_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.B03, CostantiW9.B03_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.A04, CostantiW9.A04_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.A05, CostantiW9.A05_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.A21, CostantiW9.A21_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.A24, CostantiW9.A24_PROPEDEUTICO_SITAT);
      
    flussiSitat.put(CostantiW9.A06, CostantiW9.A06_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.A07, CostantiW9.A07_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.A08, CostantiW9.A08_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.A25, CostantiW9.A25_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.A09, CostantiW9.A09_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.A10, CostantiW9.A10_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.A11, CostantiW9.A11_PROPEDEUTICO_SITAT);

    flussiSitat.put(CostantiW9.A12, CostantiW9.A12_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.A13, CostantiW9.A13_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.A14, CostantiW9.A14_PROPEDEUTICO_SITAT);

    flussiSitat.put(CostantiW9.A15, CostantiW9.A15_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.A16, CostantiW9.A16_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.A20, CostantiW9.A20_PROPEDEUTICO_SITAT);

    flussiSitat.put(CostantiW9.B02, CostantiW9.B02_PROPEDEUTICO_SITAT);
    //flussiSitat.put(CostantiW9.B04, CostantiW9.CostantiW9.A04 + " OR " + CostantiW9.A05 + " OR " + CostantiW9.A21).toString());
    flussiSitat.put(CostantiW9.B06, CostantiW9.B06_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.B07, CostantiW9.B07_PROPEDEUTICO_SITAT);
    flussiSitat.put(CostantiW9.B08, CostantiW9.B08_PROPEDEUTICO_SITAT);

    
    // Condizione flussi propedeutici per SIMOG
    // la condizione del caso Sitat non viene soddisfatta
    
    flussiSimog.put(CostantiW9.A06, CostantiW9.A06_PROPEDEUTICO_SIMOG);
    flussiSimog.put(CostantiW9.A07, CostantiW9.A07_PROPEDEUTICO_SIMOG);
    flussiSimog.put(CostantiW9.A08, CostantiW9.A08_PROPEDEUTICO_SIMOG);
    flussiSimog.put(CostantiW9.A25, CostantiW9.A25_PROPEDEUTICO_SIMOG);
    flussiSimog.put(CostantiW9.A09, CostantiW9.A09_PROPEDEUTICO_SIMOG);
    flussiSimog.put(CostantiW9.A10, CostantiW9.A10_PROPEDEUTICO_SIMOG);
    flussiSimog.put(CostantiW9.A11, CostantiW9.A11_PROPEDEUTICO_SIMOG);

    flussiSimog.put(CostantiW9.A12, CostantiW9.A12_PROPEDEUTICO_SIMOG);
    flussiSimog.put(CostantiW9.A13, CostantiW9.A13_PROPEDEUTICO_SIMOG);
    flussiSimog.put(CostantiW9.A14, CostantiW9.A14_PROPEDEUTICO_SIMOG);

    flussiSimog.put(CostantiW9.A15, CostantiW9.A15_PROPEDEUTICO_SIMOG);
    flussiSimog.put(CostantiW9.A16, CostantiW9.A16_PROPEDEUTICO_SIMOG);
    flussiSimog.put(CostantiW9.A20, CostantiW9.A20_PROPEDEUTICO_SIMOG);

    flussiSimog.put(CostantiW9.B02, CostantiW9.B02_PROPEDEUTICO_SIMOG);
    flussiSimog.put(CostantiW9.B06, CostantiW9.B06_PROPEDEUTICO_SIMOG);
    flussiSimog.put(CostantiW9.B07, CostantiW9.B07_PROPEDEUTICO_SIMOG);
    flussiSimog.put(CostantiW9.B08, CostantiW9.B08_PROPEDEUTICO_SIMOG);
	}
    
}
