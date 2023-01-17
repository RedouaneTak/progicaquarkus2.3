package fr.cd.repositories;

import fr.cd.entities.SaisonGiteEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class SaisonGiteRepository implements PanacheRepositoryBase<SaisonGiteEntity, Integer> {
}
