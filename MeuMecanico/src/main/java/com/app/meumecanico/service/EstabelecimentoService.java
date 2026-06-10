package com.app.meumecanico.service;

import com.app.meumecanico.model.Estabelecimento;
import com.app.meumecanico.model.EstabelecimentoResponse;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class EstabelecimentoService {

    public List<EstabelecimentoResponse> listar(double lat, double lon, Double raio) {

        List<Estabelecimento> lista = List.of(
                new Estabelecimento("Oficina Rocha Motors", "11999999999", -23.4545, -46.5333),
                new Estabelecimento("Borracharia do João", "11888888888", -23.4600, -46.5400),
                new Estabelecimento("Auto Elétrica Central", "11777777777", -23.4500, -46.5200)
        );

        return lista.stream()
                .map(est -> {
                    double distancia = calcularDistancia(
                            lat, lon,
                            est.getLatitude(), est.getLongitude()
                    );

                    return new EstabelecimentoResponse(
                            est.getNome(),
                            est.getTelefone(),
                            est.getLatitude(),
                            est.getLongitude(),
                            distancia
                    );
                })
                .filter(est -> raio == null || est.getDistanciaKm() <= raio)
                .sorted(Comparator.comparingDouble(EstabelecimentoResponse::getDistanciaKm))
                .toList();
    }

    private double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {

        final int R = 6371;

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }
}