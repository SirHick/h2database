package exe_gamer.h2database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor //Construtor vazio
@AllArgsConstructor //Construtor com todos os argumentos

public class usuarioGamer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String email;
    private String jogoFavorito;
    private Integer nivel;
    //Lombok gera tudo (getters e setters das variáveis)
    }
