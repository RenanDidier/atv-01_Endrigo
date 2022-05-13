package school.cesar.criptocorretora.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class EmailUtilTest {

    private val EmailUtil = EmailUtil()

    @Test
    fun `Verifica se o email inserido e valido`() {
        assertEquals(true, EmailUtil.isEmailValido("teste@gmail.com"))
    }

}