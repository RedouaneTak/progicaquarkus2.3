package fr.cd.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "REGION", schema = "dbo", catalog = "PROGICA")
public class RegionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_REGION")
    private int idRegion;
    @Basic
    @Column(name = "NOM_REGION")
    private String nomRegion;

 }
