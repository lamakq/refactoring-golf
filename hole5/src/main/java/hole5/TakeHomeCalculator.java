package hole5;

import java.util.Arrays;
import java.util.List;

import static hole5.Money.money;

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

        Double amount = total.value * (taxRate.getPercent() / 100d);
        Money tax = money(amount.intValue(), first.currency);

        return total.minus(tax);
    }
}
