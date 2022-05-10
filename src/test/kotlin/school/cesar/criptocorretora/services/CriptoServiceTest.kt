package school.cesar.criptocorretora.services

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import school.cesar.criptocorretora.builders.CriptoBuilder
import school.cesar.criptocorretora.repositories.CriptoRepository
import school.cesar.criptocorretora.validadores.CriptoValidador
import java.math.BigDecimal


internal class CriptoServiceTest {

    private val criptoService = CriptoService(CriptoBuilder(), CriptoValidador(), CriptoRepository())

    @Test
    fun `Cripto deve ser encontrada pelo ID`() {
        org.junit.jupiter.api.assertDoesNotThrow {
            criptoService.add("criptoMoeda", BigDecimal(4))
            criptoService.buscarPorId(0.toLong())
        }
    }
}