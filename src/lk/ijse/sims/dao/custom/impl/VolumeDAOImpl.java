/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.sims.dao.CrudUtil;
import lk.ijse.sims.dao.custom.VolumeDAO;
import lk.ijse.sims.entity.Volume;

/**
 *
 * @author acer
 */
public class VolumeDAOImpl implements VolumeDAO {

    @Override
    public boolean add(Volume v) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("INSERT INTO volume VALUES(?,?,?,?)", v.getvID(), v.getSize(), v.getQTY(), v.getPrice());
    }

    @Override
    public boolean update(Volume v) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("UPDATE volume SET Size=?,QTY=?,price=? WHERE vID=? ", v.getSize(), v.getQTY(), v.getPrice(), v.getvID());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("DELETE FROM volume WHERE vID=?", id);
    }

    @Override
    public Volume search(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM volume WHERE vID=?", id);
        Volume vID = null;
        while (rst.next()) {
            vID = new Volume();
            vID.setvID(rst.getString(1));
            vID.setSize(rst.getString(2));
            vID.setQTY(rst.getInt(4));
            vID.setPrice(rst.getDouble(4));
        }
        return vID;
    }

    @Override
    public ArrayList<Volume> getAll() throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Volume");
        ArrayList<Volume> getAll = new ArrayList<>();
        while(rst.next()){
            Volume temp = new Volume(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4));
            getAll.add(temp);
        }
        return getAll;
    }

}
