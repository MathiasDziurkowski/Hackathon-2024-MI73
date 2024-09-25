package br.senai.hackathon.controller;

import br.senai.hackathon.entity.Meme;
import br.senai.hackathon.service.MemeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/meme")
@CrossOrigin("*")
public class MemeController {
    private MemeService memeService;

    @GetMapping
    public ResponseEntity<Page<Meme>> buscarTodosPaginado(Pageable pageable) {
        return ResponseEntity.status(200).body(memeService.buscarTodosPaginado(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meme> buscarMemePorId(@PathVariable Long id) {
        try {
            return ResponseEntity.status(200).body(memeService.buscarMemePorId(id));
        } catch (NoSuchElementException exception) {
            return ResponseEntity.status(400).build();
        }

    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> criarMeme(List<MultipartFile> multipartFiles) {
        try {
            memeService.criarMeme(multipartFiles);
            return ResponseEntity.status(200).build();
        } catch (IOException exception) {
            return ResponseEntity.status(400).build();
        }
    }
}
