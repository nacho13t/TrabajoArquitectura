/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nacho
 */
@Entity
@Table(name = "ENTERPRISES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enterprises.findAll", query = "SELECT e FROM Enterprises e")
    , @NamedQuery(name = "Enterprises.findByEnterprise", query = "SELECT e FROM Enterprises e WHERE e.enterprise = :enterprise")
    , @NamedQuery(name = "Enterprises.findByCodigo", query = "SELECT e FROM Enterprises e WHERE e.codigo = :codigo")
    , @NamedQuery(name = "Enterprises.findByPerfil", query = "SELECT e FROM Enterprises e WHERE e.perfil = :perfil")
    , @NamedQuery(name = "Enterprises.findByObjetivo", query = "SELECT e FROM Enterprises e WHERE e.objetivo = :objetivo")
    , @NamedQuery(name = "Enterprises.findByMision", query = "SELECT e FROM Enterprises e WHERE e.mision = :mision")
    , @NamedQuery(name = "Enterprises.findByVision", query = "SELECT e FROM Enterprises e WHERE e.vision = :vision")
    , @NamedQuery(name = "Enterprises.findByValores", query = "SELECT e FROM Enterprises e WHERE e.valores = :valores")
    , @NamedQuery(name = "Enterprises.findByValoracion", query = "SELECT e FROM Enterprises e WHERE e.valoracion = :valoracion")
    , @NamedQuery(name = "Enterprises.findByValoraciones", query = "SELECT e FROM Enterprises e WHERE e.valoraciones = :valoraciones")})
public class Enterprises implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ENTERPRISE")
    private String enterprise;
    @Size(max = 100)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "PERFIL")
    private String perfil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "OBJETIVO")
    private String objetivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "MISION")
    private String mision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "VISION")
    private String vision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "VALORES")
    private String valores;
    @Column(name = "VALORACION")
    private Integer valoracion;
    @Column(name = "VALORACIONES")
    private Integer valoraciones;

    public Enterprises() {
    }

    public Enterprises(String enterprise) {
        this.enterprise = enterprise;
    }

    public Enterprises(String enterprise, String perfil, String objetivo, String mision, String vision, String valores) {
        this.enterprise = enterprise;
        this.perfil = perfil;
        this.objetivo = objetivo;
        this.mision = mision;
        this.vision = vision;
        this.valores = valores;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getValores() {
        return valores;
    }

    public void setValores(String valores) {
        this.valores = valores;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public Integer getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(Integer valoraciones) {
        this.valoraciones = valoraciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enterprise != null ? enterprise.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enterprises)) {
            return false;
        }
        Enterprises other = (Enterprises) object;
        if ((this.enterprise == null && other.enterprise != null) || (this.enterprise != null && !this.enterprise.equals(other.enterprise))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Enterprises[ enterprise=" + enterprise + " ]";
    }
    
}
