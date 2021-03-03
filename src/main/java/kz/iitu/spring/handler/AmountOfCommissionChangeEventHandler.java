package kz.iitu.spring.handler;

import kz.iitu.spring.event.AmountOfCommissionChangeEvent;
import kz.iitu.spring.models.SalariedCommissionEmployee;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AmountOfCommissionChangeEventHandler implements ApplicationListener<AmountOfCommissionChangeEvent> {

    @Override
    public void onApplicationEvent(AmountOfCommissionChangeEvent amountOfCommissionChangeEvent) {
        System.out.println("AmountOfCommissionChangeEventHandler.onApplicationEvent");
        System.out.println("Amount of commission update: " + ((SalariedCommissionEmployee)amountOfCommissionChangeEvent.getEmployee()).getAmountOfCommission());
        System.out.println("Amount of commission old:    " + amountOfCommissionChangeEvent.getOldAmountOfCommission());
        System.out.println("Employee: " + amountOfCommissionChangeEvent.getEmployee());
    }
}
