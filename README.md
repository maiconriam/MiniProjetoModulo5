# MiniProjetoModulo5
Mini projeto do estrelas do modulo 5 - Banco STAR

Aplicação que simula uma API de um banco, permitindo o cadastro de usuários e a vinculação destes à contas bancárias que possuem operações de depósito, saque, transferência e consulta de saldo e status da conta.


#Regras de Negócio

- Não deve ser permitido criar uma conta para usuário nao cadastrado;
- O usuário só pode ter uma conta;
- O saldo da conta nao pode ficar negativo após uma operaçao;
- Nao deve ser possível fazer saques ou transferencias quando o saldo  da conta é insuficiente
- As contas envolvidas em qualquer operaçao devem ser válidas
- O ID da conta de destino de uma transferencia deve ser incluído na resposta do pedido de transferencia
- Nao deve ser possível fazer uma transferencia para si próprio (a conta de origem nao pode ser igual a conta de destino quando for uma transferencia, exceto depósitos e saques)
- Apagar um usuário deve apagar sua conta, mas nao o seu histórico de operaçoes.

#Como Rodar a API localmente

> Pré-requisitos:

- JAVA JDK
- Maven
- MariaDB/MySQL

>Link para instalar o Maven:

https://maven.apache.org/download.cgi

Após instalar as dependencias através do terminal na pasta do projeto, execute o seguinte comando:


Voce deve agora ser capaz de iniciar a aplicaçao na IDE. Será possível testar a aplicaçao em: localhost:8080/


#UML


