public class EmployeeBook {
    private  static final int EMPLOYEES_SIZE = 10;
    private static final int DEPARTMENT_COUNT = 6;
    /// почему если сделать 5ть в консоль выводица тока 4ре департамента.
    private final Employee[] employees = new Employee[EMPLOYEES_SIZE];
    public void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public int calculateTotalSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            sum = sum + employee.getSalary();
        }
        return sum;
    }
    public Employee findEmployeeWitchMinSalary() {
        Employee employeeWithMinSalary = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < employeeWithMinSalary.getSalary()){
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }
    public Employee findEmployeeWitchMaxSalary() {
        Employee employeeWithMaxSalary = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > employeeWithMaxSalary.getSalary()){
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }
    public float calculateAverageSalary(){
        /// Зачем флоат несовсем понял
        return calculateTotalSalary() / (float)employees.length;
        /// чтоб не целочисленный получился результат привели одно из значеник флоат
    }
    public void increaseSalary(int percent) {
        for (Employee employee : employees) {
            int currentSalary = employee.getSalary();
            employee.setSalary((int) (currentSalary * (percent / 100f + 1)));
        }
    }
    public Employee findEmployeeWitchMinSalaryByDepartment(int department) {
        /// считаем минимальную зарплату сотрудиника по депортаменту
        int minSalary = Integer.MAX_VALUE;
        Employee employeeWithMinSalary = null;

        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }
    public Employee findEmployeeWitchMaxSalaryByDepartment(int department) {
        /// считаем максимальную зарплату сотрудиника по депортаменту
        int maxSalary = Integer.MIN_VALUE;
        Employee employeeWithMaxSalary = null;

        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }
    public int calculateTotalSalaryOfDepartment(int department) {
        ///Считаем сумму зарплат по депортаменту
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }
    public float calculateAverageSalaryOfDepartment(int department) {
        ///Считаем среднюю заплату по депортаменту
        int sum = 0;
        int memberCount = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum = sum + employee.getSalary();
                memberCount++;
            }
        }
        return sum / (float) memberCount;
    }
    public void increaseSalaryDepartment(int department, int percent) {
        ///увеличиваем зарплату сотрудников депортамента
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                int currentSalary = employee.getSalary();
                employee.setSalary((int) (currentSalary * (percent / 100f + 1)));
            }
        }
    }
    public void printEmployeesOfDepartment(int department) {
        ///Выводим сотрудников депортамента
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println(employee);
            }
        }
    }
    public void printEmployeesWithMinSalary(int salary) {
        ///Выводим  сотрудников  c зарлатой меньше salary
        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                System.out.println(employee);
            }
        }
    }
    public void printEmployeesWithMaxSalary(int salary) {
        ///Выводим сотрудников  c зарплатой больше salary
        for (Employee employee : employees) {
            if (employee.getSalary() > salary) {
                System.out.println(employee);
            }
        }
    }

    public void createEmployee(String nick, int department, int salary) {
        ///новый сотрудник
        int index = findFreeIndex();
        if(index == -1) {
            System.out.println("Хранилище заполнено.");
        } else {
            employees[index] = new Employee(nick,department,salary);
        }
    }
    private int findFreeIndex() {
        ///поиск свободного места для сотрудника
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] == null) {
                return i;
            }
        }
        return  -1;
    }
    public void  removeEmployeeId(int id) {
        ///удаляем сотрудника по id
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }
    public void  removeEmployee(String nick) {
        ///удаляем сотрудника по имени
        for (int i = 0; i < employees.length && employees[i] != null ; i++) {
            if (employees[i].getNick().equals(nick)) {
                employees[i] = null;
            }
        }
    }
    public void  changeSalary (String nick, int salary) {
    ///изменяем зарплату сотрудника
        for (Employee employee: employees) {
            if (employee.getNick().equals(nick)) {
                employee.setSalary(salary);
            }
        }
    }
    public void  changeDepartment (String nick, int department) {
        ///изменяем департамент сотрудника
        for (Employee employee: employees) {
            if (employee.getNick().equals(nick)) {
                employee.setDepartment(department);
            }
        }
    }
    public void printEmployeeByDepartments() {
        for (int department = 1; department < DEPARTMENT_COUNT; department++) {
            System.out.println("Отдел - " + department + ":");
            for (Employee employee: employees) {
                if (employee.getDepartment() == department) {
                    System.out.println(employee.getNick());
                }
            }
        }
    }

}
