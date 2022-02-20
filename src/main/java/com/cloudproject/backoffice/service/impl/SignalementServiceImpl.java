package com.cloudproject.backoffice.service.impl;

import com.cloudproject.backoffice.dao.SignalementDao;
import com.cloudproject.backoffice.model.Signalement;
import com.cloudproject.backoffice.service.SignalementService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignalementServiceImpl implements SignalementService {
    private SignalementDao signalementDao;

    @Autowired
    public void setSignalementDao(SignalementDao signalementDao) {
        this.signalementDao = signalementDao;
    }

    @Override
    public List getAllSign()
    {
        return signalementDao.getAllSign();
    }

    @Override
    public List getNonAssigner()
    {
        return signalementDao.getNonAssigner();
    }

    @Override
    public Signalement getSign(int id)
    {
        return signalementDao.getSign(id);
    }

    @Override
    public List getSignRegion(int Id)
    {
        return signalementDao.getSignRegion(Id);
    }

    @Override
    public List getSignUser(int IdUser){ return signalementDao.getSignUser(IdUser);}

    @Override
    public void updateSignalement(int IdSignalement, Integer IdUtilisateur, int IdType, int IdStatus, String DescriptionSignalement, float Longitude, float Latitude, Date DateHeureSignalement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
