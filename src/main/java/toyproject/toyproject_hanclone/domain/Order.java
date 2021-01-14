package toyproject.toyproject_hanclone.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "`order`")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    private Long amount;
    private Long stat;
    private Date date;

    @ManyToOne @JoinColumn(name = "userId")
    private User user;
    @ManyToOne @JoinColumn(name = "productId")
    private Product product;
}
