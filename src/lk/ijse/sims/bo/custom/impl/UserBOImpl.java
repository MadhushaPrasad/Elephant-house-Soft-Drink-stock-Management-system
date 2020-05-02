/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.bo.custom.impl;

import java.sql.SQLException;
import lk.ijse.sims.bo.custom.UserBO;
import lk.ijse.sims.dao.DAOFactory;
import lk.ijse.sims.dao.custom.UserDAO;
import lk.ijse.sims.dto.UserDTO;
import lk.ijse.sims.entity.User;

/**
 *
 * @author acer
 */
public class UserBOImpl implements UserBO {

    UserDAO dao = (UserDAO) DAOFactory.getInstance().getDAOType(DAOFactory.DAOType.USER);

    @Override
    public boolean userRegister(UserDTO user) throws NullPointerException, ClassNotFoundException, SQLException, Exception {
        System.out.println(user.getUser_Name());
        System.out.println(user.getUser_Email());
        System.out.println(user.getUser_Password());
        return dao.userRegister(new User(user.getUser_Name(), user.getUser_Email(), user.getUser_Password()));
    }

}
