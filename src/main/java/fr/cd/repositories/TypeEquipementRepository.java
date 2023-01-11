package fr.cd.repositories;

import fr.cd.entities.TypeEquipementEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TypeEquipementRepository implements PanacheRepositoryBase<TypeEquipementEntity, Integer> {
}
