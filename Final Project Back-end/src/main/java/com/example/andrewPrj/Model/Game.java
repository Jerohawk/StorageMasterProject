package com.example.andrewPrj.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue
    @Column(name="g_id")
    private Integer g_id;

    @Column(name="g_name")
    private String name;


    @Column(name="g_volume")
    private String volume;

    @Column(name="g_author")
    private String author;

    @Column(name="g_phys_vir")
    private String physical_virtual;

    @Column(name="g_type")
    private String type;

    @Column(name="g_copies")
    private String copies;

    @Column(name="g_status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "u_id")
    private Customer user;
}
