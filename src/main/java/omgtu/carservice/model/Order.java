package omgtu.carservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Expose
    private Integer quantity;

    @Expose
    private BigDecimal amount;

    @Expose
    @Column(name = "employee_id")
    private Long employeeId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;


    @JsonCreator
    public Order(@JsonProperty("spareId") Long spareId, @JsonProperty("timestamp") Date timestamp,
                 @JsonProperty("quantity") Integer quantity, @JsonProperty("amount") BigDecimal amount,
                 @JsonProperty("employeeId") Long employeeId, @JsonProperty("clientId") Long clientId) {

        this.spareId = spareId;
        this.timestamp = timestamp;
        this.quantity = quantity;
        this.amount = amount;
        this.employeeId = employeeId;
        this.client = new Client(clientId, null, null, null, null, null, null, null);
    }
}