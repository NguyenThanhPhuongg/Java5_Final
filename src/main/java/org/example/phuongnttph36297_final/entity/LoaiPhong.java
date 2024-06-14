package org.example.phuongnttph36297_final.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "loai_phong")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class LoaiPhong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten_loai_phong")
    private String tenLoaiPhong;


}
