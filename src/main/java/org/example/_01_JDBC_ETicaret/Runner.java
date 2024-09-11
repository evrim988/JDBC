package org.example._01_JDBC_ETicaret;

import java.sql.*;


/**
 * executeUpdate metodu ile INSERT,UPDATE,DELETE komutlarını çalıştırırız. Geriye int olarak etkilenen satır sayısını döner.
 * executeQuery metodu ile SELECT komutu çalıştırılır. Geriye ResultSet döner.
 * execute metodu ile tüm komutlar çalıştırılır. (Kullanılmıyor)
 */

public class Runner {
    public static void main(String[] args) throws SQLException {

        /*adresEkle(3, "İzmir", "Bornova");
        adresEkle(4, "Bolu", "Mengen");
        adresEkle(5, "Sakarya", "Sapanca");*/

        /*adresEklePrepared(6,"Ankara","Mamak");
        adresEklePrepared(7,"Antalya","Manavgat");
        adresEklePrepared(8,"Isparta","Eğirdir");*/

        /*adresSil(1010);
        adresSil(1011);
        adresSil(1012);
        adresSil(1013);
        adresSil(1014);
        adresSil(1015);*/

        //adresGuncelle(1009,"Muğla","Marmaris");

        adresListele("Londra");

    }

    private static void adresListele(String ilArg) {
        String ADRES_SELCT_SQL = "SELECT * FROM tbladres WHERE il ILIKE ?";
        String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret?user=postgres&password=root";

        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(ADRES_SELCT_SQL)) {

            preparedStatement.setString(1, "%" + ilArg + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println("Müşteri ID: " + resultSet.getInt("musteri_id") +
                        ", İl: " + resultSet.getString("il") +
                        ", İlçe: " + resultSet.getString("ilce"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void adresGuncelle(int id, String yeniIl, String yeniIlce) {
        String ADRES_UPDATE_SQL = "UPDATE tbladres SET  il=?, ilce=? WHERE id=?";
        String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret";
        String username = "postgres";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(ADRES_UPDATE_SQL)) {

            preparedStatement.setString(1, yeniIl); //buradaki 1 ifadesi SQL cümlesindeki ? işaretinin sırasıdır.
            preparedStatement.setString(2, yeniIlce);
            preparedStatement.setInt(3, id);

            int etkilenenSatirSayisi = preparedStatement.executeUpdate();

            if (etkilenenSatirSayisi > 0) {
                System.out.println("kayıt başarı ile güncellendi.");
            } else {
                System.out.println("Güncellemede sorun yaşandı.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void adresSil(int idArg) {
        String ADRES_DELETE_SQL = "DELETE FROM tbladres WHERE id=?";
        String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret";
        String username = "postgres";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(ADRES_DELETE_SQL)) {

            preparedStatement.setInt(1, idArg);

            int etkilenenSatirSayisi = preparedStatement.executeUpdate();

            if (etkilenenSatirSayisi > 0) {
                System.out.println(etkilenenSatirSayisi + " adet kayıt başarı ile silindi.");
            } else {
                System.out.println("Kayıt Silme Sırasında Bir Sorun Oluştu");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void adresEkle(int musteri_id, String il, String ilce) throws SQLException {
        String ADRES_INSERT_SQL = "INSERT INTO tbladres(musteri_id, il, ilce) VALUES (" + musteri_id + ", '" + il + "', '" + ilce + "')";

        String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret";
        String username = "postgres";
        String password = "root";

        Connection connection = DriverManager.getConnection(connectionString, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(ADRES_INSERT_SQL);
        int etkilenenSatirSayisi = preparedStatement.executeUpdate();

        if (etkilenenSatirSayisi > 0) {
            System.out.println("Kayıt Başarı ile Eklendi.");
        } else {
            System.out.println("Kaydetme Sırasında Bir Sorun Oluştu");
        }
        connection.close();
    }

    private static void adresEklePrepared(int musteri_id, String il, String ilce) throws SQLException {
        String ADRES_INSERT_SQL = "INSERT INTO tbladres(musteri_id, il, ilce) VALUES (?,?,?)";

        String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret";
        String username = "postgres";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(ADRES_INSERT_SQL)) {


            preparedStatement.setInt(1, musteri_id); //values'in içerisine soru işareti olan yere index değerine göre ekleme yaptık.
            preparedStatement.setString(2, il);
            preparedStatement.setString(3, ilce);

            int etkilenenSatirSayisi = preparedStatement.executeUpdate();

            if (etkilenenSatirSayisi > 0) {
                System.out.println("Kayıt Başarı ile Eklendi.");
            } else {
                System.out.println("Kaydetme Sırasında Bir Sorun Oluştu");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
