package com.app.meumecanico.controller;

import com.app.meumecanico.model.EstabelecimentoResponse;
import com.app.meumecanico.service.EstabelecimentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estabelecimentos")
public class EstabelecimentoController {

    private final EstabelecimentoService service;

    public EstabelecimentoController(EstabelecimentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<EstabelecimentoResponse> listar(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam(required = false) Double raio
    ) {
        return service.listar(lat, lon, raio);
    }
}