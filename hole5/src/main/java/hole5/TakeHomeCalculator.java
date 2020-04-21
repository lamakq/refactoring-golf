package hole5;

import java.util.Arrays;
import java.util.List;

class TakeHomeCalculator {

    public TakeHomeCalculator(TaxRate taxRate) {
        this.taxRate = taxRate;
    }

    private final TaxRate taxRate;

    Money netAmount(Money first, Money... rest) {

        List<Money> monies = Arrays.asList(rest);

        Money total = first;

        for (Money next : monies) {
            total = total.plus(next);
        }

        Money tax = taxRate.apply(total);

        return total.minus(tax);
    }

}
