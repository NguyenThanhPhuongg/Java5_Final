package org.example.phuongnttph36297_final.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhongResponse {
    private Integer id;
    private String tenPhong;
    private String soLuongPhong;
    private String trangThai;
    private String ghiChu;
    private String tenLoaiPhong;
}
