/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.bo.custom;


import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.sims.bo.SuperBO;
import lk.ijse.sims.dto.VolumeDTO;

/**
 *
 * @author dell
 */
public interface VolumeBO extends SuperBO{
    public boolean addVolume(VolumeDTO volume) throws SQLException, ClassNotFoundException, Exception;

    public boolean deleteVolume(String id) throws ClassNotFoundException, SQLException, Exception;

    public boolean updateVolume(VolumeDTO volume) throws SQLException, ClassNotFoundException, Exception;

    public VolumeDTO searchVolume(String id) throws ClassNotFoundException, SQLException, Exception;

    public ArrayList<VolumeDTO> getAllVolume() throws ClassNotFoundException, SQLException, Exception;
    
}
