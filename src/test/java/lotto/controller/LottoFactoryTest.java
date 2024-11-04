package lotto.controller;

import lotto.model.LottoGenerator;
import lotto.model.LottoRateCalculator;
import lotto.model.LottoWinningChecker;
import lotto.Exception.Money.MoneyInputErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    private final LottoFactory lottoFactory = new LottoFactory(new LottoRateCalculator(), new LottoGenerator(), new LottoWinningChecker());
    private static final int UNIT_CASH = 1000;

    @Test
    @DisplayName("입력된 금액이 1,000원 단위가 아닌 경우 예외가 발생한다.")
    void 금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> lottoFactory.convertCashToLottTicket(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MoneyInputErrorCode.NOT_IN_THOUSANDS.getArgsErrorMessage(UNIT_CASH));
    }

    @Test
    @DisplayName("입력된 금액이 1,000원 단위일 경우 로또 티켓 개수를 반환한다.")
    void 금액이_1000원_단위일_경우_티켓_개수_반환() {
        int ticketCount = lottoFactory.convertCashToLottTicket(5000);
        assertThat(ticketCount).isEqualTo(5);
    }
}
