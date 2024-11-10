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

    static void printTitle(String title) {
        int lineLength = 100;
        int headerLength = title.length();
        int dob = (lineLength - headerLength) / 2;
        String completion = "-";
        System.out.println("\n" + completion.repeat(dob) + title + completion.repeat(dob));
    }

    static boolean evaluateCell(Employee element) {
        return (element.getFulname() != null && !element.getFulname().isBlank());

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

    static  void compareMoreLess(String moreLess) {
        float minimum = employees[0].getSalary();
        float maximum = employees[0].getSalary();
        System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                if (minimum > variable.getSalary()) {
                    minimum = variable.getSalary();
                }
                if (maximum <= variable.getSalary()) {
                    maximum = variable.getSalary();
                }
            }
        }
        int counter = 0;
        float minimumOrMaximum = minimum;
        String outputString = "Минимальная";
        if (moreLess.contains(">")) {
            minimumOrMaximum = maximum;
            outputString = "Максимальная";
        }
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                if (minimumOrMaximum == variable.getSalary()) {
                    counter++;
                    System.out.println(variable);
                }
            }
        }
        System.out.printf("\n%s%s", outputString, " зарплата сотрудника предприятия составляет: ");
        System.out.printf("%.2f%s%d%s\n", minimumOrMaximum, " руб. и её получает ", counter, " человек(а)");
    }

    static void displayListEmployees() {
        System.out.printf("%35s\n", "Фамилия имя отчество");
        for (Employee variable : employees) {
            if (evaluateCell(variable)) {
                System.out.printf("%35s\n", variable.getFulname());
            }
        }
    }

    public static void main(String[] args) {
        printTitle("КУРСОВОЕ ЗАДАНИЕ");
        printTitle("КНИГА СОТРУДНИКОВ");
        printTitle("БАЗОВАЯ СЛОЖНОСТЬ");
        printTitle("a) список всех сотрудников");
        outputTheTable();
        printTitle("b) сумму затрат на ЗП в месяц");
        if (calculateAmountExpenses() == 0 && countTheEmployees() != 0) {
            System.out.println("Руководитель не платит работникам зарплату, или таблица заполнена не коректно");
        } else if (countTheEmployees() == 0) {
            System.out.println("Штат пуст, трудоустраиваите людей на вакантные должности, или проверьте правильность ввода массива информации");
        } else {
            System.out.printf("%s%.2f%s\n", "Сумма затрат на зарплату сотрудникам составляет: ", calculateAmountExpenses(), " руб");
            printTitle("c) сотрудники предприятия с минимальной ЗП");
            compareMoreLess("<");
            printTitle("d) сотрудники предприятия с максимальной ЗП");
            compareMoreLess(">");
            printTitle("e) среднее значение зарплат на предприятии");
            System.out.printf("%s%.2f%s\n", "Среднее значение зарплат сотрудников предприятия составляет: ",
                    calculateAmountExpenses() / countTheEmployees(), " руб");
            printTitle("f) список ФИО всех сотрудников предприятия");
            displayListEmployees();
        }
    }
}