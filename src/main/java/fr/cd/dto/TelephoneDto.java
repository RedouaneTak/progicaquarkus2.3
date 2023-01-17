package fr.cd.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.cd.HateOas;
import fr.cd.entities.SaisonGiteEntity;
import fr.cd.entities.TelephoneEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"numTel","idPersonne","idTypeTelephone"})
public class TelephoneDto extends HateOas {
    private String numTel;
    private int idPersonne;
    private int idTypeTelephone;


    public TelephoneDto(TelephoneEntity telephoneEntity){
        numTel = telephoneEntity.getNumTel();
        idPersonne = telephoneEntity.getIdPersonne();
        idTypeTelephone = telephoneEntity.getIdTypeTelephone();
    }

    public static List<TelephoneDto> toTelephoneDtoList(List<TelephoneEntity> telephoneEntities) {
        List<TelephoneDto> telephoneDtoList = new ArrayList<>();
        for (TelephoneEntity telephoneEntity : telephoneEntities) {
            telephoneDtoList.add(new TelephoneDto(telephoneEntity));
        }
        return telephoneDtoList;
    }
}
