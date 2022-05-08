package school.cesar.criptocorretora.repositories

import school.cesar.criptocorretora.entidades.Usuario
import school.cesar.criptocorretora.excecoes.UsuarioInvalidoException

class UsuarioRepository {

    private val usuarios = mutableListOf<Usuario>()

    fun add(usuario: Usuario) {
        usuarios.add(usuario)
    }

    fun buscarPorId(id: Long) =
        usuarios.firstOrNull { it.id == id } ?: throw UsuarioInvalidoException("Usuario nao encontrado")
}
