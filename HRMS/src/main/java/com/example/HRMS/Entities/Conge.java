package com.example.HRMS.Entities;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Conge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCong;
    private String typeCong;
    private LocalDate debutCong;
    private LocalDate finCong;
    private LocalDate createdAt;
    private String description;
    private int duree ;
    private int soldeConge ;
    private String statusOfDemand="Waiting";
    @ManyToOne
    @JoinColumn(name = "idEmployee", referencedColumnName = "idEmployee")
    private Employee user;
    }



