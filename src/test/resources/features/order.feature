# language: pt

Funcionalidade: ProducaoPedido

  Cenario: Criar Pedido na Producao
    Quando registrar um novo pedido
    Entao o pedido é registrado com sucesso

  Cenario: Buscar Status do Pedido pelo Id
    Dado que já existe um pedido na produção
    Quando buscar esse pedido
    Entao o pedido retorna com sucesso

  Cenario: Alterar status do pedido
    Dado que já existe um pedido
    Quando alterar status do pedido
    Entao o pedido retorna com sucesso
