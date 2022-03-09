package com.rev;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserTransactionsObj {

    @Id
    private int id;
    @Column(name="userName")
    private String userName;
    @Column(name="amount")
    private String amount;
    @Column(name="date")
    private String date;
    @Column(name="note")
    private String note;

    private String isAprove;

    public int getId(){
        return id;
    }
    public String getAmount(){
        return amount;
    }
    public String getDate(){
        return date;
    }
    public String getNote(){
        return note;
    }
    public String getisAprove(){
        return isAprove;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setuserName(String userName){
        this.userName = userName;
    }
    public void setAmount(String amount){
        this.amount = amount;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setNote(String note){
        this.note = note;
    }
    public void setisAprove(String isAprove){
        this.isAprove = isAprove;
    }
}
