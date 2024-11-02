package lotto.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.message.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class MoneyInputHandlerTest {

    private final MoneyInputHandler moneyInputHandler = new MoneyInputHandler();

    @DisplayName("구입 금액을 성공적으로 받는 경우")
    @Test
    void 구입_금액_입력_성공() {
        // given
        String inputNum = "5238000";

        // when
        long lottoCount = moneyInputHandler.getLottoCount(inputNum);

        // then
        assertThat(lottoCount).isEqualTo(5238L);
    }

    @DisplayName("구입 금액은 0도 가능하다")
    @Test
    void 구입_금액_경계값검사() {
        // given
        String zero = "0";

        // when
        long lottoCount = moneyInputHandler.getLottoCount(zero);

        // then
        assertThat(lottoCount).isEqualTo(0);
    }

    @DisplayName("구입 금액은 숫자로만 이루어져야 한다.")
    @Test
    void 구입_금액_정수조건() {
        // given
        String nonIntegerInput = "5238,000";

        // when & then
        assertThatCode(() -> moneyInputHandler.convertToLong(nonIntegerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NON_INTEGER_PURCHASE_AMOUNT.getMessage());
    }

    @DisplayName("구입 금액은 0이상의 정수여야 한다.")
    @Test
    void 구입_금액_양수조건() {
        // given
        long negativeLong = -1L;

        // when & then
        assertThatCode(() -> moneyInputHandler.validateMoney(negativeLong))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NEGATIVE_PURCHASE_AMOUNT.getMessage());
    }


    @DisplayName("구입 금액은 1000으로 나누어 떨어져야 한다.")
    @Test
    void 구입_금액_1000의_배수() {
        // given
        long inputNum = 123654687;

        // when & then
        assertThatCode(() -> moneyInputHandler.validateMoney(inputNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
    }

}
