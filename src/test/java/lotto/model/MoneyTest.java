package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import view.exception.LottoException;
import view.validation.InputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static view.validation.InputErrorMessage.MONEY_EMPTY_MESSAGE;
import static view.validation.InputErrorMessage.MONEY_FORMAT_MESSAGE;

public class MoneyTest {

    @ParameterizedTest
    @DisplayName("구입금액은 숫자만 입력되어야 한다.")
    @ValueSource(strings = {"aa", ",,"})
    public void 구입금액_숫자로_이루어져야_한다(String money) {
        assertThatThrownBy(() -> InputValidator.validateMoney(money))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(MONEY_FORMAT_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("구입금액은 빈 값이 아니어야 한다.")
    @NullAndEmptySource
    public void 구입금액_빈값이_아니어야_한다(String money) {
        assertThatThrownBy(() -> InputValidator.validateMoney(money))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(MONEY_EMPTY_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("구입금액은 1000원 단위어야 한다.")
    @ValueSource(ints = {-100, 50, 1050})
    public void 구입금액_1000원_단위어야_한다(int money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(LottoException.class);
    }
}
