
package com.demojsf.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

 
import com.demojsf.impl.DaoLoginImpl;
import com.demojsf.dao.DaoLogin;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
 
@ManagedBean(name = "loginBean")
@SessionScoped
 
public class LoginBean implements Serializable {
    
    private DaoLogin dao = new DaoLoginImpl();
 
    private static final long serialVersionUID = 1L;
    private String uname;
    private String password;
 
     
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUname() {
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }
 
    public String loginProject() {
        
        System.out.println("Ejecutando Bean");
        System.out.println("Ejecutando Bean..");
        System.out.println("Ejecutando Bean....");
        System.out.println("Ejecutando Bean......");
            
        FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
        
        boolean result = dao.login(uname, password);
        if (result) {
            return "dashboard";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
            return "login";
        }
    }
}