# language:pt

Funcionalidade: Efetuar compra na loja

  @cadastro_usuario
  Cenário: Tentar cadastrar um novo usuário
  Dado efetuar um novo cadastro
  Então validar que o cadastro foi efetuado
  
  @login_usuario
  Cenário: Tentar logar com o novo usuário cadastrado
  Dado efetuar um novo cadastro
  E logar com o usuário
  Então validar que é possivel logar com o usuário criado
  
  @comprar_produto
  Cenário: Tentar efetuar a compra de um produto
  Dado efetuar um novo cadastro
  E logar com o usuário
  Quando efetuar a compra do item "Faded Short Sleeve T-shirts" no site
  Então validar que a compra foi efetuada