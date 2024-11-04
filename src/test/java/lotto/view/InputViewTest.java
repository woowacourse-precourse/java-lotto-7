package lotto.view;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @DisplayName("구입금액 입력 문자 포함 예외")
    @Test
    void 구입금액_입력_문자_포함() {
        String amount = "abcd";
        assertThatThrownBy(() -> InputView.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 숫자로 입력해야 합니다.");
    }

    @DisplayName("구입금액 입력 1000원 단위 테스트")
    @Test
    void 구입금액_입력_1000원_단위() {
        String amount = "2500";
        assertThatThrownBy(() -> InputView.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
    }

    @DisplayName("당첨번호 공백 포함 시 예외발생")
    @Test
    void 당첨번호_공백_포함_예외발생() {
        String simulatedInput = "1, 2, 3, 4, 5, 6";
        assertThatThrownBy(() -> InputView.validateWinningNumbers(simulatedInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 숫자와 쉼표로만 입력해야 합니다.");
    }

    @DisplayName("당첨번호 특수문자 포함 시 예외발생")
    @Test
    void 당첨번호_특수문자_포함_예외발생() {
        String simulatedInput = "1,2,3,@4,5,6";
        assertThatThrownBy(() -> InputView.validateWinningNumbers(simulatedInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 숫자와 쉼표로만 입력해야 합니다.");
    }

    @DisplayName("보너스번호 공백 입력")
    @Test
    void 보너스번호_공백_입력() {
        String bonusNumber = " ";
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> InputView.validateBonusNumber(bonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
    }

    @DisplayName("보너스번호 문자 입력")
    @Test
    void 보너스번호_문자_입력() {
        String bonusNumber = "@";
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> InputView.validateBonusNumber(bonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
    }

    @DisplayName("보너스번호 1 ~ 45 범위에서 벗어난 입력")
    @Test
    void 보너스번호_범위_밖_입력() {
        String bonusNumber = "46";
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> InputView.validateBonusNumber(bonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스번호 중복 입력")
    @Test
    void 보너스번호_중복_입력() {
        String bonusNumber = "6";
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> InputView.validateBonusNumber(bonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
    }
}
