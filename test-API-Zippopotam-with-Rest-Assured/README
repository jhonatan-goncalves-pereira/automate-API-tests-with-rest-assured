# 🚀 **Automating API Tests with REST Assured** 🌟

Este repositório contém exemplos e práticas de **automação de testes para APIs REST** utilizando **REST Assured** e **JUnit**. No curso, exploramos várias funcionalidades do **REST Assured**, como parametrização, validação de cabeçalhos e corpos de resposta, reutilização de código e (de)serialização de corpos de requisição e resposta.

---

## 📚 **Objetivos do Curso**

O curso abrange os seguintes tópicos:

- **Escrever testes em Java utilizando REST Assured e JUnit** ⚙️
- **Funcionalidades do REST Assured** 🛠️:
  - Parametrização e testes baseados em dados 📊
  - Verificação de cabeçalhos e corpos de resposta ✅
  - Reutilização de código de teste para maior eficiência ♻️
  - (De)serialização de corpos de requisição e resposta 🔄

Durante o curso, exploramos como escrever testes automatizados de API com **REST Assured**, focando em praticidade e otimização de código para validações rápidas e eficientes.

---

## 🛠️ **Funcionalidades Abordadas**

### 1. **Escrevendo Testes com REST Assured e JUnit** 📑

- Como organizar e executar testes usando **JUnit** e **REST Assured**.
- A estrutura básica de testes com **REST Assured** em Java.

### 2. **Funcionalidades do REST Assured** ✨

- **Verificação de Cabeçalhos e Corpos de Resposta**: Como validar se os cabeçalhos e corpos das respostas estão corretos.
- **Testes Parametrizados e Baseados em Dados**: Aplicando parâmetros dinâmicos para criar testes reutilizáveis com diferentes entradas de dados.
- **Reutilização de Código de Teste**: Como criar especificações reutilizáveis para otimizar o código.
- **(De)serialização de Corpos de Requisição e Resposta**: Convertendo JSON para objetos Java e vice-versa, simplificando o trabalho com APIs.

### 3. **Testes Baseados na API: [http://api.zippopotam.us](http://api.zippopotam.us)** 🌍

A API **Zippopotam.us** foi utilizada como base para ilustrar como escrever e executar testes automatizados. Ela fornece informações sobre códigos postais e cidades em diferentes países.

- **Endpoint de Exemplo**: `http://api.zippopotam.us/us/90210`
- A resposta fornece detalhes sobre o código postal fornecido, como cidade, estado e país.

---

## 🧑‍💻 **Exemplo de Teste**

Exemplo de teste para validar a resposta de um código postal:

```java
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class ZipCodeTest {

    @Test
    public void testZipCode() {
        RestAssured.given()
            .baseUri("http://api.zippopotam.us")
            .basePath("/us/90210")
        .when()
            .get()
        .then()
            .statusCode(200)
            .body("places[0].place name", equalTo("Beverly Hills"))
            .body("places[0].state", equalTo("California"))
            .body("places[0].country", equalTo("United States"));
    }
}
```

---

## ⚡ **Parâmetros e Dados Dinâmicos**

Aqui está como você pode criar testes parametrizados para reutilizar código com diferentes entradas de dados:

```java
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.hamcrest.Matchers.*;

public class ZipCodeParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = { "90210", "10001", "30301" })
    public void testZipCode(String zipCode) {
        RestAssured.given()
            .baseUri("http://api.zippopotam.us")
            .basePath("/us/" + zipCode)
        .when()
            .get()
        .then()
            .statusCode(200)
            .body("places[0].place name", notNullValue());
    }
}
```

---

## 🔄 **Reusabilidade e Otimização de Código**

Reutilizando especificações de requisição e verificação de resposta:

```java
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.ResponseSpecBuilder;
import static org.hamcrest.Matchers.*;

public class ZipCodeTest {

    private RequestSpecification requestSpec = RestAssured.given().baseUri("http://api.zippopotam.us");
    private ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody("places[0].place name", notNullValue())
            .build();

    @Test
    public void testZipCode() {
        requestSpec
            .basePath("/us/90210")
        .when()
            .get()
        .then()
            .spec(responseSpec);
    }
}
```

---

## 🔄 **(De)serialização de JSON**

Exemplo de como converter JSON para objetos Java e vice-versa:

```java
import com.fasterxml.jackson.databind.ObjectMapper;

public class ZipCodeResponse {
    public String country;
    public String state;
    public String placeName;

    // Getters and setters omitted for brevity
}

public class DeserializeExample {

    @Test
    public void testDeserialize() throws Exception {
        String jsonResponse = "{\"country\": \"United States\", \"state\": \"California\", \"place name\": \"Beverly Hills\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        ZipCodeResponse response = objectMapper.readValue(jsonResponse, ZipCodeResponse.class);

        assertEquals("United States", response.country);
        assertEquals("California", response.state);
        assertEquals("Beverly Hills", response.placeName);
    }
}
```

---

## 🛠️ **Requisitos**

Para rodar os testes, você precisará de:

- **Java 17** ☕
- **Maven** ou **Gradle** para gerenciar dependências 🧳
- **JUnit 5** para execução dos testes 🧪
- **REST Assured** para automação de testes de API 📡

---

## 🚀 **Como Executar**

1. Clone este repositório:
   ```bash
   git clone https://github.com/jhonatan-goncalves-pereira/automate-API-tests-with-rest-assured/tree/main/test-API-Zippopotam-with-Rest-Assured
   cd test-API-Zippopotam-with-Rest-Assured
   ```

2. Instale as dependências com Maven ou Gradle:
   ```bash
   mvn install
   ```

3. Execute os testes:
   ```bash
   mvn test
   ```

---

## ✨ **Conclusão**

Este repositório fornece exemplos práticos para iniciar na **automação de testes de APIs** com **REST Assured** e **JUnit**, além de ajudar a entender as funcionalidades do framework para validar e otimizar seus testes de API.
