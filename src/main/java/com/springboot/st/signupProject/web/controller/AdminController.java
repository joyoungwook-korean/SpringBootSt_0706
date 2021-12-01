package com.springboot.st.signupProject.web.controller;

import com.springboot.st.domain.user.User;
import com.springboot.st.domain.user.UserRepository;
import com.springboot.st.hotelProject.domain.Hotel_Room;
import com.springboot.st.hotelProject.domain.Hotel_Room_Img;
import com.springboot.st.hotelProject.domain.Hotel_Room_ImgRepository;
import com.springboot.st.hotelProject.domain.dto.Hotel_RoomDto;
import com.springboot.st.hotelProject.service.HotelRoomService;
import com.springboot.st.signupProject.service.AdminService;
import com.springboot.st.signupProject.service.Room_Img_S3DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final HotelRoomService hotelRoomService;
    private final Room_Img_S3DBService room_img_s3DBService;

    @GetMapping("/admin/hotel_crud")
    public String hotel_crud(Model model) {
        List<Hotel_Room> hotel_rooms = hotelRoomService.all_find();
        model.addAttribute("hotelroom", hotel_rooms);
        model.addAttribute("hotelroomCount", hotel_rooms.size());
        model.addAttribute("hotelroomDto", new Hotel_RoomDto());
        return "admin/hotel_crud";
    }

    @PostMapping("/admin/hotel_crud")
    public String hotel_crud(@Valid @ModelAttribute("hotelroomDto") Hotel_RoomDto hotel_roomDto, BindingResult bindingResult, Model model, @RequestParam("hotel_img") List<MultipartFile> multipartFile) {
        if (bindingResult.hasErrors()) {
            List<Hotel_Room> hotel_rooms = hotelRoomService.all_find();
            model.addAttribute("hotelroom", hotel_rooms);
            model.addAttribute("hotelroomCount", hotel_rooms.size());
            return "admin/hotel_crud";
        }
       hotelRoomService.save(hotel_roomDto,multipartFile);

        return "redirect:/admin/hotel_crud";
    }


    @PostMapping("/admin/hotel_crud/set")
    public @ResponseBody
    Hotel_Room set_Room(@RequestBody Map new_id) {
        Hotel_Room hotel_room = hotelRoomService.find_By_Idx(new_id.get("new_id").toString());
        return hotel_room;
    }

    @GetMapping("/admin")
    public String admin_index(Model model) {
        List<User> findAllUser = adminService.findAllUser();
        model.addAttribute("userDto", findAllUser);
        model.addAttribute("userCount", findAllUser.size());
        return "admin/index";
    }

    @PostMapping("/admin")
    public @ResponseBody
    List<User> post_index(@RequestBody String find_id, Model model) {
        if (find_id == null) {
            System.out.println("null");
            return null;
        } else if (find_id.equals("")) {

            System.out.println("equals null");
            return null;
        } else {
            List<User> find_user_e = adminService.find_user_ajax(find_id);
            model.addAttribute("userDto", find_user_e);
            return find_user_e;
        }
    }

    // Delete
    @PostMapping("/admin/hotel_crud/delete")
    public String delete_Hotel_Room(Hotel_RoomDto hotel_roomDto) {
        hotelRoomService.delete_Room(hotel_roomDto);
        return "redirect:/admin/hotel_crud";
    }

    //update
    @PostMapping("/admin/hotel_crud/update")
    public String update_Hotel_Room(@RequestPart(value = "key") Map hotel_room, @RequestPart(value = "file[]") List<MultipartFile> multipartFile) throws IOException {

        Hotel_RoomDto hotel_roomDto = new Hotel_RoomDto();
        hotel_roomDto.setId((String) hotel_room.get("idx"));
        hotel_roomDto.setMaxpeople(Integer.valueOf((String) hotel_room.get("max")));
        hotel_roomDto.setMinpeople(Integer.valueOf((String) hotel_room.get("min")));
        hotel_roomDto.setPrice(Integer.valueOf((String)hotel_room.get("price")));
        hotel_roomDto.setContent((String) hotel_room.get("content"));
        hotel_roomDto.setRoomname((String) hotel_room.get("roomname"));
        hotel_roomDto.setRoomcount(Integer.valueOf((String)hotel_room.get("roomcount")));

        hotelRoomService.update_Room(hotel_roomDto,multipartFile);

        return "redirect:/admin/hotel_crud";
    }

    @GetMapping("/s3test")
    public String s3test(){
        return "s3test";
    }

    @PostMapping("/s3test")
    public String s3testpost(@RequestParam("file2") List<MultipartFile> multipartFiles) throws IOException {
        room_img_s3DBService.saveImg_S3(multipartFiles);
        return "redirect:/s3test";
    }

}
