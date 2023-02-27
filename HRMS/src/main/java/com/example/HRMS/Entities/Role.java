package com.example.HRMS.Entities;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Erole name ;

    public Role(Erole name) {
        this.name = name;
    }

}