package school.cesar.criptocorretora.validadores

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import school.cesar.criptocorretora.entidades.Cripto
import school.cesar.criptocorretora.entidades.Usuario
import school.cesar.criptocorretora.excecoes.CriptoInvalidaException
import school.cesar.criptocorretora.excecoes.UsuarioInvalidoException
import school.cesar.criptocorretora.repositories.CriptoRepository
import school.cesar.criptocorretora.util.CPFUtil
import school.cesar.criptocorretora.util.EmailUtil
import school.cesar.criptocorretora.util.SenhaUtil

internal class UsuarioValidatorTest {

    private val usuarioValidator = UsuarioValidator(CPFUtil(), EmailUtil(), SenhaUtil())
    private val usuario = Usuario(123456789, "30331412004", "Renan Didier", "renanDidier@qa.com", "ABcd12345", ArrayList())

    @Test
    fun `O campo deve ser preenchido`() {
        assertThrows<UsuarioInvalidoException> {
            usuarioValidator.valida(usuario.copy(nome=""))
        }.also {
            Assertions.assertEquals("O nome deve ser preenchido", it.message)
        }
    }


    @Test
    fun `O cpf deve ser preenchido`() {
        assertThrows<UsuarioInvalidoException> {
            usuarioValidator.valida(usuario.copy(cpf =""))
        }.also {
            Assertions.assertEquals("O cpf deve ser preenchido", it.message)
        }
    }

    @Test
    fun `O e-mail deve ser preenchido`() {
        assertThrows<UsuarioInvalidoException> {
            usuarioValidator.valida(usuario.copy(email =""))
        }.also {
            Assertions.assertEquals("O e-mail deve ser preenchido", it.message)
        }
    }

    @Test
    fun `A senha deve ser preenchido`() {
        assertThrows<UsuarioInvalidoException> {
            usuarioValidator.valida(usuario.copy(senha =""))
        }.also {
            Assertions.assertEquals("O senha deve ser preenchido", it.message)
        }
    }


    @Test
    fun `O campo nome deve ter menos de 200 caracteres`() {
        assertThrows<UsuarioInvalidoException> {
            usuarioValidator.valida(usuario.copy(nome ="a".repeat(201)))
        }.also {
            Assertions.assertEquals("O campo nome deve ter menos de 200 caracteres", it.message)
        }
    }

    @Test
    fun `O campo cpf deve ter 11 caracteres numericos`() {
        assertThrows<UsuarioInvalidoException> {
            usuarioValidator.valida(usuario.copy(cpf ="umcpf"))
        }.also {
            Assertions.assertEquals("O campo cpf deve ter 11 caracteres numericos", it.message)
        }
    }

    @Test
    fun `O campo confirmação senha deve ter mais de 8 caracteres`() {
        assertThrows<UsuarioInvalidoException> {
            usuarioValidator.valida(usuario.copy(senha ="123"))
        }.also {
            Assertions.assertEquals("O campo confirmação senha deve ter mais de 8 caracteres", it.message)
        }
    }


    @Test
    fun `O campo confirmação senha deve ser menor do que 15 caracteres`() {
        assertThrows<UsuarioInvalidoException> {
            usuarioValidator.valida(usuario.copy(senha ="1234567891234567"))
        }.also {
            Assertions.assertEquals("O campo confirmação senha deve ser menor do que 15 caracteres", it.message)
        }
    }


    @Test
    fun `O CPF nao pode ser invalido`() {
        assertThrows<UsuarioInvalidoException> {
            usuarioValidator.valida(usuario.copy(cpf ="90457612079"))
        }.also {
            Assertions.assertEquals("O cpf é invalido", it.message)
        }
    }


    @Test
    fun `O a email deve seguir o formato correto`() {
        assertThrows<UsuarioInvalidoException> {
            usuarioValidator.valida(usuario.copy(email ="renan@gmail"))
        }.also {
            Assertions.assertEquals("O a emal deve seguir o formato palavra@palavra.palavra", it.message)
        }
    }


    @Test
    fun `A a senha deve conter numeros, letras maisculas e minusculas`() {
        assertThrows<UsuarioInvalidoException> {
            usuarioValidator.valida(usuario.copy(senha ="ABcddddddd"))
        }.also {
            Assertions.assertEquals("O a senha deve conter numeros, letras maisculas e minusculas", it.message)
        }
    }

    @Test
    fun `Usuario deve ser validado corretamente`() {
        assertDoesNotThrow() {
            usuarioValidator.valida(usuario)
        }
    }

}