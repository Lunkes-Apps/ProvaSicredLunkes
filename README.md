# Prova da Sicred 

Projeto elaborado para prova da Sicred

# Comentário

A configuração do chromedriver pode ser feita no windows adicionando o caminho do driver no PATH das variáveis de sistema.
Caso prefira usar outro caminho, deixei comentado uma linha de código que configura o driver no momento da execução do teste.
* `System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");`

# Relatórios

No final do teste, na pasta `target`, será gerado um relatório em `HTML` e screenshots por cenário.
* `\target\report-html`
* `\target\screenshots`

