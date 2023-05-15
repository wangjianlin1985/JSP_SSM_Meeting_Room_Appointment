// 
// 
// 

package com.em.service;

import com.em.domain.Room;
import java.util.List;

public interface RoomService
{
    Integer roomCount();
    
    List<Room> findByPaging(Integer p0) throws Exception;
    
    void add(Room p0) throws Exception;
    
    Room findById(Integer p0) throws Exception;
    
    void updateById(Room p0) throws Exception;
    
    void removeById(Integer p0) throws Exception;
    
    List<Room> findByName(String p0) throws Exception;
    
    List<Room> nameList() throws Exception;
}
