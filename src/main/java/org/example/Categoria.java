package org.example;


import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Audited
@Entity
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;
    @Builder.Default
    @ManyToMany(mappedBy = "categorias")
    private List<Articulo> articulos = new ArrayList<Articulo>();

}
