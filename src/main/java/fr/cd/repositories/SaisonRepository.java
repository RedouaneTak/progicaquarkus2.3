package fr.cd.repositories;

import fr.cd.entities.SaisonEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class SaisonRepository implements PanacheRepositoryBase<SaisonEntity,Integer> {
}
