# Documentação da aplicação

Esta aplicação é referente a parte de produção do Sistema da lanchonete.

Ela consome a fila de pedidos pagos usando rabbitmq para colocar na fila de produção. Aqui é possível também ir
atualizando o status do pedido conforme ele vai sendo produzido.

## Como subir a aplicação

Para rodar a aplicação localmente, rode o comando './roda_spring_normal.sh' na raíz do projeto.

Caso queira rodar na nuvem usando kubernetes, rode terraform apply no repositório terraform-eks para criar as instâncias EKS, 
e rode os arquivos yaml do kubernetes presentes neste projeto dentro da instância.

## Verificando cobertura de testes

Os testes de cobertura desta aplicação podem ser verificados rodando o seguinte comando no terminal (dentro da pasta raíz do projeto):
mvn clean verify sonar:sonar -Dsonar.projectKey=producao -Dsonar.host.url=http://localhost:9000 -Dsonar.login=<login_sonar> -Dsonar.password=<senha_sonar>

Na imagem abaixo é possível ver o relatório de cobertura do teste pelo sonar.

![img.png](img.png)