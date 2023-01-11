package fr.cd.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.cd.HateOas;
import fr.cd.entities.GiteEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"id","nomGite","nbrChambre","nbrCouchage","surface","adresse"})
public class GiteDto extends HateOas {

    private int id;
    private String nomGite;
    private int nbrChambre;
    private int nbrCouchage;
    private int surface;
    private String adresse;

    public GiteDto(GiteEntity giteEntity){
         id = giteEntity.getIdGite();
         nomGite = giteEntity.getNomGite();
         nbrChambre = giteEntity.getNbrChambre();
         nbrCouchage = giteEntity.getNbrCouchage();
         surface = giteEntity.getSurfaceHabitable();
         adresse = giteEntity.getAdresseGite();

    }

    public static List<GiteDto> toGiteDtoList(List<GiteEntity> giteEntities) {
        List<GiteDto> giteDtoList = new ArrayList<>();
        for (GiteEntity giteEntity : giteEntities){
            giteDtoList.add(new GiteDto(giteEntity));
        }
        return giteDtoList;
    }

    public static GiteDto toGiteById (GiteEntity giteEntity){
        return new GiteDto(giteEntity);
    }

}
