package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    private final LottoMachine lottoMachine;

    LottoMachineTest() {
        this.lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("getLottos는 범위 밖에 구입 금액일 때, IllegalArgumentException를 지정한 메세지와 함께 던집니다.")
    void getLottos_WithOutOfRange_ThrowIllegalArgumentExceptionWithExpectedMessage() {
        // given
        final int belowThanMinValue = LottoMachine.BUY_AMOUNT_MIN_VALUE - 1;
        final int aboveThanMaxValue = LottoMachine.BUY_AMOUNT_MAX_VALUE + 1;

        // when & then
        assertThatThrownBy(() -> lottoMachine.getLottos(belowThanMinValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoMachine.RANGE_ERROR_MESSAGE);

        assertThatThrownBy(() -> lottoMachine.getLottos(aboveThanMaxValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoMachine.RANGE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("getLottos는 로또 금액으로 나눌 수 없는 구입 금액일 때, IllegalArgumentException를 지정한 메세지와 함께 던집니다.")
    void getLottos_WithNonDivisibleLottoPrice_ThrowIllegalArgumentExceptionWithExpectedMessage() {
        if (Lotto.PRICE == 1) {
            return;
        }

        // given
        final int nonDivisibleLottoPrice = Lotto.PRICE + 1;

        // when & then
        assertThatThrownBy(() -> lottoMachine.getLottos(nonDivisibleLottoPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoMachine.NON_DIVISIBLE_LOTTO_PRICE_ERROR_MESSAGE);
    }
}
