package sda.hibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Book {

    @Id
    private int id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    Set<Author> authors;

}