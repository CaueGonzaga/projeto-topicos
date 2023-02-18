package dev.cauesouza;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;

@ApplicationScoped
public class JogoService {
    
    public List <Jogo> listarJogos(){
        return Jogo.listAll();
    }
    
    @Transactional
    public Jogo criarJogo(Jogo novoJogo){

        Jogo jogo = new Jogo();
                
        jogo.setNome(novoJogo.getNome());
        jogo.setDataLanca(novoJogo.getDataLanca());
        jogo.setConsole(novoJogo.getConsole());
        jogo.setGenero(novoJogo.getGenero());
        jogo.setPreco(novoJogo.getPreco());

        jogo.persist();

        return jogo;
    }
    public Jogo findById(Long id) {
        return Jogo.findById(id);
    }

    @Transactional
    public Jogo updateJogo(Long id, Jogo jogoUpdate) {

        Jogo jogo = Jogo.findById(id);
        jogo.setNome(jogoUpdate.getNome());
        jogo.setDataLanca(jogoUpdate.getDataLanca());
        jogo.setGenero(jogoUpdate.getGenero());
        jogo.setConsole(jogoUpdate.getConsole());
        jogo.setPreco(jogoUpdate.getPreco());

        return jogo;
    }

    @DELETE
    @Transactional
    public boolean deleteJogo(Long id){
        return Jogo.deleteById(id);
    }
}
