package org.example._00_JDBC_Baslangic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Veritabanı Driver:
 * Bir programlama dili ile bir veritabanı arasında iletiim kurmayı sağlayan yazılım veya bileşendir.
 * Vt Driver:
 * Vt sunucusuna bağlantı kurabiliriz.
 * Veritabanına komut gönderebiliriz.
 * Sorgular yazabiliriz.
 * Geri dönen değerleri alabiliriz.
 * gibi işlemler yapabiliriz.
 *
 * Her bir veritabanı üreticisi farklı programlama dilleri için driverlar üretirler.
 *
 * PostgreSQL Java Driver'ını indirmemiz gerekli.
 * Bunun için mvnrepostitory sitesini görelim.
 * postgresql java driver diye arattık. postgresql JDBC driver geldi.
 * Karşımıza çıkan en son sürümn bağımlılık cümlesini Gradle(Short) alanından kopyaladık.
 * Projemizdeki buil.gradle dosyasını açtık.
 * Bu dosya içindeki dependcies bloğu için kopyaladığımız bağımlılık cümlesini ekledik.
 * dependencies {
 *     implementation 'org.postgresql:postgresql:42.7.4'
 * }
 *
 */

public class Main {
    public static void main(String[] args) throws SQLException {

        //javadan postgresql'e geçip bağlantı kurmka için gerekli olanlar:
        //hostname: localhost
        //port: 5432
        //username: postgres
        //password: root
        //database: Java15ETicaret

        //Connection String - Bağlantı Cümlesi oluşturma
        String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret";
        String username = "postgres";
        String password = "root";

        //Parametrelerle Connection nesnesi yaratmak için DriverManager sınıfının getConnection metodunu kullandık.
        Connection connection = DriverManager.getConnection(connectionString, username, password);
        //String bir ifade içinde basit bir sql komutu yazalım.
        String sqlkomut = "INSERT INTO tbladres(musteri_id, il, ilce)VALUES (1, 'Londra', 'Soho')";


        //String bir sorgu direkt olarak connection nesnesi aracılığıyla çalıştırılamaz.
        //Bunun için öncelikle komutun hazırlanmması gerekir.

        PreparedStatement preparedStatement = connection.prepareStatement(sqlkomut);

        //Bu işlem sonucunda artık SQL ifadesi çalıştırılabilir hale gelmiştir.
        preparedStatement.executeUpdate(); //bu adım sorgumuzun vt server'ında çalıştırılmasını sağlar.
        connection.close(); //connection işlemleri bittikten sonra kapatılmalıdır.
    }
}