package hole2;

import java.util.Arrays;
import java.util.List;

class TakeHomeCalculator {

    private final int percent;

    TakeHomeCalculator(int percent) {
        this.percent = percent;
    }

    Money<Integer, String> netAmount(Money<Integer, String> first, Money<Integer, String>... rest) {

        List<Money<Integer, String>> monies = Arrays.asList(rest);

        Money<Integer, String> total = first;

        for (Money<Integer, String> next : monies) {
            if (!next.second.equals(total.second)) {
                throw new Incalculable();
            }
        }

        for (Money<Integer, String> next : monies) {
            total = new Money<>(total.first + next.first, next.second);
        }

        Double amount = total.first * (percent / 100d);
        Money<Integer, String> tax = new Money<>(amount.intValue(), first.second);

        if (!total.second.equals(tax.second)) {
            throw new Incalculable();
        }
        return new Money<>(total.first - tax.first, first.second);
    }

    static class Money<Integer, String> {
        final Integer first;
        final String second;

        Money(Integer first, String second) {
            this.first = first;
            this.second = second;
        }

    }
}
