package lotto;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {
    // 금액 입력 테스트
    private void assertMoneyInputValidation(String moneyInput, boolean isExceptionExpected) {
        if (isExceptionExpected) {
            assertThatThrownBy(() -> Validator.validateMoneyInput(moneyInput))
                    .isInstanceOf(IllegalArgumentException.class);
        } else {
            assertThatCode(() -> Validator.validateMoneyInput(moneyInput))
                    .doesNotThrowAnyException();
        }
    }

    @DisplayName("금액 입력에 빈 값이 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "'' : true",
            "'   ' : true",
            "1000 : false"
    }, delimiter = ':')
    void validateMoneyInput_빈_값_입력_테스트(
            String moneyInput, boolean isExceptionTriggerValue) {
        assertMoneyInputValidation(moneyInput, isExceptionTriggerValue);
    }

    @DisplayName("금액 입력에 숫자가 아닌 문자가 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "a : true",
            "1000j : true",
            "천원 : true",
            "]000 : true",
            "2000 : false"
    }, delimiter = ':')
    void validateMoneyInput_숫자가_아닌_문자_입력_테스트(
            String moneyInput, boolean isExceptionTriggerValue) {
        assertMoneyInputValidation(moneyInput, isExceptionTriggerValue);
    }

    @DisplayName("금액 입력에 음수나 0이 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "0 : true",
            "-2000 : true",
            "1000 : false"
    }, delimiter = ':')
    void validateMoneyInput_양수가_아닌_숫자_입력_테스트(
            String moneyInput, boolean isExceptionTriggerValue) {
        assertMoneyInputValidation(moneyInput, isExceptionTriggerValue);
    }

    @DisplayName("금액 입력에 1000단위가 아닌 숫자가 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "500 : true",
            "1700 : true",
            "3000 : false"
    }, delimiter = ':')
    void validateMoneyInput_1000으로_나누어_떨어지지_않는_숫자_입력_테스트(
            String moneyInput, boolean isExceptionTriggerValue) {
        assertMoneyInputValidation(moneyInput, isExceptionTriggerValue);
    }

    // 당첨 번호 입력 테스트
    private void assertWinningNumberValidation(String number, boolean isExceptionExpected) {
        if (isExceptionExpected) {
            assertThatThrownBy(() -> Validator.validateLottoNumber(number))
                    .isInstanceOf(IllegalArgumentException.class);
        } else {
            assertThatCode(() -> Validator.validateLottoNumber(number))
                    .doesNotThrowAnyException();
        }
    }

    @DisplayName("당첨 번호에 빈 값이 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "'' : true",
            "'   ' : true",
            "1 : false"
    }, delimiter = ':')
    void validateLottoNumber_빈_값_입력_테스트(String number, boolean isExceptionTriggerValue) {
        assertWinningNumberValidation(number, isExceptionTriggerValue);
    }

    @DisplayName("당첨 번호에 숫자가 아닌 값이 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "일 : true",
            "one : true",
            "- : true",
            "1 : false"
    }, delimiter = ':')
    void validateLottoNumber_숫자가_아닌_문자_입력_테스트(String number, boolean isExceptionTriggerValue) {
        assertWinningNumberValidation(number, isExceptionTriggerValue);
    }

    @DisplayName("당첨 번호에 음수나 0이 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "-1 : true",
            "0 : true",
            "1 : false"
    }, delimiter = ':')
    void validateLottoNumber_양수가_아닌_숫자_입력_테스트(String number, boolean isExceptionTriggerValue) {
        assertWinningNumberValidation(number, isExceptionTriggerValue);
    }

    @DisplayName("당첨 번호 입력에 1~45 범위를 벗어나는 숫자가 들어올 경우 예외가 발생한다.")
    @Test
    void validateWinningNumbers_범위를_벗어나는_숫자_테스트() {
        assertThatThrownBy(() -> Validator.validateWinningNumbers(List.of(46,1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력에 1~45 범위를 벗어나지 않는 숫자가 들어올 경우 예외가 발생하지 않는다.")
    @Test
    void validateWinningNumbers_범위를_벗어나지_않는_숫자_테스트() {
        assertThatCode(() -> Validator.validateWinningNumbers(List.of(1,2,3,4,5,45)))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호가 5개인 경우 예외가 발생한다.")
    @Test
    void validateWinningNumbers_5개의_숫자가_입력된_경우_테스트() {
        assertThatThrownBy(() -> Validator.validateWinningNumbers(List.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개인 경우 예외가 발생하지 않는다.")
    @Test
    void validateWinningNumbers_6개의_숫자가_입력된_경우_테스트() {
        assertThatCode(() -> Validator.validateWinningNumbers(List.of(1,2,3,4,5,6)))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호가 7개인 경우 예외가 발생한다.")
    @Test
    void validateWinningNumbers_7개의_숫자가_입력된_경우_테스트() {
        assertThatThrownBy(() -> Validator.validateWinningNumbers(List.of(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복이 있을 경우 예외가 발생한다.")
    @Test
    void validateWinningNumbers_숫자에_중복이_있는_경우_테스트() {
        assertThatThrownBy(() -> Validator.validateWinningNumbers(List.of(1,1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 보너스 번호 입력 테스트
    private void assertBonusNumberValidation(String bonusNumber, boolean isExceptionExpected) {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int number = Integer.parseInt(bonusNumber);

        if (isExceptionExpected) {
            assertThatThrownBy(() -> Validator.validateBonusNumber(lotto, number))
                    .isInstanceOf(IllegalArgumentException.class);
        } else {
            assertThatCode(() -> Validator.validateBonusNumber(lotto, number))
                    .doesNotThrowAnyException();
        }
    }

    @DisplayName("보너스 번호 입력에 1~45 범위를 벗어나는 숫자가 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "0 : true",
            "46 : true",
            "7 : false"
    }, delimiter = ':')
    void validateBonusNumber_범위를_벗어나는_숫자_입력_테스트(String bonusNumber, boolean isExceptionTriggerValue) {
        assertBonusNumberValidation(bonusNumber, isExceptionTriggerValue);
    }

    @DisplayName("보너스 번호 입력에 당첨 번호와 중복되는 값이 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1 : true",
            "2 : true",
            "6 : true",
            "7 : false",
    }, delimiter = ':')
    void validateBonusNumber_당첨_번호와_중복되는_숫자_입력_테스트(String bonusNumber, boolean isExceptionTriggerValue) {
        assertBonusNumberValidation(bonusNumber, isExceptionTriggerValue);
    }
}