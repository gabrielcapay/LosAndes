package com.example.Los_Andes.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String permissionName;

}
