package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.domain.calculators.TicketCalculator;
import lotto.domain.calculators.TicketCalculatorImpl;
import lotto.domain.calculators.YieldCalculator;
import org.junit.jupiter.api.Test;

class WalletTest {
    private final TicketCalculator ticketCalculator = new TicketCalculatorImpl();
    private final YieldCalculator yieldCalculator = new YieldCalculator();

    @Test
    void 최소_구입_금액_미달시_예외_처리() {
        assertThatThrownBy(() -> new Wallet(100, ticketCalculator, yieldCalculator))
                .isInstanceOf(IllegalArgumentException.class);

    }


    @Test
    void 금액_단위가_맞지_않을시_예외_처리() {
        assertThatThrownBy(() -> new Wallet(1001, ticketCalculator, yieldCalculator))
                .isInstanceOf(IllegalArgumentException.class);

    }

}