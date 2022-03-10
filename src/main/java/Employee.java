import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class Employee {


    @Id
    private int id;
    private String name;
    private String email;
    private String user_name;
    private String user_pass;
    private double balance;
    private int pending;
    private int isResolved;

    public Employee(){}

    public Employee(int id, String user_name, String user_pass, String name, String email, double balance, int pending, int isResolved) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.user_name = user_name;
        this.user_pass = user_pass;
        this.balance = balance;
        this.pending = pending;
        this.isResolved = isResolved;

    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    public int getIsResolved() {
        return isResolved;
    }

    public void setIsResolved(int isResolved) {
        this.isResolved = isResolved;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_pass='" + user_pass + '\'' +
                ", balance=" + balance +
                ", pending=" + pending +
                ", isResolved=" + isResolved +
                '}';
    }
}
