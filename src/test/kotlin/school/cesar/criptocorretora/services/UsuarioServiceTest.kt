package school.cesar.criptocorretora.services

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import school.cesar.criptocorretora.entidades.Carteira
import school.cesar.criptocorretora.entidades.Cripto
import school.cesar.criptocorretora.entidades.Usuario
import school.cesar.criptocorretora.excecoes.CriptoInvalidaException
import school.cesar.criptocorretora.excecoes.UsuarioInvalidoException
import school.cesar.criptocorretora.repositories.CriptoRepository
import school.cesar.criptocorretora.repositories.UsuarioRepository
import school.cesar.criptocorretora.util.CPFUtil
import school.cesar.criptocorretora.util.EmailUtil
import school.cesar.criptocorretora.util.SenhaUtil
import school.cesar.criptocorretora.validadores.UsuarioValidator
import java.math.BigDecimal

internal class UsuarioServiceTest {

    private val usuarioService = UsuarioService(UsuarioValidator(CPFUtil(), EmailUtil(), SenhaUtil()), UsuarioRepository())
    //private val usuarioMock = mokk<Usuario(123456789, "30331412004", "Renan Didier", "renanDidier@qa.com", "ABcd12345", ArrayList())>
    private val usuario = Usuario(123456789, "30331412004", "Renan Didier", "renanDidier@qa.com", "ABcd12345", Carteira())

    @Test
    fun `Deve adicionar usuario`() {
        assertDoesNotThrow {
            usuarioService.adicionar(usuario)
        }
    }

    @Test
    fun `Usuario deve ser encontrado pelo ID`() {
        assertDoesNotThrow {
            usuarioService.adicionar(usuario)
            usuarioService.buscarPorId(123456789)
        }
    }
}