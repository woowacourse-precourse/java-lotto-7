package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoMachineTest {
    @Test
    void 입력값이_유효하지_않을_때_예외_처리_후_재입력() {
        String dummyInput = "a\na\n1000";
        TestUtils.setInputStream(dummyInput);

        LottoMachine.initData();
    }
}