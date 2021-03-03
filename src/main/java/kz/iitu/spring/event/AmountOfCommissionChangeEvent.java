package kz.iitu.spring.event;

import kz.iitu.spring.models.Employee;
import org.springframework.context.ApplicationEvent;

public class AmountOfCommissionChangeEvent extends ApplicationEvent {
    private Employee employee;
    private Double oldAmountOfCommission;

    public AmountOfCommissionChangeEvent(Object source, Employee employee, Double oldAmountOfCommission) {
        super(source);
        this.employee = employee;
        this.oldAmountOfCommission = oldAmountOfCommission;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Double getOldAmountOfCommission() {
        return oldAmountOfCommission;
    }
}
