package school.cesar.criptocorretora.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import school.cesar.criptocorretora.entidades.Cripto
import school.cesar.criptocorretora.entidades.Usuario
import school.cesar.criptocorretora.excecoes.CriptoInvalidaException
import school.cesar.criptocorretora.excecoes.UsuarioInvalidoException
import school.cesar.criptocorretora.repositories.CriptoRepository
import school.cesar.criptocorretora.validadores.UsuarioValidator

internal class CPFUtilTest {

    private val CPFUtil = CPFUtil()

    @Test
    fun `Deve limpar a mascara do CPF`() {
        assertEquals("58330054004", CPFUtil.limpaCPF("583.300.540-04"))
    }
}