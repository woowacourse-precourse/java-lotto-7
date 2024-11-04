package lotto.validator;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"-1", "jewan", "1 2", "1234"})
    void 로또_구입_금액_예외_발생(String inputString) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoValidator.validateInputMoney(inputString));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {",", "1,a,b,4,5,6", "1,2,3,4,5", "1,1,3,3,5,6", "0,2,3,4,5,6", "0,2,3,4,5,46"})
    void 로또_당첨_번호_예외_발생(String inputString) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validateWinningNumbers(inputString));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {",", "1", "-1", "0", "46"})
    void 로또_보너스_번호_예외_발생(String inputString) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validateBonusNumber(inputString, winningNumbers));
    }
}
