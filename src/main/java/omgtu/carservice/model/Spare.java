package omgtu.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spares")
public class Spare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "categoryid")
    private Long categoryId;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "img")
    private String img;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "spare")
    private List<Order> orders;
}
