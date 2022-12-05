package example.JPA_N1.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(indexes = @Index(name = "user_id", columnList = "userId"))
public class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    public Logs(Integer userId) {
        this.userId = userId;
    }
}
