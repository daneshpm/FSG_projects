import jakarta.persistence.*;
import java.util.*;

public class EmpolyeeDetails implements CommonDetails, Comparator<Employee> {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;

    private List<Employee> employees;
    private Scanner scanner;

    // Constructor
    public EmpolyeeDetails(List<Employee> employees, Scanner scanner) {
        this.employees = employees;
        this.scanner = scanner;

        // Initialize JPA
        emf = Persistence.createEntityManagerFactory("vikas");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    
    // ADD Employee
    
    @Override
    public void add() {
        Employee e = readEmployeeDetails();
        if (Objects.nonNull(e)) {
            try {
                et.begin();
                em.persist(e);
                et.commit();
                employees.add(e);
                System.out.println("Employee added successfully: " + e);
            } catch (Exception ex) {
                if (et.isActive()) et.rollback();
                System.out.println("Error adding employee: " + ex.getMessage());
            }
        }
    }

    
    // UPDATE Employee
    
    public void update() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        Employee e = em.find(Employee.class, id);

        if (e != null) {
            System.out.print("Enter new salary: ");
            double newSalary = scanner.nextDouble();

            try {
                et.begin();
                e.setSalary(newSalary);
                em.merge(e);
                et.commit();
                System.out.println("Employee updated successfully.");
            } catch (Exception ex) {
                if (et.isActive()) et.rollback();
                System.out.println("Error updating employee: " + ex.getMessage());
            }
        } else {
            System.out.println("Employee not found.");
        }
    }

    
    // DELETE Employee
    
    public void remove() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        Employee e = em.find(Employee.class, id);

        if (e != null) {
            try {
                et.begin();
                em.remove(e);
                et.commit();
                employees.remove(e);
                System.out.println("Employee deleted successfully.");
            } catch (Exception ex) {
                if (et.isActive()) et.rollback();
                System.out.println("Error deleting employee: " + ex.getMessage());
            }
        } else {
            System.out.println("Employee not found.");
        }
    }

    // --------------------------
    // RETRIEVE (Display All)
    // --------------------------
    public void display() {
        List<Employee> list = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        System.out.println("===== Employee List =====");
        list.forEach(System.out::println);
    }

   
    // READ EMPLOYEE DETAILS
    
    private Employee readEmployeeDetails() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        
        System.out.print("Enter mobile no: ");
        long moblie = scanner.nextLong();
        
        System.out.print("Enter e-mail: ");
        String email = scanner.next();
        

        return new Employee(id, name, salary,moblie,email);
    }

    
    // Comparator Implementation
    
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareToIgnoreCase(e2.getName());
    }
}
