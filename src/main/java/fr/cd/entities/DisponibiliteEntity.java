package fr.cd.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Data
@Table(name = "DISPONIBILITE", schema = "dbo", catalog = "PROGICA")
public class DisponibiliteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_DISPONIBILITE")
    private int idDisponibilite;
    @Basic
    @Column(name = "JOUR")
    private int jour;
    @Basic
    @Column(name = "HEURE_DEBUT")
    private Date heureDebut;
    @Basic
    @Column(name = "HEURE_FIN")
    private Date heureFin;
    @Basic
    @Column(name = "ID_PERSONNE")
    private int idPersonne;
//    @ManyToOne
//    @JoinColumn(name = "ID_PERSONNE")
//    private DisponibiliteEntity disponibilite;

    }
