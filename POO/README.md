## Diagrama de Classes

```mermaid
    classDiagram
        class IPhone {
            +tocar()
            +pausar()
            +selecionarMusica(musica: String)
            +ligar(numero: String)
            +atender()
            +iniciarCorreioVoz()
            +exibirPagina(url: String)
            +adicionarNovaAba()
            +atualizarPagina()
        }
    
        class ReprodutorMusical {
            <<interface>>
            +tocar()
            +pausar()
            +selecionarMusica(musica: String)
        }
    
        class AparelhoTelefonico {
            <<interface>>
            +ligar(numero: String)
            +atender()
            +iniciarCorreioVoz()
        }
    
        class NavegadorInternet {
            <<interface>>
            +exibirPagina(url: String)
            +adicionarNovaAba()
            +atualizarPagina()
        }
    
        IPhone --|> ReprodutorMusical
        IPhone --|> AparelhoTelefonico
        IPhone --|> NavegadorInternet
