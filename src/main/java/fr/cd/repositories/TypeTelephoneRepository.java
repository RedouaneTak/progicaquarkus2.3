package fr.cd.repositories;

import fr.cd.entities.TypeTelephoneEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TypeTelephoneRepository implements PanacheRepositoryBase<TypeTelephoneEntity, Integer> {
}
