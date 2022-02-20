package br.com.alura.tdd.service;

import br.com.alura.tdd.enums.PerformanceEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ReadjustmentTest {

    @Test
    public void readjustmentIfThePerfomanceIsNotEnough() {
        ReadjustmentService readjustmentService = new ReadjustmentService();
        Assertions.assertEquals(new BigDecimal("1030.00"), readjustmentService.readjust(BigDecimal.valueOf(1000), PerformanceEnum.NOT_ENOUGH));
    }

    @Test
    public void readjustmentIfThePerfomanceIsEnough() {
        ReadjustmentService readjustmentService = new ReadjustmentService();
        Assertions.assertEquals(new BigDecimal("1150.00"), readjustmentService.readjust(BigDecimal.valueOf(1000), PerformanceEnum.ENOUGH));
    }

    @Test
    public void readjustmentIfThePerfomanceIsHigher() {
        ReadjustmentService readjustmentService = new ReadjustmentService();
        Assertions.assertEquals(new BigDecimal("1200.00"), readjustmentService.readjust(BigDecimal.valueOf(1000), PerformanceEnum.HIGHER));
    }

    @Test
    public void readjustmentIfTheSalaryIsBiggerThanTenThousand() {
        ReadjustmentService readjustmentService = new ReadjustmentService();
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> readjustmentService.readjust(BigDecimal.valueOf(100000), PerformanceEnum.HIGHER));
    }

}
