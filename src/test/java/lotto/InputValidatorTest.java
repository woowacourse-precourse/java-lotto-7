package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatNoException;
import java.util.Arrays;
import java.util.List;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {" "})
    void 빈_입력은_예외가_발생한다(String purchasePrice) {
        assertThatThrownBy(() -> InputValidator.validatePrice(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어 있을 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "5000", "10000"})
    void 유효한_구입금액은_예외가_발생하지_않는다(String purchasePrice) {
        assertThatNoException().isThrownBy(() -> InputValidator.validatePrice(purchasePrice));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1000", "1500"})
    void 단위가_유효하지_않은_구입금액이면_예외가_발생한다(String purchasePrice) {
        assertThatThrownBy(() -> InputValidator.validatePrice(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", ";;"})
    void 유효하지_않은_구입금액이면_예외가_발생한다(String purchasePrice) {
        assertThatThrownBy(() -> InputValidator.validatePrice(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은(는) 숫자로 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "10,20,30,40,41,42"})
    void 유효한_당첨번호_형식이면_예외가_발생하지_않는다(String winningNumInput) {
        assertThatNoException().isThrownBy(() -> InputValidator.validateWinningNum(winningNumInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2,3,4,5,abc", "1,2,3,4,5,6,7"})
    void 유효하지_않은_당첨번호_형식이면_예외가_발생한다(String winningNumInput) {
        assertThatThrownBy(() -> InputValidator.validateWinningNum(winningNumInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 쉼표로 구분된 6개의 숫자로 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "7", "45"})
    void 유효한_보너스번호이면_예외가_발생하지_않는다(String bonusNumInput) {
        assertThatNoException().isThrownBy(() -> InputValidator.validateBonusNum(bonusNumInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"50", "0"})
    void 유효하지_않은_보너스번호이면_예외가_발생한다_숫자(String bonusNumInput) {
        assertThatThrownBy(() -> InputValidator.validateBonusNum(bonusNumInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1과 45 사이의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "de"})
    void 유효하지_않은_보너스번호이면_예외가_발생한다_문자(String bonusNumInput) {
        assertThatThrownBy(() -> InputValidator.validateBonusNum(bonusNumInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호은(는) 숫자로 입력해야 합니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "7, '1,2,3,4,5,6'",
            "45, '10,20,30,40,41,42'"
    })
    void 보너스번호가_당첨번호와_중복되지_않으면_예외가_발생하지_않는다(int bonusNum, String winningNumbersInput) {
        List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                .map(Integer::parseInt)
                .toList();
        assertThatNoException().isThrownBy(() -> InputValidator.validateBonusNumUnique(bonusNum, winningNumbers));
    }

    @ParameterizedTest
    @CsvSource({
            "3, '1,2,3,4,5,6'",
            "20, '10,20,30,40,41,42'"
    })
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다(int bonusNum, String winningNumbersInput) {
        List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                .map(Integer::parseInt)
                .toList();

        assertThatThrownBy(() -> InputValidator.validateBonusNumUnique(bonusNum, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}
