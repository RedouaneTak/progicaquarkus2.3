package fr.cd.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.cd.HateOas;
import fr.cd.entities.DisponibiliteEntity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@JsonPropertyOrder({"idDisponibilite","jour","heureDebut","heureFin"})
public class DisponibiliteDto extends HateOas {
    private int idDisponibilite;
    private int jour;
    private Date heureDebut;
    private Date heureFin;
    private int idPersonne;

    public DisponibiliteDto(DisponibiliteEntity disponibiliteEntity) {
        idDisponibilite = disponibiliteEntity.getIdDisponibilite();
        jour = disponibiliteEntity.getJour();
        heureDebut = disponibiliteEntity.getHeureDebut();
        heureFin = disponibiliteEntity.getHeureFin();
    }

    public static List<DisponibiliteDto> toDisponibiliteDtoList(List<DisponibiliteEntity> disponibiliteEntities) {
        List<DisponibiliteDto> disponibiliteDtos = new ArrayList<>();
        for (DisponibiliteEntity disponibiliteEntity : disponibiliteEntities) {
            disponibiliteDtos.add(new DisponibiliteDto(disponibiliteEntity));
        }
        return disponibiliteDtos;
    }
}
