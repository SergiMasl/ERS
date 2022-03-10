package com.rev;


import javax.persistence.*;

@Entity
public class User {
    @Id
    private int id_prof;

    //profile
    @Column(name="userName")
    private String userName;
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
    private String role;


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
    public String getrole(){
        return role;
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
    public void setrole(String role){
        this.role = role;
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
