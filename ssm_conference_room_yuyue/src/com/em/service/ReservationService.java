// 
// 
// 

package com.em.service;

import com.em.domain.ReservationCustom;
import com.em.domain.Reservation;
import com.em.domain.ReservationVo;
import java.util.List;

public interface ReservationService
{
    Integer reservationCount() throws Exception;
    
    List<ReservationVo> findByPaging(Integer p0) throws Exception;
    
    List<Reservation> findByName(String p0);
    
    Integer reservationPassCount();
    
    List<ReservationVo> findRecord(Integer p0) throws Exception;
    
    void reviewReservation(Integer p0) throws Exception;
    
    Integer reserveCount() throws Exception;
    
    List<ReservationVo> findAllByPaging(Integer p0) throws Exception;
    
    void addReservation(ReservationCustom p0) throws Exception;
    
    List<ReservationVo> queryByUser(String p0) throws Exception;
    
    List<ReservationCustom> findByUser(String p0) throws Exception;
    
    void cancelApplication(Integer p0) throws Exception;
}
