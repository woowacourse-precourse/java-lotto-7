package lotto.model.winningNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.common.Exceptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {
    @Test
    @DisplayName("[success] 보너스 번호를 저장한다.")
    void saveBonusNumber() {
        BonusNumber bonusNumber = new BonusNumber(10);

        assertThat(bonusNumber.number()).isEqualTo(10);
    }

    @ParameterizedTest
    @DisplayName("[fail] 보너스 넘버가 1 이상 45 이하가 아니라면 예외가 발생한다.")
    @ValueSource(ints = {-1, 0, 46})
    void fail_IfBonusNumberOutOfRange(int testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new BonusNumber(testNumber))
                .withMessage(Exceptions.OUT_OF_LOTTERY_NUMBER_RANGE.getMessage());
    }
}
