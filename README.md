# Flood Fill – Estruturas de Dados em Java
Projeto desenvolvido para a disciplina Resolução de Problemas Estruturados em Computação (PUCPR), ministrada pela Professora Lisiane Reips.
O objetivo é implementar o algoritmo Flood Fill utilizando estruturas próprias de Pilha e Fila, aplicando conceitos de Programação Orientada a Objetos.

---

### Objetivo
Implementar o Flood Fill (preenchimento por inundação) de duas formas:
	•	Pilha (DFS) – preenche por profundidade
	•	Fila (BFS) – preenche por largura

O algoritmo percorre os pixels conectados à cor-alvo a partir de um ponto inicial, pintando-os com uma nova cor e salvando o progresso em frames.

---

### Estrutura do projeto
```
├── Main.java
├── ProcessarImagem.java
├── Pilha.java
├── Fila.java
├── Pixel.java
└── frames_pilha/ e frames_fila/
```

---

### Tecnologias
- Java
- BufferedImage / ImageIO
- Estruturas de dados próprias (Pilha e Fila)

---

### Resultado
O programa recebe uma imagem .png, preenche a área conectada com uma nova cor e salva os frames da animação e a imagem final no diretório do projeto.  
