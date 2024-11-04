package lotto.view;

import java.util.List;
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

    @DisplayName("당첨 번호가 쉼표로 구분되지 않으면 예외가 발생한다")
    @Test
    void validateWinningNumbersFormat() {
        assertThatThrownBy(() -> {
            new LottoInputView().validateWinningNumbers("1 2 3 4 5 6");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 쉼표(,)로 구분해야 합니다.");
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다")
    @Test
    void validateWinningNumbersCount() {
        assertThatThrownBy(() -> {
            new LottoInputView().validateWinningNumbers("1,2,3,4,5");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @DisplayName("당첨 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다")
    @Test
    void validateWinningNumbersRange() {
        assertThatThrownBy(() -> {
            new LottoInputView().validateWinningNumbers("0,1,2,3,4,5");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        assertThatThrownBy(() -> {
            new LottoInputView().validateWinningNumbers("1,2,3,4,5,46");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @Test
    void validateWinningNumbersDuplicate() {
        assertThatThrownBy(() -> {
            new LottoInputView().validateWinningNumbers("1,2,3,4,5,5");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    @Test
    void validateBonusNumberDuplicate() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> {
            new LottoInputView().validateBonusNumber("1", winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}