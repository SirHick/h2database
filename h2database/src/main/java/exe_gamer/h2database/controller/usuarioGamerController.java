package exe_gamer.h2database.controller;

import exe_gamer.h2database.model.usuarioGamer;
import exe_gamer.h2database.service.usuarioGamerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class usuarioGamerController {

    private final usuarioGamerService service;

    // ========== METODO 1: LISTAR TODAS AS PESSOAS ==========

    @GetMapping ("/")
    public String listar(Model model){
        model.addAttribute("usuarios", service.listar());
        return "lista";
    }

    // ========== METODO 2: MOSTRAR FORMULÁRIO VAZIO (NOVO) ==========

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("usuario", new usuarioGamer());
        return "form";
    }

    // ========== METODO 3: SALVAR OU ATUALIZAR PESSOA ==========

    @PostMapping ("/inserir")
    public String inserir(usuarioGamer usuario){
        service.inserir(usuario);
    return "redirect:/";
    }

    // ========== METODO 4: MOSTRAR FORMULÁRIO PREENCHIDO (EDITAR) ==========

    @GetMapping("/editar/{id}")  // ← {id} é uma VARIÁVEL na URL
    public String editar(@PathVariable Long id, Model model) {

        usuarioGamer usuario = service.buscarPorID(id);
        model.addAttribute("usuario", usuario);
        return "form";
    }

    // ========== METODO 5: EXCLUIR PESSOA ==========

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id) {
        service.remover(id);

        return "redirect:/";
    }
}
