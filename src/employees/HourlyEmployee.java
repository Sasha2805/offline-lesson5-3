package employees;

public class HourlyEmployee extends SuperEmployee {
    private double hourlyRate;

    public HourlyEmployee(String name, String surname, double hourlyRate) {
        super(name, surname);
        this.hourlyRate = hourlyRate;
        calcOfMonthlyWage();
    }

    @Override
    public void calcOfMonthlyWage() {
        super.setMonthlyWage(20.8 * 8 * hourlyRate);
    }

}
