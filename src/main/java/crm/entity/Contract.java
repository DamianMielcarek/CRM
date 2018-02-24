package crm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String content;

    private BigDecimal value;

//    @JsonFormat(pattern="yyyy-MM-dd")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate beginDate;

//    @JsonFormat(pattern="yyyy-MM-dd")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private User user;

//    @Transient
//    private DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

}
