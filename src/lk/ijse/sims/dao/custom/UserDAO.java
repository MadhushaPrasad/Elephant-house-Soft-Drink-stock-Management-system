/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dao.custom;

import java.sql.SQLException;
import lk.ijse.sims.dao.SuperDAO;
import lk.ijse.sims.entity.User;

/**
 *
 * @author acer
 */
public interface UserDAO extends SuperDAO{
    public boolean userRegister(User user)throws NullPointerException,ClassNotFoundException,SQLException,Exception;
}
