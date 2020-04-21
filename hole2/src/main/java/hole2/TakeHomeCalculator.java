package hole2;

import java.util.Arrays;
import java.util.List;

class TakeHomeCalculator {

    private final int percent;

    TakeHomeCalculator(int percent) {
        this.percent = percent;
    }

    Money netAmount(Money first, Money... rest) {

        List<Money> monies = Arrays.asList(rest);

        Money total = first;

        for (Money next : monies) {
            if (!next.second.equals(total.second)) {
                throw new Incalculable();
            }
        }

        for (Money next : monies) {
            total = new Money(total.first + next.first, next.second);
        }

        Double amount = total.first * (percent / 100d);
        Money tax = new Money(amount.intValue(), first.second);

        if (!total.second.equals(tax.second)) {
            throw new Incalculable();
        }
        return new Money(total.first - tax.first, first.second);
    }

    static class Money {
        final Integer first;
        final String second;

        Money(Integer first, String second) {
            this.first = first;
            this.second = second;
        }

    }
}
