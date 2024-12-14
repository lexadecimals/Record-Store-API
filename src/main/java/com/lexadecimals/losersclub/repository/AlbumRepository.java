package com.lexadecimals.losersclub.repository;

import com.lexadecimals.losersclub.model.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
}
