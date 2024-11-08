public final class Main {
    static Employee[] employees = {
            new Employee("Рыжиков Сергей Викторович", 5, 74003f),
            new Employee("Кукушкина Надежда Михайловна", 2, 68432f),
            new Employee("Калмыков Вячеслав Васильевич", 3, 99343f),
            new Employee("Панферов Игорь викторович", 4, 99343f),
            new Employee("Баязитов Евгений Александрович", 1, 83023f),
            new Employee("Позднякова Галина Михайловна", 2, 77777f),
            new Employee("Синицын Алексей Иванович", 2, 83000f),
            new Employee(" ", 0, 0),
            new Employee("Колосов Александр Игоревич", 3, 85000f),
            new Employee(" ", 0, 0)
    };

    static boolean evaluateCell(Employee element) {
        return (element.getSurnameNamePatrnimic() != null && !element.getSurnameNamePatrnimic().isBlank());

    }

    static void outputTheTable() {
        System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                System.out.println(variable);
            }
        }
    }

    static float calculateAmountExpenses() {
        float amount = 0;
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                amount = amount + variable.getSalary();
            }
        }
        return amount;
    }

    static byte countTheEmployees() {
        byte amount = 0;
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                amount++;
            }
        }
        return amount;
    }

    static void findMinimumWage() {
        float minimum = 1000000f;
        System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (minimum >= variable.getSalary()) {
                    minimum = variable.getSalary();
                }
            }
        }
        int counter = 0;
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (minimum == variable.getSalary()) {
                    counter++;
                    System.out.println(variable);
                }
            }
        }
        System.out.printf("\n%s", "Минимальная зарплата сотрудника предприятия составляет: ");
        System.out.printf("%.2f%s%d%s\n", minimum, " и её получает ", counter, " человек(а)");
    }

    static void findMaximumWage() {
        float maximum = 0f;
        System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (maximum <= variable.getSalary()) {
                    maximum = variable.getSalary();
                }
            }
        }
        int counter = 0;
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                if (maximum == variable.getSalary()) {
                    counter++;
                    System.out.println(variable);
                }
            }
        }
        System.out.printf("%s", "Максимальная зарплата сотрудника предприятия составляет: ");
        System.out.printf("%.2f%s%d%s\n", maximum, " и её получает ", counter, " человек(а)");
    }

    static void displayListEmployees() {
        System.out.printf("%35s\n", "Фамилия имя отчество");
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                System.out.printf("%35s\n", variable.getSurnameNamePatrnimic());
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("""
                -------------------------КУРСОВОЕ ЗАДАНИЕ-------------------------------
                ----------------------- КНИГА СОТРУДНИКОВ-------------------------------
                ------------------------------------------------------------------------
                """);
        System.out.println("------------------------БАЗОВАЯ СЛОЖНОСТЬ-------------------------------\n");
        System.out.println("--------------------a) список всех сотрудников--------------------------\n");
        outputTheTable();
        System.out.println("\n--------------------b) сумму затрат на ЗП в месяц------------------------");
        if (calculateAmountExpenses() == 0 && countTheEmployees() != 0) {
            System.out.println("Руководитель не платит работникам зарплату, или таблица заполнена не коректно");
        } else if (countTheEmployees() == 0) {
            System.out.println("Штат пуст, трудоустраиваите людей на вакантные должности, или проверьте правильность ввода массива информации");
        } else {
            System.out.printf("%s%.2f%s\n", "Сумма затрат на зарплату сотрудникам составляет: ", calculateAmountExpenses(), " руб");
            System.out.println("\n--------------------c) сотрудники предприятия с минимальной ЗП-----------");
            findMinimumWage();
            System.out.println("\n--------------------d) сотрудники предприятия с максимальной ЗП----------");
            findMaximumWage();
            System.out.println("\n--------------------e) среднее значение зарплат на предприятии-----------");
            System.out.printf("%s%.2f%s\n", "Среднее значение зарплат сотрудников предприятия составляет: ",
                    calculateAmountExpenses() / countTheEmployees(), " руб");
            System.out.println("\n--------------------f) список ФИО всех сотрудников предприятия-----------");
            displayListEmployees();
        }
    }
}