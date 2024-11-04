package lotto;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {
    // 금액 입력 테스트
    @DisplayName("금액 입력에 빈 값이 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "   "
    })
    void validateMoneyInput_빈_값_입력_테스트(String moneyInput) {
        assertThatThrownBy(() -> Validator.validateMoneyInput(moneyInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력에 숫자가 아닌 문자가 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "a ",
            "1000j",
            "천원",
            "]000"
    })
    void validateMoneyInput_숫자가_아닌_문자_입력_테스트(
            String moneyInput) {
        assertThatThrownBy(() -> Validator.validateMoneyInput(moneyInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력에 음수나 0이 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "0",
            "-2000"
    })
    void validateMoneyInput_양수가_아닌_숫자_입력_테스트(
            String moneyInput) {
        assertThatThrownBy(() -> Validator.validateMoneyInput(moneyInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력에 1000단위가 아닌 숫자가 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "500",
            "1700"
    })
    void validateMoneyInput_1000으로_나누어_떨어지지_않는_숫자_입력_테스트(
            String moneyInput) {
        assertThatThrownBy(() -> Validator.validateMoneyInput(moneyInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 당첨 번호 입력 테스트
    @DisplayName("당첨 번호에 빈 값이 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "   "
    })
    void validateIndividualLottoNumber_빈_값_입력_테스트(
            String number) {
        assertThatThrownBy(() -> Validator.validateIndividualLottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 숫자가 아닌 값이 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "일",
            "one",
            "-"
    })
    void validateIndividualLottoNumber_숫자가_아닌_문자_입력_테스트(
            String number) {
        assertThatThrownBy(() -> Validator.validateIndividualLottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 음수나 0이 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "-1",
            "0"
    })
    void validateIndividualLottoNumber_양수가_아닌_숫자_입력_테스트(
            String number) {
        assertThatThrownBy(() -> Validator.validateIndividualLottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력에 1~45 범위를 벗어나는 숫자가 들어올 경우 예외가 발생한다.")
    @Test
    void validateWinningNumbers_범위를_벗어나는_숫자_테스트() {
        assertThatThrownBy(() -> Validator.validateWinningNumbers(
                List.of(46,1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력에 1~45 범위를 벗어나지 않는 숫자가 들어올 경우 예외가 발생하지 않는다.")
    @Test
    void validateWinningNumbers_범위를_벗어나지_않는_숫자_테스트() {
        assertThatCode(() -> Validator.validateWinningNumbers(
                List.of(1,2,3,4,5,45)))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호가 5개인 경우 예외가 발생한다.")
    @Test
    void validateWinningNumbers_5개의_숫자가_입력된_경우_테스트() {
        assertThatThrownBy(() -> Validator.validateWinningNumbers(
                List.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개인 경우 예외가 발생하지 않는다.")
    @Test
    void validateWinningNumbers_6개의_숫자가_입력된_경우_테스트() {
        assertThatCode(() -> Validator.validateWinningNumbers(
                List.of(1,2,3,4,5,6)))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호가 7개인 경우 예외가 발생한다.")
    @Test
    void validateWinningNumbers_7개의_숫자가_입력된_경우_테스트() {
        assertThatThrownBy(() -> Validator.validateWinningNumbers(
                List.of(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복이 있을 경우 예외가 발생한다.")
    @Test
    void validateWinningNumbers_숫자에_중복이_있는_경우_테스트() {
        assertThatThrownBy(() -> Validator.validateWinningNumbers(
                List.of(1,1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 보너스 번호 입력 테스트
    private void assertBonusNumberValidation(
            String bonusNumber) {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int number = Integer.parseInt(bonusNumber);

        assertThatThrownBy(() -> Validator.validateBonusNumber(lotto, number))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("보너스 번호 입력에 1~45 범위를 벗어나는 숫자가 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "0",
            "46",
            "1000"
    })
    void validateBonusNumber_범위를_벗어나는_숫자_입력_테스트(
            String bonusNumber) {
        assertBonusNumberValidation(bonusNumber);
    }

    @DisplayName("보너스 번호 입력에 당첨 번호와 중복되는 값이 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "1",
            "2",
            "5",
            "6",
    })
    void validateBonusNumber_당첨_번호와_중복되는_숫자_입력_테스트(
            String bonusNumber) {
        assertBonusNumberValidation(bonusNumber);
    }
}