package fr.cd.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "EQUIPEMENT", schema = "dbo", catalog = "PROGICA")
public class EquipementEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_EQUIPEMENT")
    private int idEquipement;
    @Basic
    @Column(name = "LIBELLE_EQUIPEMENT")
    private String libelleEquipement;
//    @Basic
//    @Column(name = "ID_TYPE_EQUIPEMENT")
//    private int idTypeEquipement;

    @ManyToOne
    @JoinColumn(name="ID_TYPE_EQUIPEMENT")
    private TypeEquipementEntity typeEquipementEntity;


}
