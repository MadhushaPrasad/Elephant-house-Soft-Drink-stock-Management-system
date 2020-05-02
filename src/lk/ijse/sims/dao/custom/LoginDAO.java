/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dao.custom;

import java.sql.SQLException;
import lk.ijse.sims.dao.SuperDAO;
import lk.ijse.sims.entity.Login;


/**
 *
 * @author acer
 */
public interface LoginDAO extends SuperDAO{
    public boolean checkUser(Login login) throws SQLException, ClassNotFoundException, Exception;
}
