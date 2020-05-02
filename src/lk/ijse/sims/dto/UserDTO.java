/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dto;

/**
 *
 * @author acer
 */
public class UserDTO {

    private String user_Name;
    private String user_Email;
    private String user_Password;

    public UserDTO() {
    }

    public UserDTO(String user_Name, String user_Email, String user_Password) {
        this.user_Name = user_Name;
        this.user_Email = user_Email;
        this.user_Password = user_Password;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_Email() {
        return user_Email;
    }

    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }

    public String getUser_Password() {
        return user_Password;
    }

    public void setUser_Password(String user_Password) {
        this.user_Password = user_Password;
    }

}
