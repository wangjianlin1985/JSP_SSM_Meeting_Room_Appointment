// 
// 
// 

package com.em.dao;

import com.em.domain.Room;
import java.util.List;
import com.em.domain.PagingVO;

public interface RoomMapper
{
    Integer roomCount();
    
    List<Room> findByPaging(PagingVO p0) throws Exception;
    
    void add(Room p0) throws Exception;
    
    void updateById(Room p0) throws Exception;
    
    Room findById(Integer p0) throws Exception;
    
    void removeById(Integer p0) throws Exception;
    
    List<Room> findByName(String p0) throws Exception;
    
    List<Room> nameList() throws Exception;
}
