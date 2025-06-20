# Sistema de Gerenciamento de Perfis

Este projeto tem como objetivo implementar o caso de uso **"Manter Perfil"**, permitindo que usuários com perfil de **Administrador** ou **Co-coordenador** gerenciem os perfis do sistema. A aplicação foi desenvolvida em **Java**.

## 📌 Funcionalidades

As funcionalidades implementadas cobrem os seguintes fluxos:

- ✅ Listar todos os perfis existentes no sistema
- ✅ Visualizar os usuários atribuídos a cada perfil
- ✅ Criar novos perfis com nome e descrição
- ✅ Editar perfis existentes
- ✅ Excluir perfis (desde que não estejam atribuídos a usuários)
- ✅ Atribuir e remover permissões de perfis
- ✅ Associar ou desvincular usuários de um perfil
- ✅ Visualizar mensagens de sucesso ou erro conforme as ações

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Gradle
- Banco de Dados (PostgreSQL)

## 🧑‍💻 Perfis com Acesso

- **Administrador**
- **Co-coordenador**

> ⚠️ Somente usuários autenticados com um dos perfis acima têm acesso à funcionalidade de gerenciamento de perfis.


## 🖼️ Telas Implementadas

- **Tela de Listagem de Perfis**
- **Tela de Criação de Perfil**
- **Tela de Edição de Perfil**
- **Tela de Confirmação de Exclusão**
- **Tela de Atribuição de Permissões**
- **Mensagens de sucesso e erro (popup)**

## ✅ Pré-Requisitos

- JDK 17
- Gradle (para gerenciamento de dependências)
- IDE de sua preferência (ex: IntelliJ IDEA, Eclipse, VS Code)
- Postgres

## 🚀 Como Executar o Projeto

1. Clone o repositório:
```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   cd seu-repositorio
```

2. Importe o projeto em sua IDE

3. Configurando variáveis de ambiente

Configure as variáveis no seu sistema:
```bash
DB_HOST=localhost
DB_USER=seu_usuario
DB_SENHA=sua_senha
```

4. Executando o projeto

Utilize o Gradle Wrapper para iniciar a aplicação:

Linux/MacOS
```bash
chmod +x gradlew
./gradlew bootRun
```

Windows
```bash
.\gradlew.bat bootRun
```

🛠️ Outros comandos úteis

| Comando                 | Descrição                          |
| ----------------------- | ---------------------------------- |
| `./gradlew build`       | Compila o projeto e gera o `.jar`  |
| `./gradlew clean build` | Limpa e recompila do zero          |
| `./gradlew test`        | Executa os testes automatizados    |
| `./gradlew tasks`       | Lista todas as tarefas disponíveis |


5. Após executar, a aplicação estará disponível em:

```bash
http://localhost:8080
```

## 🔒 Regras de Negócio Implementadas

- Perfis protegidos não podem ser editados nem excluídos.
- Perfis só podem ser excluídos se não houver usuários atribuídos.
- Os campos obrigatórios (Nome e Descrição) são validados antes de salvar.

Repositorio FrontEnd: https://github.com/EduFleury/Front-Sooc-Perfil
