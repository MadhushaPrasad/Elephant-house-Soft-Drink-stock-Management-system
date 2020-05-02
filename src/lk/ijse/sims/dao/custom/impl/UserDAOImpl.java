/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dao.custom.impl;

import java.sql.SQLException;
import lk.ijse.sims.dao.CrudUtil;
import lk.ijse.sims.dao.custom.UserDAO;
import lk.ijse.sims.entity.User;

/**
 *
 * @author acer
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public boolean userRegister(User user) throws NullPointerException, ClassNotFoundException, SQLException, Exception {
        return CrudUtil.executeUpdate("INSERT INTO user VALUES(userID,?,?, PASSWORD(?))", user.getUserName(), user.getEmail(), user.getPassword());
    }
}
