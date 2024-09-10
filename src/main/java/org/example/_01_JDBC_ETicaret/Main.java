package org.example._01_JDBC_ETicaret;

import org.example._01_JDBC_ETicaret.entity.Adres;
import org.example._01_JDBC_ETicaret.entity.Musteri;
import org.example._01_JDBC_ETicaret.repository.DatabaseHelper;
import org.example._01_JDBC_ETicaret.repository.MusteriRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        MusteriRepository musteriRepository = new MusteriRepository();

       /* Musteri m1 = new Musteri("Selim","Sarı","E", LocalDate.of(2000,5,15),"selimsari@gmail.com","Istanbul","5553332266");
        musteriRepository.save(m1);*/

        //musteriRepository.delete(1001);

       // musteriRepository.findAll().forEach(System.out::println);

       // musteriRepository.findById(1000).ifPresentOrElse(System.out::println,() -> System.out.println("Aradığınız müşteri bulunamadı"));

        //1002 id'li müşteirnin soyadını değiştirelim.
        /*Optional<Musteri> guncellenecekMusteri = musteriRepository.findById(1002);
        if (guncellenecekMusteri.isPresent()) {
            guncellenecekMusteri.get().setSoyad("YeniSarı");
            musteriRepository.update(guncellenecekMusteri.get());
        }
        else {
            System.out.println("Güncellenecek müşteri bulunamadı.");
        }

        musteriRepository.findById(1002).ifPresent(System.out::println);*/

        /*List<Musteri> all = musteriRepository.findAll();
        for (Musteri m : all) {
            if(m.getAd().equalsIgnoreCase(username))
        }*/
    }
}
