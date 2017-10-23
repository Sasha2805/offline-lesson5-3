package employees;

public abstract class SuperEmployee {
    private String name;
    private String surname;
    private double monthlyWage;

    public SuperEmployee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public abstract void calcOfMonthlyWage();

    //Getters ang setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getMonthlyWage() {
        return monthlyWage;
    }

    public void setMonthlyWage(double monthlyWage) {
        this.monthlyWage = monthlyWage;
    }
}
