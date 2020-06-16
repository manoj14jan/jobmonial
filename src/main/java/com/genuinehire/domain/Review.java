package com.genuinehire.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Reviewid;

    @NotNull
    @Column(name = "rating")
    private Integer Rating;

    @NotNull
    @Column(name = "work_life_balance")
    private Integer Work_life_Balance;

    @NotEmpty
    @Column(name = "Comments")
    private  String Comments;

}
