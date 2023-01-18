package fr.cd.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.cd.HateOas;
import fr.cd.entities.SaisonGiteEntity;
import fr.cd.entities.TelephoneEntity;
import fr.cd.entities.TypeTelephoneEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"numTel","idPersonne","idTypeTelephone"})
public class TelephoneDto extends HateOas {
    private String numTel;
    private int idPersonne;
    private TypeTelephone typeTelephone;



    public TelephoneDto(TelephoneEntity telephoneEntity){
        numTel = telephoneEntity.getNumTel();
        idPersonne = telephoneEntity.getIdPersonne();
        typeTelephone = new TypeTelephone(telephoneEntity.getTypeTelephone());
    }

    public static List<TelephoneDto> toTelephoneDtoList(List<TelephoneEntity> telephoneEntities) {
        List<TelephoneDto> telephoneDtoList = new ArrayList<>();
        for (TelephoneEntity telephoneEntity : telephoneEntities) {
            telephoneDtoList.add(new TelephoneDto(telephoneEntity));
        }
        return telephoneDtoList;
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
