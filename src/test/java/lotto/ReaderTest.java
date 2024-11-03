package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@Disabled
class ReaderTest {
    @Test
    void 입력_테스트() {
        String dummyInput = "1000";
        TestUtils.setInputStream(dummyInput);

        String input = Reader.readInput();

        assertThat(input).isEqualTo(dummyInput);
    }

    @Test
    void 빈_문자열_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    String dummyInput = "";
                    TestUtils.setInputStream(dummyInput);

                    String input = Reader.readInput();

                    assertThat(dummyInput).isEqualTo(input);
                });
    }
}