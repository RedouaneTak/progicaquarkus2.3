package fr.cd.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.cd.HateOas;
import fr.cd.entities.DepartementEntity;
import fr.cd.entities.RegionEntity;
import fr.cd.entities.VilleEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"idRegion","nomRegion"})
public class RegionDto extends HateOas {

    private String nomRegion;
    private Integer idRegion;

    public RegionDto(RegionEntity regionEntity){

        nomRegion = regionEntity.getNomRegion();
        idRegion = regionEntity.getIdRegion();

    }

    public static List<RegionDto> toRegionDtoList(List<RegionEntity> regionEntities) {
        List<RegionDto> regionDtoList = new ArrayList<>();
        for (RegionEntity regionEntity : regionEntities){
            regionDtoList.add(new RegionDto(regionEntity));
        }
        return regionDtoList;
    }

    public static RegionDto toRegionById(RegionEntity regionEntity) {
        return new RegionDto(regionEntity);

    }



}
