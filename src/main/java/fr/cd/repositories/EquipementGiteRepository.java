package fr.cd.repositories;

import fr.cd.entities.EquipementGiteEntity;
import fr.cd.entities.EquipementGiteEntityPK;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class EquipementGiteRepository implements PanacheRepositoryBase<EquipementGiteEntity, EquipementGiteEntityPK> {
}
