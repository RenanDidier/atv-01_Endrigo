package school.cesar.criptocorretora.repositories

import school.cesar.criptocorretora.entidades.Cripto
import school.cesar.criptocorretora.excecoes.CriptoInvalidaException

class CriptoRepository {

    private val criptos = mutableListOf<Cripto>()

    fun add(cripto: Cripto) {
        criptos.add(cripto)
    }

    fun excluir(cripto: Cripto) {
        criptos.remove(cripto)
    }

    fun buscarPeloId(id: Long) =
        criptos.firstOrNull { it.id == id } ?: throw CriptoInvalidaException("Id não existente")

    fun buscarPeloNome(nome: String) =
        criptos.firstOrNull { it.nome == nome } ?: throw CriptoInvalidaException("Nome não existente")
}
