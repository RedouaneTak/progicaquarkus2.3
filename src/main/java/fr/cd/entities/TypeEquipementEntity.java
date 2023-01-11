package fr.cd.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "TYPE_EQUIPEMENT", schema = "dbo", catalog = "PROGICA")
public class TypeEquipementEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_TYPE_EQUIPEMENT")
    private int idTypeEquipement;
    @Basic
    @Column(name = "LIBELLE_TYPE_EQUIPEMENT")
    private String libelleTypeEquipement;

}
