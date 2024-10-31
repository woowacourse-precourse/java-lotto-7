package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ParserTest {
    @Test
    void 금액_파싱_테스트() {
        String dummyInput = "1000";

        int amount = Parser.parseAmount(dummyInput);
        assertThat(amount).isEqualTo(1000);
    }
}