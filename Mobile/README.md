# Loomi - Estante Virtual de Livros

Uma aplicação React moderna e elegante para gerenciar sua estante virtual de livros, similar ao Skoob.

## 🎨 Características

- ✨ **Interface Moderna**: Design limpo e intuitivo com Tailwind CSS
- 📚 **Gerenciamento de Livros**: Adicionar, editar e deletar livros
- 🔍 **Filtros e Busca**: Busque por título ou ISBN, filtre por status de leitura
- 📊 **Estatísticas**: Visualize quantos livros você tem em cada categoria
- 🎯 **Acompanhamento de Progresso**: Monitore o progresso de leitura de cada livro
- 🎨 **Capas Dinâmicas**: Capas coloridas e visuais para cada livro
- 📱 **Responsivo**: Funciona perfeitamente em desktop, tablet e mobile

## 🚀 Instalação

### Pré-requisitos
- Node.js 18+ e npm/yarn
- Backend Spring Boot rodando em `http://localhost:3000`

### Passos

1. **Instale as dependências**
```bash
npm install
```

2. **Configure o arquivo .env**
```bash
cp .env.example .env
```

3. **Inicie o servidor de desenvolvimento**
```bash
npm run dev
```

A aplicação estará disponível em `http://localhost:3000`

## 📦 Build para Produção

```bash
npm run build
npm run preview
```

## 🏗️ Estrutura do Projeto

```
Mobile/
├── src/
│   ├── components/       # Componentes reutilizáveis
│   │   ├── BookCard.jsx
│   │   ├── LoadingSpinner.jsx
│   │   ├── EmptyState.jsx
│   │   └── Toast.jsx
│   ├── pages/            # Páginas da aplicação
│   │   ├── BookshelfPage.jsx
│   │   └── AddBookPage.jsx
│   ├── services/         # API e serviços
│   │   └── api.js
│   ├── App.jsx
│   ├── App.css
│   ├── index.css
│   └── main.jsx
├── index.html
├── vite.config.js
├── tailwind.config.js
└── package.json
```

## 🎯 Páginas

### Estante Virtual (/)
- Visualize todos os seus livros em um layout de grid
- Estatísticas de leitura (total, lendo, lido, quero ler)
- Busca por título ou ISBN
- Filtros por status de leitura
- Editar ou deletar livros

### Adicionar Livro (/adicionar)
- Formulário para adicionar novo livro
- Campos: ISBN, Título, Status, Progresso
- Prévia do livro antes de salvar
- Validações de formulário

## 🔗 Integração com Backend

A aplicação se conecta com o backend Spring Boot através da API REST:

### Endpoints utilizados
- `GET /livro` - Listar todos os livros
- `GET /livro/{id}` - Buscar livro por ID
- `POST /livro` - Criar novo livro
- `PUT /livro/{id}` - Atualizar livro
- `DELETE /livro/{id}` - Deletar livro

## 🎨 Paleta de Cores

- **Primária**: Índigo (#6366f1)
- **Secundária**: Rosa (#ec4899)
- **Fundo**: Cinza neutro (#f3f4f6 a #e5e7eb)

## 🛠️ Tecnologias Utilizadas

- **React 18**: Framework UI
- **Vite**: Build tool
- **Tailwind CSS**: Estilização
- **Axios**: HTTP client
- **React Router**: Roteamento
- **Lucide React**: Ícones
- **PostCSS**: Processamento CSS

## 📱 Responsividade

A aplicação é totalmente responsiva:
- **Desktop**: Grid de 4+ colunas
- **Tablet**: Grid de 2-3 colunas
- **Mobile**: Grid de 1-2 colunas

## 🐛 Troubleshooting

### CORS Error
Se receber erro de CORS, certifique-se que o backend tem `@CrossOrigin(origins = "*")` configurado.

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

## 🤝 Contribuindo

Contribuições são bem-vindas! Por favor, sinta-se à vontade para abrir issues e enviar pull requests.

## 📧 Contato

Para dúvidas ou sugestões, entre em contato através dos canais disponíveis.

---

**Loomi** - Sua paixão por livros, organizada ✨📚
