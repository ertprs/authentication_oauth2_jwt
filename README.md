<h1 align="center">Authenticação oAuth2, JWT e Angular</h1>

</br></br>

Conteúdos
=================
<!--ts-->
   * [Sobre](#sobre)
   * [Features](#features)
   * [Pré-requisitos](#pre-requisitos)
   * [Instalação](#instalacao)     
   * [Como usar](#como-usar)  
       * [API](#api)
       * [UI](#ui)   
   * [Tecnologias](#tecnologias)
   * [Demonstração](#demonstracao)
<!--te-->

</br></br></br></br>

<div id="sobre"></div>

# Sobre
<div>
<p align="left">Essa é uma pequena demonstração de autenticação utilizando Spring, oAuth2, JWT e Angular</p>
<p align="left">Esse projeto terá continuidade e se transformará em um <b>Gerenciador de Equipamentos de Informática</b> e será atualizado em um curto período de tempo.</p>
</div>

</br></br></br></br>

<h4 align="center"> 
🚧  Em construção...  🚧
</h4>

</br></br></br></br>


<div id="features"></div>

# Features
- [x] Login
- [ ] Cadastro de Equipamentos
- [ ] Consulta de Equipamentos

</br></br></br></br>


<div id="pre-requisitos"></div>

# Pré-requisitos
<p align="left">
  <ul>
    <li>Mysql 5</li>
    <li>JDK 8+</li>
    <li>Postman 7.36.1</li>
    <li>Node 4.15.1</li>
    <li>NPM 6.14.8</li>
    <li>Angular CLI 9.0.7</li>
    <li>Netbeans 12</li>
    <li>Visual Studio Code</li>
    </ul>
  </p>


</br></br></br></br>

<div id="instalacao"></div>

# Instalação
<div>
<p align="left">Importe para o seu Mysql o arquivo <b>database.sql</b>, que se encontra em _files. Na pasta _files encontra-se também o arquivo <b>postman_collection.json</b> para que você importe para o seu postman. Esse arquivo contém os endpoints da aplicação. A API está documentada com Swagger e você pode acessar pela url /swagger-ui.html</p>
</div>

</br></br></br></br>

<div id="como-usar"></div>

# Como Usar

<div id="api"></div>

## API
<div>
<p align="left">Primeiramente, edite o arquivo <b>/api/src/main/resources/application.properties</b> e altere as seguintes informações:</p>  
  <ul>
  <li><b>server.port=</b>PORT - Porta do Mysql</li>
  <li><b>spring.datasource.username=</b>USER_NAME - Usuário do Mysql</li>
  <li><b>spring.datasource.password=</b>PASSWORD - Senha do Mysql</li>
  <li><b>api.allow.origin=</b>http://localhost:4200 - Essa é a url padrão que roda a apicação Angular. Se você rodar o front-end em outra porta, essa linha também deverá ser alterada.</li>
  <li><b>api.domain=</b>http://localhost:8083 - Se a porta da API for alterada, altere também esta linha</li>
  </ul>  
 </br>
 <p align="left">Abra o projeto na sua IDE (originalmente desenvolvida no Netbeans) e execute. Abra o Postman e importe o arquivo <b>postman_collection.json</b> e faça os testes.</p>  
</div>

</br>

<div id="ui"></div>
  
## UI
<div>
<p align="left">Edite o arquivo <b>ui/src/environments/environment.ts</b> e altere a seguinte informação:</p>  
<ul>
<li><b>apiUrl: </b>'http://localhost:8083/api' - Essa é a url que, por padrão, estará rodando a API</li>  
</ul>  
</br>
<p align="left">No terminal, execute npm install, isso instalará todas as dependências do projeto. Após, execute ng serve, por padrão a aplicação rodará na porta 4200, caso queira alterar a porta, execute ng serve --port 8080</p>  
<h5><b>IMPORTANTE</b></h5>
<p align="left">Se executar o prjeto em outra porta que não seja 4200, você precisará alterar a Origem Permitida no arquivo <b>application.properties</b> na API</P>
</div>

</br></br>

<div id="tecnologias"><div>

# Tecnologias 
<div>
<img src="https://img.shields.io/static/v1?label=Java&message=11&color=green"/>
<img src="https://img.shields.io/static/v1?label=spring-boot&message=2.4.1&color=green"/>
<img src="https://img.shields.io/static/v1?label=oauth&message=2.2.6&color=green"/>
<img src="https://img.shields.io/static/v1?label=jwt&message=1.1.0&color=green"/>
<img src="https://img.shields.io/static/v1?label=mysql&message=5&color=green"/>
<img src="https://img.shields.io/static/v1?label=swagger&message=2.6.0&color=green"/>
<img src="https://img.shields.io/static/v1?label=angular&message=9&color=green"/>
  
<img src="https://img.shields.io/static/v1?label=angular-jwt&message=4.0.3&color=green"/>
<img src="https://img.shields.io/static/v1?label=ng2-toasty&message=4.0.3&color=green"/>
<img src="https://img.shields.io/static/v1?label=rxjs&message=6.5.4&color=green"/>
<img src="https://img.shields.io/static/v1?label=rxjs-compat&message=6.6.3&color=green"/>
<img src="https://img.shields.io/static/v1?label=bootstrap&message=4.5.3&color=green"/>
</div>

</br></br>

<div id="demonstracao"></div>
  
# Demonstração
<pre>
<div>
<p align="center">
<a target="_blank" rel="noopener noreferrer" href="https://github.com/fmatheus21/authentication_oauth2_jwt/blob/master/_files/demonstracao.gif">
<img src="https://github.com/fmatheus21/authentication_oauth2_jwt/blob/master/_files/demonstracao.gif" alt="Logo" style="max-width:100%;" ></a>
</p>
</div>
</pre>
