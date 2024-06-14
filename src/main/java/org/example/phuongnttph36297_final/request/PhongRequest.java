package org.example.phuongnttph36297_final.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhongRequest {
    @NotBlank(message = "ten phong khong duoc de trong")
    private String tenPhong;
    @NotBlank(message = "so luong phong khong duoc de trong")
    private String soLuongPhong;
    @NotBlank(message = "trang thai khong duoc de trong")
    private String trangThai;
    @NotBlank(message = "ghi chu khong duoc de trong")
    private String ghiChu;
    private Integer idLoaiPhong;
}

