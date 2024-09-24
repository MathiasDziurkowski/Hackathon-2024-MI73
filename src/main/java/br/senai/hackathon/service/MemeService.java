package br.senai.hackathon.service;

import br.senai.hackathon.entity.Meme;
import br.senai.hackathon.repository.MemeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class MemeService {
    private MemeRepository repository;


    public Page<Meme> buscarTodosPaginado(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void criarMeme(List<MultipartFile> multipartFiles) throws IOException {
        List<Meme> memes = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            memes.add(new Meme(multipartFile));
        }
        repository.saveAll(memes);
    }

    public Meme buscarMemePorId(Long id) throws NoSuchElementException {
        return repository.findById(id).orElseThrow();
    }
}
