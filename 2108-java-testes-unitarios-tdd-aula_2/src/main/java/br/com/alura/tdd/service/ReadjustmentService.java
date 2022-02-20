package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.PerformanceEnum;

import java.math.BigDecimal;

public class ReadjustmentService {

    public BigDecimal readjust(BigDecimal baseSalary, PerformanceEnum performance) {
        if (baseSalary.compareTo(new BigDecimal("10000.00"))>-1) {
            throw new IllegalArgumentException("The base salary is too higher to readjust");
        }
        switch (performance){
            case ENOUGH:
                return baseSalary.multiply(BigDecimal.valueOf(0.15)).add(baseSalary).setScale(2);
            case HIGHER:
                return baseSalary.multiply(BigDecimal.valueOf(0.20)).add(baseSalary).setScale(2);
            default:
                return baseSalary.multiply(BigDecimal.valueOf(0.03)).add(baseSalary).setScale(2);
        }
    }

}
