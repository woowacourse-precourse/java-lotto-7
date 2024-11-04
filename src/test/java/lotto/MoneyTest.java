package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.message.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {990, 1503, 100032})
    @DisplayName("입력하 로또 구입금액이 1000원 단위가 아니면 예외가 발생한다.")
    void testPurchaseMoneyUnit(int input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_PURCHASE_MONEY_UNIT);
    }
}
