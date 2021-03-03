package kz.iitu.spring.service;

import kz.iitu.spring.models.CommissionEmployee;
import kz.iitu.spring.models.Employee;
import kz.iitu.spring.models.HourlyEmployee;
import kz.iitu.spring.models.SalariedCommissionEmployee;
import org.springframework.stereotype.Component;

@Component
public class SalaryCalculatorService {
    public Employee calculateSalary(HourlyEmployee employee) {
        Double newSalary;

        if (employee.getWorkHour() > 40) {
            newSalary = 40.0 * employee.getSalaryHour() + (employee.getWorkHour() - 40) * 1.5 * employee.getSalaryHour();
        } else {
            newSalary = employee.getWorkHour() * employee.getSalaryHour();
        }
        employee.setSalary(newSalary);

        return employee;
    }

    public Employee calculateSalary(CommissionEmployee employee, Double amount) {
        Double bonus = amount * employee.getPercentageSales() / 100;
        employee.setSalary(employee.getSalary() + bonus);

        return employee;
    }

    public Employee calculateSalary(SalariedCommissionEmployee employee, Double amount) {
        Double bonus = amount * employee.getPercentageSales() / 100;
        employee.setAmountOfCommission(employee.getAmountOfCommission() + bonus);

        return employee;
    }
}
