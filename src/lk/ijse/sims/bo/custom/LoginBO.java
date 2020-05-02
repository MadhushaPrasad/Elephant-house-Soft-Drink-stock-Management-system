/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.bo.custom;

import java.sql.SQLException;
import lk.ijse.sims.bo.SuperBO;
import lk.ijse.sims.dto.LoginDTO;

/**
 *
 * @author acer
 */
public interface LoginBO extends SuperBO{
    public boolean checkUser(LoginDTO login) throws SQLException, ClassNotFoundException, Exception;
}
