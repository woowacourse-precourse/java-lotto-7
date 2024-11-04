package lotto.vaildate;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateTest {

    @DisplayName("정상적인 구매 가격을 입력시")
    @Test
    void validPurchasePrice() {
        assertThat(Validate.purchasePriceValidate("8000")).isEqualTo(8);
    }

    @DisplayName("숫자 형식이 아닌 문자열 입력 시 예외 발생")
    @Test
    void nonNumericInput() {
        assertThatThrownBy(() -> Validate.purchasePriceValidate("천원"))
                .hasMessage(ErrorMessage.ONLY_NUMBER_INPUT_ALLOWED)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값이 비었을 때 예외 발생")
    @Test
    void emptyInput() {
        assertThatThrownBy(() -> Validate.purchasePriceValidate(""))
                .hasMessage(ErrorMessage.INPUT_PROMPT)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 형식이 아닌 문자열 입력 시 예외 발생")
    @Test
    void nonNumericParse() {
        assertThatThrownBy(() -> Validate.parseIntegerValidate("이천원"))
                .hasMessage(ErrorMessage.ONLY_NUMBER_INPUT_ALLOWED)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 당첨 번호 입력 시")
    @Test
    void validWinningNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(Validate.winningNumbersValidate(winningNumbers)).isEqualTo(winningNumbers);
    }

    @DisplayName("당첨 번호가 부족할 때 예외 발생")
    @Test
    void incompleteWinningNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> Validate.winningNumbersValidate(winningNumbers))
                .hasMessage(ErrorMessage.INVALID_NUMBER_COUNT)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어난 당첨 번호 입력 시 예외 발생")
    @Test
    void outOfRangeWinningNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 45, 61, 5);
        assertThatThrownBy(() -> Validate.winningNumbersValidate(winningNumbers))
                .hasMessage(ErrorMessage.NUMBER_ONE_TO_FORTY_FIVE)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 당첨 번호 입력 시 예외 발생")
    @Test
    void duplicateWinningNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 1, 3, 45, 32, 5);
        assertThatThrownBy(() -> Validate.winningNumbersValidate(winningNumbers))
                .hasMessage(ErrorMessage.UNIQUE_NUMBER)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 보너스 번호 입력 시")
    @Test
    void validBonusNumber() {
        assertThat(Validate.parseIntegerBonusValidate("15", Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(15);
    }

    @DisplayName("당첨 번호와 중복된 보너스 번호 입력 시 예외 발생")
    @Test
    void duplicateBonusNumber() {
        assertThatThrownBy(() -> Validate.parseIntegerBonusValidate("1", Arrays.asList(1, 2, 3, 4, 5, 6)))
                .hasMessage(ErrorMessage.DUPLICATE_BONUS_NUMBER)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 입력하지 않았을 때 예외 발생")
    @Test
    void emptyBonusNumber() {
        assertThatThrownBy(() -> Validate.parseIntegerBonusValidate("", Arrays.asList(1, 2, 3, 4, 5, 6)))
                .hasMessage(ErrorMessage.INPUT_PROMPT)
                .isInstanceOf(IllegalArgumentException.class);
    }

}