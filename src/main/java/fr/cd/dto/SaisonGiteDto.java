package fr.cd.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.cd.HateOas;
import fr.cd.entities.DepartementEntity;
import fr.cd.entities.RegionEntity;
import fr.cd.entities.SaisonGiteEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"idSaison","IdGite","prixLocation"})
public class SaisonGiteDto extends HateOas {
    private int idSaison;
    private int idGite;
    private float prixLocation;

    public SaisonGiteDto(SaisonGiteEntity saisonGiteEntity) {
        this.idSaison = saisonGiteEntity.getIdSaison();
        this.idGite = saisonGiteEntity.getIdGite();
        this.prixLocation = saisonGiteEntity.getPrixLocation();
    }

    public static List<SaisonGiteDto> toSaisonGiteDtoList(List<SaisonGiteEntity> saisonGiteEntities) {
        List<SaisonGiteDto> SaisonGiteDtoList = new ArrayList<>();
        for (SaisonGiteEntity saisonGiteEntity : saisonGiteEntities) {
            SaisonGiteDtoList.add(new SaisonGiteDto(saisonGiteEntity));
        }
        return SaisonGiteDtoList;
    }

    public static SaisonGiteDto toSaisonGiteById(SaisonGiteEntity saisonGiteEntity) {
        return new SaisonGiteDto(saisonGiteEntity);

    }
}
