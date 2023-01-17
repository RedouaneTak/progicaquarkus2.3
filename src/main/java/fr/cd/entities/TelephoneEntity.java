package fr.cd.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "TELEPHONE", schema = "dbo", catalog = "PROGICA")
public class TelephoneEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUM_TEL")
    private String numTel;
    @Basic
    @Column(name = "ID_PERSONNE")
    private int idPersonne;
    @Basic
    @Column(name = "ID_TYPE_TELEPHONE")
    private int idTypeTelephone;


}
