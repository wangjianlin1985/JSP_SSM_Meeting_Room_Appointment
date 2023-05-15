// 
// 
// 

package com.em.dao;

import com.em.domain.ReservationCustom;
import com.em.domain.Reservation;
import com.em.domain.ReservationVo;
import java.util.List;
import com.em.domain.PagingVO;

public interface ReservationMapper
{
    Integer reservationCount();
    
    List<ReservationVo> findByPaging(PagingVO p0);
    
    List<Reservation> findByName(String p0);
    
    Integer reservationPassCount();
    
    List<ReservationVo> findRecord(PagingVO p0);
    
    void reviewReservation(Integer p0);
    
    Integer reserveCount();
    
    List<ReservationVo> findAllByPaging(PagingVO p0);
    
    void addReservation(ReservationCustom p0);
    
    List<ReservationVo> queryByUser(String p0);
    
    List<ReservationCustom> findByUser(String p0);
    
    void cancelApplication(Integer p0);
}
