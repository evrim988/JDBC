package org.example._02_JDBC_Forum.repositories;

import org.example._02_JDBC_Forum.entites.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements ICrud<User> {

    private final DatabaseHelper databaseHelper;
    private String sql;

    public UserRepository() {
        this.databaseHelper = new DatabaseHelper();
    }

    @Override
    public void save(User user) {
        sql = "INSERT INTO tbluser(ad, soyad, username, password) VALUES ('%s','%s','%s','%s')"
                .formatted(user.getAd(), user.getSoyad(), user.getUsername(), user.getPassword());

        databaseHelper.executeUpdate(sql);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> findAll() {
        sql = "SELECT * FROM tbluser ORDER BY id DESC";
        Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
        List<User> userList = new ArrayList<>();
        try{
            if (resultSet.isPresent()) {
                ResultSet rs = resultSet.get();
                while (rs.next()) {
                    userList.add(getValueFromResultSet(rs));
                }
            }
        }
        catch(SQLException e){
            System.out.println("Kullanıcıları listelerken bir hata oluştu.. "+e.getMessage());
        }
        return userList;
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.empty();
    }

    private User getValueFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String ad = rs.getString("ad");
        String soyad = rs.getString("soyad");
        String username = rs.getString("username");
        String password = rs.getString("password");
        int state=rs.getInt("state");
        long createat = rs.getLong("createat");
        long updateat = rs.getLong("updateat");
        return new User(id, ad, soyad, username, password, state, createat, updateat);
    }
}
