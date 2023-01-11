package fr.cd.repositories;

import fr.cd.entities.RegionEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class RegionRepository implements PanacheRepositoryBase<RegionEntity, Integer> {
}
