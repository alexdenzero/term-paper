public class Employee {
    ///класс Сотрудник(шаблон)
    private final String nick;
    ///ФИО
    private int department;
    ///Отдел
    private int salary;
    ///Зарплата
    private final int id;
    ///id сотрудника
    private static int idCounter = 1;
    //// счетчик сотрудника
    public Employee(String nick, int department, int salary) {
        this.id = idCounter++;
        this.nick = nick;
        this.department = department;
        this.salary = salary;
    }

    public String getNick() {
        return nick;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Сотрудник[" +
                "Ф.И.О. = " + nick  +
                ", Отдел = " + department +
                ", Зарплата = " + salary +
                ", id = " + id +
                ']';
    }
}
