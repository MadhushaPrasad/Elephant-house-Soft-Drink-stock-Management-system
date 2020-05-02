/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import lk.ijse.sims.dao.CrudUtil;
import lk.ijse.sims.dao.custom.LoginDAO;
import lk.ijse.sims.entity.Login;

/**
 *
 * @author acer
 */
public class LoginDAOImpl implements LoginDAO {

    boolean b;

    @Override
    public boolean checkUser(Login login) throws SQLException, ClassNotFoundException, Exception {
        System.out.println(login.getEmail());
        System.out.println(login.getPassword());
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM user WHERE password=PASSWORD(?) && email=?", login.getPassword(), login.getEmail());
        if (rst.next()) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }

}
