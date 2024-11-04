package lotto.validator;


import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoInputValidatorTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private final LottoInputValidator validator = new LottoInputValidator();

    // 금액 검증 테스트
    @Test
    @DisplayName("금액이 비어있는 경우 예외 발생")
    void validateMoney_Blank_Test() {
        validateMoneyTest("");
    }

    @Test
    @DisplayName("금액이 음수인 경우 예외 발생")
    void validateMoney_Negative_Test() {
        validateMoneyTest("-1000");
    }

    @Test
    @DisplayName("금액이 숫자가 아닌 경우 예외 발생")
    void validateMoney_NotNumber_Test() {
        validateMoneyTest("abc");
    }
    
    @Test
    @DisplayName("금액이 1,000원 미만인 경우 예외 발생")
    void validateMoney_Under_1_000_Test() {
        validateMoneyTest("999");
    }
    
    @Test
    @DisplayName("금액이 1,000,000원 초과인 경우 예외 발생")
    void validateMoney_Over_1_000_000_Test() {
        validateMoneyTest("1,000,001");
    }

    // 당첨 번호 검증 테스트
    @Test
    @DisplayName("당첨 번호가 비어있는 경우 예외 발생")
    void validateWinnerNumbers_Blank_Test() {
        validateWinnerNumbersTest("");
    }

    @Test
    @DisplayName("당첨 번호가 공백으로 구분된 경우 예외 발생")
    void validateWinnerNumbers_NotSeparatedByComma_Test() {
        validateWinnerNumbersTest("1 2 3 4 5 6");
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닌 경우 예외 발생")
    void validateWinnerNumbers_SizeNot6_Test() {
        validateWinnerNumbersTest("1,2,3,4,5");
    }

    @Test
    @DisplayName("당첨 번호가 1~45 범위를 벗어나는 경우 예외 발생")
    void validateWinnerNumbers_OutOfRange_Test() {
        validateWinnerNumbersTest("1,2,3,4,5,46");
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있는 경우 예외 발생")
    void validateWinnerNumbers_Duplicated_Test() {
        validateWinnerNumbersTest("1,2,3,4,4,5");
    }

    // 보너스 번호 검증 테스트
    @Test
    @DisplayName("보너스 번호가 비어있는 경우 예외 발생")
    void validateBonusNumber_Blank_Test() {
        validateBonusNumberTest(List.of(1, 2, 3, 4, 5, 6), "");
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외 발생")
    void validateBonusNumber_NotNumber_Test() {
        validateBonusNumberTest(List.of(1, 2, 3, 4, 5, 6), "abc");
    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위를 벗어나는 경우 예외 발생")
    void validateBonusNumber_OutOfRange_Test() {
        validateBonusNumberTest(List.of(1, 2, 3, 4, 5, 6), "46");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우 예외 발생")
    void validateBonusNumber_Duplicated_Test() {
        validateBonusNumberTest(List.of(1, 2, 3, 4, 5, 6), "1");
    }

    private void validateMoneyTest(String input) {
        assertThatThrownBy(() -> validator.validateMoney(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    private void validateWinnerNumbersTest(String input) {
        assertThatThrownBy(() -> validator.validateWinnerLottoNumbers(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    private void validateBonusNumberTest(List<Integer> winnerNumbers, String bonusNumber) {
        assertThatThrownBy(() -> validator.validateBonusNumber(winnerNumbers, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }
}