package logDemo;

public class Employee {
    private String username;
    private String uPassword;

    public Employee() {

    }

    public Employee(String username, String uPassword) {
        this.username = username;
        this.uPassword = uPassword;
    }

    public String getuName(){
        return username;
    }
    public String getuPassword(){
        return uPassword;
    }

    public void setuName(String username){
        this.username = username;
    }
    public void setuPassword(String uPassword){
        this.uPassword = uPassword;
    }
}
