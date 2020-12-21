package omgtu.carservice.model;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@ToString()
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "producers")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String address;

    private String phone;

}