// 
// 
// 

package com.em.controller;

import com.em.domain.User;
import com.em.domain.Reservation;
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
@RequestMapping({ "/admin" })
public class AdminController
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
        return "/admin/showRoom";
    }
    
    @RequestMapping(value = { "/queryRoom" }, method = { RequestMethod.POST })
    private String queryRoom(final String findByName, final Model model) throws Exception {
        final List<Room> list = this.roomService.findByName(findByName);
        model.addAttribute("roomList", (Object)list);
        return "/admin/showRoom";
    }
    
    @RequestMapping(value = { "/addRoom" }, method = { RequestMethod.GET })
    public String addRoom(final Model model) throws Exception {
        return "/admin/addRoom";
    }
    
    @RequestMapping(value = { "/addRoom" }, method = { RequestMethod.POST })
    public String addRoom(final Room room, final Model model) throws Exception {
        this.roomService.add(room);
        return "redirect:/admin/showRoom";
    }
    
    @RequestMapping(value = { "/editRoom" }, method = { RequestMethod.GET })
    public String editRoomUI(final Integer id, final Model model) throws Exception {
        if (id == null) {
            return "redirect:/admin/showRoom";
        }
        final Room room = this.roomService.findById(id);
        model.addAttribute("roomList", (Object)room);
        return "/admin/editRoom";
    }
    
    @RequestMapping(value = { "/editRoom" }, method = { RequestMethod.POST })
    public String editRoom(final Room room) throws Exception {
        this.roomService.updateById(room);
        return "redirect:/admin/showRoom";
    }
    
    @RequestMapping({ "/removeRoom" })
    public String removeRoom(final Integer id) throws Exception {
        if (id == null) {
            return "/admin/showRoom";
        }
        this.roomService.removeById(id);
        return "redirect:/admin/showRoom";
    }
    
    @RequestMapping({ "/showReservation" })
    public String findAllReservation(final Model model, final Integer page) throws Exception {
        List<ReservationVo> list = null;
        final PagingVO pagingVO = new PagingVO();
        pagingVO.setTotalCount(this.reservationService.reservationCount());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = this.reservationService.findByPaging(1);
        }
        else {
            pagingVO.setToPageNo(page);
            list = this.reservationService.findByPaging(page);
        }
        model.addAttribute("reservationList", (Object)list);
        model.addAttribute("pagingVO", (Object)pagingVO);
        return "/admin/showReservation";
    }
    
    @RequestMapping(value = { "queryUser" }, method = { RequestMethod.POST })
    private String queryUser(final String findByName, final Model model) throws Exception {
        final List<Reservation> list = this.reservationService.findByName(findByName);
        model.addAttribute("reservationList", (Object)list);
        return "/admin/showReservation";
    }
    
    @RequestMapping({ "/reviewReservation" })
    public String reviewReservation(final Integer id) throws Exception {
        this.reservationService.reviewReservation(id);
        return "redirect:/admin/showReservation";
    }
    
    @RequestMapping({ "/showRecord" })
    public String findRecord(final Model model, final Integer page) throws Exception {
        List<ReservationVo> list = null;
        final PagingVO pagingVO = new PagingVO();
        pagingVO.setTotalCount(this.reservationService.reservationPassCount());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = this.reservationService.findRecord(1);
        }
        else {
            pagingVO.setToPageNo(page);
            list = this.reservationService.findRecord(page);
        }
        model.addAttribute("recordList", (Object)list);
        model.addAttribute("pagingVo", (Object)pagingVO);
        return "/admin/showRecord";
    }
    
    @RequestMapping(value = { "/userRegister" }, method = { RequestMethod.GET })
    public String userRegister(final Model model) throws Exception {
        return "/admin/userRegister";
    }
    
    @RequestMapping(value = { "/userRegister" }, method = { RequestMethod.POST })
    public String userRegister(final User user) throws Exception {
        if (user.getId() != null && user.getId() != "" && user.getPassword() != null && user.getPassword() != "") {
            this.userService.addNewUser(user);
        }
        return "redirect:/admin/userRegister";
    }
}
