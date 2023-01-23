package fr.cd.repositories;

import fr.cd.entities.DisponibiliteEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class DisponibiliteRepository implements PanacheRepositoryBase<DisponibiliteEntity,Integer> {
}
