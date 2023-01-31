package co.edu.unicauca.distribuidos.core.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CancionEntity {
    private Integer codigo;
    private String titulo;
    private String tipo;
    private String autor;
    private Double tamanioBytes;

    public CancionEntity() {
    }

}
