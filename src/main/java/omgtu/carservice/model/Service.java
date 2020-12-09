package omgtu.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
@ToString(exclude = {"purchases"})
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    @JsonIgnore
    @OneToMany(mappedBy = "service",
               fetch = FetchType.LAZY)
    private List<Purchase> purchases;
}