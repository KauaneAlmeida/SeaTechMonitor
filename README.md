# SeaReportAPI

| INTEGRANTES                    | RM      | Turma
|--------------------------------|---------|--------
| Kauane Almeida Goncalves       | RM551405| 2TDSPG
| Igor Ribeiro Anccilotto        | RM550415| 2TDSPG
| Pedro Henrique Endo de Oliveira| RM551446| 2TDSPG
| Luigi Ye                       | RM552213| 2TDSPV

## LINK DO REPOSITORIO NO GITHUB
[Link](https://github.com/KauaneAlmeida/SeaTechMonitor.git)


## SUMÁRIO

[ RESUMO ](#_RESUMO)

[ DIAGRAMAS ](##_DIAGRAMA DE CLASSES)

[ INSTRUÇÕES PARA IMPORTAR ](##_INSTRUÇÕES_PARA_IMPORTAR)

[ ENDPOINTS DA API ](##_ENDPOINTS_DA_API)

[ LINK VÍDEO APRESENTAÇÃO DA PROPOSTA ](https://youtu.be/hha5U4Af_d0?si=kUZKWSpMscnnSIzT)

## RESUMO

Monitorar a saúde dos oceanos é um desafio crucial para a preservação ambiental. Atualmente, isso exige equipamentos especializados e conhecimento técnico, o que pode limitar a coleta de dados e a análise precisa dos parâmetros ambientais.

Para resolver isso, desenvolvemos o Sistema de Monitoramento Marinho com IoT e IA, uma plataforma que utiliza IoT e IA para analisar dados ambientais. Após baixar o aplicativo e criar uma conta, você pode acessar informações detalhadas sobre parâmetros como temperatura da água, salinidade, pH e presença de poluentes. O sistema coleta dados em tempo real e os envia automaticamente para a nuvem, onde são analisados por algoritmos de machine learning. Isso facilita o monitoramento contínuo e preciso, ajudando pesquisadores científicos e autoridades ambientais a tomar decisões informadas.

## DIAGRAMA DE CLASSES
![](documentacao/diagrama_png.jpeg)

## INSTRUÇÕES PARA IMPORTAR

### Importar Testes no Postman

Para importar testes no Postman, siga estas etapas:

1. Abra o Postman: Inicie o aplicativo Postman no seu computador.
2. Acesse a aba "Collections": Clique na aba "Collections" no painel esquerdo do Postman.
3. Clique em "Import": Na parte superior do painel "Collections", clique no botão "Import".
4. Selecione o arquivo: Na janela de importação que aparece, clique em "Upload Files" e selecione o arquivo contendo os testes que você deseja importar. Certifique-se de que o arquivo esteja no formato adequado para importação no Postman, como um arquivo JSON ou uma coleção Postman.
5. Confirme a importação: Depois de selecionar o arquivo, clique em "Import" para confirmar e importar os testes.
6. Acesse os testes importados: Após a importação ser concluída com sucesso, você poderá encontrar os testes importados na coleção correspondente no painel esquerdo do Postman, dentro da aba "Collections".




### Clonar e Executar um Projeto no IntelliJ IDEA

Este guia fornece instruções passo a passo sobre como clonar e executar um projeto no IntelliJ IDEA.

#### Clonar o Repositório Git

1. Abra o IntelliJ IDEA.
2. Clique em "Get from Version Control" na tela inicial ou vá em "VCS" > "Get from Version Control" no menu.
3. Na janela "Get from Version Control", cole o URL do repositório Git que você deseja clonar.
4. Escolha o diretório onde deseja clonar o repositório.
5. Clique em "Clone".

#### Importar o Projeto

1. Quando o IntelliJ terminar de clonar o repositório, ele deve detectar automaticamente o tipo de projeto e abrir uma janela de importação.
2. Selecione "Import project" na janela de importação.
3. Escolha a opção "Import project from external model" e selecione "Maven" ou "Gradle", dependendo do tipo de projeto que está sendo importado.
4. Clique em "Next".
5. Selecione as configurações de importação adequadas e clique em "Next" novamente.
6. Clique em "Finish" para concluir a importação do projeto.

#### Executar o Projeto

1. Após importar o projeto, localize o arquivo de configuração principal do seu aplicativo, como uma classe com um método `main`.
2. Clique com o botão direito do mouse no arquivo de configuração e escolha "Run <nome do arquivo>" para executar o aplicativo.


## ENDPOINTS DA API
1. ### USUÁRIO
    1. #### GET /user

       Obter todos os usuários.

       Parâmetros de consulta:
        - `username` (opcional): Filtrar usuários pelo nome de usuário.

    2. #### POST /user

       Criar um novo usuário.

       Corpo da requisição:
       ~~~json
       {
        "username":"joao_silva",
        "password":"Joao@123",
        "phoneNumber":"+551123456789"
       }
       ~~~

    3. #### POST /user/login

       Efetuar login de usuário.

       Corpo da requisição:
       ~~~json
       {
           "username":"joao_silva",
           "password":"Joao@123"
       }
       ~~~

2. ### RELATÓRIO
    1. #### POST /report

       Salvar um novo relatório.

       Corpo da requisição:
       ~~~json
       {
       "description":"Descrição do relatório aqui",
       "userId": 1,
       "category": 2,
       "location":{
           "longitude": -17.950722,
           "latitude": -38.718196
           }
       }
       ~~~

    2. #### GET /report/user/{userId}

       Obter relatórios por ID de usuário.

    3. #### GET /report/disapproved

       Obter relatórios reprovados.

    4. #### GET /report/category

       Obter categorias de relatórios.

3. ### POSTAGEM
    1. #### POST /post

       Salvar uma nova postagem.

       Corpo da requisição:
       ~~~json
       {
       "contentPost": "Os oceanos desempenham um papel crucial na regulação do clima global e na manutenção da biodiversidade marinha. No entanto, a saúde dos nossos oceanos está cada vez mais ameaçada devido à poluição, à acidificação das águas, ao aumento da temperatura e à presença de poluentes. É essencial desenvolver um sistema de monitoramento marinho utilizando tecnologias de IoT e IA para coletar e analisar dados sobre parâmetros como temperatura da água, salinidade, pH e presença de poluentes. Esses dados podem fornecer insights valiosos para a preservação da saúde dos oceanos, permitindo a identificação de áreas com maior impacto humano e a implementação de medidas de conservação e mitigação. Através da tecnologia, podemos contribuir de maneira significativa e sustentável para a proteção desse precioso ecossistema marinho e para o bem-estar das futuras gerações."
       }
       ~~~

    2. #### GET /post

       Obter todas as postagens.

       Parâmetros de consulta:
        - `word` (opcional): Filtrar postagens por palavra-chave.

4. ### AvaliationMonitor
    1. #### POST /Avaliation

       Salvar um novo AvaliationMonitor.

       Corpo da requisição:
       ~~~json
       {
       "idUser": 1,
       "idPost": 2
       }
       ~~~

    2. #### GET /avaliation/user/{userId}

       Obter AvaliationMonitor por ID de usuário.

    3. #### DELETE /avaliation/{id}

       Excluir um AvaliationMonitor pelo seu ID.

## LINK VÍDEO APRESENTAÇÃO DA PROPOSTA

