package fr.cd.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class VilleEntityPK implements Serializable {

    @Column(name = "CODE_INSEE_DEPT")
    private String codeInseeDept;

    @Column(name = "CODE_INSEE")
    private String codeInsee;




}
