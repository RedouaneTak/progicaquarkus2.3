package fr.cd.repositories;

import fr.cd.entities.DepartementEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class DepartementRepository implements PanacheRepositoryBase<DepartementEntity, String> {
}
