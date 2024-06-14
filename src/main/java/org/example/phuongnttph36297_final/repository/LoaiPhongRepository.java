package org.example.phuongnttph36297_final.repository;

import org.example.phuongnttph36297_final.entity.LoaiPhong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiPhongRepository extends JpaRepository<LoaiPhong, Integer> {
    boolean existsById(int id);
}
