package com.woosik.sideproject.repository;

import com.woosik.sideproject.domain.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {

}
