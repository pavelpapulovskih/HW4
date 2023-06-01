package org.max.seminar;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "current", schema = "main", catalog = "")
public class CurrentEntity {
    private short currentId;
    private String balance;
    private String openDate;
    private String number;

    @Id
    @Column(name = "current_id")
    public short getCurrentId() {
        return currentId;
    }

    public void setCurrentId(short currentId) {
        this.currentId = currentId;
    }

    @Basic
    @Column(name = "balance")
    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "open_date")
    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    @Basic
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentEntity that = (CurrentEntity) o;
        return currentId == that.currentId && Objects.equals(balance, that.balance) && Objects.equals(openDate, that.openDate) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentId, balance, openDate, number);
    }
}
