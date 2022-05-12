package school.cesar.criptocorretora.repositories

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import school.cesar.criptocorretora.entidades.Carteira
import school.cesar.criptocorretora.entidades.Usuario


internal class UsuarioRepositoryTest {

    private val usuarioRepository = UsuarioRepository()
    //private val usuarioMock = mokk<usuario()>
    private val usuario = Usuario(123456789, "30331412004", "Renan Didier", "renanDidier@qa.com", "ABcd12345", Carteira())

    @Test
    fun `Deve-se adicionar um usuario ao repo`() {
        Assertions.assertDoesNotThrow() {
            usuarioRepository.add(usuario)
            usuarioRepository.buscarPorId(123456789.toLong())
        }
    }
}