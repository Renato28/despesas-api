package org.github.minhascontas_api.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.github.minhascontas_api.domain.Despesa;
import org.github.minhascontas_api.domain.dto.*;
import org.github.minhascontas_api.domain.Usuario;
import org.github.minhascontas_api.repository.UsuarioRepository;
import org.github.minhascontas_api.repository.DespesaRepository;
import org.github.minhascontas_api.service.exceptions.DespesaNaoEncontradaException;
import org.github.minhascontas_api.service.exceptions.UsuarioNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DespesaService {

    public static final String DESPESA_NÃO_ENCONTRADA = "Despesa não encontrada";
    public static final String USUARIO_NÃO_ENCONTRADO = "Usuario não encontrado";
    private final DespesaRepository despesaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ValidationService validationService;

    @Transactional
    public Long cadastrar(DadosCadastroDespesa dados) {
        validationService.validar(dados);
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
    public void atualizar(Long id, DadosAtualizacaoDespesa dados) {

        validationService.validar(dados);

        var despesa = despesaRepository.findById(id).orElseThrow(()
                -> new DespesaNaoEncontradaException(DESPESA_NÃO_ENCONTRADA));

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
