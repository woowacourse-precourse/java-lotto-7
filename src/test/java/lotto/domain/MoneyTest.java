package lotto.domain;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Nested
    @DisplayName("객체 생성 테스트" )
    class CreateMoneyTest {
        @Test
        void Money_객체는_구입금액을_가진다() {
            // given
            String purchaseAmount = "1000";
            Money money = new Money(purchaseAmount);

            // when
            int actual = money.getPrice();
            int expected = 1000;

            // then
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("예외 처리 테스트" )
    class MoneyExceptionTest {
        final int LOTTO_COST = 1000;

        @Test
        void 구입금액은_1000원에_나누어_떨어져야_한다() {
            // given
            String input = "4000";

            // when & then
            assertDoesNotThrow(() -> new Money(input));
        }

        @Test
        void 구입금액이_1000원에_나누어_떨어지지_않으면_예외를_발생한다() {
            // given
            String input = "1234";

            // when
            assertThatThrownBy(() -> new Money(input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage(format("[ERROR] 구입 금액은 %d원으로 나누어 떨어져야 합니다.", LOTTO_COST));
        }

        @Test
        void 구입금액이_음수이면_예외를_발생한다() {
            // given
            String input = "-1000";

            // when
            assertThatThrownBy(() -> new Money(input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage(format("[ERROR] 구입 금액은 %d이상의 정수여야 합니다.", LOTTO_COST));
        }

        @Test
        void 구입금액이_1000원_미만이면_예외를_발생한다() {
            // given
            String input = "500";

            // when
            assertThatThrownBy(() -> new Money(input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage(format("[ERROR] 구입 금액은 %d이상의 정수여야 합니다.", LOTTO_COST));
        }
    }
}
