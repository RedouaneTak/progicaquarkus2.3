package fr.cd.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.cd.HateOas;
import fr.cd.entities.GiteEntity;
import fr.cd.entities.PersonneEntity;
import fr.cd.entities.TelephoneEntity;
import fr.cd.entities.TypeTelephoneEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"id","nomGite","nbrChambre","nbrCouchage","surface","adresse"})
public class GiteDetailsDto extends HateOas {

    private int id;
    private String nomGite;
    private int nbrChambre;
    private int nbrCouchage;
    private int surface;
    private String adresse;
    private Personne proprietaire;
    private Personne gerant;

    public GiteDetailsDto(GiteEntity giteEntity){
         id = giteEntity.getIdGite();
         nomGite = giteEntity.getNomGite();
         nbrChambre = giteEntity.getNbrChambre();
         nbrCouchage = giteEntity.getNbrCouchage();
         surface = giteEntity.getSurfaceHabitable();
         adresse = giteEntity.getAdresseGite();
         proprietaire = new Personne(giteEntity.getPersonne());
         gerant = new Personne(giteEntity.getPersonneGerant());

    }

    public static List<GiteDetailsDto> toGiteDtoList(List<GiteEntity> giteEntities) {
        List<GiteDetailsDto> giteDtoList = new ArrayList<>();
        for (GiteEntity giteEntity : giteEntities){
            giteDtoList.add(new GiteDetailsDto(giteEntity));
        }
        return giteDtoList;
    }

    public static GiteDetailsDto toGiteById (GiteEntity giteEntity){
        return new GiteDetailsDto(giteEntity);
    }

    @Getter
    @Setter
    class Personne{

        int idPersonne;
        String nom;
        String prenom;
        String codeAderent;
        String idMail;
        List<Telephone> telephone;

        public Personne(PersonneEntity personneEntity){

            idPersonne = personneEntity.getIdPersonne();
            nom= personneEntity.getNomPersonne();
            prenom = personneEntity.getPrenomPersonne();
            codeAderent = personneEntity.getCodeAderent();
            idMail = personneEntity.getIdMail();
            telephone = Telephone.toListTelephone(personneEntity.getTelephoneEntity());



        }

    }
    @Data
    static
    class Telephone{
        String numTel;
        TypeTelephone typeTelephone;


        public Telephone(TelephoneEntity telephoneEntity) {
            numTel = telephoneEntity.getNumTel();
            typeTelephone = new TypeTelephone(telephoneEntity.getTypeTelephone());
        }

        public  static List<Telephone> toListTelephone(List<TelephoneEntity> telephoneEntities){
            List<Telephone> telephones = new ArrayList<>();
            for(TelephoneEntity telephoneEntity:telephoneEntities){
                telephones.add(new Telephone(telephoneEntity));
            }

            return telephones;
        }


    }
    @Data
    static
    class TypeTelephone{
        int idTypeTelephone;
        String nomTypeTelephone;

        public TypeTelephone(TypeTelephoneEntity typeTelephoneEntity) {
            idTypeTelephone = typeTelephoneEntity.getIdTypeTelephone();
            nomTypeTelephone = typeTelephoneEntity.getLibelleTypeTelephone();
        }
    }

}
