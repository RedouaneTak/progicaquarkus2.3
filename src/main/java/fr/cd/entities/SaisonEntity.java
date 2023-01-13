package fr.cd.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "SAISON", schema = "dbo", catalog = "PROGICA")
public class SaisonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_SAISON")
    private int idSaison;
    @Basic
    @Column(name = "LIBELLE_SAISON")
    private String libelleSaison;

}
