/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Enterprises;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author nacho
 */
public class EnterpriseController {
        public boolean validar(String user, String pass){
        EnterprisesFacade enterprisesFacade = lookupEnterprisesFacadeLocal();
        if((enterprisesFacade.find(user)!=null)&&(enterprisesFacade.find(user).getCodigo().equals(pass)))return true;
        return false;
    }
    
    public boolean registrar(String user, String pass){
        EnterprisesFacade enterpriseFacade = lookupEnterprisesFacadeLocal();
        Enterprises enterprise = new Enterprises(user," "," "," "," "," ");
        enterprise.setCodigo(pass);
        enterpriseFacade.create(enterprise);
        return true;
    }
    
    public List<String> getPerfil(String user){
        EnterprisesFacade enterpriseFacade = lookupEnterprisesFacadeLocal();
        List<String> lista = new ArrayList();
        Enterprises empresa = enterpriseFacade.find(user);
        System.out.println(user);
        lista.add(empresa.getPerfil());
        lista.add(empresa.getObjetivo());
        lista.add(empresa.getMision());
        lista.add(empresa.getVision());
        lista.add(empresa.getValores());
        return lista;
    }
    
    public void actualizar(String[] datos){
        EnterprisesFacade enterpriseFacade = lookupEnterprisesFacadeLocal();
        Enterprises ent = enterpriseFacade.find(datos[5]);
        ent.setPerfil(datos[0]);
        ent.setObjetivo(datos[1]);
        ent.setMision(datos[2]);
        ent.setVision(datos[3]);
        ent.setValores(datos[4]);
        enterpriseFacade.edit(ent);
    }
    
    public String obtenerValoracion(String empresa){
        EnterprisesFacade enterpriseFacade = lookupEnterprisesFacadeLocal();
        if(enterpriseFacade.find(empresa).getValoraciones()==null)return "Sin valoraciones";
        double valoracion = enterpriseFacade.find(empresa).getValoracion();
        double valoraciones = enterpriseFacade.find(empresa).getValoraciones();
        double cociente = valoracion/valoraciones;
        return Double.toString(cociente);
    }
    
    public void registrarValoraciones(String empresa, int valoracion){
        EnterprisesFacade enterpriseFacade = lookupEnterprisesFacadeLocal();
        int val;
        int valor;
        Enterprises emp = enterpriseFacade.find(empresa);
        if(emp.getValoraciones()==null){
            val = 0;
            valor = 0;
        }else{
            val = enterpriseFacade.find(empresa).getValoraciones();
            valor = enterpriseFacade.find(empresa).getValoracion();
        }
        val++;  
        if(valoracion==1){
            valor++;
        }
        emp.setValoracion(valor);
        emp.setValoraciones(val);
        enterpriseFacade.edit(emp);
        
    }
    
    public void corregirValoracion(String empresa, boolean valoracion){
        EnterprisesFacade enterpriseFacade = lookupEnterprisesFacadeLocal();
        Enterprises emp = enterpriseFacade.find(empresa);
        int valor = emp.getValoracion();
        if(valoracion){ 
            valor++;
        }else{
            valor--;    
        }
        emp.setValoracion(valor);
        enterpriseFacade.edit(emp);
    }
    
    public List<Enterprises> obtenerTodas(){
        EnterprisesFacade enterpriseFacade = lookupEnterprisesFacadeLocal();
        return enterpriseFacade.findAll();
    }
    
     private EnterprisesFacade lookupEnterprisesFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (EnterprisesFacade) c.lookup("java:global/TrabajoArquitectura/TrabajoArquitectura-ejb/EnterprisesFacade!controllers.EnterprisesFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
  
}
