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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "VALORACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoraciones.findAll", query = "SELECT v FROM Valoraciones v")
    , @NamedQuery(name = "Valoraciones.findById", query = "SELECT v FROM Valoraciones v WHERE v.id = :id")
    , @NamedQuery(name = "Valoraciones.findByUsuario", query = "SELECT v FROM Valoraciones v WHERE v.usuario = :usuario")
    , @NamedQuery(name = "Valoraciones.findByEmpresa", query = "SELECT v FROM Valoraciones v WHERE v.empresa = :empresa")
    , @NamedQuery(name = "Valoraciones.findByValoracion", query = "SELECT v FROM Valoraciones v WHERE v.valoracion = :valoracion")})
public class Valoraciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "USUARIO")
    private String usuario;
    @Size(max = 100)
    @Column(name = "EMPRESA")
    private String empresa;
    @Column(name = "VALORACION")
    private Integer valoracion;

    public Valoraciones() {
    }

    public Valoraciones(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoraciones)) {
            return false;
        }
        Valoraciones other = (Valoraciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Valoraciones[ id=" + id + " ]";
    }
    
}
