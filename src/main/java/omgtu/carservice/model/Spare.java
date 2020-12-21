package omgtu.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
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
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Expose
    @Column(name = "categoryid")
    private Long categoryId;

    @Expose
    @Column(name = "type")
    private String type;

    @Expose
    @Column(name = "name")
    private String name;

    @Expose
    @Column(name = "manufacturer")
    private String manufacturer;

    @Expose
    @Column(name = "price")
    private BigDecimal price;

    @Expose
    @Column(name = "img")
    private String img;

  /*  @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "spare")
    private List<Order> orders;*/
}
