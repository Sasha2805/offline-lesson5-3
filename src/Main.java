import company.Company;
import employees.FixedWageEmployee;
import employees.Freelancer;
import employees.HourlyEmployee;

public class Main {
    private static final String PATH = "src/data_employees.txt";

    public static void main(String[] args) {
        Company company = new Company();
        company.addEmployee(new HourlyEmployee("John", "Smith", 11));
        company.addEmployee(new FixedWageEmployee("Bob", "Smith", 1500));
        company.addEmployee(new Freelancer("Rachel", "Oliver", 5, 10));
        company.saveEmployeesInFile(PATH);

        System.out.println(company.monthlyPaymentWages());
        company.show();

        company.sortWagesAscending();
        company.show();

        company.sortWagesDescending();
        company.show();
    }
}
