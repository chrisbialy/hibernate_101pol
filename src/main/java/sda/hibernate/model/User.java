package sda.hibernate.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"address", "orders"})
@EqualsAndHashCode(exclude = {"address", "orders"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private int id;
    @Column(name = "USR_FIRSTNAME")
    private String firstName;
    @Column(name = "USR_LASTNAME")
    private String lastName;
    @Column(name = "USR_PASSWORD")
    private String password;
    @Column(name = "USR_EMAIL")
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USR_ADD_ID", referencedColumnName = "ADD_ID")
    private Address address;
    @Column(name = "USR_BIRTH_DATE")
    private LocalDate birthDate;
    @OneToMany(mappedBy = "user")
    private Set<Order> orders = new HashSet<>();



}