// 
// 
// 

package com.em.service.impl;

import com.em.domain.PagingVO;
import com.em.domain.Room;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.em.dao.RoomMapper;
import org.springframework.stereotype.Service;
import com.em.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService
{
    @Autowired
    private RoomMapper roomMapper;
    
    @Override
    public Integer roomCount() {
        return this.roomMapper.roomCount();
    }
    
    @Override
    public List<Room> findByPaging(final Integer toPageNo) throws Exception {
        final PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        final List<Room> list = this.roomMapper.findByPaging(pagingVO);
        return list;
    }
    
    @Override
    public void add(final Room room) throws Exception {
        this.roomMapper.add(room);
    }
    
    @Override
    public Room findById(final Integer id) throws Exception {
        return this.roomMapper.findById(id);
    }
    
    @Override
    public void updateById(final Room room) throws Exception {
        this.roomMapper.updateById(room);
    }
    
    @Override
    public void removeById(final Integer id) throws Exception {
        this.roomMapper.removeById(id);
    }
    
    @Override
    public List<Room> findByName(final String name) throws Exception {
        return this.roomMapper.findByName(name);
    }
    
    @Override
    public List<Room> nameList() throws Exception {
        return this.roomMapper.nameList();
    }
}
