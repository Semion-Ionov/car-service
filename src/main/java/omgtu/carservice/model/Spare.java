package omgtu.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spares")
public class Spare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private BigDecimal price;

    private String type;

    @Column(name = "img_ref")
    private String imgRef;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Producer producer;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
               mappedBy = "spare")
    private List<Order> orders;
}
