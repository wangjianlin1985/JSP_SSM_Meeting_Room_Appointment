// 
// 
// 

package com.em.service.impl;

import com.em.domain.ReservationCustom;
import com.em.domain.Reservation;
import com.em.domain.PagingVO;
import com.em.domain.ReservationVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.em.dao.ReservationMapper;
import org.springframework.stereotype.Service;
import com.em.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService
{
    @Autowired
    private ReservationMapper reservationMapper;
    
    @Override
    public Integer reservationCount() {
        return this.reservationMapper.reservationCount();
    }
    
    @Override
    public List<ReservationVo> findByPaging(final Integer toPageNo) {
        final PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        final List<ReservationVo> list = this.reservationMapper.findByPaging(pagingVO);
        return list;
    }
    
    @Override
    public List<Reservation> findByName(final String name) {
        return this.reservationMapper.findByName(name);
    }
    
    @Override
    public Integer reservationPassCount() {
        return this.reservationMapper.reservationPassCount();
    }
    
    @Override
    public List<ReservationVo> findRecord(final Integer toPageNo) throws Exception {
        final PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        final List<ReservationVo> list = this.reservationMapper.findRecord(pagingVO);
        return list;
    }
    
    @Override
    public void reviewReservation(final Integer id) throws Exception {
        this.reservationMapper.reviewReservation(id);
    }
    
    @Override
    public Integer reserveCount() throws Exception {
        return this.reservationMapper.reserveCount();
    }
    
    @Override
    public List<ReservationVo> findAllByPaging(final Integer toPageNo) throws Exception {
        final PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        final List<ReservationVo> list = this.reservationMapper.findAllByPaging(pagingVO);
        return list;
    }
    
    @Override
    public void addReservation(final ReservationCustom reservationCustom) throws Exception {
        this.reservationMapper.addReservation(reservationCustom);
    }
    
    @Override
    public List<ReservationVo> queryByUser(final String name) throws Exception {
        return this.reservationMapper.queryByUser(name);
    }
    
    @Override
    public List<ReservationCustom> findByUser(final String name) throws Exception {
        return this.reservationMapper.findByUser(name);
    }
    
    @Override
    public void cancelApplication(final Integer id) throws Exception {
        this.reservationMapper.cancelApplication(id);
    }
}
