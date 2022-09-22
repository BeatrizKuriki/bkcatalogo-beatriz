# bkcatalogo


[![NPM](https://img.shields.io/npm/l/react)](https://github.com/BeatrizKuriki/bkcatalogo-beatriz/blob/main/LICENSE)

Projeto CRUD de produtos


## Índice

- [Visão Geral](#visão-geral)
  - [O desafio](#the-challenge)
  - [Captura de tela](#captura-de-tela)
  - [Links](#links)
- [Meu processo](#meu-processo)
  - [Construído com](#construído-com)
  - [O que aprendi](#o-que-aprendi)
  
- [Autor](#autor)


## Visão geral
O sistema realiza as quatro operações do CRUD, faz busca dos produtos por Id e por categorias. Foi implementada paginação e exceptions personalizadas. O projeto foi elaborado seguindo o modelo de camadas, tornando o sistema flexível e de fácil manutenção.
No presente projeto tem-se três camadas: Controladores REST, Camada de Serviço, Camada de acesso à Dados e Entidades(sendo a entidade, um bloco isolado que será instanciada quando as operações do CRUD são realizadas).
Cada camada possui suas próprias responsabilidades.
Controladores REST: são responsáveis por receber as requisições da aplicação, isto é, as interações que o usuário faz no frontend são encamainhadas para os serviços que tem a função de realizar a ação.
Camada de Serviço: é a camada que faz toda a lógica do sistema, lógica do negócio, verificações, cálculos ou orquestra as operações.
Por fim, a Camada de Acesso a Dados: contém somente as operações básicas de acesso a dados do Banco de Dados(podemos dizer que é aqui onde o CRUD acontece).

## Modelo de Camadas exemplo: 
![exemplo 1](https://github.com/BeatrizKuriki/bkcatalogo-beatriz/blob/main/img/camadas.PNG).

## Padrão DTO
São objetos simples para carregar os dados entreo controlador rest e o serviço, sendo sua principal atividade o tráfego de dados.

## Modelo Conceitual
O sistema foi feito utilizando o modelo conceitual conforme diagrama abaixo:
![exemplo 1](https://github.com/BeatrizKuriki/bkcatalogo-beatriz/blob/main/projetoModeloConceitual/modeloConceitual.PNG)


### Captura de tela

![exemplo 1]()



## Meu processo
O projeto consiste em um CRUD de produtos utilizando o Spring Boot.



### Construído com

- Java Spring Boot


### O que eu aprendi
Consegui ter algumas noções mais claras do funcionamento do framework, bem como uma breve ideia do conceito de injeçãod e dependências e suas vantagens como garantir maior flexibilidade, manutenção facilitada e reaproveitamento.





## Autor


- Linkedin: (https://www.linkedin.com/in/beatriz-alencar-kuriki/)


