package org.github.minhascontas_api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.github.minhascontas_api.domain.dto.AtualizacaoDespesa;
import org.github.minhascontas_api.domain.dto.DadosCadastroDespesa;
import org.github.minhascontas_api.domain.dto.DadosListaDespesa;
import org.github.minhascontas_api.domain.dto.DespesaResponse;
import org.github.minhascontas_api.service.exceptions.DespesaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/despesas")
@RequiredArgsConstructor
public class DespesaController {

    private final DespesaService despesaService;

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid DadosCadastroDespesa dados, UriComponentsBuilder builder) {
        Long id = despesaService.cadastrar(dados);

        URI uri = builder.path("/despesas/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid AtualizacaoDespesa dados) {
        despesaService.atualizar(id, dados);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<DadosListaDespesa>> listar() {
        List<DadosListaDespesa> despesas = despesaService.listar();
        return ResponseEntity.ok(despesas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespesaResponse> buscarPorId(@PathVariable Long id) {
        DespesaResponse response = despesaService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        despesaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
