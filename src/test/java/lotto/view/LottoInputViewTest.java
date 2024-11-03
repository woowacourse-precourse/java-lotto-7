package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoInputViewTest {

    @DisplayName("로또 구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다")
    @Test
    void validateMoneyNotThousandUnit() {
        assertThatThrownBy(() -> {
            new LottoInputView().validateMoney("1500");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
    }

    @DisplayName("로또 구입 금액이 숫자가 아닐 경우 예외가 발생한다")
    @Test
    void validateMoneyNotNumber() {
        assertThatThrownBy(() -> {
            new LottoInputView().validateMoney("abc");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자를 입력해 주세요.");
    }

    @DisplayName("로또 구입 금액이 0원 이하일 경우 예외가 발생한다")
    @Test
    void validateMoneyNotPositive() {
        assertThatThrownBy(() -> {
            new LottoInputView().validateMoney("0");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 0보다 커야 합니다.");
    }
}