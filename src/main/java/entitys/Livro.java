package entitys;
import enums.StatusLivro;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "livro")
@Entity
public class Livro{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    @Size(max = 255)
    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "isbn", unique = true, length = 13)
    @Size(min = 10, max = 13, message = "O ISBN deve ter entre 10 e 13 caracteres")
    private String isbn;

    @NotNull
    @Column(name = "numero_paginas")
    private Integer numeroPaginas;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusLivro status = StatusLivro.DISPONIVEL;

    @Builder.Default
    @Min(0)
    @Column(name = "quantidade_total", nullable = false)
    private Integer quantidadeTotal = 1;

    @Builder.Default
    @Min(0)
    @Column(name = "quantidade_disponivel", nullable = false)
    private Integer quantidadeDisponivel = 1;

    @Size(max = 1000)
    @Column(length = 1000)
    private String sinopse;

    @CreationTimestamp
    @Column(name = "data_cadastro", updatable = false)
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

}
