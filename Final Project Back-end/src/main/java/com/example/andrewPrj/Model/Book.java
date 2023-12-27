package com.example.andrewPrj.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue
    @Column(name="b_id")
    private Integer b_id;

    @Column(name="b_name")
    private String name;


    @Column(name="b_volume")
    private String volume;

    @Column(name="b_author")
    private String author;

    @Column(name="b_phys_vir")
    private String physical_virtual;

    @Column(name="b_type")
    private String type;

    @Column(name="b_copies")
    private String copies;

    @Column(name="b_status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "u_id")
    private Customer user;
}
