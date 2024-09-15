package org.example;


import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
@Entity
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCalle;

    private  int numero;

    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;


}
