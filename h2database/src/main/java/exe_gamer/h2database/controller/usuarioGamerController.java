package exe_gamer.h2database.controller;

import exe_gamer.h2database.model.usuarioGamer;
import exe_gamer.h2database.service.usuarioGamerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor

public class usuarioGamerController {

    private final usuarioGamerService service;

    //GET /pessoa (listar todas)

    @GetMapping
    public List<usuarioGamer> listar(){
        return service.listar();
    }

    //GET /pessoa/ {id} (busca por id)

    @GetMapping("/{id}")
    public ResponseEntity<usuarioGamer> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorID(id));
    }

    //POST /pessoa/{id}

    @PostMapping
    public ResponseEntity<usuarioGamer> inserir(@RequestBody usuarioGamer usuario) {
        return ResponseEntity.ok(service.inserir(usuario));
    }
    //PUT /pessoa /{id} (Atualizar)
    @PutMapping("/{id}")
    public ResponseEntity<usuarioGamer> atualizar(@PathVariable Long id,
                                                  @RequestBody usuarioGamer dados){
        return ResponseEntity.ok(service.atualizar(id, dados));
    }

    //DELETE /pessoas/ {id}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
