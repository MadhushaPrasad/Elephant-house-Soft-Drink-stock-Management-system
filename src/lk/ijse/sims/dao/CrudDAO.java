/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dao;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author acer
 */
public interface CrudDAO<T,ID> extends SuperDAO{
    public boolean add(T t)throws ClassNotFoundException,SQLException;
    public boolean update(T t)throws ClassNotFoundException,SQLException;
    public boolean delete(ID id)throws ClassNotFoundException,SQLException;
    public T search(ID id)throws ClassNotFoundException,SQLException;
    public ArrayList <T> getAll()throws ClassNotFoundException,SQLException;
}
