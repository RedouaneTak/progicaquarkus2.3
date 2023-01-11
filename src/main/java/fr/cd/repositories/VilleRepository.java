package fr.cd.repositories;

import fr.cd.entities.VilleEntity;
import fr.cd.entities.VilleEntityPK;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class VilleRepository implements PanacheRepositoryBase<VilleEntity, VilleEntityPK> {
}
