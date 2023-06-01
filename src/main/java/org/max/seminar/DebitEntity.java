package org.max.seminar;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "debit", schema = "main", catalog = "")
public class DebitEntity {
    private short debitId;
    private String typeName;
    private String balance;
    private String openDate;
    private String percent;
    private String status;
    private String number;

    @Id
    @Column(name = "debit_id")
    public short getDebitId() {
        return debitId;
    }

    public void setDebitId(short debitId) {
        this.debitId = debitId;
    }

    @Basic
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
    @Column(name = "percent")
    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        DebitEntity that = (DebitEntity) o;
        return debitId == that.debitId && Objects.equals(typeName, that.typeName) && Objects.equals(balance, that.balance) && Objects.equals(openDate, that.openDate) && Objects.equals(percent, that.percent) && Objects.equals(status, that.status) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(debitId, typeName, balance, openDate, percent, status, number);
    }
}
