package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.controller.error.ErrorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("금액이 단위 금액에 맞는 값이라면 생성된다.")
        void createMoney() {
            // given
            int amount = 3000;

            // when
            Money money = new Money(amount);

            // then
            assertThat(money.getAmount()).isEqualTo(amount);
        }

        @Test
        @DisplayName("문자열로 주어진 금액으로도 생성된다.")
        void createMoneyFromString() {
            // given
            String amount = "5000";

            // when
            Money money = Money.fromString(amount);

            // then
            assertThat(money.getAmount()).isEqualTo(5000);
        }

        @Test
        @DisplayName("로또 개수로부터도 생성된다.")
        void createMoneyFromLottoCount() {
            // given
            int lottoCount = 4;

            // when
            Money money = Money.fromLottoCount(lottoCount);

            // then
            assertThat(money.getAmount()).isEqualTo(Money.UNIT_AMOUNT * lottoCount);
        }
    }

    @Nested
    @DisplayName("유효하지 않은 경우")
    class InvalidCases {

        @Test
        @DisplayName("금액이 음수일 경우 예외가 발생한다.")
        void amountNegativeAmount() {
            // given
            int negativeAmount = -1000;

            // when & then
            assertThatThrownBy(() -> new Money(negativeAmount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorType.NEGATIVE_AMOUNT.getMessage());
        }

        @Test
        @DisplayName("금액이 단위 금액의 배수가 아닐 경우 예외가 발생한다.")
        void amountInvalidUnit() {
            // given
            int invalidAmount = 1500;

            // when & then
            assertThatThrownBy(() -> new Money(invalidAmount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorType.INVALID_UNIT_AMOUNT.getMessage());
        }

        @Test
        @DisplayName("문자열로 주어진 금액이 숫자가 아닌 경우 예외가 발생한다.")
        void amountInvalidFormat() {
            // given
            String invalidAmount = "abc";

            // when & then
            assertThatThrownBy(() -> Money.fromString(invalidAmount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorType.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
