package company;

import employees.FixedWageEmployee;
import employees.HourlyEmployee;
import employees.SuperEmployee;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Company {
    private ArrayList<SuperEmployee> employees;
    private static final String SEPARATOR = ";";

    public Company() {
        employees = new ArrayList<>();
    }

    public void addEmployee(SuperEmployee employee){
        employees.add(employee);
    }

    public void addEmployee(ArrayList<SuperEmployee> employees){
        this.employees = employees;
    }

    public double monthlyPaymentWages(){
        double monthlyPayment = 0;
        for (SuperEmployee employee: employees) {
            monthlyPayment += employee.getMonthlyWage();
        }
        return monthlyPayment;
    }

    public void show(){
        for (SuperEmployee employee: employees) {
            System.out.println("Name: " + employee.getName());
            System.out.println("Surname: " + employee.getSurname());
            System.out.println("Wage: " + employee.getMonthlyWage());
        }
    }

    public void saveEmployeesInFile(String path){
        try {
            FileWriter writer = new FileWriter(path);
            for (SuperEmployee employee: employees) {
                writer.write(employee.getClass().getSimpleName() + SEPARATOR);
                writer.write(employee.getName() + SEPARATOR);
                writer.write(employee.getSurname() + SEPARATOR);
                writer.write(employee.getMonthlyWage() + SEPARATOR);
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadEmployeesFromFile(String path){
        try {
            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(SEPARATOR);

                if (data[0].equals("FixedWageEmployee")) {
                    employees.add(new FixedWageEmployee(data[1], data[2], Double.parseDouble(data[3])));
                }
                if (data[0].equals("HourlyEmployee")) {
                    employees.add(new HourlyEmployee(data[1], data[2], Double.parseDouble(data[3])));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sortWagesAscending(){
        SuperEmployee temp;
         for (int i = employees.size() - 1; i >= 0 ; i--){
            for (int j = 0; j < i; j++)
            if (employees.get(j).getMonthlyWage() > employees.get(j + 1).getMonthlyWage()){
                temp = employees.get(j);
                employees.set(j, employees.get(j + 1));
                employees.set(j + 1, temp);
            }
        }
    }

    public void sortWagesDescending(){
        sortWagesAscending();
        SuperEmployee temp;
        for (int i = 0; i < employees.size() / 2; i++){
            temp = employees.get(i);
            employees.set(i, employees.get(employees.size() - i - 1));
            employees.set(employees.size() - i - 1, temp);
        }
    }

}
