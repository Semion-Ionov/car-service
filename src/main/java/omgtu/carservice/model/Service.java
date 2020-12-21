package omgtu.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString()
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "services")
public class Service {
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    /*@JsonIgnore
    @OneToMany(mappedBy = "service",
               fetch = FetchType.LAZY)
    private List<Purchase> purchases;*/
}