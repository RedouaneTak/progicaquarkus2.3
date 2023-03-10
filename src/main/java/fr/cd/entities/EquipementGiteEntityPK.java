package fr.cd.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class EquipementGiteEntityPK implements Serializable {

    @Column(name = "ID_GITE")
    private int idGite;


    @ManyToOne
    @JoinColumn(name = "ID_EQUIPEMENT")
    private EquipementEntity equipementEntity;

}
