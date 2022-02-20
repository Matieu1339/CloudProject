package com.cloudproject.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author samko
 */
@Entity
@Table(name = "Signalement")
@XmlRootElement(name = "signalement")
public class Signalement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement
    @Column(name = "IdSignalement")
    private Integer IdSignalement;


    @XmlElement
    @Column(name = "IdUtilisateur")
    private Integer IdUtilisateur;

    @XmlElement
    @Column(name = "IdType")
    private Integer IdType;

    @XmlElement
    @Column(name = "IdStatus")
    private Integer IdStatus;

    @XmlElement
    @Column(name = "DescriptionSignalement")
    private String DescriptionSignalement;

    @XmlElement
    @Column(name = "Longitude")
    private float Longitude;

    @XmlElement
    @Column(name = "Latitude")
    private float Latitude;

    @XmlElement
    @Column(name = "DateHeureSignalement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date DateHeureSignalement;

    public Signalement() {

    }

    public Signalement(Integer IdSignalement, Integer IdUtilisateur, Integer IdType, Integer IdStatus, String DescriptionSignalement, float Longitude, float Latitude, Timestamp DateHeureSignalement) {
        this.IdSignalement = IdSignalement;
        this.IdUtilisateur = IdUtilisateur;
        this.IdType = IdType;
        this.IdStatus = IdStatus;
        this.DescriptionSignalement = DescriptionSignalement;
        this.Longitude = Longitude;
        this.Latitude = Latitude;
        this.DateHeureSignalement = DateHeureSignalement;
    }

    public Integer getIdSignalement() {
        return IdSignalement;
    }

    public void setIdSignalement(Integer IdSignalement) {
        this.IdSignalement = IdSignalement;
    }

    public Integer getIdUtilisateur() {
        return IdUtilisateur;
    }

    public void setIdUtilisateur(Integer IdUtilisateur) {
        this.IdUtilisateur = IdUtilisateur;
    }

    public Integer getIdType() {
        return IdType;
    }

    public void setIdType(Integer IdType) {
        this.IdType = IdType;
    }

    public Integer getIdStatus() {
        return IdStatus;
    }

    public void setIdStatus(Integer IdStatus) {
        this.IdStatus = IdStatus;
    }

    public String getDescriptionSignalement() {
        return DescriptionSignalement;
    }

    public void setDescriptionSignalement(String DescriptionSignalement) {
        this.DescriptionSignalement = DescriptionSignalement;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float Longitude) {
        this.Longitude = Longitude;
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float Latitude) {
        this.Latitude = Latitude;
    }

    public Date getDateHeureSignalement() {
        return DateHeureSignalement;
    }

    public void setDateHeureSignalement(Date dateHeureSignalement) {
        DateHeureSignalement = dateHeureSignalement;
    }
}