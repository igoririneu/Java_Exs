package Entity;

public class Employees {
    private int id;
    private String name;
    private double salary;

    public Employees(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employees(){}

    public Integer getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String setName(String name){
       return this.name = name;
    }

    public Double getSalary(){
        return salary;
    }

    public Double setSalary(double salary){
        return this.salary = salary;
    }

    public String toString(){
        return id + ", " + name + ", " + String.format("%.2f", salary);
    }

    public void increaseSalary(double percentage){
        salary += salary * percentage / 100.0;
    }
}
