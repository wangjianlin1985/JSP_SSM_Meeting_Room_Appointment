// 
// 
// 

package com.em.controller;

import com.em.domain.ReservationCustom;
import com.em.domain.ReservationVo;
import org.springframework.web.bind.annotation.RequestMethod;
import com.em.domain.Room;
import java.util.List;
import com.em.domain.PagingVO;
import org.springframework.ui.Model;
import com.em.service.UserService;
import com.em.service.ReservationService;
import javax.annotation.Resource;
import com.em.service.RoomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/ordinary" })
public class OrdinaryController
{
    @Resource(name = "roomServiceImpl")
    private RoomService roomService;
    @Resource(name = "reservationServiceImpl")
    private ReservationService reservationService;
    @Resource(name = "userServiceImpl")
    private UserService userService;
    
    @RequestMapping({ "/showRoom" })
    public String showRoom(final Model model, final Integer page) throws Exception {
        List<Room> list = null;
        final PagingVO pagingVO = new PagingVO();
        pagingVO.setTotalCount(this.roomService.roomCount());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = this.roomService.findByPaging(1);
        }
        else {
            pagingVO.setToPageNo(page);
            list = this.roomService.findByPaging(page);
        }
        model.addAttribute("roomList", (Object)list);
        model.addAttribute("pagingVO", (Object)pagingVO);
        return "/ordinary/showRoom";
    }
    
    @RequestMapping(value = { "/queryRoom" }, method = { RequestMethod.POST })
    private String queryRoom(final String findByName, final Model model) throws Exception {
        final List<Room> list = this.roomService.findByName(findByName);
        model.addAttribute("roomList", (Object)list);
        return "/ordinary/showRoom";
    }
    
    @RequestMapping({ "/showRecord" })
    public String findAllReservation(final Model model, final Integer page) throws Exception {
        List<ReservationVo> list = null;
        final PagingVO pagingVO = new PagingVO();
        pagingVO.setTotalCount(this.reservationService.reserveCount());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = this.reservationService.findAllByPaging(1);
        }
        else {
            pagingVO.setToPageNo(page);
            list = this.reservationService.findAllByPaging(page);
        }
        model.addAttribute("recordList", (Object)list);
        model.addAttribute("pagingVo", (Object)pagingVO);
        return "/ordinary/showRecord";
    }
    
    @RequestMapping(value = { "/queryByUser" }, method = { RequestMethod.POST })
    private String queryUser(final String findByName, final Model model) throws Exception {
        final List<ReservationVo> list = this.reservationService.queryByUser(findByName);
        model.addAttribute("recordList", (Object)list);
        return "/ordinary/showRecord";
    }
    
    @RequestMapping(value = { "/reserveRoom" }, method = { RequestMethod.GET })
    public String reserveRoomUI(final Model model) throws Exception {
        final List<Room> list = this.roomService.nameList();
        model.addAttribute("nameList", (Object)list);
        return "/ordinary/reserveRoom";
    }
    
    @RequestMapping(value = { "/reserveRoom" }, method = { RequestMethod.POST })
    public String reserveRoom(final ReservationCustom reservationCustom) throws Exception {
        this.reservationService.addReservation(reservationCustom);
        return "redirect:/ordinary/showRecord";
    }
    
    @RequestMapping(value = { "/cancelApplication" }, method = { RequestMethod.GET })
    public String cancelApplicationUI(final String user, final Model model) throws Exception {
        final List<ReservationCustom> list = this.reservationService.findByUser(user);
        model.addAttribute("reserveList", (Object)list);
        return "/ordinary/cancelApplication";
    }
    
    @RequestMapping({ "/cancelApply" })
    public String cancelApplication(final Integer id) throws Exception {
        this.reservationService.cancelApplication(id);
        return "redirect:/ordinary/showRecord";
    }
}
