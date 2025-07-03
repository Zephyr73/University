import java.util.Scanner;

public class Employee {
    private String name;
    private int id;
    private String dept;
    private String status;

    public Employee() {
        this.name = "";
        this.id = 0;
        this.dept = "";
        this.status = "";
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public void getDetails() {
        System.out.println("Employee name: " +name);
        System.out.println("Employee id: " +id);
        System.out.println("Employee dept: " +dept);
        System.out.println("Employee status: " +status);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Employee employee = new Employee();
        System.out.print("Enter name for employee: ");
        employee.setName(input.nextLine());
        System.out.print("Enter id for employee: ");
        employee.setId(input.nextByte());
        input.nextLine();
        System.out.print("Enter dept for employee: ");
        employee.setDept(input.nextLine());
        System.out.print("Enter status for employee: ");
        employee.setStatus(input.nextLine());

        employee.getDetails();
    }
}