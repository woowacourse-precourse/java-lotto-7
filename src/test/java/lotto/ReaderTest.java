package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ReaderTest {
    @Test
    void 입력_테스트() {
        String dummyInput = "1000";
        TestUtils.setInputStream(dummyInput);

        new Reader();
        String input = Reader.readInput();

        assertThat(input).isEqualTo(dummyInput);
    }

    @Test
    void 빈_문자열_테스트() {
        String dummyInput = "";
        TestUtils.setInputStream(dummyInput);

        new Reader();
        String input = Reader.readInput();

        assertThat("ERROR").isEqualTo(input);
    }
}