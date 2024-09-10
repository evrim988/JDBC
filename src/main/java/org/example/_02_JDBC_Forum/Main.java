package org.example._02_JDBC_Forum;

import org.example._02_JDBC_Forum.entites.User;
import org.example._02_JDBC_Forum.repositories.UserRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static UserRepository userRepository = new UserRepository();

    public static void main(String[] args) {
        menu();
      // userRepository.findAll().forEach(System.out::println);
    }

    private static void menu() {
        int userInput = -1;
        do {
            System.out.println("**** Foruma Hosgeldiniz ****");
            System.out.println("1- Kayıt Ol");
            System.out.println("2- Giriş Yap");
            System.out.println("0- Çıkış Yap");
            System.out.print("Seçiminiz: ");
            userInput = sc.nextInt();
            menuOptions(userInput);

        } while (userInput != 0);
    }

    private static void menuOptions(int userInput) {

        switch (userInput) {
            case 1: {
                kayitOl();
                break;
            }
            case 2: {
                //girisYap();
                break;
            }
            case 0: {
                System.out.println("Çıkış yapılıyor");
                break;
            }
            default: {
                System.out.println("Geçerli bir seçim yapiniz !!!");
                break;
            }
        }


    }

    private static void kayitOl() {
        System.out.println("***** Kullanici Kayit Formu *****");
        System.out.print("Adınız: ");
        String ad = sc.next();
        System.out.print("Soyadiniz: ");
        String soyad = sc.next();
        String username = getUsername();
        System.out.print("Password giriniz: ");
        String password = sc.next();
        User user = new User(ad, soyad, username, password);
        userRepository.save(user);
    }

    private static String getUsername() {
        String username;
        while (true) {
            System.out.print("Username giriniz: ");
            username = sc.next();
            if (existByUserName(username)) {
                return username;
            } else {
                System.out.println("Bu kullanıcı adı daha önce alınmış, farklı bir kullanıcı adı giriniz.");
            }
        }
    }

    private static boolean existByUserName(String username) {
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return false;
            }
        }
        return true;
    }
}
