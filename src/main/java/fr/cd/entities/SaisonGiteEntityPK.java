package fr.cd.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Data
public class SaisonGiteEntityPK implements Serializable {
    @Column(name = "ID_GITE")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGite;
    @Column(name = "ID_SAISON")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSaison;

}
