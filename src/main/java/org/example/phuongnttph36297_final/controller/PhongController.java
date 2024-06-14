package org.example.phuongnttph36297_final.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.phuongnttph36297_final.entity.LoaiPhong;
import org.example.phuongnttph36297_final.entity.Phong;
import org.example.phuongnttph36297_final.repository.LoaiPhongRepository;
import org.example.phuongnttph36297_final.repository.PhongRepository;
import org.example.phuongnttph36297_final.request.PhongRequest;
import org.example.phuongnttph36297_final.response.PhongResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/dich-vu")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Controller
public class PhongController {

    PhongRepository phongRepository;
    LoaiPhongRepository loaiPhongRepository;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<PhongResponse> listPhong = phongRepository.getAllPhong();
        model.addAttribute("listPhong", listPhong);
        List<LoaiPhong> listLoaiPhong = loaiPhongRepository.findAll();
        model.addAttribute("listLoaiPhong", listLoaiPhong);
        return "hienthi";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute PhongRequest phongRequest , BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error", getError(bindingResult));
            List<PhongResponse> listPhong = phongRepository.getAllPhong();
            model.addAttribute("listPhong", listPhong);
            List<LoaiPhong> listLoaiPhong = loaiPhongRepository.findAll();
            model.addAttribute("listLoaiPhong", listLoaiPhong);
            return "hienthi";
        }
            Phong phong = new Phong();
            phong.setTenPhong(phongRequest.getTenPhong());
            phong.setSoLuongPhong(phongRequest.getSoLuongPhong());
            phong.setTrangThai(phongRequest.getTrangThai());
            phong.setGhiChu(phongRequest.getGhiChu());
            phong.setIdLoaiPhong(phongRequest.getIdLoaiPhong());
            phongRepository.save(phong);
        return "redirect:/dich-vu/hien-thi";
    }

    public static Map<String, String> getError(BindingResult bindingResult){
        Map<String, String> error = new HashMap<>();
        for(FieldError fieldError : bindingResult.getFieldErrors()){
            error.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return error;
    }

    @GetMapping("/tim-kiem")
    public String timKiem(Model model, HttpSession session, @RequestParam(required = false) String tenPhong, @RequestParam (required = false) String soLuong){
        session.setAttribute("tenPhong", tenPhong);
        session.setAttribute("soLuong", soLuong);
        List<LoaiPhong> listLoaiPhong = loaiPhongRepository.findAll();
        model.addAttribute("listLoaiPhong", listLoaiPhong);
        model.addAttribute("listPhong" , phongRepository.getAllPhongByTenPhong(tenPhong ,soLuong));
        return "hienthi";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, PhongResponse response, Model model){
        PhongResponse phongResponse = phongRepository.detail(id);
        model.addAttribute("detail" , phongResponse);
        List<PhongResponse> listPhong = phongRepository.getAllPhong();
        model.addAttribute("listPhong", listPhong);
        List<LoaiPhong> listLoaiPhong = loaiPhongRepository.findAll();
        model.addAttribute("listLoaiPhong", listLoaiPhong);
        return "hienthi";
    }

}
