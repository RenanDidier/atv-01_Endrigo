package school.cesar.criptocorretora.services

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import school.cesar.criptocorretora.builders.CriptoBuilder
import school.cesar.criptocorretora.entidades.Carteira
import school.cesar.criptocorretora.entidades.Cripto
import school.cesar.criptocorretora.entidades.Usuario
import school.cesar.criptocorretora.repositories.CriptoRepository
import school.cesar.criptocorretora.validadores.CriptoValidador
import java.lang.Long
import java.math.BigDecimal

internal class CarteiraServiceTest {

    private val usuario = Usuario(123456789, "30331412004", "Renan Didier", "renanDidier@qa.com", "ABcd12345", Carteira())
    private val cripto = Cripto(1.toLong(), "cripto", BigDecimal(3))
    private val usuarioServiceMock = mockk<UsuarioService>()
    private val criptoServiceMockk = mockk<CriptoService>()
    private val carteiraService = CarteiraService(usuarioServiceMock, criptoServiceMockk)

    @Test
    fun `Deve realizar compra`() {
        org.junit.jupiter.api.assertDoesNotThrow {
            every {usuarioServiceMock.buscarPorId(1)} returns usuario
            every {criptoServiceMockk.buscarPorId(1)} returns cripto
            carteiraService.comprar(1.toLong(), 1.toLong(), BigDecimal(10))
        }
    }

    @Test
    fun `Deve consultar valores de um usuario`() {
        org.junit.jupiter.api.assertDoesNotThrow {
            every {usuarioServiceMock.buscarPorId(1.toLong())} returns usuario
            carteiraService.consultarValoresAgrupados(1.toLong())
        }
    }
}