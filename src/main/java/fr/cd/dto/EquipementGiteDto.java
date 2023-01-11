package fr.cd.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.cd.HateOas;
import fr.cd.entities.EquipementGiteEntity;
import fr.cd.entities.VilleEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"idGite","idEquipement","prixEquipement","nomEquipement","idTypeEquipement","nomTypeEquipement"})
public class EquipementGiteDto extends HateOas {

    private Integer idGite;
    private Integer idEquipement;
    private Float prixEquipement;
    private String nomEquipement;
    private Integer idTypeEquipement;
    private String nomTypeEquipement;


    public EquipementGiteDto(EquipementGiteEntity equipementGiteEntity){
        idGite = equipementGiteEntity.getEquipementGiteEntityPK().getIdGite();
        idEquipement = equipementGiteEntity.getEquipementGiteEntityPK().getEquipementEntity().getIdEquipement();
        prixEquipement = equipementGiteEntity.getPrixEquipement();
        nomEquipement = equipementGiteEntity.getEquipementGiteEntityPK().getEquipementEntity().getLibelleEquipement();
        idTypeEquipement = equipementGiteEntity.getEquipementGiteEntityPK().getEquipementEntity().getTypeEquipementEntity().getIdTypeEquipement();
        nomTypeEquipement = equipementGiteEntity.getEquipementGiteEntityPK().getEquipementEntity().getTypeEquipementEntity().getLibelleTypeEquipement();

    }

    public static List<EquipementGiteDto> toEquipementGiteDtoList(List<EquipementGiteEntity> equipementGiteEntities) {
        List<EquipementGiteDto> equipementGiteDtoList = new ArrayList<>();
        for (EquipementGiteEntity equipementGiteEntity : equipementGiteEntities) {
            equipementGiteDtoList.add(new EquipementGiteDto(equipementGiteEntity));
        }
        return equipementGiteDtoList;
    }

    public static EquipementGiteDto toEquipementGiteDtoById(EquipementGiteEntity equipementGiteEntity){
        return new EquipementGiteDto(equipementGiteEntity);
    }

}
