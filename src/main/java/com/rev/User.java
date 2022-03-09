package com.rev;


import javax.persistence.*;

@Entity
public class User {
    @Id
    private int id;
    @Column(name="userName")
    private String userName;

    private String amount;
    private String pin;
    private String date;
    private String note;

    //profile
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="adress")
    private String adress;
    @Column(name="phone")
    private String phone;
    @Column(name="accauntNubber")
    private String accauntNubber;
    private String password;


    public User(){}

    public User(String amount, String pin, String date, String note) {
        this.amount = amount;
        this.date = date;
        this.pin = pin;
        this.note = note;
    }

    public User(int id, String amount, String pin, String date, String note) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.pin = pin;
        this.note = note;
    }

    //Getters:
    public int getId(){
        return id;
    }

    public String getAmount(){
        return amount;
    }

    public String getDate(){
        return date;
    }

    public String getPin(){
        return pin;
    }

    public String getNote(){
        return note;
    }


    //Setters:
    public void setId(int id){
        this.id = id;
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

//    //profile:
    public String getname(){
        return name;
    }
    public String getuserName(){
        return userName;
    }
    public String getemail(){
        return email;
    }
    public String getadress(){
        return adress;
    }
    public String getphone(){
        return phone;
    }
    public String getPassword(){
        return password;
    }
    public String getaccauntNubber(){
        return accauntNubber;
    }

    public void setname(String name){
        this.name = name;
    }
//
    public void setuserName(String userName){
        this.userName = userName;
    }
    public void setemail(String email){
        this.email = email;
    }
    public void setadress(String adress){
        this.adress = adress;
    }
    public void setphone(String phone){
        this.phone = phone;
    }
    public void setaccauntNubber(String accauntNubber){
        this.accauntNubber = accauntNubber;
    }


//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", user_name='" + user_name + '\'' +
//                ", user_pass='" + user_pass + '\'' +
//                ", balance=" + balance +
//                ", pending=" + pending +
//                '}';
//    }
}
