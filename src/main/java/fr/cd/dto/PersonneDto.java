package fr.cd.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.cd.HateOas;
import fr.cd.entities.PersonneEntity;
import fr.cd.entities.SaisonGiteEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@JsonPropertyOrder({"idPersonne", "nomPersonne","prenomPersonne","codeAderent"})
public class PersonneDto extends HateOas {
    private int idPersonne;
    private String nomPersonne;
    private String prenomPersonne;
    private String codeAderent;

    public PersonneDto(PersonneEntity personneEntity) {
       idPersonne = personneEntity.getIdPersonne();
       nomPersonne = personneEntity.getNomPersonne();
       prenomPersonne = personneEntity.getPrenomPersonne();
        codeAderent = personneEntity.getCodeAderent();
    }

    public static List<PersonneDto> toPersonneDtoList(List<PersonneEntity> personneEntities) {
        List<PersonneDto> personneDtoList = new ArrayList<>();
        for (PersonneEntity personneEntity : personneEntities) {
            personneDtoList.add(new PersonneDto(personneEntity));
        }
        return personneDtoList;
    }

    public static PersonneDto toPersonneById(PersonneEntity personneEntity) {
        return new PersonneDto(personneEntity);

    }
}
