package employees;

public class Freelancer extends SuperEmployee {
    private double hourlyRate;
    private double countHours;

    public Freelancer(String name, String surname, double hourlyRate, double countHours) {
        super(name, surname);
        this.hourlyRate = hourlyRate;
        this.countHours = countHours;
        calcOfMonthlyWage();
    }

    @Override
    public void calcOfMonthlyWage() {
        super.setMonthlyWage(20.8 * countHours * hourlyRate);
    }
}
