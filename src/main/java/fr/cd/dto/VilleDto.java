package fr.cd.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.cd.HateOas;
import fr.cd.entities.VilleEntity;
import fr.cd.entities.VilleEntityPK;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"codeInseeDept","codeInsee","nomVille"})
public class VilleDto extends HateOas {

    private String codeInseeDept;
    private String codeInsee;
    private String nomVille;


    public VilleDto(VilleEntity villeEntity) {
        codeInsee = villeEntity.getVilleEntityPK().getCodeInsee();
        codeInseeDept = villeEntity.getVilleEntityPK().getCodeInseeDept();
        nomVille = villeEntity.getNomVille();
    }



    public static List<VilleDto> toVilleDtoList(List<VilleEntity> villeEntities) {
        List<VilleDto> villeDtoList = new ArrayList<>();
        for (VilleEntity villeEntity : villeEntities) {
            villeDtoList.add(new VilleDto(villeEntity));
        }
        return villeDtoList;
    }

    public static VilleDto toVilleById(VilleEntity villeEntity) {
         return new VilleDto(villeEntity);

    }



}