package exe_gamer.h2database.service;


import exe_gamer.h2database.model.usuarioGamer;
import exe_gamer.h2database.repository.usuarioGamerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usuarioGamerService {
    private final usuarioGamerRepository repository;

    public usuarioGamerService(usuarioGamerRepository repository) {
        this.repository = repository;
    }

    //read
    public List<usuarioGamer> listar(){
        return repository.findAll();
    }

    //read buscar por ID

    public usuarioGamer buscarPorID(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado."));
    }

    //create
    public usuarioGamer inserir(usuarioGamer usuario){
        return repository.save(usuario);
    }

    //update

    public usuarioGamer atualizar(Long id, usuarioGamer dados){
        usuarioGamer usuario = buscarPorID(id);
        usuario.setNickname(dados.getNickname());
        usuario.setEmail(dados.getEmail());
        usuario.setJogoFavorito(dados.getJogoFavorito());
        usuario.setNivel(dados.getNivel());
        return repository.save(usuario);
    }

    //delete

    public void remover(Long id){
        repository.deleteById(id);
    }

}


