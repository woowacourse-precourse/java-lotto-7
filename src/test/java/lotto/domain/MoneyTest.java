package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.exception.CustomErrorCode;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
class MoneyTest {

    @Nested
    class 예외_처리_테스트를_진행한다 {

        @ParameterizedTest
        @NullAndEmptySource
        void 공백이나_빈_값이_입력된다(String money) {
            // when & then
            assertThatThrownBy(() -> Money.from(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CustomErrorCode.EXCEPTION_EMPTY_MONEY.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"-1500", "a100", "1000a", "-10-10", "100/0", "0", "0000"})
        void 음수_또는_0_또는_문자가_포함된_돈을_입력받는다(String money) {
            // when & then
            assertThatThrownBy(() -> Money.from(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CustomErrorCode.EXCEPTION_NOT_NUMBER_MONEY.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1500", "2500", "10500"})
        void 천_원_단위가_아닌_돈을_입력받는다(String money) {
            // when & then
            assertThatThrownBy(() -> Money.from(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CustomErrorCode.EXCEPTION_NOT_THOUSAND_MONEY.getMessage());
        }
    }

    @ParameterizedTest
    @CsvSource({"10000, 10", "1000, 1", "5000, 5"})
    void 살_수_있는_로또_수를_계산한다(String money, int lottoCount) {
        // given
        Money validMoney = Money.from(money);

        // when
        int lottoMoney = validMoney.buyLottos();

        // then
        assertThat(lottoMoney).isEqualTo(lottoCount);
    }
}
