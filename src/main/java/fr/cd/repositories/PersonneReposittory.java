package fr.cd.repositories;

import fr.cd.entities.PersonneEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class PersonneReposittory implements PanacheRepositoryBase<PersonneEntity, Integer> {
}
