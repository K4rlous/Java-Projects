# Webscraper

## 📌 Descrição
Este projeto é um Webscraper simples que:

Acessa uma página oficial do governo brasileiro

Localiza e faz o download de anexos em formato PDF

Compacta os arquivos baixados em um único arquivo .zip

## ✅ Requisitos
Java 8 ou superior

JSoup (arquivo .jar incluído na pasta lib/)

## 🛠️ Compilando o projeto
Execute o seguinte comando a partir da raiz do projeto:

### Linux/macOS:

```bash
javac -cp "lib/jsoup.jar" -d bin src/com/seunome/webscraper/**/*.java
```

### Windows:

```bash
javac -cp "lib\jsoup.jar" -d bin src\com\seunome\webscraper\**\*.java
```

Observação: No Windows, use ; para separar caminhos no classpath; no Linux/macOS, use :.

## ▶️ Executando o projeto
Após compilar, execute o comando:

### Linux/macOS:

```bash
java -cp "bin:lib/jsoup.jar" com.seunome.webscraper.App
```

### Windows:

```bash
java -cp "bin;lib\jsoup.jar" com.seunome.webscraper.App`
```

## 📜 Usando os scripts de execução (opcional)
Para facilitar, você pode executar o script adequado para seu sistema:

Linux/macOS: ./run.sh

Windows: run.bat

Eles já devem estar configurados para compilar e executar o projeto com os comandos corretos.

## 📁 Estrutura do Projeto
```bash
WebScraper/
├── src/                         # Código-fonte principal
│   └── com/seunome/webscraper/
│       ├── App.java             # Classe principal
│       ├── Scraper.java         # Controla o processo
│       ├── Downloader.java      # Download dos arquivos
│       ├── Compressor.java      # Criação do .zip
│       └── utils/
│           └── HtmlParser.java  # Extração dos links
├── test/                        # Testes unitários (JUnit)
│   └── com/seunome/webscraper/
│       └── HtmlParserTest.java
├── lib/                         # Bibliotecas externas (.jar)
│   └── jsoup.jar
├── bin/                         # Classes compiladas
├── resources/
│   └── config.properties        # Configurações do sistema
├── README.md
└── run.sh / run.bat             # Scripts opcionais de execução
```