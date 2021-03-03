package kz.iitu.spring.event;

import kz.iitu.spring.models.Employee;
import org.springframework.context.ApplicationEvent;

public class SalaryChangeEvent extends ApplicationEvent {
    private Employee employee;
    private Double oldSalary;

    public SalaryChangeEvent(Object source, Employee employee, Double oldSalary) {
        super(source);
        this.employee = employee;
        this.oldSalary = oldSalary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Double getOldSalary() {
        return oldSalary;
    }
}
