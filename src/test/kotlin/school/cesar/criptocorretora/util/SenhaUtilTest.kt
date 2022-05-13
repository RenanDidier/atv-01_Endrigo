package school.cesar.criptocorretora.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class SenhaUtilTest {

    private val SenhaUtil = SenhaUtil()

    @Test
    fun `Verifica se o formato da senha e valido`() {
        assertEquals(true, SenhaUtil.isFormatoOK("Senha123"))
    }

}