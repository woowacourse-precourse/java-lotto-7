package lotto.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void init() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1000히히", "120숫자", "1아2", "1?000", "1a00", "4a1b", "-1"})
    void 구입금액이_자연수가_아닐때_에러_반환(String amount) {
        Throwable throwable = catchThrowable(() -> {
            inputValidator.validatePurchaseAmount(amount);
        });
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 정수여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"100", "1", "10", "99", "999", "0"})
    void 구입금액이_1000보다_작을때_에러_반환(String amount) {
        assertThatThrownBy(() -> {
            inputValidator.validatePurchaseAmount(amount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"11100", "9990", "8800", "99100"})
    void 구입금액이_천원단위인지_검증한다(String amount) {
        assertThatThrownBy(() -> {
            inputValidator.validatePurchaseAmount(amount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "", "   "})
    void 당첨번호가_비어있을때_오류반환(String winningNumbers) {
        assertThatThrownBy(() -> {
            inputValidator.validateWinningNumbers(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호는 비어있을 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3:4:5:6", "1:2,3:4:5:6", "1,2,3,4:5,6", "1,2,3,4,5:6", "12,45,1,23,32!23",
            "1?,12,4?5,"})
    void 당첨번호의_구분자가_쉼표가_아닐때_에러_반환(String winningNumbers) {
        assertThatThrownBy(() -> {
            inputValidator.validateWinningNumbers(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호의 구분자는 쉼표여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2,3,4", "1,2,3,4,5", "12,45,1,23,32,23,29"})
    void 당첨번호가_6개가_아닐때_에러_반환(String winningNumbers) {
        assertThatThrownBy(() -> {
            inputValidator.validateWinningNumbers(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호는 6개여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,43,45", "1,5,2,3,43,46"})
    void 당첨번호가_1미만_45초과일때_에러_반환(String number) {
        assertThatThrownBy(() -> {
            inputValidator.validateWinningNumbers(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호는 1이상 45이하여야 합니다.");
    }

}