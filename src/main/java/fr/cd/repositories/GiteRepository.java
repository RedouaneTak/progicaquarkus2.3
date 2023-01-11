package fr.cd.repositories;

import fr.cd.entities.GiteEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class GiteRepository implements PanacheRepositoryBase<GiteEntity, Integer> {
}
