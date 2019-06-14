
package com.demojsf.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.demojsf.impl.DaoLoginImpl;
import com.demojsf.dao.DaoLogin;
import com.demojsf.db.JdbcConnect;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

 
@ManagedBean(name = "loginBean2")
@SessionScoped
 
public class LoginJSFManagedBean implements Serializable {
     private String username;
     
    private String password;
 
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
   
    public void login(ActionEvent event) throws ClassNotFoundException {
       /* FacesMessage message = null;
        boolean loggedIn = false;
         
        if(username != null && username.equals("admin") && password != null && password.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        //PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
        
        */
        

        try {
            Connection connect = JdbcConnect.getConnect();
            PreparedStatement pst = connect.prepareStatement("Select ccorreo, clave from user where correo= ? and clave= ? ");
            pst.setString(1, username);
            pst.setString(2, password);
 
            ResultSet rs = pst.executeQuery();
            if (rs.next()) // found
            {
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Si encontro la Consulta", "Please Try Again!"));
                
                System.out.println("Todo good...");
                //System.out.println(rs.getString("user"));
                
                //return true;
            }
            else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "NO encontro la Consulta", ":C"));

                System.out.println("Nada good...");
                
                //return false;
            }
        } catch (SQLException ex) {

        }
        
    }   
   
}

