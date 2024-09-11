package org.example._02_JDBC_Forum;

import org.example._02_JDBC_Forum.controller.UserController;
import org.example._02_JDBC_Forum.entites.User;
import org.example._02_JDBC_Forum.repositories.DatabaseHelper;
import org.example._02_JDBC_Forum.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);


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
            sc.nextLine();
            menuOptions(userInput);

        } while (userInput != 0);
    }

    private static void menuOptions(int userInput) {
        UserController userController = new UserController();
        switch (userInput) {
            case 1: {
                userController.registerUser();
                break;
            }
            case 2: {
                userController.girisYap();
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


}
