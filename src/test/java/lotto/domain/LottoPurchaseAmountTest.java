package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "-1", ";", "0"})
    @DisplayName("로또 구입 금액이 양수가 아니면 예외가 발생한다.")
    void validatePurchaseAmount(String input) {
        assertThatThrownBy(() -> LottoPurchaseAmount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 양수만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1001", "100", "10", "5500"})
    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void validatePurchaseAmountUnit(String input) {
        assertThatThrownBy(() -> LottoPurchaseAmount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위로 입력할 수 있습니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"\n", "\t", "   ", "\r\n"})
    @DisplayName("로또 구입 금액이 비어있는 경우 예외가 발생한다.")
    void validatePurchaseAmountIsNotEmpty(String input) {
        assertThatThrownBy(() -> LottoPurchaseAmount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 비어있을 수 없습니다.");
    }

}