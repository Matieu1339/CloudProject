/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudproject.backoffice.dao;

import java.util.Date;

/**
 *
 * @author samko
 */
public interface SignalementRegionDao {

    public void insertSignalementRegion(Integer IdSignalement, Integer IdRegion, Date DateAffectation);
    
}
