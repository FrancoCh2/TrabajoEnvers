package org.example;


import lombok.*;
import lombok.Builder.Default;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
@Entity
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fecha;

    private int numero;

    private int total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="fk_cliente")
    private Cliente cliente;
    @Builder.Default
    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalleFactura = new ArrayList<DetalleFactura>();
}
