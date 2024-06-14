package org.example.phuongnttph36297_final.repository;

import org.example.phuongnttph36297_final.entity.Phong;
import org.example.phuongnttph36297_final.response.PhongResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhongRepository extends JpaRepository<Phong, Integer> {

    @Query("SELECT NEW org.example.phuongnttph36297_final.response.PhongResponse" +
            "(p.id,p.tenPhong,p.soLuongPhong,p.trangThai,p.ghiChu,lp.tenLoaiPhong) \n" +
            "FROM Phong p\n" +
            "JOIN LoaiPhong lp ON p.idLoaiPhong = lp.id")
    List<PhongResponse> getAllPhong();

    @Query("SELECT NEW org.example.phuongnttph36297_final.response.PhongResponse" +
            "(p.id,p.tenPhong, p.soLuongPhong, p.trangThai, p.ghiChu, lp.tenLoaiPhong) " +
            "FROM Phong p " +
            "JOIN LoaiPhong lp ON p.idLoaiPhong = lp.id " +
            "WHERE (:tenPhong IS NULL OR p.tenPhong LIKE %:tenPhong%) " +
            "AND (:soLuong IS NULL OR p.soLuongPhong LIKE :soLuong%)")
    List<PhongResponse> getAllPhongByTenPhong(@Param("tenPhong") String tenPhong, @Param("soLuong") String soLuong);

    @Query("SELECT NEW org.example.phuongnttph36297_final.response.PhongResponse" +
            "(p.id,p.tenPhong, p.soLuongPhong, p.trangThai, p.ghiChu, lp.tenLoaiPhong) " +
            "FROM Phong p " +
            "JOIN LoaiPhong lp ON p.idLoaiPhong = lp.id " +
            "WHERE p.id = :id")
    PhongResponse detail(@Param("id") Integer id);

}
