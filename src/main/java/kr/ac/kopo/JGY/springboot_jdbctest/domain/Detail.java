package kr.ac.kopo.JGY.springboot_jdbctest.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private float weight;
    private float height;
    private float width;
    @OneToOne
    @JoinColumn(name = "product_id")
    @MapsId
    private Product product;
}
