package lotto.view.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ErrorFormatterTest {

    private final ErrorFormatter errorFormatter;

    public ErrorFormatterTest() {
        this.errorFormatter = new ErrorFormatter();
    }

    @Test
    @DisplayName("format은 예외의 메세지를 추출하여 의도한 포맷 결과를 반환한다.")
    void format_ReturnFormattedStringWithExceptionMessage() {
        // given
        Exception error = new Exception("test message");

        // when
        String formattedError = errorFormatter.format(error);

        // then
        assertThat(formattedError)
                .isEqualTo("[ERROR] test message");
    }
}
