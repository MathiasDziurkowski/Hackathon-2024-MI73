package br.senai.hackathon.controller;

import br.senai.hackathon.controller.dto.ComentarioPostDTO;
import br.senai.hackathon.entity.Comentario;
import br.senai.hackathon.service.ComentarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/comentario")
@CrossOrigin("*")
public class ComentarioController {

    private ComentarioService service;
    @PostMapping
    public ResponseEntity<Comentario> criarComentario(@RequestBody ComentarioPostDTO dto){
        return ResponseEntity.ok(service.criarComentario(dto));
    }
}
