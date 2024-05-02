package br.com.edu.infnet.tp01springboot.controller;

import br.com.edu.infnet.tp01springboot.domain.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public UsuarioController() {
        usuarios.addAll(List.of(
                new Usuario(1,"thalita","Policarpo","thalita@gmail.com", "30","Feminino"),
                new Usuario(2,"Aline","Silva","aline@gmail.com", "22","Feminino"),
                new Usuario(3,"Bruno","Assis","bruno@gmail.com", "30","Masculino"),
                new Usuario(4,"Luis","Andrade","luis@gmail.com", "35","Masculino"),
                new Usuario(5,"barbara","Sousa","barbara@gmail.com", "29","Feminino"),
                new Usuario(6,"Luana","Alcantara","luana@gmail.com", "37","Feminino")
        ));
    }

    @GetMapping("/usuarios")
    Iterable<Usuario> getUsuario(){
        return usuarios;
    }

    @GetMapping("/usuarios/{id}")
    Optional<Usuario> getUsuarioPorId(@PathVariable int id){

        for(Usuario usuario : usuarios){
            if(usuario.getId() == id){
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }

    @PostMapping("/usuarios/incluir")
    Usuario incluirUsuario(@RequestBody Usuario usuario){
        usuarios.add(usuario);
        return usuario;
    }

    @PutMapping("/usuarios/{id}/atualizar")
    Usuario atualizarAluno(@PathVariable int id, @RequestBody Usuario usuario){
        int usuarioIndex = -1;
        for(Usuario u : usuarios){
            if(u.getId() == id){
                usuarioIndex = usuarios.indexOf(u);
                usuarios.set(usuarioIndex, usuario);
            }
        }
        return ( usuarioIndex == -1) ? incluirUsuario(usuario) : usuario;
    }

    @DeleteMapping("/usuarios/{id}/deletar")
    void deletarUsuario(@PathVariable int id){
        usuarios.removeIf(usuario -> usuario.getId() == id);
    }
}
