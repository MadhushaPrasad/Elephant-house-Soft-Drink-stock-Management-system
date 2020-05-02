/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.bo.custom;

import java.sql.SQLException;
import lk.ijse.sims.bo.SuperBO;
import lk.ijse.sims.dto.UserDTO;

/**
 *
 * @author acer
 */
public interface UserBO extends SuperBO{
    public boolean userRegister(UserDTO user)throws NullPointerException,ClassNotFoundException,SQLException,Exception;
}
