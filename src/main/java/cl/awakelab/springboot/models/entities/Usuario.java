package cl.awakelab.springboot.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer usuarioId;
    private String nombreUsuario;
    private String contrasena;
    private String rol;
}
