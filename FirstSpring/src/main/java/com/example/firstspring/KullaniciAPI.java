package com.example.firstspring;


import com.example.firstspring.repository.KullaniciRepository;
import com.example.firstspring.entity.Kullanici;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/kullanici2")
public class KullaniciAPI {
    @Autowired
    private KullaniciRepository kullaniciRepository;


    @PostConstruct
    public void init(){
        Kullanici kullanici= new Kullanici();
        Scanner scanner= new Scanner(System.in);
        System.out.println("Kullanici id bilgisi:");
        kullanici.setId(scanner.next());
        System.out.println("Kullanici adı:");
        kullanici.setAd(scanner.next());
        System.out.println("Kullanici soyadı:");
        kullanici.setSoyad(scanner.next());
        kullaniciRepository.save(kullanici);

    }
    @PostMapping
    public ResponseEntity<Kullanici> ekle(@RequestBody Kullanici kullanici){
        return ResponseEntity.ok(kullaniciRepository.save(kullanici)) ;
    }
    @GetMapping
    public ResponseEntity<List<Kullanici>> listele(){
        return ResponseEntity.ok(kullaniciRepository.findAll()) ;
    }


}
