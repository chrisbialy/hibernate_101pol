package sda.hibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Author {

    @Id
    private int id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "books_authors",
            joinColumns = {@JoinColumn(name = "book_id")}, // klucz obcy w tabeli books_authors - wskazujący na tabelę Books
            inverseJoinColumns = {@JoinColumn(name = "author_id")}) // klucz obcy w tabeli books_autors - wskazujący na tabelę Author
    Set<Book> books;

}