package it.unisa.advanced;

import it.unisa.advanced.domain.Scan;
import it.unisa.advanced.service.VerificaGP;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerificaGPTest {

    @Test
    public void testVerifica() {
        // TODO Create DAO mocks, stub their methods, give them to the service
        VerificaGP verificaGP = new VerificaGP();

        Scan scan = verificaGP.verifica("%123123%");
        Assertions.assertFalse(scan.isValido(), "The supplied QRCode refers to an improperly valid green pass");
    }
}
