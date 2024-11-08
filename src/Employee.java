public class Employee {
    private final int id;
    private String surnameNamePatrnimic;
    private int departament;
    private float salary;
    static int counter = 0;

    Employee(String surnameNamePatrnimic, int departament, float salary) {
        id = ++counter;
        this.surnameNamePatrnimic = surnameNamePatrnimic.trim();
        this.departament = departament;
        this.salary = salary;
    }

    public int getId() {
        return this.id;
    }

    public String getSurnameNamePatrnimic() {
        return this.surnameNamePatrnimic;
    }

    public int getDepartament() {
        return this.departament;
    }

    public float getSalary() {
        return this.salary;
    }

    public void setSurnameNamePatrnimic(String surnameNamePatrnimic) {
        if (surnameNamePatrnimic != null && !surnameNamePatrnimic.isBlank()) {
            this.surnameNamePatrnimic = surnameNamePatrnimic.trim();
        } else {
            String error = "ОШИБКА ввода ФИО по ID= " + this.id;
            throw new IllegalArgumentException(error);
        }
    }

    public void setDepartament(int departament) {
        if (departament >= 1 && departament <= 5) {
            this.departament = departament;
        } else {
            String error = "ОШИБКА ввода номера отдела по ID= " + this.id;
            throw new IllegalArgumentException(error);
        }
    }

    public void setSalary(float salary) {
        if (salary > 0f && salary <= 1_000_000f) {
            this.salary = salary;
        } else {
            String error = "ОШИБКА ввода зарплаты сотрудника по ID= " + this.id;
            throw new IllegalArgumentException(error);
        }
    }

    @Override
    public String toString() {
        return String.format("%5d%35s%10d%20.2f%s", this.id, this.surnameNamePatrnimic, this.departament, this.salary, " руб");
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.departament);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return (departament == employee.getDepartament());
    }
}
