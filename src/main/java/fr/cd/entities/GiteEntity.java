package fr.cd.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "GITE", schema = "dbo", catalog = "PROGICA")
public class GiteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_GITE")
    private int idGite;
    @Basic
    @Column(name = "NOM_GITE")
    private String nomGite;
    @Basic
    @Column(name = "NBR_CHAMBRE")
    private int nbrChambre;
    @Basic
    @Column(name = "NBR_COUCHAGE")
    private int nbrCouchage;
    @Basic
    @Column(name = "SURFACE_HABITABLE")
    private int surfaceHabitable;
    @Basic
    @Column(name = "ADRESSE_GITE")
    private String adresseGite;
    @Basic
    @Column(name = "ID_PERSONNE")
    private int idPersonne;
    @Basic
    @Column(name = "ID_PERSONNE_GERANT_GITE")
    private int idPersonneGerantGite;
    @Basic
    @Column(name = "CODE_INSEE_DEPT")
    private String codeInseeDept;
    @Basic
    @Column(name = "CODE_INSEE")
    private String codeInsee;


}
