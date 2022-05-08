package school.cesar.criptocorretora.validadores

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import school.cesar.criptocorretora.entidades.Cripto
import school.cesar.criptocorretora.excecoes.CriptoInvalidaException
import java.math.BigDecimal

internal class CriptoValidadorTest {

    private val criptoValidador = CriptoValidador()

    @Test
    fun `Verifica se os campos obrigatorios estao corretos`() {
        assertThrows<CriptoInvalidaException> {
            criptoValidador.valida(Cripto(5.toLong(), "", BigDecimal(4.5)))
        }.also {
            Assertions.assertEquals("O campo nome deve ser preenchido", it.message)
        }
    }
}