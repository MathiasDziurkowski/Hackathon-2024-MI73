package br.senai.hackathon.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Meme {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private byte[] bytes;
    private String originalFilename;
    private String contentType;
    @OneToMany(mappedBy = "meme")
    private List<Comentario> comentarioList;
    @CreationTimestamp
    private LocalDate creationTime;

    public Meme(MultipartFile multipartFile) throws IOException {
        this.bytes = multipartFile.getBytes();
        this.originalFilename = multipartFile.getOriginalFilename();
        this.contentType = multipartFile.getContentType();
    }

}
