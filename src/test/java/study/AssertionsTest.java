package study;


import java.io.IOException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertionsTest {

    static class TestConfig {
        public static void callIllegalStateException() {
            throw new IllegalStateException();
        }

        public static void callIOException() throws IOException {
            throw new IOException();
        }
    }

    @Test
    @DisplayName("assertThatIllegalArgumentException - 특정 동작에서 IllegalArgumentException 예외가 발생하는지 알 수 있다.")
    void assertThatIllegalArgumentException() {
        // given
        String testString = "abc";
        // when & then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Integer.parseInt(testString));
    }

    @Test
    @DisplayName("assertThatIllegalStateException - 특정 동작에서 IllegalStateException 예외가 발생하는지 알 수 있다.")
    void assertThatIllegalStateException() {

        Assertions.assertThatIllegalStateException().isThrownBy(() -> TestConfig.callIllegalStateException());
    }

    @Test
    @DisplayName("assertThatIOException - 특정 동작에서 IOException 예외가 발생하는지 알 수 있다.")
    void assertThatIOException() {
        Assertions.assertThatIOException().isThrownBy(() -> TestConfig.callIOException());
    }

    @Test
    @DisplayName("assertThatNullPointerException - 특정 동작에서 NullPointerException 예외가 발생하는지 알 수 있다.")
    void assertThatNullPointerException() {
        // given
        String testString = null;
        // when & then
        Assertions.assertThatNullPointerException().isThrownBy(() -> testString.substring(0, 1));
    }
}


