package foo.bar;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Period;

public class MoneySavingCalculatorTest {

    MoneySavingCalculator calc = new MoneySavingCalculator();

    @Test
    @Description("During period of 1 year, when saving is 1000 once a YEAR, total savings should be 1000")
    void saveEachYearDuringYear1000pln() {
        Assertions.assertEquals(
                BigDecimal.valueOf(1000),
                calc.calculateSavings(SavingFrequency.ONCE_A_YEAR,
                        BigDecimal.valueOf(1000), Period.ofYears(1))
        );
    }

    @Test
    @Description("During period of 2 months, when saving is 20 once a month, total saving should 40")
    void saveTwiceAWeekTDuringTwoMonths20pln() {

        Assertions.assertEquals(BigDecimal.valueOf(40), calc.calculateSavings(SavingFrequency.EACH_MONTH, BigDecimal.valueOf(20), Period.ofMonths(2)));
    }

    @Test
    @Description("During period of 20 days, when saving is 10 every second day, total saving should be 100")
    void saveSecondDay20Days10() {

        Assertions.assertEquals(BigDecimal.valueOf(100), calc.calculateSavings(SavingFrequency.EACH_SECOND_DAY, BigDecimal.valueOf(10), Period.ofDays(20)));

    }


    @Test
    @Description("During period of 138 days, when saving 1,23 once a day, total saving shuld be 169,74")
    void saveEachDayDuring138Days123pln() {
        Assertions.assertEquals(BigDecimal.valueOf(169.74), calc.calculateSavings(SavingFrequency.EACH_DAY, BigDecimal.valueOf(1.23), Period.ofDays(138)));

    }
}
