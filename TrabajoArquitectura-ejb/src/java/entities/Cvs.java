/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nacho
 */
@Entity
@Table(name = "CVS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cvs.findAll", query = "SELECT c FROM Cvs c")
    , @NamedQuery(name = "Cvs.findByNombre", query = "SELECT c FROM Cvs c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cvs.findByApellidos", query = "SELECT c FROM Cvs c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "Cvs.findByPais", query = "SELECT c FROM Cvs c WHERE c.pais = :pais")
    , @NamedQuery(name = "Cvs.findByProvincia", query = "SELECT c FROM Cvs c WHERE c.provincia = :provincia")
    , @NamedQuery(name = "Cvs.findByCpos", query = "SELECT c FROM Cvs c WHERE c.cpos = :cpos")
    , @NamedQuery(name = "Cvs.findByExlab", query = "SELECT c FROM Cvs c WHERE c.exlab = :exlab")
    , @NamedQuery(name = "Cvs.findByEdyfor", query = "SELECT c FROM Cvs c WHERE c.edyfor = :edyfor")
    , @NamedQuery(name = "Cvs.findByLengmat", query = "SELECT c FROM Cvs c WHERE c.lengmat = :lengmat")
    , @NamedQuery(name = "Cvs.findByIdiomas", query = "SELECT c FROM Cvs c WHERE c.idiomas = :idiomas")
    , @NamedQuery(name = "Cvs.findByComcom", query = "SELECT c FROM Cvs c WHERE c.comcom = :comcom")
    , @NamedQuery(name = "Cvs.findByComorg", query = "SELECT c FROM Cvs c WHERE c.comorg = :comorg")
    , @NamedQuery(name = "Cvs.findByComemp", query = "SELECT c FROM Cvs c WHERE c.comemp = :comemp")
    , @NamedQuery(name = "Cvs.findByComdig", query = "SELECT c FROM Cvs c WHERE c.comdig = :comdig")
    , @NamedQuery(name = "Cvs.findByUsername", query = "SELECT c FROM Cvs c WHERE c.username = :username")
    , @NamedQuery(name = "Cvs.findByFechora", query = "SELECT c FROM Cvs c WHERE c.fechora = :fechora")
    , @NamedQuery(name = "Cvs.findById", query = "SELECT c FROM Cvs c WHERE c.id = :id")})
public class Cvs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 200)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 50)
    @Column(name = "PAIS")
    private String pais;
    @Size(max = 100)
    @Column(name = "PROVINCIA")
    private String provincia;
    @Column(name = "CPOS")
    private Integer cpos;
    @Size(max = 2000)
    @Column(name = "EXLAB")
    private String exlab;
    @Size(max = 2000)
    @Column(name = "EDYFOR")
    private String edyfor;
    @Size(max = 50)
    @Column(name = "LENGMAT")
    private String lengmat;
    @Size(max = 100)
    @Column(name = "IDIOMAS")
    private String idiomas;
    @Size(max = 2000)
    @Column(name = "COMCOM")
    private String comcom;
    @Size(max = 2000)
    @Column(name = "COMORG")
    private String comorg;
    @Size(max = 2000)
    @Column(name = "COMEMP")
    private String comemp;
    @Size(max = 2000)
    @Column(name = "COMDIG")
    private String comdig;
    @Size(max = 50)
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "FECHORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechora;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;

    public Cvs() {
    }

    public Cvs(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getCpos() {
        return cpos;
    }

    public void setCpos(Integer cpos) {
        this.cpos = cpos;
    }

    public String getExlab() {
        return exlab;
    }

    public void setExlab(String exlab) {
        this.exlab = exlab;
    }

    public String getEdyfor() {
        return edyfor;
    }

    public void setEdyfor(String edyfor) {
        this.edyfor = edyfor;
    }

    public String getLengmat() {
        return lengmat;
    }

    public void setLengmat(String lengmat) {
        this.lengmat = lengmat;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getComcom() {
        return comcom;
    }

    public void setComcom(String comcom) {
        this.comcom = comcom;
    }

    public String getComorg() {
        return comorg;
    }

    public void setComorg(String comorg) {
        this.comorg = comorg;
    }

    public String getComemp() {
        return comemp;
    }

    public void setComemp(String comemp) {
        this.comemp = comemp;
    }

    public String getComdig() {
        return comdig;
    }

    public void setComdig(String comdig) {
        this.comdig = comdig;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFechora() {
        return fechora;
    }

    public void setFechora(Date fechora) {
        this.fechora = fechora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public boolean contiene(String text){
        if((nombre!=null)&&(nombre.contains(text)))return true;
        if((apellidos!=null)&&(apellidos.contains(text)))return true;
        if((pais!=null)&&(pais.contains(text)))return true;
        if((idiomas!=null)&&(idiomas.contains(text)))return true;
        if((lengmat!=null)&&(lengmat.contains(text)))return true;
        if((exlab!=null)&&(exlab.contains(text)))return true;
        if((provincia!=null)&&(provincia.contains(text)))return true;
        if((exlab!=null)&&(exlab.contains(text)))return true;
        if((edyfor!=null)&&(edyfor.contains(text)))return true;
        if((comcom!=null)&&(comcom.contains(text)))return true;
        if((comorg!=null)&&(comorg.contains(text)))return true;
        if((comdig!=null)&&(comdig.contains(text)))return true;
        if((comemp!=null)&&(comemp.contains(text)))return true;
        return false;
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
        if (!(object instanceof Cvs)) {
            return false;
        }
        Cvs other = (Cvs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cvs[ id=" + id + " ]";
    }
    
}
