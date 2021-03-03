package kz.iitu.spring.dao;

import kz.iitu.spring.DBConnection;
import kz.iitu.spring.event.AmountOfCommissionChangeEvent;
import kz.iitu.spring.event.SalaryChangeEvent;
import kz.iitu.spring.models.CommissionEmployee;
import kz.iitu.spring.models.Employee;
import kz.iitu.spring.models.HourlyEmployee;
import kz.iitu.spring.models.SalariedCommissionEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher eventPublisher;
    private DBConnection dbConnection;

    @Autowired
    public EmployeeDao(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void updateSalary(Employee employee, Double oldSalary) {
        String tableName;
        String sqlBonus = "";

        if (employee instanceof SalariedCommissionEmployee) {
            tableName = "salaried_commission_employees";
        } else if (employee instanceof HourlyEmployee) {
            tableName = "hourly_employees";
            sqlBonus = ", `salary-hour` = " + ((HourlyEmployee) employee).getSalaryHour();
        } else if (employee instanceof CommissionEmployee) {
            tableName = "commission_employees";
        } else {
            tableName = "salaried_employees";
        }

        String sql = "UPDATE " + tableName + " SET salary = " + employee.getSalary() + sqlBonus + " WHERE id = " + employee.getId();
        dbConnection.updateData(sql);
//        System.out.println(sql);
        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, employee, oldSalary));
    }

    public void updateAmountOfCommission(Employee employee, Double amountOfCommission) {
        String tableName = "salaried_commission_employees";

        String sql = "UPDATE " + tableName + " SET amount_of_commission = " + ((SalariedCommissionEmployee)employee).getAmountOfCommission() + " WHERE id = " + employee.getId();
        dbConnection.updateData(sql);
//        System.out.println(sql);
        this.eventPublisher.publishEvent(new AmountOfCommissionChangeEvent(this, employee, amountOfCommission));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
