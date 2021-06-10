/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean1;

public class SignupBean {
    private String name;
    private String email;
    private String occupation;
    private String networth;
    private String location;
    private String mobile;
    private String password;
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setOccupation(String occu){
        this.occupation = occu;
    }
    
    public String getOccupation(){
        return this.occupation;
    }
    
    public void setNetWorth(String net){
        this.networth = net;
    }
    
    public String getNetWorth(){
        return this.networth;
    }
    public void setLocation(String loc){
        this.location = loc;
    }
    
    public String getLocaton(){
        return this.location;
    }
    
    public void setMobile(String mob){
        this.mobile = mob;
    }
    
    public String getMobile(){
        return this.mobile;
    }
    
    public void setPassword(String pass){
        this.password = pass;
    }
    
    public String getPassword(){
        return this.password;
    }
}
