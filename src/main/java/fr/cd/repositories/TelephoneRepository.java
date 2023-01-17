package fr.cd.repositories;

import fr.cd.entities.TelephoneEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TelephoneRepository implements PanacheRepositoryBase<TelephoneEntity, String> {
}
