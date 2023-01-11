package fr.cd.repositories;

import fr.cd.entities.EquipementEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class EquipementRepository implements PanacheRepositoryBase<EquipementEntity, Integer> {
}
