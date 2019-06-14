
package com.demojsf.impl;

import com.demojsf.dao.DaoLogin;
import com.demojsf.db.JdbcConnect;
import com.demojsf.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class DaoLoginImpl implements DaoLogin {

    @Override
   public boolean login(String user, String password) {

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JdbcConnect.getConnect();
            ps = con.prepareStatement(
                    "select correo, clave from user where correo= ? and clave= ? ");
            ps.setString(1, user);
            ps.setString(2, password);
 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Si encontro la Consulta", "Please Try Again!"));
                
                System.out.println("Todo good...");
                //System.out.println(rs.getString("user"));
                
                return true;
            }
            else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "NO encontro la Consulta", ":C"));
                
                addMessage("System Error", "Please try again later.");
                System.out.println("Nada good...");
                
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return false;
        } finally {
            
        }
    }
   
   public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
