
# API de exercícios

Projeto desenvolvido para treinar a criação de um CRUD simples com Spring Boot, visando melhorar minhas habilidades como desenvolvedor backend.
## Stack utilizada

**Back-end:** Java 17, Spring Boot

## Documentação da API

#### Cadastra um exercício

```http
  POST /exercicios
```

| Body   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `string` | **Obrigatório**. O nome do exercício. |
| `grupoMuscular` | `string` | O grupo muscular trabalhado. |
| `sinergistas` | `List<String>` | Os grupos musculares sinergistas. |

Exemplo de requisição para criar um exercício

```json
{
  "nome": "Supino Reto",
  "grupoMuscular": "Peito",
  "sinergistas": ["Tríceps", "Ombro"]
}
```

#### Retorna um exercício por id

```http
  GET /exercicios/id/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do exercício desejado. |

Exemplo de resposta para id=1

```json
{
  "id": 1,
  "nome": "Supino Reto",
  "grupoMuscular": "Peito",
  "sinergistas": ["Tríceps", "Ombro"]
}
```


#### Retorna um exercício por nome

```http
  GET /exercicios/nome/{nome}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `String` | **Obrigatório**. O nome do exercício desejado. |

Exemplo de resposta para nome=Agachamento Livre

```json
{
  "id": 2,
  "nome": "Agachamento Livre",
  "grupoMuscular": "Pernas",
  "sinergistas": ["Glúteos", "Quadríceps", "Posterior de coxa"]
}
```


#### Retorna os exercícios para um determinado grupo muscular

```http
  GET /exercicios/grupo-muscular/{grupoMuscular}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `grupoMuscular`      | `String` | **Obrigatório**. O grupo muscular pelo qual deseja-se procurar exercícios. |

Exemplo de resposta para grupoMuscular=pernas

```json
[
  {
    "id": 3,
    "nome": "Leg Press",
    "grupoMuscular": "Pernas",
    "sinergistas": ["Glúteos", "Quadríceps"]
  },
  {
    "id": 2,
    "nome": "Agachamento Livre",
    "grupoMuscular": "Pernas",
    "sinergistas": ["Glúteos", "Quadríceps", "Posterior de coxa"]
  }
]

```

#### Exclui um exercício

```http
  DELETE /exercicios/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do exercício que deseja excluir. |

#### Altera informações sobre um exercício

```http
  PUT /exercicios/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do exercício que deseja alterar. |

| Body   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `string` | O nome do exercício. |
| `grupoMuscular` | `string` | O grupo muscular trabalhado. |
| `sinergistas` | `List<String>` | Os grupos musculares sinergistas. |

Exemplo de requisição para alterar um exercício

```json
{
  "nome": "Agachamento Livre",
  "grupoMuscular": "Pernas",
  "sinergistas": ["Glúteos", "Quadríceps", "Posterior de coxa"]
}
```
## Aprendizados

Durante o desenvolvimento desta API evolui um pouco minhas habilidades de backend com Spring Boot, aprendi e pratiquei os seguintes conceitos:

- Estruturação de um CRUD completo com Spring Boot.
- Aprendi o que é e como usar um **@RestControllerAdvice** para tratar exceções globalmente.
- Entendi um pouco mais sobre a diferença entre **@PathVariable** e **@RequestParam** para capturar parâmetros de URL.
- Modelagem de entidades com listas utilizando **@ElementCollection**.
- Busquei utilizar boas práticas de organização de pacotes (controller, service, repository, exception).


## Feedback

Qualquer feedback é de grande ajuda, por favor abra uma issue ou mande um email para phellipelisboa.dev@gmail.com

