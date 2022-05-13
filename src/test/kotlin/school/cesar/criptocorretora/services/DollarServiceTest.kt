package school.cesar.criptocorretora.services

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class DollarServiceTest{

    private val dollarservicetest = DollarService()

    @Test
    fun `Deve receber um valor BigDecimal entre 4 e 5`() {
        org.junit.jupiter.api.assertDoesNotThrow {
            val valor = dollarservicetest.pegarValorDollarAtual()
            assertTrue(valor >= BigDecimal(4))
            assertTrue(valor <= BigDecimal(5))
        }
    }
}