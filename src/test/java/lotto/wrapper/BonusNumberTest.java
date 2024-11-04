package lotto.wrapper;

import lotto.exception.ErrorMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    @DisplayName("보너스 번호는 숫자여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 보너스_번호는_숫자여야_한다(int inputNumber) {
        BonusNumber bonusNumber = BonusNumber.of(inputNumber);

        Assertions.assertThat(bonusNumber).isInstanceOf(BonusNumber.class);
    }

    @DisplayName("보너스 번호는 1부터 45 사이가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스_번호는_1부터_45_사이여야_한다(int inputNumber) {
        Assertions.assertThatThrownBy(() -> BonusNumber.of(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_LOTTO_RANGE.getMessage());
    }

}
