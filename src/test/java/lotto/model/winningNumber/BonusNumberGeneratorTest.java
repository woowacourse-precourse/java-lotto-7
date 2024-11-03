package lotto.model.winningNumber;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.exception.Exceptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberGeneratorTest {
    private final WinningNumber defaultWinningNumber = new WinningNumber(
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

    @Test
    @DisplayName("[success] 보너스 번호를 숫자로 변환하여 저장한다.")
    void transferBonusNumberToInteger() {
        String testNumber = "7";

        assertThatCode(() -> NumberGenerator.registerBonusNumber(testNumber, defaultWinningNumber))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("[fail] 보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    void fail_IfBonusNumberDuplicatesWinningNumber() {
        String duplicatedNumber = "1";

        assertThatIllegalArgumentException().isThrownBy(
                        () -> NumberGenerator.registerBonusNumber(duplicatedNumber, defaultWinningNumber))
                .withMessage(Exceptions.DUPLICATED_BONUS_NUMBER.getMessage());
    }
}
