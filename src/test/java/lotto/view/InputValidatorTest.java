package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.common.validator.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    private InputValidator validator;

    @BeforeEach
    void setUp() {
        validator = new InputValidator();
    }

    @Test
    void 빈_입력_검증() {
        assertThat(validator.isEmptyInput("")).isTrue();
        assertThat(validator.isEmptyInput(null)).isTrue();
        assertThat(validator.isEmptyInput("1")).isFalse();
    }

    @Test
    void 숫자_형식_검증() {
        assertThat(validator.isNumeric("123456789")).isTrue();
        assertThat(validator.isNumeric("7000")).isTrue();
        assertThat(validator.isNumeric("abc")).isFalse();
        assertThat(validator.isNumeric("abc123")).isFalse();
        assertThat(validator.isNumeric("1.2345")).isFalse();
        assertThat(validator.isNumeric("-12345")).isFalse();
        assertThat(validator.isNumeric("-12.345")).isFalse();
    }

    @Test
    void 정수_범위_검증() {
        assertThat(validator.isIntegerRange("0")).isTrue();
        assertThat(validator.isIntegerRange("2147483647")).isTrue();
        assertThat(validator.isIntegerRange("2147483648")).isFalse();
        assertThat(validator.isIntegerRange("-2147483648")).isTrue();
        assertThat(validator.isIntegerRange("-2147483649")).isFalse();
    }

    @Test
    void 구매_금액이_1000원_단위인지_검증() {
        assertThat(validator.isMultipleOfUnitPrice("1000")).isTrue();
        assertThat(validator.isMultipleOfUnitPrice("10000")).isTrue();
        assertThat(validator.isMultipleOfUnitPrice("100000")).isTrue();
        assertThat(validator.isMultipleOfUnitPrice("7000")).isTrue();
        assertThat(validator.isMultipleOfUnitPrice("100001")).isFalse();
        assertThat(validator.isMultipleOfUnitPrice("10001")).isFalse();
        assertThat(validator.isMultipleOfUnitPrice("1001")).isFalse();
    }

    @Test
    void 입력값에_공백있는지_검증() {
        assertThat(validator.containsWhiteSpace(" 7000")).isTrue();
        assertThat(validator.containsWhiteSpace("7000 ")).isTrue();
        assertThat(validator.containsWhiteSpace(" 7000 ")).isTrue();
        assertThat(validator.containsWhiteSpace("7 000")).isTrue();
        assertThat(validator.containsWhiteSpace("7000")).isFalse();
    }

    @Test
    void 로또_범위_번호인지_검증() {
        assertThat(validator.isNumberInLottoRange("1")).isTrue();
        assertThat(validator.isNumberInLottoRange("45")).isTrue();
        assertThat(validator.isNumberInLottoRange("0")).isFalse();
        assertThat(validator.isNumberInLottoRange("46")).isFalse();
        assertThat(validator.isNumberInLottoRange("-1")).isFalse();
    }
}
