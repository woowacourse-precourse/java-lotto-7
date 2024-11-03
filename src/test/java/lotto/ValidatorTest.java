package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ValidatorTest {
    @Test
    void 금액_유효성_테스트() {
        String dummyInput = "1000";

        Validator.validateAmount(dummyInput);
    }

    @Test
    void 금액_유효성_테스트_예외_문자() {
        String dummyInput = "1000.";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Validator.validateAmount(dummyInput);
                });
    }

    @Test
    void 금액_유효성_테스트_예외_단위() {
        String dummyInput = "1001";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Validator.validateAmount(dummyInput);
                });
    }

    @Test
    void 금액_유효성_테스트_예외_범위() {
        String dummyInput = "100000";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Validator.validateAmount(dummyInput);
                });
    }

    @Test
    void 숫자_유효성_테스트() {
        String dummyInput = "1,2,3,4,5,6";

        Validator.validateUserPickNumbers(dummyInput);
    }

    @Test
    void 숫자_유효성_테스트_예외_문자() {
        String dummyInput = "6,5,4,a,2,1";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Validator.validateUserPickNumbers(dummyInput);
                });
    }

    @Test
    void 숫자_유효성_테스트_예외_구분자() {
        String dummyInput = "6,5,4.3,2,1";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Validator.validateUserPickNumbers(dummyInput);
                });
    }

    @Test
    void 숫자_유효성_테스트_예외_범위1() {
        String dummyInput = "6,5,4,50,2,1";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Validator.validateUserPickNumbers(dummyInput);
                });
    }

    @Test
    void 숫자_유효성_테스트_예외_범위2() {
        String dummyInput = "6,5,4,3,2,0";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Validator.validateUserPickNumbers(dummyInput);
                });
    }

    @Test
    void 숫자_유효성_테스트_예외_중복() {
        String dummyInput = "6,5,4,2,2,1";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Validator.validateUserPickNumbers(dummyInput);
                });
    }

    @Test
    void 숫자_유효성_테스트_예외_개수() {
        String dummyInput = "7,6,5,4,3,2,1";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Validator.validateUserPickNumbers(dummyInput);
                });
    }

    @Test
    void 숫자_유효성_테스트_예외_형식() {
        String dummyInput = "7,6,5,4,3,2,1,";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Validator.validateUserPickNumbers(dummyInput);
                });
    }
}