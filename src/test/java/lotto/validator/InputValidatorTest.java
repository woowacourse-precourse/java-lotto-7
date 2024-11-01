package lotto.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
            inputValidator.purchaseAmountValidate(amount);
        });
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 정수여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"100", "1", "10", "99", "999", "0"})
    void 구입금액이_1000보다_작을때_에러_반환(String amount) {
        assertThatThrownBy(() -> {
            inputValidator.purchaseAmountValidate(amount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"11100", "9990", "8800", "99100"})
    void 구입금액이_천원단위인지_검증한다(String amount) {
        assertThatThrownBy(() -> {
            inputValidator.purchaseAmountValidate(amount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위어야 합니다.");
    }
}