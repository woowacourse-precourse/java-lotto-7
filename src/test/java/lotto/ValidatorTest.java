package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ValidatorTest {
    @Test
    void 유효성_테스트1() {
        String dummyInput = "1000";

        Validator.validateAmount(dummyInput);
    }

    @Test
    void 예외_테스트1() {
        String dummyInput = "1000.";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Validator.validateAmount(dummyInput);
                });
    }

    @Test
    void 예외_테스트2() {
        String dummyInput = "1001";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Validator.validateAmount(dummyInput);
                });
    }

    @Test
    void 예외_테스트3() {
        String dummyInput = "100000";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Validator.validateAmount(dummyInput);
                });
    }
}