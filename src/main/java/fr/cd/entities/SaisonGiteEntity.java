package fr.cd.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "SAISON_GITE", schema = "dbo", catalog = "PROGICA")
@IdClass(SaisonGiteEntityPK.class)
public class SaisonGiteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_GITE")
    private int idGite;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_SAISON")
    private int idSaison;
    @Basic
    @Column(name = "PRIX_LOCATION")
    private float prixLocation;


}
