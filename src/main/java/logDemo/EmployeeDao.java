package logDemo;

public interface EmployeeDao {

    public int insertEmployee(Employee e);
    public Employee getEmployee(String username, String uPassword);

}
