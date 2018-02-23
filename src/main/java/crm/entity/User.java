package crm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Please provide a valid e-mail")
    @NotEmpty(message = "Please provide an e-mail")
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private int enabled;

    @ManyToOne
    private Role role;

    public int getColumnCount() {
        return getClass().getDeclaredFields().length;
    }

    public int getRole_id() {
        return role.getId();
    }

    public String getRole_name() {
        return role.getName();
    }

    public String getName() {
        return firstName + " " + lastName;
    }

}
