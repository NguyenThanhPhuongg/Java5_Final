package org.example.phuongnttph36297_final.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "phong")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Phong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_loai_phong")
    private Integer idLoaiPhong;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @Column(name = "so_luong_phong")
    private String soLuongPhong;

    @Column(name = "ten_phong")
    private String tenPhong;

    @Column(name = "trang_thai")
    private String trangThai;

}
