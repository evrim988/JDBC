package org.example._02_JDBC_Forum.repositories;

import org.example._01_JDBC_ETicaret.repository.DatabaseHelper;
import org.example._02_JDBC_Forum.entites.Post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostRepository implements ICrud<Post> {

    private final DatabaseHelper databaseHelper;
    private String sql;

    public PostRepository() {
        this.databaseHelper = new DatabaseHelper();
    }

    @Override
    public void save(Post post) {
        sql = "INSERT INTO tblpost(user_id, baslik, icerik) VALUES( %d, '%s', '%s')"
                .formatted(post.getUser_id(), post.getBaslik(), post.getIcerik());
        databaseHelper.executeUpdate(sql);
    }

    @Override
    public void delete(int silinecekPostId) {
        sql = "DELETE FROM tblpost WHERE id= " + silinecekPostId;
        databaseHelper.executeUpdate(sql);
    }

    @Override
    public void update(Post post) { //user_id ye göre güncelleme olabilir mi?
        sql = "UPDATE tblpost SET baslik = '%s', icerik = '%s' WHERE id= %d"
        .formatted(post.getBaslik(), post.getIcerik(), post.getId());
        databaseHelper.executeUpdate(sql);
    }

    @Override
    public List<Post> findAll() {
        sql = "SELECT * FROM tblpost ORDER BY id";
        Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
        List<Post> postList = new ArrayList<>();
        try {
            if (resultSet.isPresent()) {
                ResultSet rs = resultSet.get();
                while (rs.next()) {
                    postList.add(getValueFromResultSet(rs));
                }
            }
        }
        catch (SQLException e){
            System.out.println("Postları listelerken bir hata oluştu..." + e.getMessage());
        }
        return postList;
    }

    @Override
    public Optional<Post> findById(int id) {
        sql = "SELECT * FROM tblpost WHERE id= " + id;
        Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
        try{
            if (resultSet.isPresent()) {
                ResultSet rs = resultSet.get();
                if (rs.next()) {
                    return Optional.of(getValueFromResultSet(rs));
                }
            }
        }
        catch (SQLException e){
            System.out.println("Post bulmada bir sorun oluştu..." + e.getMessage());
        }

        return Optional.empty();
    }

    private Post getValueFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int user_id = rs.getInt("user_id");
        String baslik = rs.getString("baslik");
        String icerik = rs.getString("icerik");
        Integer state = rs.getInt("state");
        LocalDateTime paylasilmaTarihi = rs.getTimestamp("paylasilma_tarihi").toLocalDateTime();
        LocalDateTime createat = rs.getTimestamp("createat").toLocalDateTime();
        LocalDateTime updateat = rs.getTimestamp("updateat").toLocalDateTime();

        return new Post(id,user_id,baslik,icerik,paylasilmaTarihi, state,createat,updateat);
    }
}
