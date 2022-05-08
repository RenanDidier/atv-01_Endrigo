package school.cesar.criptocorretora.repositories

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import school.cesar.criptocorretora.entidades.Cripto
import school.cesar.criptocorretora.excecoes.CriptoInvalidaException
import java.math.BigDecimal


internal class CriptoRepositoryTest {

    private val criptoRepository = CriptoRepository()

    @Test
    fun `Deve-se adicionar a cripto ao repo`() {
        assertDoesNotThrow() {
            criptoRepository.add(Cripto(5.toLong(), "Didier", BigDecimal(4.5)))
            criptoRepository.buscarPeloId(5.toLong())
        }
    }


    @Test
    fun `Deve-se excluir a cripto do repo`() {
        assertThrows<CriptoInvalidaException> {
            criptoRepository.add(Cripto(5.toLong(), "Didier", BigDecimal(4.5)))
            criptoRepository.excluir(Cripto(5.toLong(), "Didier", BigDecimal(4.5)))
            criptoRepository.buscarPeloId(5.toLong())
        }.also {
            Assertions.assertEquals("Id não existente", it.message)
        }
    }



    @Test
    fun `Nāo deve encontrar cripto inexistente pelo ID`() {
        assertThrows<CriptoInvalidaException> {
            criptoRepository.buscarPeloId(6.toLong())
        }.also {
            Assertions.assertEquals("Id não existente", it.message)
        }
    }

    @Test
    fun `Nāo deve encontrar cripto inexistente pelo Nome`() {
        assertThrows<CriptoInvalidaException> {
            criptoRepository.buscarPeloNome("Renan")
        }.also {
            Assertions.assertEquals("Nome não existente", it.message)
        }
    }
}