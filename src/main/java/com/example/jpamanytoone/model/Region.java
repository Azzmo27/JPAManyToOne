package com.example.jpamanytoone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Region {
    @Id
    @Column(length = 4) //ikke mere end 4 char
    private String kode;
    @Column(nullable = false) //man skal have et navn
    private String navn;
    private String href;

    @OneToMany(mappedBy = "region")
    @JsonBackReference
    private Set<Kommune> kommuner = new HashSet<>();


    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
