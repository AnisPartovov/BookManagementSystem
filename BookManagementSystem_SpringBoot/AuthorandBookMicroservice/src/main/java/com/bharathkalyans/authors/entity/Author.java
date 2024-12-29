package com.bharathkalyans.authors.entity;


import jakarta.persistence.*;

@Entity
public class Author {

    @Id
    @SequenceGenerator(name = "author_sequence_generator", sequenceName = "author_sequence_generator", allocationSize = 1)
    @GeneratedValue(generator = "author_sequence_generator", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "author_name", nullable = false)
    private String authorName;

    public Integer getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
