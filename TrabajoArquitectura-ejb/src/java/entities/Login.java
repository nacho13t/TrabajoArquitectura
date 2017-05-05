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
import javax.persistence.Lob;
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
@Table(name = "LOGIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l")
    , @NamedQuery(name = "Login.findByUsername", query = "SELECT l FROM Login l WHERE l.username = :username")
    , @NamedQuery(name = "Login.findByPassword", query = "SELECT l FROM Login l WHERE l.password = :password")
    , @NamedQuery(name = "Login.findByNombre", query = "SELECT l FROM Login l WHERE l.nombre = :nombre")
    , @NamedQuery(name = "Login.findByApellidos", query = "SELECT l FROM Login l WHERE l.apellidos = :apellidos")
    , @NamedQuery(name = "Login.findByProfesion", query = "SELECT l FROM Login l WHERE l.profesion = :profesion")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @Lob
    @Column(name = "FOTO")
    private byte[] foto;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 50)
    @Column(name = "PROFESION")
    private String profesion;

    public Login() {
    }

    public Login(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
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

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Login[ username=" + username + " ]";
    }

    public boolean contiene(String text) {
        if((nombre!=null)&&(nombre.contains(text)))return true;
        if((apellidos!=null)&&(apellidos.contains(text)))return true;
        if((profesion!=null)&&(profesion.contains(text)))return true;
        return false;
    }
    
}
