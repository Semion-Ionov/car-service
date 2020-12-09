package omgtu.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@ToString(exclude = {"orders", "purchases"})
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String phone;

    private String email;

    private String pswd;

    @JsonIgnore
    @OneToMany(mappedBy = "client",
               fetch = FetchType.LAZY)
    private List<Order> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "client",
               fetch = FetchType.LAZY)
    private List<Purchase> purchases;
}