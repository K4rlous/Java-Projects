package io.github.k4rlous.weathersystem;

import org.json.JSONObject;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome da cidade e o pais: ");
        String cidade = scanner.nextLine();

        try {
            String dadosClimaticos = getDadosClimaticos(cidade); // Retorna um JSON

            // Código 1006 significa 'localização não encontrada'
            if(dadosClimaticos.contains("\"code\":1006")){ // Se o JSON retornar esses dados: \"code\":1006 significa que houve um erro!
                System.out.println("Localização não encontrada. Por favor, tente novamente.");
            } else {
                imprimirDadosClimaticos(dadosClimaticos);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String getDadosClimaticos(String cidade) throws Exception{
        String apiKey = new String(
                MainApp.class.getResourceAsStream("/api-key.txt").readAllBytes(),
                StandardCharsets.UTF_8
                ).trim(); // Lê o arquivo .txt e salva a APIKey em um a string, removendo todos os espaços

        String formataNomeCidade = URLEncoder.encode(cidade, StandardCharsets.UTF_8); // Formata a String para suportar vários idiomas e etc
        String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + formataNomeCidade;
        HttpRequest request = HttpRequest.newBuilder() // Começa a construção de uma nova solicitação HTTP
                .uri(URI.create(apiUrl)) // Este método define o URI da solicitação HTTP
                .build(); // Finaliza a construção da solicitação HTTP

        // Criação do objeto para enviar solicitações HTTP e receber respostas HTTP para acessar o site da Weather API
        HttpClient client = HttpClient.newHttpClient();

        // Envio de requisições HTTP e recebimento de respostas HTTP, comunicação com o site da API meteorológica
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // BodyHandlers diz ao cliente como lidar com a resposta

        return response.body(); // Retorna os dados meteorológicos obtidos no site da Weather API
    }

    // Método para imprimir os dados meteorológicos de forma organizada
    public static void imprimirDadosClimaticos(String dados) {

        JSONObject dadosJson = new JSONObject(dados);
        JSONObject informacoesMeteorologicas = dadosJson.getJSONObject("current"); // Current se refere aos dados meteorológicos atuais, mas podemos usar dados futuros ou passados!

        // Extrair os dados da localização
        String cidade = dadosJson.getJSONObject("location").getString("name"); // Pega o nome da localização
        String pais = dadosJson.getJSONObject("location").getString("country"); // Pega o país da localização

        // Extrai os dados adicionais
        String condicaoTempo = informacoesMeteorologicas.getJSONObject("condition").getString("text");
        int umidade = informacoesMeteorologicas.getInt("humidity");
        float velocidadeVento = informacoesMeteorologicas.getFloat("wind_kph");
        float pressaoAtmosferica = informacoesMeteorologicas.getFloat("pressure_mb");
        float sensacaoTermica = informacoesMeteorologicas.getFloat("feelslike_c");
        float temperaturaAtual = informacoesMeteorologicas.getFloat("temp_c");

        // Extrai a data e a hora da String retornada pela API
        String dataHoraString = informacoesMeteorologicas.getString("last_updated");

        // Imprime as informações atuais
        System.out.println("Informações Meteorológicas para " + cidade + ", " + pais);
        System.out.println("Data e Hora: " + dataHoraString);
        System.out.println("Temperatura Atual: " + temperaturaAtual + "°C");
        System.out.println("Sensação Térmica: " + sensacaoTermica + "°C");
        System.out.println("Condição do Tempo: " + condicaoTempo);
        System.out.println("Umidade: " + umidade + "%");
        System.out.println("Velocidade do Vento: " + velocidadeVento + " km/h");
        System.out.println("Pressão Atmosférica: " + pressaoAtmosferica + " mb");
    }
}
