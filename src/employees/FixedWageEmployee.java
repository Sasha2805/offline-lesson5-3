package employees;

public class FixedWageEmployee extends SuperEmployee {

    public FixedWageEmployee(String name, String surname, double monthlyWage) {
        super(name, surname);
        super.setMonthlyWage(monthlyWage);
    }

    @Override
    public void calcOfMonthlyWage() {

    }
}
