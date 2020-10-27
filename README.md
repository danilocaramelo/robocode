# Death Circle

### Estratégia

##### Locomoção, The Death Circle:
A estratégia deste robô consiste em fazer um circulo da morte para os outros robôs. Onde ele gira no sentido 
anti-horário sem perder o foco no adversário. Essa movimentação é eficaz para dispersar balas atiradas por snipers como
o sample.Fire, ao mesmo tempo que é efetiva para despistar robôs perseguidores como o sample.Ramfire. Em caso de 
colisão com a parede, ele também irá girar ao redor do mapa.

##### Olhos de águia:
Este robô rastreia o adversário e evita perdê-lo de vista, assim pode realizar tiros mais precisos  


### Código
##### Ao iniciar:
- São separados os movimentos do Radar, da Arma e do Tanque do robô, assim se torna mais fácil manter a arma
apontada ao inimigo enquanto o tanque está voltado a movimentação
- Inimigo: para rastrea-lo e manter o foco, são capturados o nome e a distância do inimigo e registrado em variáveis

##### onScannedRobot:
- Inicia com uma condição: Se não houver inimigo rastreado, ou houver um inimigo muito próximo, ou se o inimigo for o
mesmo já registrado, ele irá ratrear o inimigo, pegando suas informações autais.
- Após rastrea-lo, irá lançar um tiro se as condições do turno permitirem isso (temperatura da arma, duração do turno).
- Caso esteja dentro dos padrões de tiro, a força da arma será equivalente a distância do inimigo, mas limitando o 
máximo de força para 3 (não queremos desperdiçar energia nos tiros).

##### Métodos de suporte:
- `rastrearInimigo` Registra as variáveis com os valores do evento.
- `reiniciarInimigo` apaga as variáveis de inimigo. 

### Pontos Fracos :'(
- O radar está girando sem parar. Não consegui ajustar isso sem quebrar a estratégia.
- Irônicamente o robô tem uma melhor desenvoltura com os métodos `onHitByBullet` e `onHitWall` em branco, o que com 
certeza é um reflexo na dificuldade de implementação do método por minha parte.
- O sample.Velociraptor é a sua kriptonita.


### A experiência
- É uma forma divertida de criar uma competição de códigos e estratégias.
- Com certeza continuarei me desafiando com o robocode como lazer. 