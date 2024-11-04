package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static lotto.converter.StringToIntegerSetConverter.convertToTreeSet;
import static lotto.validator.InputWinningNumbersValidator.validateDuplicateWinningNumbers;
import static lotto.validator.InputWinningNumbersValidator.validateWinningNumbers;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputWinningNumbersValidatorTest {


    @DisplayName("로또 번호를 7개 이상 입력하면 예외가 발생한다.")
    @Test
    void validateWinningNumbersUpperSevenNumbers() {

        // given
        String winningNumbersInput = "1,2,3,4,5,6,7";

        // when then
        assertThatThrownBy(() -> validateWinningNumbers(winningNumbersInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 번호는 쉼표(,)를 기준으로, 6개 입력해 주세요.");
    }

    @DisplayName("쉼표 이외의 구분자를 입력하면 예외가 발생한다.")
    @Test
    void validateWinningNumbersWithoutComma() {

        // given
        String winningNumbersInput = "1;2;3;4;5;6";

        // when then
        assertThatThrownBy(() -> validateWinningNumbers(winningNumbersInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 번호는 쉼표(,)를 기준으로, 6개 입력해 주세요.");
    }

    @DisplayName("문자를 입력하면 예외가 발생한다.")
    @Test
    void validateWinningNumbersWithCharacter() {

        // given
        String winningNumbersInput = "1,2,3,4,5,d";

        // when then
        assertThatThrownBy(() -> validateWinningNumbers(winningNumbersInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 번호는 쉼표(,)를 기준으로, 6개 입력해 주세요.");
    }

    @DisplayName("1~45 사이의 숫자를 입력하지 않을 경우 예외가 발생한다.")
    @Test
    void validateWinningNumbersWithInvalidNumber() {

        // given
        String winningNumbersInput = "1,2,3,4,5,47";

        // when then
        assertThatThrownBy(() -> validateWinningNumbers(winningNumbersInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("중복된 숫자를 입력할 경우 예외가 발생한다.")
    @Test
    void validateWinningNumbersWithDuplicateWinningNumbers() {

        // given
        String winningNumbersInput = "1,2,3,4,5,5";
        Set<Integer> winningNumbers = convertToTreeSet(winningNumbersInput);

        // when then
        assertThatThrownBy(() -> validateDuplicateWinningNumbers(winningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 번호는 중복일 수 없습니다.");
    }


}