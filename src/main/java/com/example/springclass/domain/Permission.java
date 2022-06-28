package com.example.springclass.domain;

import lombok.*;

import javax.persistence.*;

@Table(name = "PERMISSION")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
