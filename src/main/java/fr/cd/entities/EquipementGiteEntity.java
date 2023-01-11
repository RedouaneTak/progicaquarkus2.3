package fr.cd.entities;

import lombok.Data;
import org.hibernate.loader.plan.spi.Fetch;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "EQUIPEMENT_GITE", schema = "dbo", catalog = "PROGICA")
public class EquipementGiteEntity {

    @EmbeddedId
    private EquipementGiteEntityPK equipementGiteEntityPK;

    @Basic
    @Column(name = "PRIX_EQUIPEMENT")
    private float prixEquipement;





}
