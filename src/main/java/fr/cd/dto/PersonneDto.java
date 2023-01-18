package fr.cd.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.cd.HateOas;
import fr.cd.entities.PersonneEntity;
import fr.cd.entities.TelephoneEntity;
import fr.cd.entities.TypeTelephoneEntity;
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
    private List <Telephone> numTel;



    public PersonneDto(PersonneEntity personneEntity) {
       idPersonne = personneEntity.getIdPersonne();
       nomPersonne = personneEntity.getNomPersonne();
       prenomPersonne = personneEntity.getPrenomPersonne();
       codeAderent = personneEntity.getCodeAderent();
       numTel = fromTelephoneDtoList(personneEntity.getTelephoneEntity());

    }

    private List<Telephone> fromTelephoneDtoList(List<TelephoneEntity> telephoneEntities) {
        List<Telephone> telephoneList = new ArrayList<>();
        for (TelephoneEntity telephoneEntity : telephoneEntities){
            telephoneList.add(new Telephone(telephoneEntity));
        }
        return telephoneList;
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

    @Data
    class Telephone{
         String numTel;
         TypeTelephone typeTelephone;


        public Telephone(TelephoneEntity telephoneEntity) {
           numTel = telephoneEntity.getNumTel();
           typeTelephone = new TypeTelephone(telephoneEntity.getTypeTelephone());
        }


    }
    @Data
    class TypeTelephone{
        int idTypeTelephone;
        String nomTypeTelephone;

        public TypeTelephone(TypeTelephoneEntity typeTelephoneEntity) {
            idTypeTelephone = typeTelephoneEntity.getIdTypeTelephone();
            nomTypeTelephone = typeTelephoneEntity.getLibelleTypeTelephone();
        }
    }
}
