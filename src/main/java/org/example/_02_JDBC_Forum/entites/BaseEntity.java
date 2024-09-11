package org.example._02_JDBC_Forum.entites;

import java.time.LocalDateTime;

public abstract class BaseEntity {

    private Integer state;
    private LocalDateTime createat; //bigint karşılığı
    private LocalDateTime updateat; //bigint karşılığı

    public BaseEntity() {
    }

    public BaseEntity(Integer state, LocalDateTime createat, LocalDateTime updateat) {
        this.state = state;
        this.createat = createat;
        this.updateat = updateat;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public LocalDateTime getCreateat() {
        return createat;
    }

    public void setCreateat(LocalDateTime createat) {
        this.createat = createat;
    }

    public LocalDateTime getUpdateat() {
        return updateat;
    }

    public void setUpdateat(LocalDateTime updateat) {
        this.updateat = updateat;
    }
}
