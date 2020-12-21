package omgtu.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString(exclude = {"client"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Expose
    @Column(name = "spare_id")
    private Long spareId;

    @Expose
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Expose
    private Integer quantity;

    @Expose
    private BigDecimal amount;

    @Expose
    @Column(name = "employee_id")
    private String employeeId;

   /* @Expose
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Spare spare;*/

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
}