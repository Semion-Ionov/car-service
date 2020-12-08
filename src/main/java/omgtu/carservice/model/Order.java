package omgtu.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    private Integer quantity;

    private BigDecimal amount;

    @Column(name = "employee_id")
    private String employeeId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Spare spare;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
}