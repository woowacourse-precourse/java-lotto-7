package lotto.service;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.common.Exceptions;
import lotto.dto.WinningNumbersDto;
import lotto.model.winningNumber.MainNumber;
import lotto.service.winningNumber.DefaultNumberGenerator;
import lotto.service.winningNumber.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DefaultBonusNumberGeneratorTest {
    private final NumberGenerator numberGenerator = new DefaultNumberGenerator();
    private final MainNumber defaultMainNumber = new MainNumber(
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

    @Test
    @DisplayName("[success] 보너스 번호를 숫자로 변환하여 저장한다.")
    void transferBonusNumberToInteger() {
        String testNumber = "7";
        WinningNumbersDto winningNumbersDto = new WinningNumbersDto(testNumber, defaultMainNumber);

        assertThatCode(() -> numberGenerator.registerBonusNumber(winningNumbersDto))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("[fail] 보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    void fail_IfBonusNumberDuplicatesWinningNumber() {
        String duplicatedNumber = "1";
        WinningNumbersDto winningNumbersDto = new WinningNumbersDto(duplicatedNumber, defaultMainNumber);

        assertThatIllegalArgumentException().isThrownBy(
                        () -> numberGenerator.registerBonusNumber(winningNumbersDto))
                .withMessage(Exceptions.DUPLICATED_BONUS_NUMBER.getMessage());
    }
}
