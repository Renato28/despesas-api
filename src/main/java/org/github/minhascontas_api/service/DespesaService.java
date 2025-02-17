package org.github.minhascontas_api.service.exceptions;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.github.minhascontas_api.domain.Despesa;
import org.github.minhascontas_api.domain.dto.*;
import org.github.minhascontas_api.domain.Usuario;
import org.github.minhascontas_api.repository.UsuarioRepository;
import org.github.minhascontas_api.repository.DespesaRepository;
import org.github.minhascontas_api.validation.UpdateStrategy;
import org.github.minhascontas_api.validation.ValidationStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DespesaService {

    public static final String DESPESA_NÃO_ENCONTRADA = "Despesa não encontrada";
    public static final String USUARIO_NÃO_ENCONTRADO = "Usuario não encontrado";
    private final DespesaRepository despesaRepository;
    private final UsuarioRepository usuarioRepository;
    private final List<ValidationStrategy> validationStrategies;
    private final List<UpdateStrategy> updateStrategies;

    @Transactional
    public Long cadastrar(DadosCadastroDespesa dados) {
        var despesa = despesaRepository.save(new Despesa(dados));
        return despesa.getId();
    }

    public DadosAssociacaoDespesaUsuario associarDespesaUsuario(Long usuarioId, Despesa despesa) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(USUARIO_NÃO_ENCONTRADO));
        despesa.setUsuario(usuario);
        Despesa despesaSalva = despesaRepository.save(despesa);
        return new DadosAssociacaoDespesaUsuario(despesaSalva);
    }

    @Transactional
    public void atualizar(Long id, AtualizacaoDespesa dados) {

        var despesa = despesaRepository.findById(id).orElseThrow(()
                -> new DespesaNaoEncontradaException(DESPESA_NÃO_ENCONTRADA));

        validationStrategies.forEach(strategy -> strategy.validate(dados));

        updateStrategies.forEach(strategy -> strategy.update(despesa, dados));

        despesaRepository.save(despesa);
    }

    public List<DadosListaDespesa> listar() {
        return despesaRepository.findAll()
                .stream()
                .map(DadosListaDespesa::new).toList();
    }

    public DespesaResponse buscarPorId(Long id) {
        var despesa = despesaRepository.findById(id)
                .orElseThrow(() -> new DespesaNaoEncontradaException(DESPESA_NÃO_ENCONTRADA));
        return new DespesaResponse(despesa);
    }

    public void excluir(Long id) {
        var despesa = despesaRepository.findById(id)
                .orElseThrow(() -> new DespesaNaoEncontradaException(DESPESA_NÃO_ENCONTRADA));
        despesaRepository.delete(despesa);
    }
}
