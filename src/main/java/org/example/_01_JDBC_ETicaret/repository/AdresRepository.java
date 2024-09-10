package org.example._01_JDBC_ETicaret.repository;

import org.example._01_JDBC_ETicaret.entity.Adres;
import org.example._01_JDBC_ETicaret.entity.Musteri;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdresRepository implements ICrud<Adres> {

    private final DatabaseHelper databaseHelper;
    private String sql;

    public AdresRepository() {
        this.databaseHelper = new DatabaseHelper();
    }

    @Override
    public void save(Adres adres) {
        sql = "INSERT INTO tbladres(musteri_id, il, ilce, mahalle, adres) VALUES('%d','%s','%s','%s','%s')"
                .formatted(adres.getMuster_id(), adres.getIl(), adres.getIlce(), adres.getMahalle(), adres.getAdres());
        databaseHelper.executeUpdate(sql);
    }

    @Override
    public void delete(int silinecekAdresid) {
        sql = "DELETE FROM tbladres WHERE musteri_id=" + silinecekAdresid;
        databaseHelper.executeUpdate(sql);
    }

    @Override
    public void update(Adres adres) {
        sql = "UPDATE tbladres SET musteri_id= %d, il= '%s', ilce= '%s', mahalle= '%s', adres= '%s' WHERE id= %d"
                .formatted(adres.getMuster_id(),adres.getIl(), adres.getIlce(), adres.getMahalle(), adres.getAdres(), adres.getId());
        databaseHelper.executeUpdate(sql);
    }

    @Override
    public List<Adres> findAll() {
        sql = "SELECT * FROM tbladres";
        Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
        List<Adres> adresList = new ArrayList<>();
        try {
            if (resultSet.isPresent()) {
                ResultSet rs = resultSet.get();
                while (rs.next()){

                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public Optional<Adres> findById(int id) {
        return Optional.empty();
    }

    //TODO: adres tablosuna göre düzeltilecek.
    private Adres getValueFromValueSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String ad = rs.getString("ad");
        String soyad = rs.getString("soyad");
        String cinsiyet = rs.getString("cinsiyet");
        String dtarih = rs.getString("dtarih");
        String email = rs.getString("email");
        String tel = rs.getString("tel");
        String sehir = rs.getString("sehir");
        Integer state = rs.getInt("state");
        Long createat = rs.getLong("createat");
        Long updateat = rs.getLong("updateat");

        return null;

    }
}
