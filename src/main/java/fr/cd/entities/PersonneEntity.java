package fr.cd.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "PERSONNE", schema = "dbo", catalog = "PROGICA")
public class PersonneEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PERSONNE")
    private int idPersonne;
    @Basic
    @Column(name = "NOM_PERSONNE")
    private String nomPersonne;
    @Basic
    @Column(name = "PRENOM_PERSONNE")
    private String prenomPersonne;
    @Basic
    @Column(name = "CODE_ADERENT")
    private String codeAderent;
    @Basic
    @Column(name = "ID_MAIL")
    private String idMail;


}
