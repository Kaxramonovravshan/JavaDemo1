package com.book.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "author_id", nullable = false)
    private long author_id;
    private String authorName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private List<Book> books;

}
