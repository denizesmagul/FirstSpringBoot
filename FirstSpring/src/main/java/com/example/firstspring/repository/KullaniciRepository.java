package com.example.firstspring.repository;

import com.example.firstspring.entity.Kullanici;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KullaniciRepository extends MongoRepository<Kullanici,String>  {

}
