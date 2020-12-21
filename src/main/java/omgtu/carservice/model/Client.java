package omgtu.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@ToString(exclude = {"orders", "purchases"})
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Expose
    private String name;

    @Expose
    private String surname;

    @Expose
    private String phone;

    @Expose
    private String email;

    private String pswd;

    @Expose
    @JsonIgnore
    @OneToMany(mappedBy = "client",
               fetch = FetchType.LAZY)
    private List<Order> orders;

    @Expose
    @JsonIgnore
    @OneToMany(mappedBy = "client",
               fetch = FetchType.LAZY)
    private List<Purchase> purchases;
}