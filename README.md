# Loomi - Estante Virtual de Livros

Uma aplicação fullstack moderna para gerenciar sua estante virtual de livros, similar ao Skoob. Backend em Spring Boot e frontend em React com autenticação de usuários.

## 🎨 Características

- 🔐 **Autenticação**: Sistema completo de login e cadastro de usuários
- ✨ **Interface Moderna**: Design limpo e intuitivo com Tailwind CSS
- 📚 **Gerenciamento de Livros**: Adicionar, editar e deletar livros
- 🔍 **Filtros e Busca**: Busque por título ou ISBN, filtre por status de leitura
- 📊 **Estatísticas**: Visualize quantos livros você tem em cada categoria
- 🎯 **Acompanhamento de Progresso**: Monitore o progresso de leitura de cada livro
- 🎨 **Capas Dinâmicas**: Capas coloridas e visuais para cada livro
- 🌓 **Dark Mode**: Suporte a tema claro e escuro
- 📱 **Responsivo**: Funciona perfeitamente em desktop, tablet e mobile

## 🚀 Como Executar o Projeto

### Pré-requisitos
- **Java 17+** e Maven
- **Node.js 18+** e npm
- Banco de dados configurado (PostgreSQL, MySQL ou H2)

### ⚙️ Executando o Backend (Spring Boot)

1. **Navegue até a raiz do projeto**
```bash
cd ../loomi
```

2. **Configure o banco de dados**
Edite o arquivo `src/main/resources/application.properties` com suas credenciais:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/loomi
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

3. **Execute o backend**

**Opção 1: Via Maven**
```bash
./mvnw spring-boot:run
```

**Opção 2: Via IDE (VS Code, IntelliJ, Eclipse)**
- Abra o projeto na IDE
- Execute a classe `LoomiApplication.java`

O servidor estará disponível em `http://localhost:8080`

### 🎨 Executando o Frontend (React)

1. **Navegue até a pasta Mobile**
```bash
cd Mobile
```

2. **Instale as dependências (apenas na primeira vez)**
```bash
npm install
```

3. **Inicie o servidor de desenvolvimento**
```bash
npm run dev
```

O frontend estará disponível em `http://localhost:5173`

### 🚦 Executando Backend e Frontend Juntos

**É necessário executar ambos os servidores simultaneamente:**

1. **Terminal 1 - Backend**:
   ```bash
   # Na raiz do projeto
   ./mvnw spring-boot:run
   ```
   ✅ Aguarde até ver: `Started LoomiApplication in X seconds`

2. **Terminal 2 - Frontend**:
   ```bash
   # Na pasta Mobile
   cd Mobile
   npm run dev
   ```
   ✅ Aguarde até ver: `Local: http://localhost:5173/`

3. **Acesse a aplicação**:
   - Abra o navegador em `http://localhost:5173`
   - Faça cadastro de um novo usuário ou login com credenciais existentes
   - Comece a gerenciar seus livros!

> **⚠️ Importante**: O frontend depende do backend. Certifique-se de que o backend está rodando antes de usar a aplicação.

## 📦 Build para Produção

### Backend
```bash
./mvnw clean package
java -jar target/loomi-0.0.1-SNAPSHOT.jar
```

### Frontend
```bash
cd Mobile
npm run build
npm run preview
```

## 🏗️ Estrutura do Projeto

```
loomi/
├── src/main/java/com/loomi/loomi/    # Backend Spring Boot
│   ├── controller/                    # Controllers REST
│   │   ├── AuthController.java
│   │   ├── LivroController.java
│   │   └── UsuarioController.java
│   ├── domain/                        # Entidades e Repositórios
│   │   ├── livro/
│   │   └── usuario/
│   ├── dto/                          # Data Transfer Objects
│   ├── exception/                    # Tratamento de exceções
│   └── services/                     # Lógica de negócio
│
├── Mobile/                           # Frontend React
│   ├── src/
│   │   ├── components/              # Componentes reutilizáveis
│   │   │   ├── BookCard.jsx
│   │   │   ├── LoadingSpinner.jsx
│   │   │   ├── PrivateRoute.jsx
│   │   │   ├── ThemeToggle.jsx
│   │   │   └── Toast.jsx
│   │   ├── contexts/                # Context API
│   │   │   └── AuthContext.jsx
│   │   ├── pages/                   # Páginas da aplicação
│   │   │   ├── LoginPage.jsx
│   │   │   ├── RegisterPage.jsx
│   │   │   ├── BookshelfPage.jsx
│   │   │   └── AddBookPage.jsx
│   │   ├── services/                # API e serviços
│   │   │   └── api.js
│   │   ├── App.jsx
│   │   └── main.jsx
│   ├── index.html
│   ├── vite.config.js
│   ├── tailwind.config.js
│   └── package.json
│
├── pom.xml                          # Configuração Maven
└── README.md
```

## 🎯 Páginas

### Login (/login)
- Autenticação de usuários
- Validação de credenciais
- Redirecionamento automático após login

### Cadastro (/cadastro)
- Registro de novos usuários
- Validação de formulário
- Confirmação de senha

### Estante Virtual (/) - Rota Protegida
- Visualize todos os seus livros em um layout de grid
- Estatísticas de leitura (total, lendo, lido, quero ler)
- BuscAPI REST

O backend expõe os seguintes endpoints:

### Autenticação
- `POST /auth/login` - Login de usuário

### Usuários
- `POST /usuario` - Criar novo usuário
- `DELETE /usuario/{id}` - Deletar usuário

### Livros
- `GET /livro` - Listar todos os livros
- `GET /livro/{id}` - Buscar livro por ID
- `POST /livro` - Criar novo livro
- `PUT /livro/{id}` - Atualizar livro
- `DELETE /livro/{id}` - Deletar livro

**Base URL**: `http://localhost:8080`
## 🔗 Integração com Backend

A aplicação se conecta com o backend Spring Boot através da API REST:

### Endpoints utilizados
- `GET /livro` - Listar todos os livros
- `GET /livro/{id}` - Buscar livro por ID
- `POST /livro` - Criar novo livro
- `PUT /livro/{id}` - Atualizar livro
- `DELETE /livro/{id}` - Deletar livro
### Backend
- **Spring Boot 3**: Framework Java
- **Spring Data JPA**: Persistência de dados
- **Maven**: Gerenciamento de dependências
- **PostgreSQL/MySQL**: Banco de dados (configurável)

### Frontend
- **React 18**: Framework UI
- **Vite**: Build tool
- **Tailwind CSS**: Estilização
- **Axios**: HTTP client
- **React Router v6**: Roteamento e proteção de rotas
- **Context API**: Gerenciamento de estad99)
- **Fundo**: Cinza neutro (#f3f4f6 a #e5e7eb)

## 🛠️ Tecnologias Utilizadas

- **React 18**: Framework UI
- Verifique se o `@CrossOrigin(origins = "*")` está presente nos controllers
- Em produção, configure CORS corretamente para aceitar apenas origens específicas

### Backend não inicia
- Verifique se a porta 8080 está disponível
- Confirme as credenciais do banco de dados no `application.properties`
- Execute `./mvnw clean install` para recompilar

### Frontend não conecta ao backend
- Certifique-se de que o backend está rodando em `http://localhost:8080`
- Verifique a URL da API em `Mobile/src/services/api.js`
- Confirme que ambos os servidores estão executando

### Erro "Usuário ou senha inválidos"
- Crie um novo usuário pela tela de cadastro primeiro
- Verifique se o banco de dados está acessível

### Estilos não carregam
Limpe o cache e execute:
```bash
cd Mobileesponsividade

A ax] Autenticação de usuários
- [x] Sistema de login e cadastro
- [x] Modo dark/light
- [x] Proteção de rotas
- [ ] JWT para autenticação
- [ ] Compartilhamento de estantes
- [ ] Resenhas e avaliações
- [ ] Integração com APIs de dados de livros (Google Books, Open Library)
- [ ] Notificações push
- [ ] Integração com redes sociais
- [ ] Importação/exportação de dado
### CORS Error
Se receber erro de CORS, certifique-se de configurar o backend para permitir apenas a origem do frontend (por exemplo, em desenvolvimento: `@CrossOrigin(origins = "http://localhost:5173")`) ou configure o CORS corretamente via Spring Security / `WebMvcConfigurer`, evitando o uso de `*` em produção.

### API não responde
Verifique se o backend está rodando em `http://localhost:8080` e configure corretamente o arquivo `.env`.

### Estilos não carregam
Limpe o cache e execute:
```bash
npm run dev
```

## 📝 Roadmap

- [ ] Autenticação de usuários
- [ ] Compartilhamento de estantes
- [ ] Resenhas e avaliações
- [ ] Integração com APIs de dados de livros
- [ ] Modo dark
- [ ] Notificações
- [ ] Integração com redes sociais

## 📄 Licença

Este projeto está sob licença MIT.

## 👥 Desenvolvedores

Este projeto foi desenvolvido por:

- **Christian David** - [@ChrisDav05](https://github.com/ChrisDav05)
- **Emanuelle de Carvalho** - [@MannuuEmanuelle](https://github.com/MannuuEmanuelle)
- **Letícia Beatriz** - [@leticiabeatriz15](https://github.com/leticiabeatriz15)

---

**Loomi** - Sua paixão por livros, organizada ✨📚
