package fr.cd.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;



@Data
@Entity
@Table(name = "VILLE", schema = "dbo", catalog = "PROGICA")
public class VilleEntity {

    @EmbeddedId
    private VilleEntityPK villeEntityPK;

    @Basic
    @Column(name = "NOM_VILLE")
    private String nomVille;
    @Basic
    @Column(name = "LATITUDE")
    private Double latitude;
    @Basic
    @Column(name = "LONGITUDE")
    private Double longitude;


}
