package kz.iitu.spring.models;

public class SalariedCommissionEmployee extends Employee {
    private Double percentageSales;
    private Double amountOfCommission;

    public SalariedCommissionEmployee() {}

    public SalariedCommissionEmployee(Integer id, String name, Double salary, Double percentageSales, Double amountOfCommission) {
        super(id, name, salary);
        this.percentageSales = percentageSales;
        this.amountOfCommission = amountOfCommission;
    }

    public Double getPercentageSales() {
        return percentageSales;
    }

    public Double getAmountOfCommission() {
        return amountOfCommission;
    }

    public void setAmountOfCommission(Double amountOfCommission) {
        this.amountOfCommission = amountOfCommission;
    }

    @Override
    public String toString() {
        return "SalariedCommissionEmployee{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", salary=" + getSalary() +
                ", percentageSales=" + percentageSales +
                ", amountOfCommission=" + amountOfCommission +
                '}';
    }
}
