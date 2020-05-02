/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sims.bo.custom.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.sims.bo.custom.VolumeBO;
import lk.ijse.sims.dao.DAOFactory;
import lk.ijse.sims.dao.custom.VolumeDAO;
import lk.ijse.sims.dto.VolumeDTO;
import lk.ijse.sims.entity.Volume;

/**
 *
 * @author acer
 */
public class VolumeBOImpl implements VolumeBO{
    VolumeDAO dao =(VolumeDAO) DAOFactory.getInstance().getDAOType(DAOFactory.DAOType.VOLUME);
    @Override
    public boolean addVolume(VolumeDTO volume) throws SQLException, ClassNotFoundException, Exception {
        return dao.add(new Volume(volume.getVolume_ID(), volume.getVolume_size(), volume.getVolume_qty(), volume.getPrice()));
    }

    @Override
    public boolean deleteVolume(String id) throws ClassNotFoundException, SQLException, Exception {
        return dao.delete(id);
    }

    @Override
    public boolean updateVolume(VolumeDTO volume) throws SQLException, ClassNotFoundException, Exception {
        return dao.update(new Volume(volume.getVolume_ID(),volume.getVolume_size(),volume.getVolume_qty(),volume.getPrice()));
    }

    @Override
    public VolumeDTO searchVolume(String id) throws ClassNotFoundException, SQLException, Exception {
         Volume volume = dao.search(id);
        return new VolumeDTO(volume.getvID(), volume.getSize(), volume.getQTY(), volume.getPrice());
    }

    @Override
    public ArrayList<VolumeDTO> getAllVolume() throws ClassNotFoundException, SQLException, Exception {
         ArrayList<VolumeDTO> getAllVolume = new ArrayList<>();
            ArrayList<Volume> all = dao.getAll();
            for (Volume volume : all) {
            getAllVolume.add(new VolumeDTO(volume.getvID(), volume.getSize(), volume.getQTY(), volume.getPrice()));
        }
            return getAllVolume;
    }
    
}
