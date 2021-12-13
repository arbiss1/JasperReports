package jasper.reports.demo.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    @Column(name = "full_name")
    private String fullName;
}
