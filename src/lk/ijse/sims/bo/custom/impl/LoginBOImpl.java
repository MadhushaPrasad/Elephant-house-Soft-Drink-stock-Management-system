/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.bo.custom.impl;

import java.sql.SQLException;
import lk.ijse.sims.bo.custom.LoginBO;
import lk.ijse.sims.dao.DAOFactory;
import lk.ijse.sims.dao.custom.LoginDAO;
import lk.ijse.sims.dto.LoginDTO;
import lk.ijse.sims.entity.Login;

/**
 *
 * @author acer
 */
public class LoginBOImpl implements LoginBO{
    LoginDAO dao = (LoginDAO) DAOFactory.getInstance().getDAOType(DAOFactory.DAOType.LOGIN);
    @Override
    public boolean checkUser(LoginDTO login) throws SQLException, ClassNotFoundException, Exception {
        return dao.checkUser(new Login(login.getUserEmail(), login.getUserPassword()));
    }
    
}
