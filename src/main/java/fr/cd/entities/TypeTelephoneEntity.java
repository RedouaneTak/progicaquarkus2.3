package fr.cd.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TYPE_TELEPHONE", schema = "dbo", catalog = "PROGICA")
public class TypeTelephoneEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_TYPE_TELEPHONE")
    private int idTypeTelephone;
    @Basic
    @Column(name = "LIBELLE_TYPE_TELEPHONE")
    private String libelleTypeTelephone;

    public int getIdTypeTelephone() {
        return idTypeTelephone;
    }

    public void setIdTypeTelephone(int idTypeTelephone) {
        this.idTypeTelephone = idTypeTelephone;
    }

    public String getLibelleTypeTelephone() {
        return libelleTypeTelephone;
    }

    public void setLibelleTypeTelephone(String libelleTypeTelephone) {
        this.libelleTypeTelephone = libelleTypeTelephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeTelephoneEntity that = (TypeTelephoneEntity) o;
        return idTypeTelephone == that.idTypeTelephone && Objects.equals(libelleTypeTelephone, that.libelleTypeTelephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTypeTelephone, libelleTypeTelephone);
    }
}
