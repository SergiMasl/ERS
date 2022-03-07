

import javax.persistence.*;

@Entity
//@Table(name="users_table")
public class User {
    @Id
//    @Column(name="user_id")
//    @GeneratedValue(strategy = GenerationType.AUTO);
    private int id;

    private String amount;
    private String pin;
    private String date;
    private String note;

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
    public void setPin(String pin){
        this.pin = pin;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setNote(String note){
        this.note = note;
    }

}
