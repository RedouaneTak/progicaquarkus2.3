package fr.cd.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "DEPARTEMENT", schema = "dbo", catalog = "PROGICA")
public class DepartementEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODE_INSEE_DEPT")
    private String codeInseeDept;
    @Basic
    @Column(name = "NOM_DEPARTEMENT")
    private String nomDepartement;
    @Basic
    @Column(name = "ID_REGION")
    private int idRegion;

   }
