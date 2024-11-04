package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.validator.Validators;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorsTest {

    private final Validators validators = new Validators();

    @DisplayName("구매 금액 단위는 1000원이 아닌경우 예외처리한다.")
    @Test
    void 구매_단위_1000원_아니면_예외처리() {
        int price = 1100;

        Assertions.assertThatThrownBy(() -> validators.validatePurchaseAmountUnit(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 문자가 숫자가 아닌경우 예외처리한다.")
    @Test
    void 입력_문자_숫자_아니면_예외처리() {
        String number = "java1000";

        Assertions.assertThatThrownBy(() -> validators.validateNumericInput(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 문자에 쉼표를 제외한 문자가 숫자가 아닌경우 예외처리한다.")
    @Test
    void 입력_문자_쉼표_제외_숫자_아니면_예외처리() {
        String number = "java,1000";

        Assertions.assertThatThrownBy(() -> validators.validateSplitNumericInput(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 숫자 1~45내에 숫자가 아닌경우 예외처리한다.")
    @Test
    void 입력_숫자_1_45_범위_아니면_예외처리() {
        int number = 50;

        Assertions.assertThatThrownBy(() -> validators.validateNumberRange(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 로또 번호가 같은 경우 예외처리한다.")
    @Test
    void 보너스_번호_로또_번호_같으면_예외처리() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(numbers);
        int bonusNumber = 6;

        Assertions.assertThatThrownBy(() -> validators.validateBonusNotInWinningNumbers(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
