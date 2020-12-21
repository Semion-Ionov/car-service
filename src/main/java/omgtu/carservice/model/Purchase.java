package omgtu.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString(exclude = {"client", "service"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchases")
public class Purchase {
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Expose
    @Column(name = "service_id")
    private Long serviceId;

    @Expose
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;


   /* @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Service service;*/
}