package foo.bar;

import java.math.BigDecimal;
import java.time.Period;


public class MoneySavingCalculator {

    public  BigDecimal calculateSavings(
            SavingFrequency frequency,
            BigDecimal singleAmmount,
            Period duration
    ) {


        long days = duration.getYears() * 365 + duration.getMonths() * 31 + duration.getDays();
        switch (frequency) {
            case EACH_DAY:
                singleAmmount = singleAmmount.multiply(BigDecimal.valueOf(days));
                break;
            case EACH_SECOND_DAY:
                singleAmmount = singleAmmount.multiply(BigDecimal.valueOf(days / 2));
                break;
            case EACH_WEEK:
                singleAmmount = singleAmmount.multiply((BigDecimal.valueOf(days / 7)));
                break;
            case TWICE_A_WEEK:
                singleAmmount = singleAmmount.multiply((BigDecimal.valueOf((days / 3))));
                break;
            case EACH_MONTH:
                singleAmmount = singleAmmount.multiply(BigDecimal.valueOf(duration.getYears() * 12 + duration.getMonths()));
                break;
            case ONCE_A_YEAR:
                singleAmmount = singleAmmount.multiply(BigDecimal.valueOf(duration.getYears()));
                break;
        }


        return singleAmmount;
    }


}
